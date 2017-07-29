"use strict";

let printDistances = (graph, fromVertex = 0) => {

    let numVertices = graph.length,
        dists = [],
        visited = [];

    for (let i in graph) {

        dists.push(Number.MAX_VALUE);
        visited.push(false);

    }

    dists[fromVertex] = 0;

    for (let k = 0; k < numVertices - 1; k++) {

        let minDist = Number.MAX_VALUE,
            vertex = -1;

        for (let v in graph) {

            if (!visited[v] && dists[v] <= minDist) {

                minDist = dists[v];
                vertex = v;

            }

        }

        visited[vertex] = true;

        for (let neighbor in graph) {

            if (!visited[neighbor] && graph[vertex][neighbor] && dists[vertex] != Number.MAX_VALUE) {

                let newDist = dists[vertex] + graph[vertex][neighbor];

                if (newDist < dists[neighbor]) {

                    dists[neighbor] = newDist;

                }

            }

        }

    }

    for (let v in graph) {

        console.log(`${v} ${dists[v]}`);

    }

}

let graph = [
    [0, 0, 0, 0, 5, 0, 0, 8, 0],
    [9, 0, 8, 0, 0, 0, 6, 0, 0],
    [0, 8, 5, 0, 0, 8, 0, 0, 0],
    [0, 0, 7, 0, 9, 0, 0, 0, 0],
    [0, 6, 0, 0, 0, 9, 0, 0, 0],
    [0, 0, 4, 0, 9, 0, 2, 0, 0],
    [0, 0, 0, 2, 0, 3, 0, 2, 8],
    [0, 6, 0, 0, 0, 0, 1, 0, 7],
    [0, 0, 4, 0, 0, 0, 0, 5, 0]
];

printDistances(graph);
