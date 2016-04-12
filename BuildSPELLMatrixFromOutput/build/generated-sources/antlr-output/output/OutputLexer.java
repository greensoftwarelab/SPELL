// $ANTLR 3.5.2 output/Output.g 2016-04-12 13:58:36
 package output; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class OutputLexer extends Lexer {
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

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public OutputLexer() {} 
	public OutputLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public OutputLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "output/Output.g"; }

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:4:7: ( ',' )
			// output/Output.g:4:9: ','
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
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:5:7: ( ';' )
			// output/Output.g:5:9: ';'
			{
			match(';'); 
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
			// output/Output.g:6:7: ( '<' )
			// output/Output.g:6:9: '<'
			{
			match('<'); 
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
			// output/Output.g:7:7: ( '=' )
			// output/Output.g:7:9: '='
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:8:7: ( '>' )
			// output/Output.g:8:9: '>'
			{
			match('>'); 
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
			// output/Output.g:9:7: ( '[' )
			// output/Output.g:9:9: '['
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:10:7: ( ']' )
			// output/Output.g:10:9: ']'
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:11:7: ( 'cpu' )
			// output/Output.g:11:9: 'cpu'
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:12:7: ( 'disk' )
			// output/Output.g:12:9: 'disk'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:13:7: ( 'fans' )
			// output/Output.g:13:9: 'fans'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:14:7: ( 'gpu' )
			// output/Output.g:14:9: 'gpu'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:15:7: ( 'm' )
			// output/Output.g:15:9: 'm'
			{
			match('m'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:16:7: ( 'ram' )
			// output/Output.g:16:9: 'ram'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:17:7: ( 't' )
			// output/Output.g:17:9: 't'
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
	// $ANTLR end "T__23"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:70:2: ( IdentifierNondigit ( IdentifierNondigit | DIGIT )* )
			// output/Output.g:70:6: IdentifierNondigit ( IdentifierNondigit | DIGIT )*
			{
			mIdentifierNondigit(); 

			// output/Output.g:71:13: ( IdentifierNondigit | DIGIT )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}
				else if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// output/Output.g:71:17: IdentifierNondigit
					{
					mIdentifierNondigit(); 

					}
					break;
				case 2 :
					// output/Output.g:72:17: DIGIT
					{
					mDIGIT(); 

					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:77:2: ( ( DIGIT )+ ( '.' ( DIGIT )+ )? | '.' ( DIGIT )+ )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
				alt6=1;
			}
			else if ( (LA6_0=='.') ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// output/Output.g:77:4: ( DIGIT )+ ( '.' ( DIGIT )+ )?
					{
					// output/Output.g:77:4: ( DIGIT )+
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
							// output/Output.g:77:4: DIGIT
							{
							mDIGIT(); 

							}
							break;

						default :
							if ( cnt2 >= 1 ) break loop2;
							EarlyExitException eee = new EarlyExitException(2, input);
							throw eee;
						}
						cnt2++;
					}

					// output/Output.g:77:11: ( '.' ( DIGIT )+ )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0=='.') ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// output/Output.g:77:12: '.' ( DIGIT )+
							{
							match('.'); 
							// output/Output.g:77:16: ( DIGIT )+
							int cnt3=0;
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// output/Output.g:77:16: DIGIT
									{
									mDIGIT(); 

									}
									break;

								default :
									if ( cnt3 >= 1 ) break loop3;
									EarlyExitException eee = new EarlyExitException(3, input);
									throw eee;
								}
								cnt3++;
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// output/Output.g:78:4: '.' ( DIGIT )+
					{
					match('.'); 
					// output/Output.g:78:8: ( DIGIT )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// output/Output.g:78:8: DIGIT
							{
							mDIGIT(); 

							}
							break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
						}
						cnt5++;
					}

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
	// $ANTLR end "NUMBER"

	// $ANTLR start "IdentifierNondigit"
	public final void mIdentifierNondigit() throws RecognitionException {
		try {
			// output/Output.g:82:5: ( Nondigit )
			// output/Output.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IdentifierNondigit"

	// $ANTLR start "Nondigit"
	public final void mNondigit() throws RecognitionException {
		try {
			// output/Output.g:85:19: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
			// output/Output.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Nondigit"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// output/Output.g:88:18: ( ( '0' .. '9' )+ )
			// output/Output.g:88:20: ( '0' .. '9' )+
			{
			// output/Output.g:88:20: ( '0' .. '9' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// output/Output.g:
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
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// output/Output.g:89:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// output/Output.g:89:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// output/Output.g:89:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '\t' && LA8_0 <= '\n')||LA8_0=='\r'||LA8_0==' ') ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// output/Output.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// output/Output.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | ID | NUMBER | WS )
		int alt9=17;
		switch ( input.LA(1) ) {
		case ',':
			{
			alt9=1;
			}
			break;
		case ';':
			{
			alt9=2;
			}
			break;
		case '<':
			{
			alt9=3;
			}
			break;
		case '=':
			{
			alt9=4;
			}
			break;
		case '>':
			{
			alt9=5;
			}
			break;
		case '[':
			{
			alt9=6;
			}
			break;
		case ']':
			{
			alt9=7;
			}
			break;
		case 'c':
			{
			int LA9_8 = input.LA(2);
			if ( (LA9_8=='p') ) {
				int LA9_18 = input.LA(3);
				if ( (LA9_18=='u') ) {
					int LA9_25 = input.LA(4);
					if ( ((LA9_25 >= '0' && LA9_25 <= '9')||(LA9_25 >= 'A' && LA9_25 <= 'Z')||LA9_25=='_'||(LA9_25 >= 'a' && LA9_25 <= 'z')) ) {
						alt9=15;
					}

					else {
						alt9=8;
					}

				}

				else {
					alt9=15;
				}

			}

			else {
				alt9=15;
			}

			}
			break;
		case 'd':
			{
			int LA9_9 = input.LA(2);
			if ( (LA9_9=='i') ) {
				int LA9_19 = input.LA(3);
				if ( (LA9_19=='s') ) {
					int LA9_26 = input.LA(4);
					if ( (LA9_26=='k') ) {
						int LA9_31 = input.LA(5);
						if ( ((LA9_31 >= '0' && LA9_31 <= '9')||(LA9_31 >= 'A' && LA9_31 <= 'Z')||LA9_31=='_'||(LA9_31 >= 'a' && LA9_31 <= 'z')) ) {
							alt9=15;
						}

						else {
							alt9=9;
						}

					}

					else {
						alt9=15;
					}

				}

				else {
					alt9=15;
				}

			}

			else {
				alt9=15;
			}

			}
			break;
		case 'f':
			{
			int LA9_10 = input.LA(2);
			if ( (LA9_10=='a') ) {
				int LA9_20 = input.LA(3);
				if ( (LA9_20=='n') ) {
					int LA9_27 = input.LA(4);
					if ( (LA9_27=='s') ) {
						int LA9_32 = input.LA(5);
						if ( ((LA9_32 >= '0' && LA9_32 <= '9')||(LA9_32 >= 'A' && LA9_32 <= 'Z')||LA9_32=='_'||(LA9_32 >= 'a' && LA9_32 <= 'z')) ) {
							alt9=15;
						}

						else {
							alt9=10;
						}

					}

					else {
						alt9=15;
					}

				}

				else {
					alt9=15;
				}

			}

			else {
				alt9=15;
			}

			}
			break;
		case 'g':
			{
			int LA9_11 = input.LA(2);
			if ( (LA9_11=='p') ) {
				int LA9_21 = input.LA(3);
				if ( (LA9_21=='u') ) {
					int LA9_28 = input.LA(4);
					if ( ((LA9_28 >= '0' && LA9_28 <= '9')||(LA9_28 >= 'A' && LA9_28 <= 'Z')||LA9_28=='_'||(LA9_28 >= 'a' && LA9_28 <= 'z')) ) {
						alt9=15;
					}

					else {
						alt9=11;
					}

				}

				else {
					alt9=15;
				}

			}

			else {
				alt9=15;
			}

			}
			break;
		case 'm':
			{
			int LA9_12 = input.LA(2);
			if ( ((LA9_12 >= '0' && LA9_12 <= '9')||(LA9_12 >= 'A' && LA9_12 <= 'Z')||LA9_12=='_'||(LA9_12 >= 'a' && LA9_12 <= 'z')) ) {
				alt9=15;
			}

			else {
				alt9=12;
			}

			}
			break;
		case 'r':
			{
			int LA9_13 = input.LA(2);
			if ( (LA9_13=='a') ) {
				int LA9_23 = input.LA(3);
				if ( (LA9_23=='m') ) {
					int LA9_29 = input.LA(4);
					if ( ((LA9_29 >= '0' && LA9_29 <= '9')||(LA9_29 >= 'A' && LA9_29 <= 'Z')||LA9_29=='_'||(LA9_29 >= 'a' && LA9_29 <= 'z')) ) {
						alt9=15;
					}

					else {
						alt9=13;
					}

				}

				else {
					alt9=15;
				}

			}

			else {
				alt9=15;
			}

			}
			break;
		case 't':
			{
			int LA9_14 = input.LA(2);
			if ( ((LA9_14 >= '0' && LA9_14 <= '9')||(LA9_14 >= 'A' && LA9_14 <= 'Z')||LA9_14=='_'||(LA9_14 >= 'a' && LA9_14 <= 'z')) ) {
				alt9=15;
			}

			else {
				alt9=14;
			}

			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case '_':
		case 'a':
		case 'b':
		case 'e':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 's':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt9=15;
			}
			break;
		case '.':
		case '0':
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
			alt9=16;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt9=17;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 9, 0, input);
			throw nvae;
		}
		switch (alt9) {
			case 1 :
				// output/Output.g:1:10: T__10
				{
				mT__10(); 

				}
				break;
			case 2 :
				// output/Output.g:1:16: T__11
				{
				mT__11(); 

				}
				break;
			case 3 :
				// output/Output.g:1:22: T__12
				{
				mT__12(); 

				}
				break;
			case 4 :
				// output/Output.g:1:28: T__13
				{
				mT__13(); 

				}
				break;
			case 5 :
				// output/Output.g:1:34: T__14
				{
				mT__14(); 

				}
				break;
			case 6 :
				// output/Output.g:1:40: T__15
				{
				mT__15(); 

				}
				break;
			case 7 :
				// output/Output.g:1:46: T__16
				{
				mT__16(); 

				}
				break;
			case 8 :
				// output/Output.g:1:52: T__17
				{
				mT__17(); 

				}
				break;
			case 9 :
				// output/Output.g:1:58: T__18
				{
				mT__18(); 

				}
				break;
			case 10 :
				// output/Output.g:1:64: T__19
				{
				mT__19(); 

				}
				break;
			case 11 :
				// output/Output.g:1:70: T__20
				{
				mT__20(); 

				}
				break;
			case 12 :
				// output/Output.g:1:76: T__21
				{
				mT__21(); 

				}
				break;
			case 13 :
				// output/Output.g:1:82: T__22
				{
				mT__22(); 

				}
				break;
			case 14 :
				// output/Output.g:1:88: T__23
				{
				mT__23(); 

				}
				break;
			case 15 :
				// output/Output.g:1:94: ID
				{
				mID(); 

				}
				break;
			case 16 :
				// output/Output.g:1:97: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 17 :
				// output/Output.g:1:104: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
