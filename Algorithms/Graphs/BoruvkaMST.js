"use strict";

class Edge {

    constructor(from, to, weight) {

        this.fromVertex = from;
        this.toVertex = to;
        this.dist = weight;

    }

}

let getEdges = (graph) => {

    let edges = [];

    for (let i = 0; i < graph.length; i++) {

        for (let j = i + 1; j < graph.length; j++) {

            if (graph[i][j] > 0) {
                edges.push(new Edge(i, j, graph[i][j]));
            }

        }

    }

    return edges;

}

let _findGroup = (parents, node) => {

    while (node != parents[node]) {
        node = parents[node];
    }

    return node;

}

let printMST = (graph) => {

    let edges = getEdges(graph);
    let n = graph.length;
    let result = [],
        parents = [...Array(n).keys()];

    while (result.length < n - 1) {

        let closestIndex = (new Array(n)).fill(-1);

        for (let i = 0; i < edges.length; i++) {



            let a = _findGroup(parents, edges[i].fromVertex),
                b = _findGroup(parents, edges[i].toVertex);

            if (a != b) {

                if (closestIndex[a] == -1 || edges[closestIndex[a]].dist > edges[i].dist) {

                    closestIndex[a] = i;

                }

                if (closestIndex[b] == -1 || edges[closestIndex[b]].dist > edges[i].dist) {

                    closestIndex[b] = i;

                }

            }

        }

        for (let index of closestIndex) {

            if (index != -1) {

                let a = _findGroup(parents, edges[index].fromVertex),
                    b = _findGroup(parents, edges[index].toVertex);

                if (a != b) {

                    result.push(edges[index]);

                    parents[a] = b;

                }

            }

        }

    }

    for (let edge of result) {

        console.log(`${edge.fromVertex} -> ${edge.toVertex}`);

    }

}

let graph = [
    [0, 3, 6, 5],
    [3, 0, 0, 9],
    [6, 0, 0, 4],
    [5, 9, 4, 0]
];

printMST(graph);
