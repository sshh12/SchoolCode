
import java.util.Arrays;

public class KruskalMST {

    private static class Edge implements Comparable<Edge> {

        int dist, fromVertex, toVertex;

        public Edge(int from, int to, int weight) {

            fromVertex = from;
            toVertex = to;
            dist = weight;

        }

        @Override
        public int compareTo(Edge other) {

            return dist - other.dist;

        }

    }

    private static Edge[] getSortedEdges(int[][] graph, int numEdges) {

        Edge[] edges = new Edge[numEdges];

        int k = 0;

        for (int i = 0; i < graph.length; i++) {

            for (int j = i + 1; j < graph.length; j++) {

                if (graph[i][j] > 0) {
                    edges[k++] = new Edge(i, j, graph[i][j]);
                }

            }

        }

        Arrays.sort(edges);

        return edges;

    }

    private static int findGroup(int[] parents, int i) {

        while (i != parents[i]) {

            i = parents[i];

        }

        return i;

    }

    public static void printMST(int[][] graph, int numEdges) {

        int n = graph.length, resultIndex = 0, edgeIndex = 0;

        Edge[] edges = getSortedEdges(graph, numEdges);

        Edge[] result = new Edge[n];

        int[] parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        while (resultIndex < n - 1) {

            Edge next = edges[edgeIndex++];

            int a = findGroup(parents, next.fromVertex);
            int b = findGroup(parents, next.toVertex);

            if (a != b) {

                result[resultIndex++] = next;

                parents[b] = a;

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
