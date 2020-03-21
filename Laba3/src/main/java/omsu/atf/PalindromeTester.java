package omsu.atf;

public class PalindromeTester {

    private final String sourceWord;
    private final String formattedWord;

    public PalindromeTester(String sourceWord) {
        this.sourceWord = sourceWord;
        this.formattedWord = sourceWord
                .trim()
                .toUpperCase()
                .replaceAll("[_!\\s.,?@\"#№$;%\\^:&\\*()\\-+=/]", "");
    }

    public String getSourceWord() {
        return sourceWord;
    }

    public String getFormattedWord() {
        return formattedWord;
    }

    public String testPalindrome() {
        LinkedQueue<Character> queue = fillQueue(formattedWord);
        Stack<Character> stack = fillStack(formattedWord);

        while (stack.peek() != null) {
            if (!stack.peek().equals(queue.peek()))
                return String.format(
                        "\"%s\" is not a palindrome. Symbol '%c' and '%c' dont have a pair",
                        sourceWord, queue.pop(), stack.pop());
            stack.pop();
            queue.pop();
        }
        return String.format("%s is a palindrome", sourceWord);
    }

    public boolean isPalindrome() {
        LinkedQueue<Character> queue = fillQueue(formattedWord);
        Stack<Character> stack = fillStack(formattedWord);

        while (stack.peek() != null) {
            if (!stack.peek().equals(queue.peek())) return false;
            stack.pop();
            queue.pop();
        }
        return true;
    }

    private LinkedQueue<Character> fillQueue(final String word) {
        LinkedQueue<Character> queue = new LinkedQueue<>();
        word.chars().forEach(symbol -> queue.push((char) symbol));
        return queue;
    }

    private Stack<Character> fillStack(final String word) {
        Stack<Character> stack = new Stack<>();
        word.chars().forEach(symbol -> stack.push((char) symbol));
        return stack;
    }
}
