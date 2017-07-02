
def _in_bounds(grid, row, col):

    return min(row, col) >= 0 and row < len(grid) and col < len(grid[0])

def count_paths_across(grid, row=None, col=None):

    if row == None and col == None:

        return count_paths_across(grid, len(grid) - 1, len(grid[0]) - 1)

    elif not _in_bounds(grid, row, col) or grid[row][col] == '#':

        return 0

    elif row == 0 and col == 0:

        return 1

    else:

        return count_paths_across(grid, row - 1, col) + count_paths_across(grid, row, col - 1)

def count_paths_across2(grid):

    rows, cols = len(grid), len(grid[0])

    db = [ [ 0 for _ in range(cols) ] for _ in range(rows) ]

    db[0][0] = 1

    for row in range(rows):

        for col in range(cols):

            if row == 0 and col == 0 or grid[row][col] == '#':

                continue

            else:

                if col != 0:

                    db[row][col] += db[row][col - 1]

                if row != 0:

                    db[row][col] += db[row - 1][col]

    return db[-1][-1]

def main():

    grid = [
        ['S', '.', '.', '.', '.', '.'],
        ['.', '#', '.', '.', '#', '.'],
        ['.', '.', '.', '.', '.', '.'],
        ['.', '.', '#', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '#', '.'],
        ['.', '#', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', 'E']
    ]

    print(count_paths_across(grid))
    print("-------")
    print(count_paths_across2(grid))

if __name__ == '__main__':
    main()
