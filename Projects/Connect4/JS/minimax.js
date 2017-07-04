MAX = 100000;
MIN = -100000;

function AlphaBetaAgent(id, depth) {

    this.id = id;
    this.depth = depth;

    this.getBestMove = (board) => {
        let bestMove = this.getMoves(board).reduce((a, b) => a.score > b.score ? a : b);
        console.log(bestMove);
        return bestMove.column;
    };

    this.getMoves = (board) => {

        let moves = [];

        for (let col = 0; col < board[0].length; col++) {
            if (board[0][col] === 0) {
                let row = getNextRow(board, col);

                board[row][col] = this.id;
                score = this.alphaBeta(board, this.depth, MIN, MAX, false);
                board[row][col] = 0;

                moves.push({
                    column: col,
                    score: score
                });
            }
        }

        return moves;

    }

    this.alphaBeta = (board, depth, alpha, beta, maximize) => {
        let v = 0;
        if (depth === 0) {
            return this.evaluate(board, this.id);
        } else if (maximize) {

            v = MIN;
            for (let col = 0; col < board[0].length; col++) {
                if (board[0][col] === 0) {
                    let row = getNextRow(board, col);

                    board[row][col] = this.id;
                    v = Math.max(v, this.alphaBeta(board, depth - 1, alpha, beta, false));
                    board[row][col] = 0;

                    alpha = Math.max(alpha, v);
                    if (beta <= alpha) {
                        break;
                    }
                }
            }

        } else {

            v = MAX;
            for (let col = 0; col < board[0].length; col++) {
                if (board[0][col] === 0) {
                    let row = getNextRow(board, col);

                    board[row][col] = this.id ^ 3;
                    v = Math.min(v, this.alphaBeta(board, depth - 1, alpha, beta, true));
                    board[row][col] = 0;

                    alpha = Math.min(alpha, v);
                    if (beta <= alpha) {
                        break;
                    }
                }
            }

        }

        return v;
    }

}

AlphaBetaAgent.prototype.evaluate = (board, id) => {
    let me = id;
    let them = id ^ 3;

    let mePoints = [mostVertical(board, me), mostHorizontal(board, me), mostIncDiag(board, me), mostDecDiag(board, me)];
    let themPoints = [mostVertical(board, them), mostHorizontal(board, them), mostIncDiag(board, them), mostDecDiag(board, them)];

    if (themPoints.includes(4)) {
        return MIN;
    }

    if (mePoints.includes(4)) {
        return MAX;
    }

    let meScore = mePoints.reduce((a, b) => a + b) * 20;
    let themScore = themPoints.reduce((a, b) => a + b) * 20;

    //meScore += Helpers.count(mePoints, 3) * 150;
    //themScore += Helpers.count(themPoints, 3) * 200;

    return meScore - themScore;
}

let mostVertical = (board, id) => {
    let most = 0;
    for (let c = 0; c < board[0].length; c++) {
        for (let r = 0; r < board.length; r++) {
            if (board[r][c] == id) {
                let count = 1;
                while (r + count < board.length && board[r + count][c] == id) {
                    count++;
                }
                most = Math.max(most, count);
            }
        }
    }
    return most;
}

let mostHorizontal = (board, id) => {
    let most = 0;
    for (let r = 0; r < board.length; r++) {
        for (let c = 0; c < board[0].length; c++) {
            if (board[r][c] == id) {
                let count = 1;
                while (c + count < board[0].length && board[r][c + count] == id) {
                    count++;
                }
                most = Math.max(most, count);
            }
        }
    }
    return most;
}

let mostIncDiag = (board, id) => {
    let most = 0;
    for (let r = 0; r < board.length; r++) {
        for (let c = 0; c < board[0].length; c++) {
            let rr = r,
                cc = c,
                count = 0;

            while (rr > 0 && cc < board[rr].length && board[rr][cc] == id) {
                rr--;
                cc++;
                count++;
            }
            most = Math.max(most, count);
        }
    }
    return most;
}

let mostDecDiag = (board, id) => {
    let most = 0;
    for (let r = 0; r < board.length; r++) {
        for (let c = 0; c < board[0].length; c++) {
            let rr = r,
                cc = c,
                count = 0;
            while (rr < board.length && cc < board[rr].length && board[rr][cc] == id) {
                rr++;
                cc++;
                count++;
            }
            most = Math.max(most, count);
        }
    }
    return most;
}

function getNextRow(board, col) {
    let row = 0;
    while (row < board.length && board[row][col] === 0) {
        row++;
    }
    return row - 1;
}

let Agent = new AlphaBetaAgent(2, 6);

function getAIMove() {
    console.log(gameField);

    return Agent.getBestMove(gameField);
}