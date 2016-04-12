// $ANTLR 3.5.2 sell/input/Matrix.g 2015-02-04 11:36:37

  package sell;
  import java.util.TreeMap;
  import sell.input.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class MatrixParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "NL", "NUMBER", "Space", "','", 
		"'0'", "'='", "'['", "']'", "'_'", "'cpu'", "'disk'", "'fans'", "'gpu'", 
		"'n'", "'ram'", "'t'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
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
	public static final int NL=4;
	public static final int NUMBER=5;
	public static final int Space=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public MatrixParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public MatrixParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return MatrixParser.tokenNames; }
	@Override public String getGrammarFileName() { return "sell/input/Matrix.g"; }



	// $ANTLR start "parse"
	// sell/input/Matrix.g:10:1: parse returns [ DataRetrieved matrix ] : ( line )+ EOF ;
	public final DataRetrieved parse() throws RecognitionException {
		DataRetrieved matrix = null;


		DataLineRetrieved line1 =null;

		 matrix = new DataRetrieved(); 
		try {
			// sell/input/Matrix.g:12:2: ( ( line )+ EOF )
			// sell/input/Matrix.g:12:4: ( line )+ EOF
			{
			// sell/input/Matrix.g:12:4: ( line )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==10) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// sell/input/Matrix.g:12:5: line
					{
					pushFollow(FOLLOW_line_in_parse37);
					line1=line();
					state._fsp--;

					 matrix.addVector(line1); 
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input,EOF,FOLLOW_EOF_in_parse44); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return matrix;
	}
	// $ANTLR end "parse"



	// $ANTLR start "line"
	// sell/input/Matrix.g:15:1: line returns [ DataLineRetrieved vector ] : '[' (c= component )+ ']' ( NL | EOF ) ;
	public final DataLineRetrieved line() throws RecognitionException {
		DataLineRetrieved vector = null;


		ComponentSample c =null;

		 vector = new DataLineRetrieved(); 
		try {
			// sell/input/Matrix.g:17:2: ( '[' (c= component )+ ']' ( NL | EOF ) )
			// sell/input/Matrix.g:17:4: '[' (c= component )+ ']' ( NL | EOF )
			{
			match(input,10,FOLLOW_10_in_line63); 
			// sell/input/Matrix.g:17:8: (c= component )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==8||LA2_0==10||(LA2_0 >= 12 && LA2_0 <= 19)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// sell/input/Matrix.g:17:9: c= component
					{
					pushFollow(FOLLOW_component_in_line70);
					c=component();
					state._fsp--;

					 vector.addComponent(c); 
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match(input,11,FOLLOW_11_in_line77); 
			if ( input.LA(1)==EOF||input.LA(1)==NL ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
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
		return vector;
	}
	// $ANTLR end "line"



	// $ANTLR start "component"
	// sell/input/Matrix.g:20:1: component returns [ ComponentSample component ] : ( param | '[' params ']' | '_' | '0' );
	public final ComponentSample component() throws RecognitionException {
		ComponentSample component = null;


		ComponentParameters params2 =null;

		try {
			// sell/input/Matrix.g:21:2: ( param | '[' params ']' | '_' | '0' )
			int alt3=4;
			switch ( input.LA(1) ) {
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
				{
				alt3=1;
				}
				break;
			case 10:
				{
				alt3=2;
				}
				break;
			case 12:
				{
				alt3=3;
				}
				break;
			case 8:
				{
				alt3=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// sell/input/Matrix.g:21:4: param
					{
					pushFollow(FOLLOW_param_in_component100);
					param();
					state._fsp--;

					}
					break;
				case 2 :
					// sell/input/Matrix.g:22:4: '[' params ']'
					{
					match(input,10,FOLLOW_10_in_component105); 
					pushFollow(FOLLOW_params_in_component107);
					params2=params();
					state._fsp--;

					match(input,11,FOLLOW_11_in_component109); 
					 component = new ComponentSample(params2); 
					}
					break;
				case 3 :
					// sell/input/Matrix.g:23:4: '_'
					{
					match(input,12,FOLLOW_12_in_component116); 
					 component = new ComponentSample(false); 
					}
					break;
				case 4 :
					// sell/input/Matrix.g:24:4: '0'
					{
					match(input,8,FOLLOW_8_in_component123); 
					 component = new ComponentSample(false); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return component;
	}
	// $ANTLR end "component"



	// $ANTLR start "params"
	// sell/input/Matrix.g:27:1: params returns [ ComponentParameters parameters ] : p1= param ( ',' p2= param )* ;
	public final ComponentParameters params() throws RecognitionException {
		ComponentParameters parameters = null;


		ParserRuleReturnScope p1 =null;
		ParserRuleReturnScope p2 =null;

		 parameters = new ComponentParameters(); 
		try {
			// sell/input/Matrix.g:29:2: (p1= param ( ',' p2= param )* )
			// sell/input/Matrix.g:29:4: p1= param ( ',' p2= param )*
			{
			pushFollow(FOLLOW_param_in_params148);
			p1=param();
			state._fsp--;

			 parameters.put((p1!=null?((MatrixParser.param_return)p1).key:null), (p1!=null?((MatrixParser.param_return)p1).value:null)); 
			// sell/input/Matrix.g:29:56: ( ',' p2= param )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==7) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// sell/input/Matrix.g:29:58: ',' p2= param
					{
					match(input,7,FOLLOW_7_in_params154); 
					pushFollow(FOLLOW_param_in_params160);
					p2=param();
					state._fsp--;

					 parameters.put((p2!=null?((MatrixParser.param_return)p2).key:null), (p2!=null?((MatrixParser.param_return)p2).value:null)); 
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
	// sell/input/Matrix.g:32:1: param returns [ String key, String value ] : ( 'n' '=' NUMBER | 't' '=' NUMBER | 'cpu' '=' NUMBER | 'ram' '=' NUMBER | 'disk' '=' NUMBER | 'fans' '=' NUMBER | 'gpu' '=' NUMBER );
	public final MatrixParser.param_return param() throws RecognitionException {
		MatrixParser.param_return retval = new MatrixParser.param_return();
		retval.start = input.LT(1);

		Token NUMBER3=null;
		Token NUMBER4=null;
		Token NUMBER5=null;
		Token NUMBER6=null;
		Token NUMBER7=null;
		Token NUMBER8=null;
		Token NUMBER9=null;

		try {
			// sell/input/Matrix.g:33:2: ( 'n' '=' NUMBER | 't' '=' NUMBER | 'cpu' '=' NUMBER | 'ram' '=' NUMBER | 'disk' '=' NUMBER | 'fans' '=' NUMBER | 'gpu' '=' NUMBER )
			int alt5=7;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt5=1;
				}
				break;
			case 19:
				{
				alt5=2;
				}
				break;
			case 13:
				{
				alt5=3;
				}
				break;
			case 18:
				{
				alt5=4;
				}
				break;
			case 14:
				{
				alt5=5;
				}
				break;
			case 15:
				{
				alt5=6;
				}
				break;
			case 16:
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
					// sell/input/Matrix.g:33:4: 'n' '=' NUMBER
					{
					match(input,17,FOLLOW_17_in_param181); 
					match(input,9,FOLLOW_9_in_param183); 
					NUMBER3=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param185); 
					 retval.key = "n"; retval.value = (NUMBER3!=null?NUMBER3.getText():null); 
					}
					break;
				case 2 :
					// sell/input/Matrix.g:34:4: 't' '=' NUMBER
					{
					match(input,19,FOLLOW_19_in_param192); 
					match(input,9,FOLLOW_9_in_param194); 
					NUMBER4=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param196); 
					 retval.key = "t"; retval.value = (NUMBER4!=null?NUMBER4.getText():null); 
					}
					break;
				case 3 :
					// sell/input/Matrix.g:35:4: 'cpu' '=' NUMBER
					{
					match(input,13,FOLLOW_13_in_param203); 
					match(input,9,FOLLOW_9_in_param205); 
					NUMBER5=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param207); 
					 retval.key = "cpu"; retval.value = (NUMBER5!=null?NUMBER5.getText():null); 
					}
					break;
				case 4 :
					// sell/input/Matrix.g:36:4: 'ram' '=' NUMBER
					{
					match(input,18,FOLLOW_18_in_param214); 
					match(input,9,FOLLOW_9_in_param216); 
					NUMBER6=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param218); 
					 retval.key = "ram"; retval.value = (NUMBER6!=null?NUMBER6.getText():null); 
					}
					break;
				case 5 :
					// sell/input/Matrix.g:37:4: 'disk' '=' NUMBER
					{
					match(input,14,FOLLOW_14_in_param225); 
					match(input,9,FOLLOW_9_in_param227); 
					NUMBER7=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param229); 
					 retval.key = "disk"; retval.value = (NUMBER7!=null?NUMBER7.getText():null); 
					}
					break;
				case 6 :
					// sell/input/Matrix.g:38:4: 'fans' '=' NUMBER
					{
					match(input,15,FOLLOW_15_in_param236); 
					match(input,9,FOLLOW_9_in_param238); 
					NUMBER8=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param240); 
					 retval.key = "fans"; retval.value = (NUMBER8!=null?NUMBER8.getText():null); 
					}
					break;
				case 7 :
					// sell/input/Matrix.g:39:4: 'gpu' '=' NUMBER
					{
					match(input,16,FOLLOW_16_in_param247); 
					match(input,9,FOLLOW_9_in_param249); 
					NUMBER9=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_param251); 
					 retval.key = "gpu"; retval.value = (NUMBER9!=null?NUMBER9.getText():null); 
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



	public static final BitSet FOLLOW_line_in_parse37 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EOF_in_parse44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_line63 = new BitSet(new long[]{0x00000000000FF500L});
	public static final BitSet FOLLOW_component_in_line70 = new BitSet(new long[]{0x00000000000FFD00L});
	public static final BitSet FOLLOW_11_in_line77 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_set_in_line79 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_component100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_component105 = new BitSet(new long[]{0x00000000000FE000L});
	public static final BitSet FOLLOW_params_in_component107 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_component109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_component116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_component123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_params148 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_7_in_params154 = new BitSet(new long[]{0x00000000000FE000L});
	public static final BitSet FOLLOW_param_in_params160 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_17_in_param181 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_param183 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUMBER_in_param185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_param192 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_param194 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUMBER_in_param196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_param203 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_param205 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUMBER_in_param207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_param214 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_param216 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUMBER_in_param218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_param225 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_param227 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUMBER_in_param229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_param236 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_param238 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUMBER_in_param240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_param247 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_param249 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUMBER_in_param251 = new BitSet(new long[]{0x0000000000000002L});
}
