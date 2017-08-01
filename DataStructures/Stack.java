
import java.util.LinkedList;

public class Stack {

    private interface StackDataStructure {

        public void add(int item);

        public int pop();

    }

    private static class Stack1 implements StackDataStructure {

        LinkedList<Integer> items;

        public Stack1() {

            items = new LinkedList<>();

        }

        public void add(int item) {

            items.add(item);

        }

        public int pop() {

            return items.removeLast();

        }

    }

    private static class Stack2 implements StackDataStructure {

        java.util.Stack<Integer> items;

        public Stack2() {

            items = new java.util.Stack();

        }

        public void add(int item) {

            items.add(item);

        }

        public int pop() {

            return items.pop();

        }

    }

    public static void main(String[] args) {

        StackDataStructure[] stackClasses = new StackDataStructure[]{new Stack1(), new Stack2()};

        for (StackDataStructure stack : stackClasses) {

            stack.add(1);
            stack.add(2);

            System.out.println(stack.pop());

            stack.add(3);

            System.out.println(stack.pop());

            System.out.println("------");

        }

    }

}
