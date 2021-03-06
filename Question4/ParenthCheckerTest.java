

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParenthCheckerTest {

	@Test
	void StartWithClosing() {
		String test = ")()()";
		boolean expected = false;
		assertEquals(expected, ParenthChecker.parenthesesChecker(test));
	}
	
	@Test
	void EndWithOpen() {
		String test = "()()(";
		boolean expected = false;
		assertEquals(expected, ParenthChecker.parenthesesChecker(test));
	}
	
	@Test
	void Valid() {
		String test = "(()(()))";
		boolean expected = true;
		assertEquals(expected, ParenthChecker.parenthesesChecker(test));
	}
	
	@Test
	void ShortestValid() {
		String test = "()";
		boolean expected = true;
		assertEquals(expected, ParenthChecker.parenthesesChecker(test));
	}
	
	@Test
	void NoParenthesis() {
		String test = "456";
		boolean expected = true;
		assertEquals(expected, ParenthChecker.parenthesesChecker(test));
	}
	
	@Test
	void ExtraClosing() {
		String test = "(()(())))";
		boolean expected = false;
		assertEquals(expected, ParenthChecker.parenthesesChecker(test));
	}
	
	@Test
	void ExtraOpening() {
		String test = "((()(()))";
		boolean expected = false;
		assertEquals(expected, ParenthChecker.parenthesesChecker(test));
	}
	
	

}
