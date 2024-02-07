package StackQueues;

public class ParenthesesChecker {
	public static boolean check(String string) {
		Stack<Character> stack = new LinkedStack<Character>();
		for (int i=0; i<string.length(); i++) {
			char character = string.charAt(i);
			if (character == '(') {
				stack.push(character);
			}
			else {
				if (stack.size() == 0) {
					return false;
				}
				stack.pop();
			}
		}
		if (stack.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		String brakets = "())(()";
		System.out.println(ParenthesesChecker.check(brakets));
	}
}

