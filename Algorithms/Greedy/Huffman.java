
import java.util.*;

public class Huffman {

    private static class Node implements Comparable<Node> {

        Node left, right;
        char value;
        int freq;

        public Node(char ch, int f) {

            value = ch;
            freq = f;

        }

        @Override
        public int compareTo(Node other) {

            return freq - other.freq;

        }

    }

    private static Map<Character, Integer> getFreqMap(String msg) {

        Map<Character, Integer> map = new TreeMap<>();

        for (char c : msg.toCharArray()) {

            if (map.containsKey(c)) {

                map.put(c, map.get(c) + 1);

            } else {

                map.put(c, 1);

            }

        }

        return map;

    }

    private static void addCodes(Node node, Map<Character, String> codes, String prefix) {

        if (node != null) {

            if (node.value != '*') {

                codes.put(node.value, prefix);

            }

            addCodes(node.left, codes, prefix + "0");
            addCodes(node.right, codes, prefix + "1");

        }

    }

    public static Map<Character, String> getHuffmanCodes(String msg) {

        Map<Character, Integer> freqs = getFreqMap(msg);

        PriorityQueue<Node> heap = new PriorityQueue<>();

        for (char c : freqs.keySet()) {

            heap.add(new Node(c, freqs.get(c)));

        }

        while (heap.size() > 1) {

            Node left = heap.remove(), right = heap.remove();

            Node combined = new Node('*', left.freq + right.freq);

            combined.left = left;
            combined.right = right;

            heap.add(combined);

        }

        Map<Character, String> codes = new TreeMap<>();

        addCodes(heap.peek(), codes, "");

        return codes;

    }

    public static String encode(String msg, Map<Character, String> codes) {

        String compressed = "";

        for (char c : msg.toCharArray()) {

            compressed += codes.get(c);

        }

        return compressed;

    }

    public static void main(String[] args) {

        String msg = "This is a test of huffman encoding............";

        System.out.println(msg);

        Map<Character, String> codes = getHuffmanCodes(msg);

        for (char c : codes.keySet()) {

            System.out.printf("%s %s%n", c, codes.get(c));

        }

        System.out.println(encode(msg, codes));

    }

}
