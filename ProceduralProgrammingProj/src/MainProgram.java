import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MainProgram {

	public static void main(String[] args) {

		
		System.out.println("## Q4Example1:");
		String prog1 = readFile("src/Q4Example1.txt");
		scan(prog1);
		System.out.println("\n## Q4Example2:");
		String prog2 = readFile("src/Q4Example2.txt");
		scan(prog2);
		System.out.println("\n## Q4Example3:");
		String prog3 = readFile("src/Q4Example3.txt");
		scan(prog3);
		System.out.println("\n## Q4Example4:");
		String prog4 = readFile("src/Q4Example4.txt");
		scan(prog4);
		System.out.println("\n## Q4Example5:");
		String prog5 = readFile("src/Q4Example5.txt");
		scan(prog5);

	}
	/**
	 * To check if a character is a single character operator(>,+,-,*,/,%)
	 * @param the character
	 * @return The corresponding token type for the character
	 */
	public static TokenType getOp(char ch) {
		
		switch (ch) {
		case '*':
			return TokenType.OP_MULTIPLY;
		case '/':
			return TokenType.OP_DIVIDE;
		case '%':
			return TokenType.OP_MOD;
		case '+':
			return TokenType.OP_ADD;
		case '-':
			return TokenType.OP_SUBTRACT;
		case '<':
			return TokenType.OP_LESS;
		case '>':
			return TokenType.OP_GREATER;
		case '=':
			return TokenType.OP_ASSIGN;
		
		default:
			return null;
		
		}
	
	}
	/**
	 * To check if string is a double character operator(<=,>=,== etc)
	 * @param s the string
	 * @return The corresponding token type for the character
	 */
	public static TokenType getOp(String s) {
	
		switch (s) {
		case "<=":
			return TokenType.OP_LESSEQUAL;
		case ">=":
			return TokenType.OP_GREATEREQUAL;
		case "==":
			return TokenType.OP_EQUAL;
		case "!=":
			return TokenType.OP_NOTEQUAL;
	
	default:
		return null;
	
	}
}
	
	/**
	 * To check if the character is a symbol
	 * @param ch the character
	 * @return The corresponding token type for the character 
	 */
	public static TokenType getSymbol(char ch) {
		
		switch (ch) {
		case '(':
			return TokenType.LEFT_PAREN;
		case ')':
			return TokenType.RIGHT_PAREN;
		case '{':
			return TokenType.LEFT_BRACE;
		case '}':
			return TokenType.RIGHT_BRACE;
		case '[':
			return TokenType.LEFT_BRACKET;
		case ']':
			return TokenType.RIGHT_BRACKET;
		case ';':
			return TokenType.SEMICOLON;
		case ',':
			return TokenType.COMMA;
		
		default:
			return null;
		
		}
		
	}
	
	/**
	 * To check if the word is a keyword
	 * @param s the string
	 * @return The corresponding token type for the character
	 */
public static TokenType getKeyword(String s) {
		
		switch (s) {
		case "if":
			return TokenType.KEYWORD_IF;
		case "else":
			return TokenType.KEYWORD_ELSE;
		case "int":
			return TokenType.KEYWORD_INT;
		case "String":
			return TokenType.KEYWORD_STRING;
		case "public":
			return TokenType.KEYWORD_PUBLIC;
		case "class":
			return TokenType.KEYWORD_CLASS;
		case "void":
			return TokenType.KEYWORD_VOID;
		case "static":
			return TokenType.KEYWORD_STATIC;
		
		default: return null;
		
		}
	}
	
	/**
	 * To check if the word is a klingon statement
	 * @param s the string
	 * @return The corresponding token type for the character
	 */
public static TokenType getKlingon(String s) {
	
	switch (s) {
	case "rItlh":
		return TokenType.KLINGON_PRINT;
	case "boq":
		return TokenType.KLINGON_ADD;
	case "boqha":
		return TokenType.KLINGON_SUBTRACT;
	case "boqegh":
		return TokenType.KLINGON_MULTIPLY;
	case "boqHaegh":
		return TokenType.KLINGON_DIVIDE;

	
	default:
		return null;
	
	}
}
	
	/**
	 * To check if the character is a letter
	 * @param ch the character
	 * @return returns true if character is a letter and false if the character is not a letter
	 */
	public static boolean isLetter(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			return true;
		}
		else if (ch >= 'A' && ch <= 'Z') {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * To check if the character is a digit
	 * @param ch the character
	 * @return returns true if character is a digit and false if the character is not a digit
	 */
	public static boolean isDigit (char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * To check if the character is a white space
	 * @param ch the character
	 * @return returns true if character is a white space and false if the character is not a white space
	 */
	public static boolean isWhiteSpace (char ch) {
		if (ch == ' ') {
			return true;
		}
		else if (ch == '\t') {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * To check if the character is a line break character(\n)
	 * @param ch the character
	 * @return returns true if character is a line break character and false if the character is not a line break character
	 */
	public static boolean isLineBreak (char ch) {
		if (ch == '\n') {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * This function scans a string into tokens
	 * @param The String prog
	 * @return returns the tokens for all characters in the string
	 */
	public static void scan(String prog) {
		
		int n = prog.length(); // The number of characters of the string. In this case, the klingon java file 
		int index = 0; // The position of the character in the string
		
		int lineNumber = 1; //Line number
		int count = 0; //Count variable to count the left braces and right braces.Increases by 1 if it is a left brace and decreases by 1 if it is a right brace.
		int errorLineLeft = 0; // Detects the error line for the case if number of left braces is deficient
		int errorLineRight = 0; // Detects the error line for the case if number of right braces is deficient
		
		while (index < n) { // While loop to iterate through the whole string character by character.
			
			char ch = prog.charAt(index);  // The current character of the string
			
			boolean whiteSpace = isWhiteSpace(ch); // Boolean variable to indicate white space
			boolean newline = isLineBreak(ch); // Boolean variable to indicate line break
			TokenType sym = getSymbol(ch); // Symbol name or null
			TokenType op = getOp(ch);  // Operator name or null
			boolean letter = isLetter(ch);  // Boolean variable to indicate letter
			boolean digit = isDigit(ch);  // Boolean variable to indicate digit
			
			if (ch == '{') { // Checks if character is '{'
				count ++;
				index ++;
				errorLineLeft = lineNumber;
				
				
			}
			else if (ch == '}') { // Checks if character is '{'
				count --;
				index ++;
				errorLineRight = lineNumber;
				
			}
			
			else if(whiteSpace) { // Checks if ch is a whitespace (' ')
				index ++;
				continue;
			}
			else if (newline) { // Checks if ch is a new line character (\n)
				
				lineNumber ++;
				
				index ++;
				continue;
			}
			
			else if (sym != null) { // Checks if character is a symbol ({,},] etc)
				
				
				index ++;
				continue;
			}
			else if (prog.charAt(index) == '/') { // Checks if character is "/" before checking if op != null so that TokenType.OP_DIVIDE is not returned.
				index ++;
				if (prog.charAt(index) == '/') { // Checks if next character is "/" after first character is "/".
					index ++;
					while (isLineBreak(ch) == false) { // Ignores everything in that line
						ch = prog.charAt(index);
						index ++;
						if (isLineBreak(ch) == true) { // If character is a line break character(\n), linenumber increases by one and this loop is broken.
							lineNumber ++;
							break;
						}
					}
					
				}
				else if (ch == '*') { // Checks if next character is "*" after first character is "/"
					index ++;
					while (index < n) { // While loop to ignore everything while two consecutive characters are "*" and "/" 
						ch = prog.charAt(index);
						index ++;
						if (isLineBreak(ch) == true) { // Adds 1 to linenumber if the character is "\n" since it is a multi line comment
							lineNumber ++;
						}
						else if (prog.charAt(index) == '*' && prog.charAt(index+1) == '/') { // Adds 2 to index then ends the while loop if two consecutive characters are '*' and '/'
							index ++;
							index ++;
							break;
						}
					}
				}
				else { // Prints the statement if its not a single line or multi line comment
					System.out.println(lineNumber + ", " + op + ", " + ch);
				}
				continue;
				
				
			}
			else if (op != null || ch == '!') { // Checks if the character is <,>,=,! basically
				index ++;
				while (index < n) {
					ch = prog.charAt(index);
					if (ch == '=') { // Checks if the character after the first is "=" since that is the only possible second letter for a double char operator
						index ++;
					}
					else { // Breaks if the second character is not '=' basically
						break;
					}
					
	
				}
			}
			else if (letter) { // Checks if ch is a letter
				String word = "";
				word += ch;
				index ++;
				
				while (index < n) {
					ch = prog.charAt(index);
					if (isLetter(ch) || isDigit(ch)) {// Checks if ch is either a letter or digit because an identifier can have numbers in between them.
						word += ch;
						index ++;
						
						
					}
					
					else { // Breaks if the character is neither a letter nor a number after the first letter
						break;
					}
				}
				TokenType keyword = getKeyword(word);
				String impWord = "";
				if (keyword == TokenType.KEYWORD_STATIC) { // Checks if the word is "static" basically
					index ++;
					while (index < n) { // While loop to extract the word after static
						ch = prog.charAt(index);
						if (isWhiteSpace(ch)) {
							break;
						}
						else {
							impWord += ch;
							index ++;
						}
						
					}
					if (impWord.equals("void") == false &&  impWord.equals("int") == false && impWord.equals("String") == false) { // Checks if the word after static is neither String nor int  nor void.Prints error if none of those words are after static.
						System.out.println("Return Type for the method is missing");
						System.out.println("at Line " + lineNumber);
					}
					
				}
				
				continue;
			}
			
			else if (digit) { // Checks if ch is a digit
				if (isDigit(prog.charAt(index)) == true && isLetter(prog.charAt(index+1))) { // Checks if the first digit is followed by a letter. If it is, prints error
					System.out.println("Syntax error on token " + "\"" + prog.charAt(index) + "\"" + ", delete this token");
					System.out.println("at Line " + lineNumber);
					
				}
				index ++;
				while (index < n) {
					ch = prog.charAt(index);// Updates character position every iteration
					if (isDigit(ch)) { // Index updates while every number after the first is a digit.
						index ++;
					}
					else if (prog.charAt(index) == '.') { // If the number contains a ., it  double. Hence an error is printed.
						System.out.println("Type mismatch: cannot convert from double to int");
						System.out.println("at Line " + lineNumber);
						index ++;
						break;
					}
					else { // If the character is not a number, the loop breaks.
						break;
					}
				}

				
				continue;
				
			}
			
			else if (ch == '"') {//Checks the first double quotation of a string literal e.g., "hello world"
				index ++;
				while (index < n) {
					ch = prog.charAt(index);
					if (ch != '"') { // As long as the characters after the first " are not ", The word(str) will keep appending characters.
						index ++;
						 if (isLineBreak(ch)) { // If the code goes to the next line before a ", it prints an error.
								System.out.println("String literal is not properly closed by a double-quote");
								System.out.println("at Line " + lineNumber);
								index ++;
								break;
							}
					}
					else if ( ch == '"') { // If ch is ", the string concatenates the character, index increases by one and the while loop breaks
						index ++;
						break;
					}
				}
				continue;
				
			}
			else { // This is the error statement in case the user types in special characters.
				
				System.out.println("Something unexpected happened " +  ch);
				index ++;
				continue;
			} 
		
		} // This is the closed bracket for while loop
		if(count != 0) {
			if (count > 0) { // If the left braces exceed the number of right braces
			System.out.println("Syntax error, insert " + "\"}\"" + " to complete ClassBody");
			System.out.println("at Line " + errorLineRight);
			}
			else { // If the right braces exceed the number of left braces
				System.out.println("Syntax error, insert " + "\"{\"" + " to complete ClassBody");
				System.out.println("at Line " + errorLineLeft);
			}
		}
		
		
	} // This is the closed bracket for scan method
	
	
	
	/**
	 * To read the content of a file into a string
	 * @param fname the file name
	 * @return the string representing the file content
	 */
	public static String readFile(String fname) {
		String content = null;
		try {
	        content = new String(Files.readAllBytes(Paths.get(fname)));
		} catch (IOException e) {
			System.out.println("Fail to read a file");
		}
		
		return content;
	} // Closed bracket for readFile
	
} // This is the closed bracket for class
