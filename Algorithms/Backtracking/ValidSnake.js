"use strict";

Set.prototype.hasPoint = function(point) {

    for (let item of this.values()) {

        if (item.r == point.r && item.c == point.c) {

            return true;

        }

    }

    return false;

};

Set.prototype.deletePoint = function(point) {

    for (let item of this.values()) {

        if (item.r == point.r && item.c == point.c) {

            return this.delete(item);

        }

    }

    return false;

};

let isValidSnake = (grid) => {

    let snakePoints = new Set();

    for (let r = 0; r < grid.length; r++) {

        for (let c = 0; c < grid[r].length; c++) {

            if (grid[r][c] == 'S') {

                snakePoints.add({r: r, c: c});

            }

        }

    }

    for (let start of snakePoints) {

        if (recur(grid, snakePoints, start, new Set())) {

            return true;

        }

    }

    return false;

}

let recur = (grid, snakePoints, cur, visited) => {

    visited.add(cur);

    if (visited.size == snakePoints.size) {

        return true;

    } else {

        let nextPoints = [];

        let {r, c} = cur;
        for (let nextPoint of [{r: r + 1, c: c}, {r: r - 1, c: c}, {r: r, c: c + 1}, {r: r, c: c - 1}]) {

            if (snakePoints.hasPoint(nextPoint) && !visited.hasPoint(nextPoint)) {

                nextPoints.push(nextPoint);

            }

        }

        if (nextPoints.length == 0) {

            return false;

        } else {

            for (let nextPoint of nextPoints) {

                if (recur(grid, snakePoints, nextPoint, visited)) {

                    return true;

                }

                visited.deletePoint(nextPoint);

            }

            return false;

        }

    }

}

let grid1 = [
    "......",
    "..SS..",
    "..S...",
    "..S...",
    "..SSS.",
    "....S.",
    "......"
]

let grid2 = [
    "......",
    "..SSS.",
    "..S.S.",
    ".SSSS.",
    "....S.",
    "......",
    "......"
]

let grid3 = [
    "....S.",
    ".SSSS.",
    ".S..S.",
    ".SSSS.",
    ".SSSS.",
    "......",
    "......"
]

console.log(isValidSnake(grid1));

console.log(isValidSnake(grid2));

console.log(isValidSnake(grid3));
