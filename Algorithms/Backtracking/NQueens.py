
def _recur(board, col=0):

    if col >= len(board):
        return True

    for row in range(len(board)):

        if _can_place_queen(board, row, col):

            board[row][col] = 1

            if _recur(board, col + 1):
                return True

            board[row][col] = 0

    return False

def _can_place_queen(board, row, col):

    for c in range(col):
        if board[row][c] == 1:
            return False

    r = row; c = col
    while r >= 0 and c >= 0:
        if board[r][c] == 1:
            return False
        r -= 1; c -= 1

    r = row; c = col
    while r < len(board) and c >= 0:
        if board[r][c] == 1:
            return False
        r += 1; c -= 1

    return True

def solve(n):

    board = [[0 for _ in range(n)] for _ in range(n)]

    if _recur(board):

        for row in board:
            print(row)

        return True

    print("No Solution")
    return False

def main():
    solve(5)

if __name__ == '__main__':
    main()
