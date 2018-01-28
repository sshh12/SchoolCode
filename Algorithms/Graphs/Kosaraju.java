
import java.util.*;

public class Kosaraju {

    private static void setOrder(int[][] graph, int vertex, boolean[] visited, Stack<Integer> stack) {

        visited[vertex] = true;

        for (int neighbor = 0; neighbor < graph.length; neighbor++) {

            if (!visited[neighbor] && graph[vertex][neighbor] > 0) {

                setOrder(graph, neighbor, visited, stack);

            }

        }

        stack.add(vertex);

    }

    private static void DFS(int[][] graph, int vertex, boolean[] visited, List<Integer> path) {

        path.add(vertex);
        visited[vertex] = true;

        for (int neighbor = 0; neighbor < graph.length; neighbor++) {

            if (!visited[neighbor] && graph[vertex][neighbor] > 0) {

                DFS(graph, neighbor, visited, path);

            }

        }

    }

    private static int[][] transpose(int[][] graph) {

        int[][] newGraph = new int[graph.length][graph[0].length];

        for (int r = 0; r < graph.length; r++) {

            for (int c = 0; c < graph[0].length; c++) {

                newGraph[c][r] = graph[r][c];

            }

        }

        return newGraph;

    }

    public static void printSCC(int[][] graph) {

        int n = graph.length;

        Stack<Integer> stack = new Stack();
        boolean[] visited = new boolean[n];

        for (int vertex = 0; vertex < n; vertex++) {

            if (!visited[vertex]) {

                setOrder(graph, vertex, visited, stack);

            }

        }

        visited = new boolean[n];
        graph = transpose(graph);

        while (!stack.isEmpty()) {

            int vertex = stack.pop();

            if (!visited[vertex]) {

                List<Integer> path = new ArrayList<>();

                DFS(graph, vertex, visited, path);

                System.out.println(path);

            }

        }

    }

    public static void main(String[] args) {

        int[][] graph = new int[][]{
            {0, 0, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0}
        };

        printSCC(graph);

    }

}
