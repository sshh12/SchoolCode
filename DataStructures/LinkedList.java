
public class LinkedList {

    private interface LinkedListDataStructure {

        public void add(int item);

        public void addFront(int item);

        public void remove();

        public void removeFront();

        public int get(int index);

        public void set(int index, int item);

        public int size();

    }

    private static class Node {

        int data;
        Node nextNode;

        public Node(int value, Node next) {

            data = value;
            nextNode = next;

        }

    }

    private static class LinkedList1 implements LinkedListDataStructure {

        Node root;
        int length;

        public LinkedList1() {

        }

        public void add(int item) {

            if (root == null) {

                root = new Node(item, null);

            } else {

                Node node = this.root;

                while (node.nextNode != null) {

                    node = node.nextNode;

                }

                node.nextNode = new Node(item, null);

            }

            length++;

        }

        public void addFront(int item) {

            root = new Node(item, root);

            length++;

        }

        public void remove() {

            Node node = root;

            if (node.nextNode != null) {

                while (node.nextNode.nextNode != null) {

                    node = node.nextNode;

                }

                node.nextNode = null;

            } else {

                root = null;

            }

            length--;

        }

        public void removeFront() {

            root = root.nextNode;

            length--;

        }

        public int get(int index) {

            Node node = root;

            for (int i = 0; i < index; i++) {

                node = node.nextNode;

            }

            return node.data;

        }

        public void set(int index, int item) {

            Node node = root;

            for (int i = 0; i < index; i++) {

                node = node.nextNode;

            }

            node.data = item;

        }

        public int size() {

            return length;

        }

    }

    private static class LinkedList2 implements LinkedListDataStructure {

        java.util.LinkedList<Integer> linkedList;

        public LinkedList2() {

            linkedList = new java.util.LinkedList<>();

        }

        public void add(int item) {

            linkedList.add(item);

        }

        public void addFront(int item) {

            linkedList.addFirst(item);

        }

        public void remove() {

            linkedList.removeLast();

        }

        public void removeFront() {

            linkedList.removeFirst();

        }

        public int get(int index) {

            return linkedList.get(index);

        }

        public void set(int index, int item) {

            linkedList.set(index, item);

        }

        public int size() {

            return linkedList.size();

        }

    }

    public static void main(String[] args) {

        LinkedListDataStructure[] linkedListClasses = new LinkedListDataStructure[]{new LinkedList1(), new LinkedList2()};

        for (LinkedListDataStructure linkedList : linkedListClasses) {

            System.out.println(linkedList.size());

            linkedList.add(1);
            linkedList.add(2);
            linkedList.add(3);

            System.out.println(linkedList.get(2));

            linkedList.set(1, 4);

            System.out.println(linkedList.get(1));

            System.out.println(linkedList.get(0));

            linkedList.removeFront();

            linkedList.add(5);

            linkedList.remove();

            System.out.println(linkedList.get(0));

            linkedList.addFront(6);

            System.out.println(linkedList.get(0));

            System.out.println(linkedList.get(1));

            linkedList.add(7);
            linkedList.add(8);

            System.out.println(linkedList.size());

            System.out.println("------");

        }

    }

}
