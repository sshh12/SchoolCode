"use strict";

let make2DArray = (rows, cols = row, fill = 0) => {

    var array = [], row = [];
    while (cols--) row.push(fill);
    while (rows--) array.push(row.slice());
    return array;

}

let inBounds = (grid, row, col) => Math.min(row, col) >= 0 && row < grid.length && col < grid[0].length;

let countPathsAcross = (grid, row = grid.length - 1, col = grid[0].length - 1) => {

    if (!inBounds(grid, row, col) || grid[row][col] == '#') {

        return 0;

    } else if (row == 0 && col == 0) {

        return 1;

    } else {

        return countPathsAcross(grid, row - 1, col) + countPathsAcross(grid, row, col - 1);

    }

}

let countPathsAcross2 = (grid) => {

    let db = make2DArray(grid.length, grid[0].length);

    db[0][0] = 1;

    for (let row in grid) {

        for (let col in grid[row]) {

            if (row == 0 && col == 0 || grid[row][col] == '#') {

                continue;

            } else {

                if (col != 0) {

                    db[row][col] += db[row][col - 1];

                }

                if (row != 0) {

                    db[row][col] += db[row - 1][col];

                }

            }

        }

    }

    return db[grid.length - 1][grid[0].length - 1];

}

let grid = [
    ['S', '.', '.', '.', '.', '.'],
    ['.', '#', '.', '.', '#', '.'],
    ['.', '.', '.', '.', '.', '.'],
    ['.', '.', '#', '.', '.', '.'],
    ['.', '.', '.', '.', '.', '.'],
    ['.', '.', '.', '.', '#', '.'],
    ['.', '#', '.', '.', '.', '.'],
    ['.', '.', '.', '.', '.', 'E']
];

console.log(countPathsAcross(grid))

console.log("------")

console.log(countPathsAcross(grid))
