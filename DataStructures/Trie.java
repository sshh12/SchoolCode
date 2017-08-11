
public class Trie {

    private interface TrieDataStructure {

        public void add(String item);

        public boolean contains(String item);

        public void remove(String item);

    }

    private static class Node {

        Node[] children;
        boolean isEnd;

        public Node() {

            children = new Node[26];

        }

        public boolean hasChild() {

            for (Node child : children) {

                if (child != null) {

                    return true;

                }

            }

            return false;

        }

    }

    private static class Trie1 implements TrieDataStructure {

        Node root;

        public Trie1() {

            root = new Node();

        }

        private int getIndex(char c) {

            return c - 97;

        }

        public void add(String item) {

            Node node = root;

            for (int i = 0; i < item.length(); i++) {

                int index = getIndex(item.charAt(i));

                if (node.children[index] == null) {

                    node.children[index] = new Node();

                }

                node = node.children[index];

            }

            node.isEnd = true;

        }

        public void remove(String item) {

            delete(item, root, 0);

        }

        private boolean delete(String item, Node node, int depth) {

            if (node != null) {

                if (depth == item.length()) {

                    node.isEnd = false;

                    return !node.hasChild();

                } else {

                    int index = getIndex(item.charAt(depth));

                    if (delete(item, node.children[index], depth + 1)) {

                        node.children[index] = null;

                        return (!node.isEnd && !node.hasChild());

                    }

                }

            }

            return false;

        }

        public boolean contains(String item) {

            Node node = root;

            for (int i = 0; i < item.length(); i++) {

                int index = getIndex(item.charAt(i));

                if (node.children[index] == null) {

                    return false;

                }

                node = node.children[index];

            }

            return (node != null && node.isEnd);

        }

    }

    public static void main(String[] args) {

        TrieDataStructure[] trieClasses = new TrieDataStructure[]{new Trie1()};

        for (TrieDataStructure trie : trieClasses) {

            trie.add("the");
            trie.add("a");
            trie.add("there");
            trie.add("any");
            trie.add("by");
            trie.add("bye");

            System.out.println(trie.contains("the"));
            System.out.println(trie.contains("bye"));
            System.out.println(trie.contains("t"));
            System.out.println(trie.contains("these"));
            System.out.println(trie.contains("ant"));

            trie.add("ant");
            trie.remove("bye");

            System.out.println(trie.contains("ant"));
            System.out.println(trie.contains("bye"));

            System.out.println("------");

        }

    }

}
