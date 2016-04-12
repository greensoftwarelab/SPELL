// $ANTLR 3.5.2 output/Output.g 2016-04-12 13:58:35

  package output;
  import genericTree.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class OutputParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "ID", "IdentifierNondigit", 
		"NUMBER", "Nondigit", "WS", "','", "';'", "'<'", "'='", "'>'", "'['", 
		"']'", "'cpu'", "'disk'", "'fans'", "'gpu'", "'m'", "'ram'", "'t'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int DIGIT=4;
	public static final int ID=5;
	public static final int IdentifierNondigit=6;
	public static final int NUMBER=7;
	public static final int Nondigit=8;
	public static final int WS=9;

        public int cpuExp = 0;
        public int timeExp = 0;
        
            
	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public OutputParser(TokenStream input, int cpuExp, int timeExp) {
		this(input, new RecognizerSharedState());
                this.timeExp = timeExp;
                this.cpuExp = cpuExp;
	}
	public OutputParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return OutputParser.tokenNames; }
	@Override public String getGrammarFileName() { return "output/Output.g"; }



	// $ANTLR start "output"
	// output/Output.g:9:1: output returns [ ArrayList<Tree<ComponentNode>> multipleTests ] : t1= testoutput ( ';' t2= testoutput )* ;
	public final ArrayList<Tree<ComponentNode>> output() throws RecognitionException {
		ArrayList<Tree<ComponentNode>> multipleTests = null;


		Tree<ComponentNode> t1 =null;
		Tree<ComponentNode> t2 =null;

		 multipleTests = new ArrayList<Tree<ComponentNode>>(); 
		try {
			// output/Output.g:11:2: (t1= testoutput ( ';' t2= testoutput )* )
			// output/Output.g:11:4: t1= testoutput ( ';' t2= testoutput )*
			{
			pushFollow(FOLLOW_testoutput_in_output40);
			t1=testoutput();
			state._fsp--;

			 multipleTests.add(t1); 
			// output/Output.g:11:54: ( ';' t2= testoutput )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==11) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// output/Output.g:11:55: ';' t2= testoutput
					{
					match(input,11,FOLLOW_11_in_output45); 
					pushFollow(FOLLOW_testoutput_in_output51);
					t2=testoutput();
					state._fsp--;

					 multipleTests.add(t2);  
					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return multipleTests;
	}
	// $ANTLR end "output"



	// $ANTLR start "testoutput"
	// output/Output.g:14:1: testoutput returns [ Tree<ComponentNode> tree ] : l1= line (l2= line )* ;
	public final Tree<ComponentNode> testoutput() throws RecognitionException {
		Tree<ComponentNode> tree = null;


		Node<ComponentNode> l1 =null;
		Node<ComponentNode> l2 =null;

		try {
			// output/Output.g:15:2: (l1= line (l2= line )* )
			// output/Output.g:15:4: l1= line (l2= line )*
			{
			pushFollow(FOLLOW_line_in_testoutput76);
			l1=line();
			state._fsp--;

			 tree = new Tree(l1); 
			// output/Output.g:15:46: (l2= line )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==14) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// output/Output.g:15:47: l2= line
					{
					pushFollow(FOLLOW_line_in_testoutput85);
					l2=line();
					state._fsp--;

					 tree.getRoot().addChild(l2);  
					}
					break;

				default :
					break loop2;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return tree;
	}
	// $ANTLR end "testoutput"


	protected static class line_scope {
		ArrayList<Node<ComponentNode>> childList;
	}
	protected Stack<line_scope> line_stack = new Stack<line_scope>();


	// $ANTLR start "line"
	// output/Output.g:18:1: line returns [ Node<ComponentNode> node ] : component_begin (l1= line )* component_end ;
	public final Node<ComponentNode> line() throws RecognitionException {
		line_stack.push(new line_scope());
		Node<ComponentNode> node = null;


		Node<ComponentNode> l1 =null;
		OutputNode component_begin1 =null;
		OutputNode component_end2 =null;

		try {
			// output/Output.g:20:2: ( component_begin (l1= line )* component_end )
			// output/Output.g:20:4: component_begin (l1= line )* component_end
			{
			pushFollow(FOLLOW_component_begin_in_line110);
			component_begin1=component_begin();
			state._fsp--;

			// output/Output.g:20:20: (l1= line )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==14) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// output/Output.g:20:21: l1= line
					{
					pushFollow(FOLLOW_line_in_line117);
					l1=line();
					state._fsp--;

					 
														if (line_stack.peek().childList == null)
															line_stack.peek().childList = new ArrayList<Node<ComponentNode>>(); 
															
														line_stack.peek().childList.add(l1); 
													
					}
					break;

				default :
					break loop3;
				}
			}

			pushFollow(FOLLOW_component_end_in_line124);
			component_end2=component_end();
			state._fsp--;


							if (component_begin1.getId().equals(component_end2.getId())){
								ComponentNode componentNode = new ComponentNode(component_begin1, component_end2,cpuExp,timeExp);
								node = new Node<ComponentNode>(componentNode);

			                                        if (line_stack.peek().childList != null) {
			                                            for(Node<ComponentNode> child : line_stack.peek().childList) {
			                                                    node.addChild(child);
			                                            }
			                                        }
							}
						
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			line_stack.pop();
		}
		return node;
	}
	// $ANTLR end "line"



	// $ANTLR start "component"
	// output/Output.g:40:1: component returns [ OutputNode outputNode ] : ID '[' params ']' ;
	public final OutputNode component() throws RecognitionException {
		OutputNode outputNode = null;


		Token ID3=null;
		OutputNodeParameters params4 =null;

		 outputNode = new OutputNode(); 
		try {
			// output/Output.g:42:2: ( ID '[' params ']' )
			// output/Output.g:42:4: ID '[' params ']'
			{
			ID3=(Token)match(input,ID,FOLLOW_ID_in_component149); 
			match(input,15,FOLLOW_15_in_component151); 
			pushFollow(FOLLOW_params_in_component153);
			params4=params();
			state._fsp--;

			match(input,16,FOLLOW_16_in_component155); 
			 outputNode.setId((ID3!=null?ID3.getText():null)); outputNode.setParameters(params4); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return outputNode;
	}
	// $ANTLR end "component"



	// $ANTLR start "component_begin"
	// output/Output.g:46:1: component_begin returns [ OutputNode nodeBegin ] : '>' component ;
	public final OutputNode component_begin() throws RecognitionException {
		OutputNode nodeBegin = null;


		OutputNode component5 =null;

		try {
			// output/Output.g:47:2: ( '>' component )
			// output/Output.g:47:4: '>' component
			{
			match(input,14,FOLLOW_14_in_component_begin173); 
			pushFollow(FOLLOW_component_in_component_begin175);
			component5=component();
			state._fsp--;

			 nodeBegin = component5; 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return nodeBegin;
	}
	// $ANTLR end "component_begin"



	// $ANTLR start "component_end"
	// output/Output.g:50:1: component_end returns [ OutputNode nodeEnd ] : '<' component ;
	public final OutputNode component_end() throws RecognitionException {
		OutputNode nodeEnd = null;


		OutputNode component6 =null;

		try {
			// output/Output.g:51:2: ( '<' component )
			// output/Output.g:51:4: '<' component
			{
			match(input,12,FOLLOW_12_in_component_end192); 
			pushFollow(FOLLOW_component_in_component_end194);
			component6=component();
			state._fsp--;

			 nodeEnd = component6; 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return nodeEnd;
	}
	// $ANTLR end "component_end"



	// $ANTLR start "params"
	// output/Output.g:54:1: params returns [ OutputNodeParameters parameters ] : p1= param ( ',' p2= param )* ;
	public final OutputNodeParameters params() throws RecognitionException {
		OutputNodeParameters parameters = null;


		ParserRuleReturnScope p1 =null;
		ParserRuleReturnScope p2 =null;

		 parameters = new OutputNodeParameters(); 
		try {
			// output/Output.g:56:3: (p1= param ( ',' p2= param )* )
			// output/Output.g:56:5: p1= param ( ',' p2= param )*
			{
			pushFollow(FOLLOW_param_in_params220);
			p1=param();
			state._fsp--;

			 parameters.put((p1!=null?((OutputParser.param_return)p1).key:null), (p1!=null?((OutputParser.param_return)p1).value:null)); 
			// output/Output.g:56:57: ( ',' p2= param )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==10) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// output/Output.g:56:59: ',' p2= param
					{
					match(input,10,FOLLOW_10_in_params226); 
					pushFollow(FOLLOW_param_in_params232);
					p2=param();
					state._fsp--;

					 parameters.put((p2!=null?((OutputParser.param_return)p2).key:null), (p2!=null?((OutputParser.param_return)p2).value:null)); 
					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return parameters;
	}
	// $ANTLR end "params"


	public static class param_return extends ParserRuleReturnScope {
		public String key;
		public String value;
	};


	// $ANTLR start "param"
	// output/Output.g:59:1: param returns [ String key, String value ] : ( 'm' '=' ID | 't' '=' NUMBER | 'cpu' '=' NUMBER | 'ram' '=' NUMBER | 'disk' '=' NUMBER | 'fans' '=' NUMBER | 'gpu' '=' NUMBER );
	public final OutputParser.param_return param() throws RecognitionException {
		OutputParser.param_return retval = new OutputParser.param_return();
		retval.start = input.LT(1);

		Token ID7=null;
		Token NUMBER8=null;
		Token NUMBER9=null;
		Token NUMBER10=null;
		Token NUMBER11=null;
		Token NUMBER12=null;
		Token NUMBER13=null;

		try {
			// output/Output.g:60:2: ( 'm' '=' ID | 't' '=' NUMBER | 'cpu' '=' NUMBER | 'ram' '=' NUMBER | 'disk' '=' NUMBER | 'fans' '=' NUMBER | 'gpu' '=' NUMBER )
			int alt5=7;
			switch ( input.LA(1) ) {
			case 21:
				{
				alt5=1;
				}
				break;
			case 23:
				{
				alt5=2;
				}
				break;
			case 17:
				{
				alt5=3;
				}
				break;
			case 22:
				{
				alt5=4;
				}
				break;
			case 18:
				{
				alt5=5;
				}
				break;
			case 19:
				{
				alt5=6;
				}
				break;
			case 20:
				{
				alt5=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// output/Output.g:60:4: 'm' '=' ID
					{
					match(input,21,FOLLOW_21_in_param254); 
					match(input,13,FOLLOW_13_in_param256); 
					ID7=(Token)match(input,ID,FOLLOW_ID_in_param258); 
					 retval.key = "m"; retval.value = (ID7!=null?ID7.getText():null); 
					}
					break;
				case 2 :
					// output/Output.g:61:4: 't' '=' NUMBER
					{
					match(input,23,FOLLOW_23_in_param265); 
					match(input,13,FOLLOW_13_in_param267); 
					NUMBER8=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param269); 
					 retval.key = "t"; retval.value = (NUMBER8!=null?NUMBER8.getText():null); 
					}
					break;
				case 3 :
					// output/Output.g:62:11: 'cpu' '=' NUMBER
					{
					match(input,17,FOLLOW_17_in_param283); 
					match(input,13,FOLLOW_13_in_param285); 
					NUMBER9=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param287); 
					 retval.key = "cpu"; retval.value = (NUMBER9!=null?NUMBER9.getText():null); 
					}
					break;
				case 4 :
					// output/Output.g:63:11: 'ram' '=' NUMBER
					{
					match(input,22,FOLLOW_22_in_param301); 
					match(input,13,FOLLOW_13_in_param303); 
					NUMBER10=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param305); 
					 retval.key = "ram"; retval.value = (NUMBER10!=null?NUMBER10.getText():null); 
					}
					break;
				case 5 :
					// output/Output.g:64:11: 'disk' '=' NUMBER
					{
					match(input,18,FOLLOW_18_in_param319); 
					match(input,13,FOLLOW_13_in_param321); 
					NUMBER11=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param323); 
					 retval.key = "disk"; retval.value = (NUMBER11!=null?NUMBER11.getText():null); 
					}
					break;
				case 6 :
					// output/Output.g:65:11: 'fans' '=' NUMBER
					{
					match(input,19,FOLLOW_19_in_param337); 
					match(input,13,FOLLOW_13_in_param339); 
					NUMBER12=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param341); 
					 retval.key = "fans"; retval.value = (NUMBER12!=null?NUMBER12.getText():null); 
					}
					break;
				case 7 :
					// output/Output.g:66:11: 'gpu' '=' NUMBER
					{
					match(input,20,FOLLOW_20_in_param355); 
					match(input,13,FOLLOW_13_in_param357); 
					NUMBER13=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param359); 
					 retval.key = "gpu"; retval.value = (NUMBER13!=null?NUMBER13.getText():null); 
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "param"

	// Delegated rules



	public static final BitSet FOLLOW_testoutput_in_output40 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_11_in_output45 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_testoutput_in_output51 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_line_in_testoutput76 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_line_in_testoutput85 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_component_begin_in_line110 = new BitSet(new long[]{0x0000000000005000L});
	public static final BitSet FOLLOW_line_in_line117 = new BitSet(new long[]{0x0000000000005000L});
	public static final BitSet FOLLOW_component_end_in_line124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_component149 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_component151 = new BitSet(new long[]{0x0000000000FE0000L});
	public static final BitSet FOLLOW_params_in_component153 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_component155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_component_begin173 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_component_in_component_begin175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_component_end192 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_component_in_component_end194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_params220 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_params226 = new BitSet(new long[]{0x0000000000FE0000L});
	public static final BitSet FOLLOW_param_in_params232 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_21_in_param254 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_param256 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_param258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_param265 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_param267 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NUMBER_in_param269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_param283 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_param285 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NUMBER_in_param287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_param301 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_param303 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NUMBER_in_param305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_param319 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_param321 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NUMBER_in_param323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_param337 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_param339 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NUMBER_in_param341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_param355 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_param357 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NUMBER_in_param359 = new BitSet(new long[]{0x0000000000000002L});
}
