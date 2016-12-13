MAX = 100000;
MIN = -100000;

function getAIMove() {
    var current = new TheoreticalBoard(gameField, true, -1);

    if (current.isEmpty()) {
        return Math.floor(Math.random() * 3) + 1;
    }

    var minimax = new Tree(current);

    minimax.setBranches(6);

    console.log("===================");

	var best = minimax.leafs.reduce((x,y) => x.evaluate() > y.evaluate() ? x:y);//Bug
	
	var best2 = minimax.leafs.reduce((x,y) => x.evaluation > y.evaluation ? x:y);
	
	console.log(minimax.leafs.map(x => x.evaluation));
	console.log(best2);
	
    return best2.head.move;
}


function TheoreticalBoard(board, myturn, mov) {
    this.board = board;
    this.ourTurn = myturn;
    this.move = mov;
    this.evaluation = 0;

    this.getBranches = function() {
        branches = [];

        if (this.evaluate() <= MIN) {
            return branches;
        }

        for (var col = 0; col < board[0].length; col++) {
            var player = this.ourturn ? 2 : 1;

            var placed = this.place(player, col);

            if (placed !== null) {
                branches.push(new TheoreticalBoard(placed, !this.ourTurn, col));
            }
        }

        return branches;
    };

    this.place = function(player, col) {
        if (!this.columnFull(col)) {
            var newboard = JSON.parse(JSON.stringify(this.board));

            var row = 0;

            for (var i = this.board.length - 1; i >= 0; i--) {
                if (this.board[i][col] === 0) {
                    row = i;
                    break;
                }
            }

            newboard[row][col] = player;

            return newboard;
        }
        return null;
    };
	
	this.columnFull = column => this.board[0][column] !== 0;

    this.isEmpty = function() {
        for (var c = 0; c < this.board.length; c++) {
            if (this.board[this.board.length - 1][c] !== 0) {
                return false;
            }
        }
        return true;
    };

}

TheoreticalBoard.prototype.mostInVertical = function(p) {
    var most = 0;
    for (var c = 0; c < this.board[0].length; c++) {
        for (var r = 0; r < this.board.length; r++) {
            if (this.board[r][c] === p) {
                var count = 1;
                while (r + count < this.board.length && this.board[r + count][c] === p) {
                    count++;
                }
                most = most > count ? most : count;
            }
        }
    }
    return most;
};

TheoreticalBoard.prototype.mostInHorizontal = function(p) {
    var most = 0;
    for (var r = 0; r < this.board.length; r++) {
        for (var c = 0; c < this.board[0].length; c++) {
            if (this.board[r][c] === p) {
                var count = 1;
                while (c + count < this.board[0].length && this.board[r][c + count] === p) {
                    count++;
                }
                most = most > count ? most : count;
            }
        }
    }
    return most;
};

TheoreticalBoard.prototype.mostInIncDiag = function(p) {
    var most = 0;
    for (var r = 0; r < this.board.length; r++) {
        for (var c = 0; c < this.board[0].length; c++) {
            var rr = r,
                cc = c,
                count = 0;

            while (rr > 0 && cc < this.board[rr].length && this.board[rr][cc] === p) {
                rr--;
                cc++;
                count++;
            }

            most = most > count ? most : count;
        }
    }
    return most;
};

TheoreticalBoard.prototype.mostInDecDiag = function(p) {
    var most = 0;
    for (var r = 0; r < this.board.length; r++) {
        for (var c = 0; c < this.board[0].length; c++) {
            var rr = r,
                cc = c,
                count = 0;

            while (rr < this.board.length && cc < this.board[rr].length && this.board[rr][cc] === p) {
                rr++;
                cc++;
                count++;
            }

            most = most > count ? most : count;
        }
    }
    return most;
};

TheoreticalBoard.prototype.evaluate = function() {
    var me = 2,
        them = 1;

    if (this.evaluation !== 0) {
        return this.evaluation;
    }
	
	var getValues = c => [this.mostInHorizontal(c), 
						  this.mostInVertical(c), 
						  this.mostInIncDiag(c), 
						  this.mostInDecDiag(c)];

    var me_values = getValues(me);
    var them_values = getValues(them);

    var Three4Me = 0,
        Three4Them = 0;

    for (var v in me_values) {
        if (me_values[v] >= 4) {
            return MAX;
        } else if (me_values[v] === 3) {
            Three4Me += 10;
        }
    }

    for (var v in them_values) {
        if (them_values[v] >= 4) {
            return MIN;
        } else if (them_values[v] === 3) {
            Three4Them += 10;
        }
    }

    var me_points = ((me_values.reduce((x,y) => x + y) + Three4Me) * 100) / 16;
    var them_points = ((them_values.reduce((x,y) => x + y) + Three4Them) * 100) / 16;
    this.evaluation = me_points - them_points;

    return this.evaluation; // Bad < 0, Draw == 0, Good > 0
};

function Tree(head) {
    this.head = head;
    this.leafs = [];
    this.evaluation = 0;

    this.addLeaf = function(leaf) {
        var tree = new Tree(leaf);
        this.leafs.push(tree);
        return tree;
    };
}

Tree.prototype.setBranches = function(b) {
    if (b === 0) {
        return;
    } else if (this.leafs.length === 0) {
        this.head
			.getBranches()
			.forEach(leaf => this.addLeaf(leaf), this);
    }

    for (var t in this.leafs) {
        if (this.leafs[t].head.evaluate() > MIN) {
            this.leafs[t].setBranches(b - 1);
        }
    }
};

Tree.prototype.evaluate = function() {
    if (this.evaluation !== 0) {
        return this.evaluation;
    }
	
    var head = this.head;
    if (this.leafs.length === 0) {
        return head.evaluate();
    } else if (!head.ourTurn) {
        this.evaluation = this.leafs
			.map(x => x.evaluate())
			.reduce((x,y) => x < y ? x:y, MAX);
    } else {
        this.evaluation = this.leafs
			.map(x => x.evaluate())
			.reduce((x,y) => x > y ? x:y, MIN);
    }
    return this.evaluation;
};


Tree.prototype.toString = function(increment) {
    var s = "";
    var inc = "";
    for (var i = 0; i < increment; ++i) {
        inc = inc + " ";
    }
    s = inc + this.evaluate();
    for (var child in this.leafs) {
        s += "\n" + this.leafs[child].toString(increment + 4);
    }
    return s;
};
