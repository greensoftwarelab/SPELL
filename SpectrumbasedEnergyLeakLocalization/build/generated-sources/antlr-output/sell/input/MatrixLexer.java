// $ANTLR 3.5.2 sell/input/Matrix.g 2015-02-04 11:36:38
 package sell; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class MatrixLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public MatrixLexer() {} 
	public MatrixLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public MatrixLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "sell/input/Matrix.g"; }

	// $ANTLR start "T__7"
	public final void mT__7() throws RecognitionException {
		try {
			int _type = T__7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:4:6: ( ',' )
			// sell/input/Matrix.g:4:8: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__7"

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:5:6: ( '0' )
			// sell/input/Matrix.g:5:8: '0'
			{
			match('0'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:6:6: ( '=' )
			// sell/input/Matrix.g:6:8: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:7:7: ( '[' )
			// sell/input/Matrix.g:7:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:8:7: ( ']' )
			// sell/input/Matrix.g:8:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:9:7: ( '_' )
			// sell/input/Matrix.g:9:9: '_'
			{
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:10:7: ( 'cpu' )
			// sell/input/Matrix.g:10:9: 'cpu'
			{
			match("cpu"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:11:7: ( 'disk' )
			// sell/input/Matrix.g:11:9: 'disk'
			{
			match("disk"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:12:7: ( 'fans' )
			// sell/input/Matrix.g:12:9: 'fans'
			{
			match("fans"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:13:7: ( 'gpu' )
			// sell/input/Matrix.g:13:9: 'gpu'
			{
			match("gpu"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:14:7: ( 'n' )
			// sell/input/Matrix.g:14:9: 'n'
			{
			match('n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:15:7: ( 'ram' )
			// sell/input/Matrix.g:15:9: 'ram'
			{
			match("ram"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:16:7: ( 't' )
			// sell/input/Matrix.g:16:9: 't'
			{
			match('t'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:43:12: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
			// sell/input/Matrix.g:43:14: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
			{
			// sell/input/Matrix.g:43:14: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// sell/input/Matrix.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			// sell/input/Matrix.g:43:24: ( '.' ( '0' .. '9' )+ )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='.') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// sell/input/Matrix.g:43:25: '.' ( '0' .. '9' )+
					{
					match('.'); 
					// sell/input/Matrix.g:43:29: ( '0' .. '9' )+
					int cnt2=0;
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// sell/input/Matrix.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt2 >= 1 ) break loop2;
							EarlyExitException eee = new EarlyExitException(2, input);
							throw eee;
						}
						cnt2++;
					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "NL"
	public final void mNL() throws RecognitionException {
		try {
			int _type = NL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:45:7: ( ( '\\r' )? '\\n' | '\\r' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\r') ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1=='\n') ) {
					alt5=1;
				}

				else {
					alt5=2;
				}

			}
			else if ( (LA5_0=='\n') ) {
				alt5=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// sell/input/Matrix.g:45:9: ( '\\r' )? '\\n'
					{
					// sell/input/Matrix.g:45:9: ( '\\r' )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0=='\r') ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// sell/input/Matrix.g:45:9: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					}
					break;
				case 2 :
					// sell/input/Matrix.g:45:22: '\\r'
					{
					match('\r'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NL"

	// $ANTLR start "Space"
	public final void mSpace() throws RecognitionException {
		try {
			int _type = Space;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sell/input/Matrix.g:46:7: ( ( ' ' | '\\t' )+ )
			// sell/input/Matrix.g:46:9: ( ' ' | '\\t' )+
			{
			// sell/input/Matrix.g:46:9: ( ' ' | '\\t' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\t'||LA6_0==' ') ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// sell/input/Matrix.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Space"

	@Override
	public void mTokens() throws RecognitionException {
		// sell/input/Matrix.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | NUMBER | NL | Space )
		int alt7=16;
		switch ( input.LA(1) ) {
		case ',':
			{
			alt7=1;
			}
			break;
		case '0':
			{
			int LA7_2 = input.LA(2);
			if ( (LA7_2=='.'||(LA7_2 >= '0' && LA7_2 <= '9')) ) {
				alt7=14;
			}

			else {
				alt7=2;
			}

			}
			break;
		case '=':
			{
			alt7=3;
			}
			break;
		case '[':
			{
			alt7=4;
			}
			break;
		case ']':
			{
			alt7=5;
			}
			break;
		case '_':
			{
			alt7=6;
			}
			break;
		case 'c':
			{
			alt7=7;
			}
			break;
		case 'd':
			{
			alt7=8;
			}
			break;
		case 'f':
			{
			alt7=9;
			}
			break;
		case 'g':
			{
			alt7=10;
			}
			break;
		case 'n':
			{
			alt7=11;
			}
			break;
		case 'r':
			{
			alt7=12;
			}
			break;
		case 't':
			{
			alt7=13;
			}
			break;
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt7=14;
			}
			break;
		case '\n':
		case '\r':
			{
			alt7=15;
			}
			break;
		case '\t':
		case ' ':
			{
			alt7=16;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 7, 0, input);
			throw nvae;
		}
		switch (alt7) {
			case 1 :
				// sell/input/Matrix.g:1:10: T__7
				{
				mT__7(); 

				}
				break;
			case 2 :
				// sell/input/Matrix.g:1:15: T__8
				{
				mT__8(); 

				}
				break;
			case 3 :
				// sell/input/Matrix.g:1:20: T__9
				{
				mT__9(); 

				}
				break;
			case 4 :
				// sell/input/Matrix.g:1:25: T__10
				{
				mT__10(); 

				}
				break;
			case 5 :
				// sell/input/Matrix.g:1:31: T__11
				{
				mT__11(); 

				}
				break;
			case 6 :
				// sell/input/Matrix.g:1:37: T__12
				{
				mT__12(); 

				}
				break;
			case 7 :
				// sell/input/Matrix.g:1:43: T__13
				{
				mT__13(); 

				}
				break;
			case 8 :
				// sell/input/Matrix.g:1:49: T__14
				{
				mT__14(); 

				}
				break;
			case 9 :
				// sell/input/Matrix.g:1:55: T__15
				{
				mT__15(); 

				}
				break;
			case 10 :
				// sell/input/Matrix.g:1:61: T__16
				{
				mT__16(); 

				}
				break;
			case 11 :
				// sell/input/Matrix.g:1:67: T__17
				{
				mT__17(); 

				}
				break;
			case 12 :
				// sell/input/Matrix.g:1:73: T__18
				{
				mT__18(); 

				}
				break;
			case 13 :
				// sell/input/Matrix.g:1:79: T__19
				{
				mT__19(); 

				}
				break;
			case 14 :
				// sell/input/Matrix.g:1:85: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 15 :
				// sell/input/Matrix.g:1:92: NL
				{
				mNL(); 

				}
				break;
			case 16 :
				// sell/input/Matrix.g:1:95: Space
				{
				mSpace(); 

				}
				break;

		}
	}



}
