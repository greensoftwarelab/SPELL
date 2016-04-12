grammar Output;

@lexer::header { package output; }
@parser::header {
  package output;
  import genericTree.*;
}

output returns [ ArrayList<Tree<ComponentNode>> multipleTests ]
@init{ $multipleTests = new ArrayList<Tree<ComponentNode>>(); }
	:	t1 = testoutput { $multipleTests.add($t1.tree); } (';' t2 = testoutput { $multipleTests.add($t2.tree);  } )* 
	;

testoutput returns [ Tree<ComponentNode> tree ]
	:	l1 = line { $tree = new Tree($l1.node); } (l2 = line { $tree.getRoot().addChild($l2.node);  } )*
	;

line returns [ Node<ComponentNode> node ]
	scope { ArrayList<Node<ComponentNode>> childList; }
	:	component_begin (l1 = line 	{ 
									if ($line::childList == null)
										$line::childList = new ArrayList<Node<ComponentNode>>(); 
										
									$line::childList.add($l1.node); 
								})* component_end 
			{
				if ($component_begin.nodeBegin.getId().equals($component_end.nodeEnd.getId())){
					ComponentNode componentNode = new ComponentNode($component_begin.nodeBegin, $component_end.nodeEnd);
					$node = new Node<ComponentNode>(componentNode);

                                        if ($line::childList != null) {
                                            for(Node<ComponentNode> child : $line::childList) {
                                                    $node.addChild(child);
                                            }
                                        }
				}
			}
	;

component returns [ OutputNode outputNode ]
@init{ $outputNode = new OutputNode(); }
	:	ID '[' params ']' { $outputNode.setId($ID.text); $outputNode.setParameters($params.parameters); }
	;


component_begin returns [ OutputNode nodeBegin ]
	:	'>' component { $nodeBegin = $component.outputNode; }
	;

component_end returns [ OutputNode nodeEnd ]
	:	'<' component { $nodeEnd = $component.outputNode; }
	;

params returns [ OutputNodeParameters parameters ]
@init{ $parameters = new OutputNodeParameters(); }
	 : p1 = param { $parameters.put($p1.key, $p1.value); } ( ',' p2 = param { $parameters.put($p2.key, $p2.value); } )* 
	 ;

param returns [ String key, String value ]
	: 'm' '=' ID { $key = "m"; $value = $ID.text; }
	| 't' '=' NUMBER { $key = "t"; $value = $NUMBER.text; }
        | 'cpu' '=' NUMBER { $key = "cpu"; $value = $NUMBER.text; }
        | 'ram' '=' NUMBER { $key = "ram"; $value = $NUMBER.text; }
        | 'disk' '=' NUMBER { $key = "disk"; $value = $NUMBER.text; }
        | 'fans' '=' NUMBER { $key = "fans"; $value = $NUMBER.text; }
        | 'gpu' '=' NUMBER { $key = "gpu"; $value = $NUMBER.text; }
	;

ID
	:   IdentifierNondigit
            (   IdentifierNondigit
            |   DIGIT
            )*
	;

NUMBER
	: DIGIT+ ('.' DIGIT+)?
	| '.' DIGIT+
	;

fragment IdentifierNondigit
    :   Nondigit
    ;

fragment Nondigit : ('a'..'z'|'A'..'Z'|'_');
 
    
fragment DIGIT   : '0'..'9'+;
WS : (' ' | '\t' | '\n' | '\r' )+ {skip();};


