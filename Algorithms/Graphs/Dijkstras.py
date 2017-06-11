INF = 999999

def print_distances(graph, from_vertex=0):

    num_vertices = len(graph)

    dists = [INF for _ in range(num_vertices)]
    visited = [False for _ in range(num_vertices)]

    dists[from_vertex] = 0

    for k in range(num_vertices - 1):

        minDist, vertex = INF, -1

        for v in range(num_vertices):
            if not visited[v] and dists[v] <= minDist:
                minDist, vertex = dists[v], v

        visited[vertex] = True

        for neighbor in range(num_vertices):

            if not visited[neighbor] and graph[vertex][neighbor] and dists[vertex] != INF:

                new_dist = dists[vertex] + graph[vertex][neighbor]

                if new_dist < dists[neighbor]:

                    dists[neighbor] = new_dist

    for v in range(num_vertices):

        print(f'{v} {dists[v]}')

def main():

    graph = [
        [0, 0, 0, 0, 5, 0, 0, 8, 0],
        [9, 0, 8, 0, 0, 0, 6, 0, 0],
        [0, 8, 5, 0, 0, 8, 0, 0, 0],
        [0, 0, 7, 0, 9, 0, 0, 0, 0],
        [0, 6, 0, 0, 0, 9, 0, 0, 0],
        [0, 0, 4, 0, 9, 0, 2, 0, 0],
        [0, 0, 0, 2, 0, 3, 0, 2, 8],
        [0, 6, 0, 0, 0, 0, 1, 0, 7],
        [0, 0, 4, 0, 0, 0, 0, 5, 0]
    ]

    print_distances(graph)

if __name__ == '__main__':
    main()
