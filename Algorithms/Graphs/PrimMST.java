
import java.util.Arrays;

public class PrimMST {

    private static int minIndex(int[] dists, boolean[] visited) {

        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i] && dists[i] < min) {

                min = dists[i];
                minIndex = i;

            }

        }

        return minIndex;

    }

    public static void printMST(int[][] graph) {

        int n = graph.length;

        int[] parents = new int[n];
        int[] dists = new int[n];

        boolean[] visited = new boolean[n];

        Arrays.fill(dists, Integer.MAX_VALUE);

        dists[0] = 0;
        parents[0] = -1;

        for (int k = 0; k < n - 1; k++) {

            int u = minIndex(dists, visited);

            visited[u] = true;

            for (int v = 0; v < n; v++) {

                if (!visited[v] && graph[u][v] > 0 && graph[u][v] < dists[v]) {

                    parents[v] = u;
                    dists[v] = graph[u][v];

                }

            }

        }

        for (int i = 1; i < n; i++) {

            System.out.printf("%d -> %d%n", parents[i], i);

        }

    }

    public static void main(String[] args) {

        int[][] graph = new int[][]{
            {0, 8, 0, 6, 0},
            {1, 0, 4, 1, 3},
            {0, 9, 0, 0, 1},
            {7, 9, 0, 0, 2},
            {0, 2, 7, 9, 0}
        };

        printMST(graph);

    }

}
