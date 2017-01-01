import connect4 as c4

class AlphaBetaAgent(c4.Agent):

    def __init__(self, id_, depth = 5):
        self.id = id_
        self.depth = depth

    def get_move(self, board):
        best, _ = max(self._moves(board), key=lambda v:v[1])
        return best

    def _moves(self, board):
        for col in range(board.shape[1]):
            if board[0, col] == 0:
                
                row = c4.next_row(board, col)
                    
                board[row, col] = self.id
                
                score = self._alphabeta(board, self.depth, c4.MIN, c4.MAX, False)
                
                board[row, col] = 0
                
                yield col, score

    

    def _alphabeta(self, board, depth, alpha, beta, maximize):
        if depth == 0:
            return c4.evaluate_board(board, self.id)
        elif maximize:
            v = c4.MIN
            for col in range(board.shape[1]):
                if board[0, col] == 0:
                    
                    row = c4.next_row(board, col)
                    
                    board[row, col] = self.id

                    v = max(v, self._alphabeta(board, depth - 1, alpha, beta, False))

                    board[row, col] = 0

                    alpha = max(alpha, v)
                    
                    if beta <= alpha:
                        break
        else:
            v = c4.MAX
            for col in range(board.shape[1]):
                if board[0, col] == 0:
                    
                    row = c4.next_row(board, col)
                    
                    board[row, col] = self.id ^ 3

                    v = min(v, self._alphabeta(board, depth - 1, alpha, beta, True))

                    board[row, col] = 0

                    beta = min(alpha, v)
                    
                    if beta <= alpha:
                        break
        return v

if __name__ == "__main__":
    board = c4.make_board()

    human = c4.Agent(1)
    alpha = AlphaBetaAgent(2)

    print("You = 1, AI = 2\n")

    while True:
        print("\n\n")
        print(board)
    
        h_col = human.get_move(board)
        c4.play_move(board, 1, h_col)

        a_col = alpha.get_move(board)
        c4.play_move(board, 2, a_col)
