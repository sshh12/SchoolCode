
import java.util.Arrays;

public class BellmanFord {

    private static class Edge {

        int weight, fromVertex, toVertex;

        public Edge(int from, int to, int dist) {

            fromVertex = from;
            toVertex = to;
            weight = dist;

        }

    }

    private static Edge[] getEdges(int[][] graph, int numEdges) {

        Edge[] edges = new Edge[numEdges];

        int k = 0;

        for (int i = 0; i < graph.length; i++) {

            for (int j = 0; j < graph.length; j++) {

                if (graph[i][j] != 0) {
                    edges[k++] = new Edge(i, j, graph[i][j]);
                }

            }

        }

        return edges;

    }

    private static boolean relax(Edge edge, int[] dists) {

        int a = edge.fromVertex;
        int b = edge.toVertex;

        int newWeight = dists[a] + edge.weight;

        if (dists[a] != Integer.MAX_VALUE && newWeight < dists[b]) {

            dists[b] = newWeight;

            return true;

        }

        return false;

    }

    public static void printDistances(int[][] graph, int numEdges, int fromVertex) throws Exception {

        int n = graph.length;

        Edge[] edges = getEdges(graph, numEdges);

        int[] dists = new int[n];

        Arrays.fill(dists, Integer.MAX_VALUE);

        dists[fromVertex] = 0;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < numEdges; j++) {

                relax(edges[j], dists);

            }

        }

        for (int j = 0; j < numEdges; j++) {

            if (relax(edges[j], dists)) {

                throw new Exception("Graph contains negative cycle.");

            }

        }

        for (int i = 0; i < n; i++) {

            System.out.printf("%d %d%n", i, dists[i]);

        }

    }

    public static void main(String[] args) throws Exception {

        int[][] graph = new int[][]{
            {0, -1, 4,  0, 0},
            {0,  0, 3,  2, 2},
            {0,  0, 0,  0, 0},
            {0,  1, 5,  0, 0},
            {0,  0, 0, -3, 0}
        };

        printDistances(graph, 8, 0);

    }

}
