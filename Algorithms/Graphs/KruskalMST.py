
from itertools import combinations

class Edge:

    def __init__(self, frm, to, weight):

        self.from_vertex = frm
        self.to_vertex = to
        self.dist = weight

def _get_sorted_edges(graph):

    edges = []

    for a, b in combinations(range(len(graph)), 2):

        if graph[a][b]:

            edges.append(Edge(a, b, graph[a][b]))

    edges.sort(key=lambda edge: edge.dist)

    return edges

def _find_group(parents, i):

    while i != parents[i]:

        i = parents[i]

    return i

def print_MST(graph):

    n, edge_index = len(graph), 0

    edges = _get_sorted_edges(graph)

    result = []

    parents = [ i for i in range(n) ]

    while len(result) < n - 1:

        next_edge = edges[edge_index]

        a = _find_group(parents, next_edge.from_vertex)
        b = _find_group(parents, next_edge.to_vertex)

        if a != b:

            result.append(next_edge)

            parents[b] = a

        edge_index += 1

    for edge in result:

        print(f'{edge.from_vertex} -> {edge.to_vertex}')

def main():

    graph = [
        [0, 3, 6, 5],
        [3, 0, 0, 9],
        [6, 0, 0, 4],
        [5, 9, 4, 0]
    ]

    print_MST(graph)

if __name__ == '__main__':
    main()
