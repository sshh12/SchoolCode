
def _bfs(graph, vertex, color_map):

    color_map[vertex] = 1

    q = [vertex]

    while len(q) > 0:

        current = q.pop(0)

        for neighbor in range(len(graph)):

            if graph[current][neighbor]:

                if color_map[neighbor] == -1:

                    color_map[neighbor] = 1 - color_map[current]

                    q.append(neighbor)

                elif color_map[current] == color_map[neighbor]:

                    return False

    return True

def is_bipartite(graph):

    color_map = [ -1 ] * len(graph)

    for i in range(len(graph)):

        if color_map[i] == -1 and not _bfs(graph, i, color_map):

            return False

    return True

def main():

    graph = [
        [0, 1, 1, 1],
        [1, 0, 1, 0],
        [1, 1, 0, 0],
        [1, 0, 0, 0]
    ]

    print(is_bipartite(graph))

if __name__ == '__main__':
    main()
