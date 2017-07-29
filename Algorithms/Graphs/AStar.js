"use strict";

class Heap { // Insert Actual Heap Here...

    constructor(endPoint) {

        this.items = [];
        this.distSort = (a, b) => dist(a, endPoint) - dist(b, endPoint);

    }

    push(item) {

        this.items.push(item);
        this.items.sort(this.distSort);

    }

    remove() {

        return this.items.shift();

    }

    get size() {

      return this.items.length;

    }

}

Set.prototype.hasPoint = function(point) {

    for (let item of this.values()) {

        if (item.x == point.x && item.y == point.y) {

            return true;

        }

    }

    return false;

};

let inBounds = (grid, p) => Math.min(p.x, p.y) >= 0 && p.x < grid.length && p.y < grid[0].length;

let dist = (a, b) => (a.x - b.x)**2 + (a.y - b.y)**2;

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
        q = new Heap(end);

    q.push(start);

    while (q.size > 0) {

        let cur = q.remove();
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

                    q.push(n);
                    parents.set(n, cur);

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
