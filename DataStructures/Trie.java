
public class Trie {

    private interface TrieDataStructure {

        public void add(String item);

        public boolean contains(String item);

    }

    private static class Node {

        Node[] children;
        boolean isEnd;

        public Node() {

            children = new Node[26];

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
            trie.add("answer");

            System.out.println(trie.contains("the"));
            System.out.println(trie.contains("bye"));
            System.out.println(trie.contains("t"));
            System.out.println(trie.contains("these"));
            System.out.println(trie.contains("ant"));

            trie.add("ant");

            System.out.println(trie.contains("ant"));

            System.out.println("------");

        }

    }

}
