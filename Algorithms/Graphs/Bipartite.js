"use strict";

let bfs = (graph, vertex, colorMap) => {

    colorMap[vertex] = 1;

    let q = [vertex];

    while (q.length > 0) {

        let current = q.shift();

        for (let neighbor in graph) {

            if (graph[current][neighbor]) {

                if (colorMap[neighbor] == -1) {

                    colorMap[neighbor] = 1 - colorMap[current];

                    q.push(neighbor);

                } else if (colorMap[current] == colorMap[neighbor]) {

                    return false;

                }

            }

        }

    }

    return true;

}

let isBipartite = (graph) => {

    let colorMap = [];
    while (colorMap.push(-1) < graph.length);

    for (let i in graph) {

        if (colorMap[i] == -1 && !bfs(graph, i, colorMap)) {

            return false;

        }

    }

    return true;

}

let graph = [
    [0, 1, 1, 1],
    [1, 0, 1, 0],
    [1, 1, 0, 0],
    [1, 0, 0, 0]
];

console.log(isBipartite(graph))
