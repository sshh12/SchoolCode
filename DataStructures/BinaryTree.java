
import java.util.ArrayList;

public class BinaryTree {

    private interface BinaryTreeDataStructure {

        public void add(int item);

        public void remove(int item);

        public boolean contains(int item);

        public ArrayList<Integer> getPreOrder();

        public ArrayList<Integer> getInOrder();

        public ArrayList<Integer> getPostOrder();

    }

    private static class Node {

        int data;
        Node left, right;

        public Node(int value) {
            data = value;
        }

    }

    private static class BinaryTree1 implements BinaryTreeDataStructure {

        Node root;

        public BinaryTree1() {
        }

        public void add(int item) {

            if (root == null) {
                root = new Node(item);
            } else {
                add(root, item);
            }

        }

        private void add(Node node, int item) {

            if (item < node.data) {

                if (node.left != null) {
                    add(node.left, item);
                } else {
                    node.left = new Node(item);
                }

            } else {

                if (node.right != null) {
                    add(node.right, item);
                } else {
                    node.right = new Node(item);
                }

            }

        }

        public void remove(int item) {
            root = deleteItem(root, item);
        }

        private Node minItem(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        private Node deleteItem(Node node, int item) {

            if (node != null) {

                if (item < node.data) {
                    node.left = deleteItem(node.left, item);
                } else if (item > node.data) {
                    node.right = deleteItem(node.right, item);
                } else {
                    if (node.left == null) {
                        return node.right;
                    } else if (node.right == null) {
                        return node.left;
                    } else {
                        Node minNode = minItem(node.right);
                        node.data = minNode.data;
                        node.right = deleteItem(node.right, minNode.data);
                    }
                }

            }

            return node;

        }

        public boolean contains(int item) {
            return contains(root, item);
        }

        private boolean contains(Node node, int item) {

            if (node == null) {
                return false;
            } else if (item == node.data) {
                return true;
            } else if (item < node.data) {
                return contains(node.left, item);
            } else {
                return contains(node.right, item);
            }

        }

        public ArrayList<Integer> getPreOrder() {

            ArrayList<Integer> items = new ArrayList<>();

            getPreOrder(root, items);

            return items;

        }

        private void getPreOrder(Node node, ArrayList<Integer> items) {

            if (node == null) {
                return;
            }

            items.add(node.data);

            getPreOrder(node.left, items);
            getPreOrder(node.right, items);

        }

        public ArrayList<Integer> getInOrder() {

            ArrayList<Integer> items = new ArrayList<>();

            getInOrder(root, items);

            return items;

        }

        private void getInOrder(Node node, ArrayList<Integer> items) {

            if (node == null) {
                return;
            }

            getInOrder(node.left, items);

            items.add(node.data);

            getInOrder(node.right, items);

        }

        public ArrayList<Integer> getPostOrder() {

            ArrayList<Integer> items = new ArrayList<>();

            getPostOrder(root, items);

            return items;

        }

        private void getPostOrder(Node node, ArrayList<Integer> items) {

            if (node == null) {

                return;

            }

            getPostOrder(node.left, items);
            getPostOrder(node.right, items);

            items.add(node.data);

        }

    }

    public static void main(String[] args) {

        BinaryTreeDataStructure[] binTreeClasses = new BinaryTreeDataStructure[]{new BinaryTree1()};

        for (BinaryTreeDataStructure binTree : binTreeClasses) {

            binTree.add(1);
            binTree.add(0);
            binTree.add(2);

            System.out.println(binTree.contains(2));
            System.out.println(binTree.getInOrder());
            System.out.println(binTree.getPreOrder());
            System.out.println(binTree.getPostOrder());

            binTree.remove(1);
            binTree.add(3);
            binTree.add(-1);
            binTree.add(-3);
            binTree.add(-2);

            System.out.println(binTree.contains(1));
            System.out.println(binTree.getInOrder());

            System.out.println("------");

        }

    }

}
