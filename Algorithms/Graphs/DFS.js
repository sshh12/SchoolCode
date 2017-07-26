"use strict";

Set.prototype.hasPoint = function(point) {

    for (let item of this.values()) {

        if (item.x == point.x && item.y == point.y) {

            return true;

        }

    }

    return false;

};

let inBounds = (grid, p) => Math.min(p.x, p.y) >= 0 && p.x < grid.length && p.y < grid[0].length;

function* getNeighbors(grid, point) {

    let {x, y} = point;

    for (let n of [{x: x + 1, y: y}, {x: x - 1, y: y}, {x: x, y: y + 1}, {x: x, y: y - 1}]) {

        if (inBounds(grid, n) && grid[n.x][n.y] == '.') {

            yield n;

        }

    }

}

let solve = (grid, start, end) => {

    let visited = new Set(),
        parents = new Map(),
        stack = [start];

    while (stack.length > 0) {

        let cur = stack.pop();
        visited.add(cur);

        if (cur.x == end.x && cur.y == end.y) {

            let path = [],
                node = cur;

            while (node != null) {

                path.unshift(node);
                node = parents.get(node);

            }

            return path;

        } else {

            for (let n of getNeighbors(grid, cur)) {

                if (!visited.hasPoint(n)) {

                    stack.push(n);
                    parents.set(n, cur);

                }

            }

        }

    }

    return null;

}

let solve2 = (grid, cur, end, visited = new Set(), path = []) => {

    visited.add(cur);

    if (cur.x == end.x && cur.y == end.y) {

        path.push(cur);

        return path;

    } else {

        for (let n of getNeighbors(grid, cur)) {

            if (!visited.hasPoint(n)) {

                path.push(cur);

                let newPath = solve2(grid, n, end, visited, path);

                if (newPath) {

                    return newPath;

                } else {

                  path.pop();

                }

            }

        }

    }

    return null;

}

let grid = [
    ".####",
    ".#...",
    ".#.#.",
    "...#.",
    ".##.."
];

for (let point of solve(grid, {x: 0, y: 0}, {x: 4, y: 4})) {

    console.log(point);

}

console.log("------");

for (let point of solve2(grid, {x: 0, y: 0}, {x: 4, y: 4})) {

    console.log(point);

}
