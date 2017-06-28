
import java.util.*;

public class TopologicalSort {

    private static void recur(int[][] graph, int vertex, boolean[] visited, Stack stack) {

        visited[vertex] = true;

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i] && graph[vertex][i] > 0) {

                recur(graph, i, visited, stack);

            }

        }

        stack.add(vertex);

    }

    public static void printOrder(int[][] graph) {

        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {

                recur(graph, i, visited, stack);

            }

        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0}
        };

        printOrder(graph);

    }

}
