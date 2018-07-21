
import java.util.Arrays;

public class KDTree {

    private interface KDTreeDataStructure {

        public Node add(int[] point);

        public boolean contains(int[] point);

    }

    private static class Node {

        int[] point;
        Node left, right;

        public Node(int[] pt) {
            point = pt;
        }

    }

    private static class KDTree1 implements KDTreeDataStructure {

        final int k;
        Node root;

        public KDTree1(int kdims) {
            k = kdims;
        }

        public Node add(int[] point) {

            root = add(root, point, 0);

            return root;

        }

        private Node add(Node node, int[] point, int depth) {

            if (node == null) {
                return new Node(point);
            }

            int dim = depth % k;

            if (point[dim] < node.point[dim]) {
                node.left = add(node.left, point, depth + 1);
            } else {
                node.right = add(node.right, point, depth + 1);
            }

            return node;

        }

        public boolean contains(int[] point) {

            return contains(root, point, 0);

        }

        private boolean contains(Node node, int[] point, int depth) {

            if (node == null) {
                return false;
            } else if (Arrays.equals(point, node.point)) {
                return true;
            }

            int dim = depth % k;

            if (point[dim] < node.point[dim]) {
                return contains(node.left, point, depth + 1);
            } else {
                return contains(node.right, point, depth + 1);
            }

        }

    }

    public static void main(String[] args) {

        KDTreeDataStructure[] kdTreeClasses = new KDTreeDataStructure[]{new KDTree1(2)};

        for (KDTreeDataStructure kdTree : kdTreeClasses) {

            kdTree.add(new int[]{1, 2});
            kdTree.add(new int[]{3, 4});
            kdTree.add(new int[]{5, 6});
            kdTree.add(new int[]{-1, 1});
            kdTree.add(new int[]{10, -10});
            kdTree.add(new int[]{2, 2});
            kdTree.add(new int[]{5, 5});

            System.out.println(kdTree.contains(new int[]{-1, 1}));
            System.out.println(kdTree.contains(new int[]{10, 10}));

            System.out.println("------");

        }

    }

}
