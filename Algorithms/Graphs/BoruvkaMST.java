
import java.util.Arrays;

public class BoruvkaMST {

    private static class Edge {

        int dist, fromVertex, toVertex;

        public Edge(int from, int to, int weight) {

            fromVertex = from;
            toVertex = to;
            dist = weight;

        }

    }

    private static Edge[] getEdges(int[][] graph, int numEdges) {

        Edge[] edges = new Edge[numEdges];

        int k = 0;

        for (int i = 0; i < graph.length; i++) {

            for (int j = i + 1; j < graph.length; j++) {

                if (graph[i][j] > 0) {
                    edges[k++] = new Edge(i, j, graph[i][j]);
                }

            }

        }

        return edges;

    }

    private static int findGroup(int[] parents, int i) {

        while (i != parents[i]) {

            i = parents[i];

        }

        return i;

    }

    public static void printMST(int[][] graph, int numEdges) {

        int n = graph.length, resultIndex = 0;

        Edge[] edges = getEdges(graph, numEdges);

        Edge[] result = new Edge[n];

        int[] closestIndex = new int[n];

        int[] parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        while (resultIndex < n - 1) {

            Arrays.fill(closestIndex, -1);

            for (int i = 0; i < edges.length; i++) {

                int a = findGroup(parents, edges[i].fromVertex);
                int b = findGroup(parents, edges[i].toVertex);

                if (a != b) {

                    if (closestIndex[a] == -1 || edges[closestIndex[a]].dist > edges[i].dist) {

                        closestIndex[a] = i;

                    }

                    if (closestIndex[b] == -1 || edges[closestIndex[b]].dist > edges[i].dist) {

                        closestIndex[b] = i;

                    }

                }

            }

            for (int i = 0; i < n; i++) {

                if (closestIndex[i] != -1) {

                    int a = findGroup(parents, edges[closestIndex[i]].fromVertex);
                    int b = findGroup(parents, edges[closestIndex[i]].toVertex);

                    if (a != b) {

                        result[resultIndex++] = edges[closestIndex[i]];

                        parents[a] = b;

                    }

                }

            }

        }

        for (int i = 0; i < resultIndex; i++) {

            System.out.printf("%d -> %d%n", result[i].fromVertex, result[i].toVertex);

        }

    }

    public static void main(String[] args) {

        int[][] graph = new int[][]{
            {0, 3, 6, 5},
            {3, 0, 0, 9},
            {6, 0, 0, 4},
            {5, 9, 4, 0}
        };

        printMST(graph, 5);

    }

}
