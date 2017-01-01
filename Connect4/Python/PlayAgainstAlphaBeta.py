import connect4 as c4

board = c4.make_board()

human = c4.Agent(1)
alpha = c4.AlphaBetaAgent(2)

print("You = 1, AI = 2\n")

while True:
    print("\n\n")
    print(board)
    
    h_col = human.get_move(board)
    c4.play_move(board, 1, h_col)

    a_col = alpha.get_move(board)
    c4.play_move(board, 2, a_col)
