
from itertools import combinations

class Edge:

    def __init__(self, frm, to, weight):

        self.from_vertex = frm
        self.to_vertex = to
        self.dist = weight

def _get_edges(graph):

    edges = []

    for a, b in combinations(range(len(graph)), 2):

        if graph[a][b]:

            edges.append(Edge(a, b, graph[a][b]))

    return edges

def _find_group(parents, i):

    while i != parents[i]:

        i = parents[i]

    return i

def print_MST(graph):

    n = len(graph)

    edges = _get_edges(graph)

    result = []

    parents = [ i for i in range(n) ]

    while len(result) < n - 1:

        closest_index = [ -1 ] * n

        for i in range(len(edges)):

            a = _find_group(parents, edges[i].from_vertex)
            b = _find_group(parents, edges[i].to_vertex)

            if a != b:

                if closest_index[a] == -1 or edges[closest_index[a]].dist > edges[i].dist:

                    closest_index[a] = i

                if closest_index[b] == -1 or edges[closest_index[b]].dist > edges[i].dist:

                    closest_index[b] = i

        for index in closest_index:

            if index != -1:

                a = _find_group(parents, edges[index].from_vertex)
                b = _find_group(parents, edges[index].to_vertex)

                if a != b:

                    result.append(edges[index])

                    parents[a] = b

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
