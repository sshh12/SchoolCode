
INF = 9e9

class Edge(object):

    def __init__(self, frm, to, dist):

        self.from_vertex = frm
        self.to_vertex = to
        self.weight = dist

def _get_edges(graph):

    edges = []

    for a in range(len(graph)):

        for b in range(len(graph)):

            if graph[a][b]:

                edges.append(Edge(a, b, graph[a][b]))

    return edges

def _relax(edge, dists):

    a, b = edge.from_vertex, edge.to_vertex

    new_weight = dists[a] + edge.weight

    if dists[a] != INF and new_weight < dists[b]:

        dists[b] = new_weight

        return True

    return False

def print_distances(graph, from_vertex):

    n = len(graph)

    edges = _get_edges(graph)

    dists = [ INF ] * n

    dists[from_vertex] = 0

    for _ in range(n - 1):

        for edge in edges:

            _relax(edge, dists)

    for edge in edges:

        if _relax(edge, dists):

            raise Exception('Graph contains negative cycle.')

    for i in range(n):

        print(f'{i} {dists[i]}')

def main():

    graph = [
        [0, -1, 4,  0, 0],
        [0,  0, 3,  2, 2],
        [0,  0, 0,  0, 0],
        [0,  1, 5,  0, 0],
        [0,  0, 0, -3, 0]
    ]

    print_distances(graph, 0)

if __name__ == '__main__':
    main()
