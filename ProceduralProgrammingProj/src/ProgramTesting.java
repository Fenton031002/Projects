
public class ProgramTesting {

	public static void main(String[] args) {
		System.out.println("### getOp single char function");
		getOp_returnNotNull();
		System.out.println();
		getOp_returnNull();
		System.out.println("\n");
		System.out.println("### getOp double char function");
		getOp_StringreturnNotNull();
		System.out.println();
		getOp_StringreturnNull();
		System.out.println("\n");
		System.out.println("### getSymbol function");
		getSymbol_returnNotNull();
		System.out.println();
		getSymbol_returnNull();
		System.out.println("\n");
		System.out.println("### getKeyword function");
		getKeyword_returnNotNull();
		System.out.println();
		getKeyword_returnNull();
		System.out.println("\n");
		System.out.println("### getKlingon function");
		getKlingon_returnNotNull();
		System.out.println();
		getKlingon_returnNull();
		System.out.println("\n");
		System.out.println("### isLetter function");
		isLetter_returnTrue();
		System.out.println();
		isLetter_returnNotTrue();
		System.out.println("\n");
		System.out.println("### isDigit function");
		isLetter_returnTrue();
		System.out.println();
		isLetter_returnNotTrue();
		System.out.println("\n");
		System.out.println("### isWhiteSpace function");
		isWhiteSpace_returnTrue();
		System.out.println();
		isWhiteSpace_returnNotTrue();
		System.out.println("\n");
		System.out.println("### isLineBreak function");
		isLineBreak_returnTrue();
		System.out.println();
		isLineBreak_returnNotTrue();
		

	}
	/*
	 * Function for testing the getOp function(single char)
	 * Tests '+'
	 * Prints TokenType.OP_ADD
	 */
	public static void getOp_returnNotNull() {
		TokenType t = MainProgram.getOp('+');
		System.out.println("Tested character - +");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + TokenType.OP_ADD);
	}
	/*
	 * Function for testing the getOp function(single char)
	 * Tests - 'a'
	 * Returns null
	 */
	public static void getOp_returnNull() {
		TokenType t = MainProgram.getOp('a');
		System.out.println("Tested character - a");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + null);
	}
	/*
	 * Function for testing the getOpfunction (double char)
	 * Tests string - ">="
	 * Returns TokenType.OP_GREATEREQUAL
	 */
	public static void getOp_StringreturnNotNull() {
		TokenType t = MainProgram.getOp(">=");
		System.out.println("Tested string - >=");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + TokenType.OP_GREATEREQUAL);
	}
	/*
	 * Function for testing the getOp function (double char)
	 * Tests character - 'u'
	 * Returns null
	 */
	public static void getOp_StringreturnNull() {
		TokenType t = MainProgram.getOp("u");
		System.out.println("Tested character - u");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + null);
	}
	/*
	 * Function for testing the getSymbol function
	 * Tests character - '['
	 * Returns TokenType.LEFT_BRACKET
	 */
	public static void getSymbol_returnNotNull() {
		TokenType t = MainProgram.getSymbol('[');
		System.out.println("Tested character - [");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + TokenType.LEFT_BRACKET);
	}
	/*
	 * Function for testing the getSymbol function
	 * Tests character - 'A'
	 * Returns null
	 */
	public static void getSymbol_returnNull() {
		TokenType t = MainProgram.getSymbol('A');
		System.out.println("Tested character - A");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + null);
	}
	/*
	 * Function for testing the getKeyword function
	 * Tests string - "void"
	 * Returns TokenType.KEYWORD_VOID
	 */
	public static void getKeyword_returnNotNull () {
		
		TokenType t = MainProgram.getKeyword("void");
		System.out.println("Tested string - void");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + TokenType.KEYWORD_VOID);
	}
	/*
	 * Function for testing the getKeyword function
	 * Tests character - 'd'
	 * Returns null
	 */
	public static void getKeyword_returnNull () {
			
		TokenType t = MainProgram.getKeyword("d");
		System.out.println("Tested character - d");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + null);
	}
	/*
	 * Function for testing the getKlingon method
	 * Tests string - "boqegh"
	 * Returns TokenType.KLINGON_MULTIPLY
	 */
	public static void getKlingon_returnNotNull () {
					
		TokenType t = MainProgram.getKlingon("boqegh");
		System.out.println("Tested string - boqegh");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + TokenType.KLINGON_MULTIPLY);
	}
	/*
	 * Function for testing the getKlingon function
	 * Tests string - "boqa"
	 * Returns null
	 */			
	public static void getKlingon_returnNull () {
					
		TokenType t = MainProgram.getKlingon("boqa");
		System.out.println("Tested string - boqa");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + null);
	}
	/*
	 * Function for testing the isLetter function
	 * Tests character - '0'
	 * Returns false
	 */
	public static void isLetter_returnNotTrue () {
			
		boolean t = MainProgram.isLetter('0');
		System.out.println("Tested character - 0");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + false);
	}
	/*
	 * Function for testing the isLetter function
	 * Tests character - 'X'
	 * Returns true
	 */			
	public static void isLetter_returnTrue () {
					
		boolean t = MainProgram.isLetter('X');
		System.out.println("Tested character - X");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + true);
	}
	/*
	 * Function for testing the isDigit function
	 * Tests character - 'g'
	 * Returns false
	 */
	public static void isDigit_returnNotTrue () {
			
		boolean t = MainProgram.isDigit('g');
		System.out.println("Tested character - g");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + false);
		}
	/*
	 * Function for testing the isDigit function
	 * Tests character - '2'
	 * Returns true
	 */		
	public static void isDigit_returnTrue () {
					
		boolean t = MainProgram.isDigit('2');
		System.out.println("Tested character - 2");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + true);
		}
	/*
	 * Function for testing the isWhiteSpace function
	 * Tests string - ">"
	 * Returns false
	 */
	public static void isWhiteSpace_returnNotTrue () {
			
		boolean t = MainProgram.isWhiteSpace('>');
		System.out.println("Tested character - >");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + false);
		}
	/*
	 * Function for testing the getOp(String) function
	 * Tests character - '\t'
	 * Returns true
	 */			
	public static void isWhiteSpace_returnTrue () {
					
		boolean t = MainProgram.isWhiteSpace('\t');
		System.out.println("Tested character - \\t");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + true);
		}
	/*
	 * Function for testing the getOp(String) function
	 * Tests character - '/'
	 * Returns false
	 */
	public static void isLineBreak_returnNotTrue () {
			
		boolean t = MainProgram.isLineBreak('/');
		System.out.println("Tested character - /");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + false);
		}
	/*
	 * Function for testing the getOp(String) function
	 * Tests character - '\n'
	 * Returns true
	 */			
	public static void isLineBreak_returnTrue () {
					
		boolean t = MainProgram.isLineBreak('\n');
		System.out.println("Tested character - \\n");
		System.out.println("Tested output: " + t);
		System.out.println("Expected output: " + true);
		}

}
