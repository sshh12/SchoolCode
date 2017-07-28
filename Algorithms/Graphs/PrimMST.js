"use strict";

let getMinIndex = (dists, visited) => {

    let min = Number.MAX_VALUE,
        minIndex = -1;

    for (let i in visited) {

        if (!visited[i] && dists[i] < min) {

            min = dists[i];
            minIndex = i;

        }

    }

    return minIndex;

}

let printMST = (graph) => {

    let parents = [-1],
        dists = [0],
        visited = [false];

    for (let i = 1; i < graph.length; i++) {

        parents.push(0);
        visited.push(false);
        dists.push(Number.MAX_VALUE);

    }

    for (let k = 0; k < graph.length - 1; k++) {

        let u = getMinIndex(dists, visited);

        visited[u] = true;

        for (let v in graph) {

            if (!visited[v] && 0 < graph[u][v] && graph[u][v] < dists[v]) {

                parents[v] = u;
                dists[v] = graph[u][v]

            }

        }

    }

    for (let i = 1; i < graph.length; i++) {

        console.log(`${parents[i]} -> ${i}`);

    }

}

let graph = [
    [0, 8, 0, 6, 0],
    [8, 0, 4, 1, 3],
    [0, 4, 0, 0, 1],
    [6, 1, 0, 0, 2],
    [0, 3, 1, 2, 0]
];

printMST(graph);
