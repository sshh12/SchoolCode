import numpy as np

MIN = -9999999
MAX =  9999999

board_size = 6, 7

def most_vertical(board, id_):
    rows, cols = board.shape
    most = 0
    for c in range(cols):
        for r in range(rows):
            if board[r, c] == id_:
                cnt = 1
                while r + cnt < rows and board[r + cnt, c] == id_:
                    cnt += 1
                most = max(most, cnt)
    return most

def most_horizontal(board, id_):
    rows, cols = board.shape
    most = 0
    for c in range(cols):
        for r in range(rows):
            if board[r, c] == id_:
                cnt = 1
                while c + cnt < cols and board[r, c + cnt] == id_:
                    cnt += 1
                most = max(most, cnt)
    return most

def most_inc_diagonal(board, id_):
    rows, cols = board.shape
    most = 0
    for c in range(cols):
        for r in range(rows):
            if board[r, c] == id_:
                cnt = 1
                while r - cnt > 0 and c + cnt < cols and board[r - cnt, c + cnt] == id_:
                    cnt += 1
                most = max(most, cnt)
    return most

def most_dec_diagonal(board, id_):
    rows, cols = board.shape
    most = 0
    for c in range(cols):
        for r in range(rows):
            if board[r, c] == id_:
                cnt = 1
                while r + cnt < rows and c + cnt < cols and board[r + cnt, c + cnt] == id_:
                    cnt += 1
                most = max(most, cnt)
    return most

def evaluate_board(board, id_):
    get_points = lambda i:[most_vertical(board, i), most_horizontal(board, i), most_inc_diagonal(board, i), most_dec_diagonal(board, i)]
    
    points = get_points(id_)
    enemy_points = get_points(id_ ^ 3)

    if 4 in enemy_points:
        return MIN
    elif 4 in points:
        return MAX

    score = sum(points) * 20 + points.count(3) * 150
    enemy_score = sum(enemy_points) * 20 + enemy_points.count(3) * 200

    return score - enemy_score

def make_board():
    return np.zeros(board_size, dtype=np.uint8)

def play_move(board, id_, col):
    board[next_row(board, col), col] = id_

def next_row(board, col):
        if board[-1, col] == 0:
            return board.shape[0] - 1 
        return np.where(board[:, col] != 0)[0][0] - 1

class Agent(object):

    def __init__(self, id_):
        self.id = id_

    def get_move(self, board):
        return int(raw_input('col > '))
