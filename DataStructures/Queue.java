
import java.util.ArrayList;
import java.util.LinkedList;

public class Queue {

    private interface QueueDataStructure {

        public void add(int item);

        public int remove();

    }

    private static class Queue1 implements QueueDataStructure {

        ArrayList<Integer> items;

        public Queue1() {

            items = new ArrayList<>();

        }

        public void add(int item) {

            items.add(item);

        }

        public int remove() {

            return items.remove(0);

        }

    }

    private static class Queue2 implements QueueDataStructure {

        java.util.Queue<Integer> items;

        public Queue2() {

            items = new LinkedList();

        }

        public void add(int item) {

            items.add(item);

        }

        public int remove() {

            return items.remove();

        }

    }

    public static void main(String[] args) {

        QueueDataStructure[] queueClasses = new QueueDataStructure[]{new Queue1(), new Queue2()};

        for (QueueDataStructure queue : queueClasses) {

            queue.add(1);
            queue.add(2);

            System.out.println(queue.remove());

            queue.add(3);

            System.out.println(queue.remove());

            System.out.println("------");

        }

    }

}
