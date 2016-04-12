grammar Matrix;

@lexer::header { package sell; }
@parser::header {
  package sell;
  import java.util.TreeMap;
  import sell.input.*;
}

parse returns [ DataRetrieved matrix ]
@init{ $matrix = new DataRetrieved(); }
 : (line { $matrix.addVector($line.vector); } )+ EOF
 ;

line returns [ DataLineRetrieved vector ]
@init{ $vector = new DataLineRetrieved(); }
 : '[' (c = component { $vector.addComponent($c.component); } )+ ']' (NL | EOF)
 ;

component returns [ ComponentSample component ]
 : param
 | '[' params ']' { $component = new ComponentSample($params.parameters); }
 | '_' { $component = new ComponentSample(false); }
 | '0' { $component = new ComponentSample(false); }
 ;

params returns [ ComponentParameters parameters ]
@init{ $parameters = new ComponentParameters(); }
 : p1 = param { $parameters.put($p1.key, $p1.value); } ( ',' p2 = param { $parameters.put($p2.key, $p2.value); } )* 
 ;

param returns [ String key, String value ]
 : 'n' '=' NUMBER { $key = "n"; $value = $NUMBER.text; }
 | 't' '=' NUMBER { $key = "t"; $value = $NUMBER.text; }
 | 'cpu' '=' NUMBER { $key = "cpu"; $value = $NUMBER.text; }
 | 'ram' '=' NUMBER { $key = "ram"; $value = $NUMBER.text; }
 | 'disk' '=' NUMBER { $key = "disk"; $value = $NUMBER.text; }
 | 'fans' '=' NUMBER { $key = "fans"; $value = $NUMBER.text; }
 | 'gpu' '=' NUMBER { $key = "gpu"; $value = $NUMBER.text; }
 ;


NUMBER     : '0'..'9'+ ('.' '0'..'9'+)?;

NL    : '\r'? '\n' | '\r';
Space : (' ' | '\t')+ {skip();};