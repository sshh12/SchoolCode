
public class Permutations {

    private static void swap(char[] chars, int a, int b) {

        char temp = chars[a];

        chars[a] = chars[b];
        chars[b] = temp;

    }

    public static void printPermutations(char[] chars, int index) {

        if (index == chars.length - 1) {

            System.out.println(String.valueOf(chars));

        } else {

            for (int i = index; i < chars.length; i++) {

                swap(chars, index, i);

                printPermutations(chars, index + 1);

                swap(chars, index, i);

            }

        }

    }

    public static void main(String[] args) {

        printPermutations("asdf".toCharArray(), 0);

    }

}
