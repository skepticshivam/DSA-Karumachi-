
import java.util.Stack;

public class PalindromeTest {

    public static void main(String[] args) {

        String input = "ababa";
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reverseInput = "";

        while (!stack.isEmpty()) {
            reverseInput += stack.pop();
        }

        if (input.equals(reverseInput))
            System.out.println("Yo! that is a palindrome.");
        else
            System.out.println("No! that isn't a palindrome.");

    }
}
