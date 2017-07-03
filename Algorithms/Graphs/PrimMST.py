
INF = 9e9

def _min_index(dists, visited):

    mn, min_index = INF, -1

    for i in range(len(visited)):

        if not visited[i] and dists[i] < mn:

            mn, min_index = dists[i], i

    return min_index

def print_MST(graph):

    n = len(graph)

    parents = [ 0 ] * n
    dists = [ INF ] * n

    visited = [ False ] * n

    dists[0], parents[0] = 0, -1

    for _ in range(n - 1):

        u = _min_index(dists, visited)
        
        visited[u] = True

        for v in range(n):

            if not visited[v] and 0 < graph[u][v] < dists[v]:

                parents[v], dists[v] = u, graph[u][v]

    for i in range(1, n):

        print(f'{parents[i]} -> {i}')

def main():

    graph = [
        [0, 8, 0, 6, 0],
        [1, 0, 4, 1, 3],
        [0, 9, 0, 0, 1],
        [7, 9, 0, 0, 2],
        [0, 2, 7, 9, 0]
    ]

    print_MST(graph)

if __name__ == '__main__':
    main()
