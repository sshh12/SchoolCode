"use strict";

let setOrder = (graph, vertex, visited, stack) => {

  visited[vertex] = true;

  for (let neighbor = 0; neighbor < graph.length; neighbor++) {

    if (!visited[neighbor] && graph[vertex][neighbor] > 0) {

      setOrder(graph, neighbor, visited, stack);

    }

  }

  stack.push(vertex);

};

let DFS = (graph, vertex, visited, path) => {

  path.push(vertex);
  visited[vertex] = true;

  for (let neighbor = 0; neighbor < graph.length; neighbor++) {

    if (!visited[neighbor] && graph[vertex][neighbor] > 0) {

      DFS(graph, neighbor, visited, path);

    }

  }

};

let transpose = (graph) => graph[0].map((col, i) => graph.map(row => row[i]));

let printSCC = (graph) => {

  let n = graph.length;

  let stack = [],
      visited = (new Array(n)).fill(false);

  for (let vertex = 0; vertex < n; vertex++) {

    if (!visited[vertex]) {

      setOrder(graph, vertex, visited, stack);

    }

  }

  visited = (new Array(n)).fill(false);
  graph = transpose(graph);

  while (stack.length > 0) {

    let vertex = stack.pop();

    if (!visited[vertex]) {

      let path = [];

      DFS(graph, vertex, visited, path);

      console.log(path);

    }

  }

};

let graph = [
  [0, 0, 1, 1, 0],
  [1, 0, 0, 0, 0],
  [0, 1, 0, 0, 0],
  [0, 0, 0, 0, 1],
  [0, 0, 0, 0, 0]
];

printSCC(graph);
