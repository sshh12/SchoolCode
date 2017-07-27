"use strict";

let recur = (graph, vertex, visited, stack) => {

    visited.add(vertex);

    for (let i in graph) {

        if (!visited.has(i) && graph[vertex][i] > 0) {

            recur(graph, i, visited, stack);

        }

    }

    stack.push(vertex);

}

let printOrder = (graph) => {

    let visited = new Set(),
        stack = [];

    for (let i in graph) {

        if (!visited.has(i)) {

            recur(graph, i, visited, stack);

        }

    }

    while (stack.length > 0) {

        console.log(stack.pop());

    }

}

let graph = [
    [0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0, 0],
    [0, 1, 0, 0, 0, 0],
    [1, 1, 0, 0, 0, 0],
    [1, 0, 1, 0, 0, 0]
];

printOrder(graph);
