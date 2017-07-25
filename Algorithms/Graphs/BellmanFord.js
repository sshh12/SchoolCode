let getEdges = (graph) => {

    let edges = [];

    for (let a in graph) {

        for (let b in graph) {

            if (graph[a][b]) {

                edges.push({
                    fromVertex: a,
                    toVertex: b,
                    weight: graph[a][b]
                });

            }

        }

    }

    return edges;

}

let relax = (edge, dists) => {

    let a = edge.fromVertex,
        b = edge.toVertex;

    let newWeight = dists[a] + edge.weight;

    if (dists[a] != Number.MAX_VALUE && newWeight < dists[b]) {

        dists[b] = newWeight;

        return true;

    }

    return false;

}

let printDistances = (graph, fromVertex) => {

    let edges = getEdges(graph);

    let dists = [];
    while (dists.push(Number.MAX_VALUE) < graph.length);

    dists[fromVertex] = 0;

    for (let k = 0; k < graph.length - 1; k++) {

        for (let edge of edges) {

            relax(edge, dists);

        }

    }

    for (let edge of edges) {

        if (relax(edge, dists)) {

            throw 'Graph contains negative cycle.';

        }

    }

    for (let i in graph) {

        console.log(`${i} ${dists[i]}`);

    }

}

let graph = [
    [0, -1, 4, 0, 0],
    [0, 0, 3, 2, 2],
    [0, 0, 0, 0, 0],
    [0, 1, 5, 0, 0],
    [0, 0, 0, -3, 0]
];

printDistances(graph, 0);
