
def _recur(graph, vertex, visited, stack):

    visited[vertex] = True

    for i in range(len(graph)):

        if not visited[i] and graph[vertex][i] > 0:

            _recur(graph, i, visited, stack)

    stack.append(vertex)

def print_order(graph):

    visited = [ False ] * len(graph)
    stack = []

    for i in range(len(graph)):

        if not visited[i]:

            _recur(graph, i, visited, stack)

    while len(stack) > 0:

        print(stack.pop())

def main():

    graph = [
        [0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0],
        [0, 0, 0, 1, 0, 0],
        [0, 1, 0, 0, 0, 0],
        [1, 1, 0, 0, 0, 0],
        [1, 0, 1, 0, 0, 0]
    ]

    print_order(graph)

if __name__ == '__main__':
    main()
