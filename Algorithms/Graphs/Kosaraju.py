
def _set_order(graph, vertex, visited, stack):

    visited[vertex] = True

    for neighbor, dist in enumerate(graph[vertex]):

        if not visited[neighbor] and dist > 0:

            _set_order(graph, neighbor, visited, stack)

    stack.append(vertex)

def _DFS(graph, vertex, visited, path):

    path.append(vertex)
    visited[vertex] = True

    for neighbor, dist in enumerate(graph[vertex]):

        if not visited[neighbor] and dist > 0:

            _DFS(graph, neighbor, visited, path)

def _transpose(graph):

    return list(map(list, zip(*graph)))

def print_SCC(graph):

    n = len(graph)

    stack = []
    visited = [False] * n

    for vertex in range(n):

        if not visited[vertex]:

            _set_order(graph, vertex, visited, stack)

    visited = [False] * n
    graph = _transpose(graph)

    while len(stack) > 0:

        vertex = stack.pop()

        if not visited[vertex]:

            path = []

            _DFS(graph, vertex, visited, path)

            print(path)


def main():

    graph = [
        [0, 0, 1, 1, 0],
        [1, 0, 0, 0, 0],
        [0, 1, 0, 0, 0],
        [0, 0, 0, 0, 1],
        [0, 0, 0, 0, 0]
    ]

    print_SCC(graph)

if __name__ == '__main__':
    main()
