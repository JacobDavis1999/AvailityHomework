
import java.util.Scanner;
import java.util.Stack;


public class ParenthChecker {

	public static void main(String[] args) {
		//Open scanner to detect user input
		Scanner userInput = new Scanner(System.in);
		
		//Loop program until user enters E
		while(true) {
			
		System.out.println("Please enter the LISP code for correct parenthesis placement detection: ");
		System.out.println("To exit program, type E ");

	    String lisp = userInput.nextLine();
	    
	    //If user typed E, exit loop
	   if(lisp.equals("E")) {
	    	break;
	    }
	    
	    //Method call for correct parenthesis placement detection
	    boolean check = parenthesesChecker(lisp);
	    
	    //If method returns true, LISP code has valid parenthesis placement
	    if(check == true) {
	    	System.out.println("Valid LISP Code");
	    //If method returns false, LISP code has invalid parenthesis placement
	    }else {
	    	System.out.println("Invalid LISP Code");
	    }
	    
	    System.out.println("---------------------------------");
	    
	    }
	    //Close Scanner
	    userInput.close();

	}
	
	//Method for correct parenthesis placement detection, accepts string as a parameter
public static boolean parenthesesChecker(String s) {
	
	//Character stack 

	Stack<Character> parenthesesStack = new Stack<Character>();
	
	
	//Char array with length equal to user input string length
    char[] tokenized = new char[s.length()];
    
    
    //Tokenize user string and place into char array
    for(int i = 0; i< s.length(); i++) {
    	tokenized[i] = s.charAt(i);
    }
	
	//Loop through Stack
	for(int i = 0; i<tokenized.length; i++) {

		//If an open parenthesis, push onto stack
		if(tokenized[i] == '(') {
			parenthesesStack.push('(');
		}
		
		
		//If stack is not empty and the top is an '(', then pop; else return false
		if(tokenized[i] == ')') {
			if(!parenthesesStack.isEmpty() && parenthesesStack.peek() == '(') {
				parenthesesStack.pop();
			}else {
				return false;
			}		
		}
	}
	
	//Return true if stack is empty
	if(parenthesesStack.isEmpty()) {
		return true;
	}else {
		return false;
	}
	
	
	}

}


