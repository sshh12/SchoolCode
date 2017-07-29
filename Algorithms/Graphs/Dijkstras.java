
public class Dijkstras {

    public static void printDistances(int[][] graph, int fromVertex) {

        int numVertices = graph.length;

        int[] dists = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {

            dists[i] = Integer.MAX_VALUE;

        }

        dists[fromVertex] = 0;

        for (int k = 0; k < numVertices - 1; k++) {

            int minDist = Integer.MAX_VALUE, vertex = -1;

            for (int v = 0; v < numVertices; v++) {

                if (!visited[v] && dists[v] <= minDist) {

                    minDist = dists[v];
                    vertex = v;

                }

            }

            visited[vertex] = true;

            for (int neighbor = 0; neighbor < numVertices; neighbor++) {

                if (!visited[neighbor] && graph[vertex][neighbor] > 0 && dists[vertex] != Integer.MAX_VALUE) {

                    int newDist = dists[vertex] + graph[vertex][neighbor];

                    if (newDist < dists[neighbor]) {
                      
                        dists[neighbor] = newDist;

                    }

                }

            }

        }

        for (int v = 0; v < numVertices; v++) {

            System.out.println(v + " " + dists[v]);

        }

    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 0, 0, 0, 5, 0, 0, 8, 0},
            {9, 0, 8, 0, 0, 0, 6, 0, 0},
            {0, 8, 5, 0, 0, 8, 0, 0, 0},
            {0, 0, 7, 0, 9, 0, 0, 0, 0},
            {0, 6, 0, 0, 0, 9, 0, 0, 0},
            {0, 0, 4, 0, 9, 0, 2, 0, 0},
            {0, 0, 0, 2, 0, 3, 0, 2, 8},
            {0, 6, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 4, 0, 0, 0, 0, 5, 0}
        };

        printDistances(graph, 0);

    }

}
