"use strict";

let make2DArray = (rows, cols = rows) => {
  var array = [], row = [];
  while (cols--) row.push(0);
  while (rows--) array.push(row.slice());
  return array;
}

let recur = (board, col = 0) => {

    if (col >= board.length) {
        return true;
    }

    for (let row in board) {

        if (canPlaceQueen(board, row, col)) {

            board[row][col] = 1;

            if (recur(board, col + 1)) {
                return true;
            }

            board[row][col] = 0;

        }

    }

    return false;

}

let canPlaceQueen = (board, row, col) => {

    for (let c = 0; c < col; c++) {

        if (board[row][c] == 1) {
            return false;
        }

    }

    for (let r = row, c = col; r >= 0 && c >= 0; r--, c--) {

        if (board[r][c] == 1) {
            return false;
        }

    }

    for (let r = row, c = col; r < board.length && c >= 0; r++, c--) {

        if (board[r][c] == 1) {
            return false;
        }

    }

    return true;

}

let solve = (n) => {

    let board = make2DArray(n);

    if (recur(board)) {

        for (let row of board) {
            console.log(row);
        }

        return true;

    }

    console.log("No Solution");
    return false;

}

solve(5);
