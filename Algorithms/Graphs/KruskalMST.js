"use strict";

let getSortedEdges = (graph) => {

    let edges = [];

    for (let i = 0; i < graph.length; i++) {

        for (let j = i + 1; j < graph.length; j++) {

            if (graph[i][j]) {

                edges.push({
                    fromVertex: i,
                    toVertex: j,
                    weight: graph[i][j]
                });

            }

        }

    }

    edges.sort((a, b) => a.weight - b.weight);

    return edges;

}

let findGroup = (parents, i) => {

    while (i != parents[i]) {

        i = parents[i];

    }

    return i;

}

let printMST = (graph) => {

    let edgeIndex = 0,
        edges = getSortedEdges(graph),
        result = [],
        parents = [];

    while (parents.push(parents.length) < graph.length); // 0,1,2,3...n

    while (result.length < graph.length - 1) {

        let nextEdge = edges[edgeIndex++];

        let a = findGroup(parents, nextEdge.fromVertex),
            b = findGroup(nextEdge.toVertex);

        if (a != b) {

            result.push(nextEdge);

            parents[b] = a;

        }

    }

    for (let edge of result) {

        console.log(`${edge.fromVertex} -> ${edge.toVertex}`)

    }

}

let graph = [
    [0, 3, 6, 5],
    [3, 0, 0, 9],
    [6, 0, 0, 4],
    [5, 9, 4, 0]
];

printMST(graph);
