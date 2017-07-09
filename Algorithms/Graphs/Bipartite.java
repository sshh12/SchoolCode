
import java.util.*;

public class Bipartite {

    private static boolean bfs(int[][] graph, int vertex, int[] colorMap) {

        colorMap[vertex] = 1;

        Queue<Integer> q = new LinkedList<>();

        q.add(vertex);

        while (!q.isEmpty()) {

            int current = q.remove();

            for (int neighbor = 0; neighbor < graph.length; neighbor++) {

                if (graph[current][neighbor] > 0) {

                    if (colorMap[neighbor] == -1) {

                        colorMap[neighbor] = 1 - colorMap[current];

                        q.add(neighbor);

                    } else if (colorMap[current] == colorMap[neighbor]) {

                        return false;

                    }

                }

            }

        }

        return true;

    }

    public static boolean isBipartite(int[][] graph) {

        int[] colorMap = new int[graph.length];

        Arrays.fill(colorMap, -1);

        for (int i = 0; i < graph.length; i++) {

            if (colorMap[i] == -1 && !bfs(graph, i, colorMap)) {

                return false;

            }

        }

        return true;

    }

    public static void main(String[] args) {

        int[][] graph = new int[][]{
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 0},
            {1, 0, 0, 0}
        };

        System.out.println(isBipartite(graph));

    }

}
