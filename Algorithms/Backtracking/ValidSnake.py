
def is_valid_snake(grid):

    snake_points = set()

    for r in range(len(grid)):

        for c in range(len(grid[r])):

            if grid[r][c] == 'S':

                snake_points.add((r, c))

    for start_point in snake_points:

        if recur(grid, snake_points, start_point, set()):

            return True

    return False

def recur(grid, snake_points, cur, visited):

    visited.add(cur)

    if len(visited) == len(snake_points):

        return True

    else:

        next_points = []

        r, c = cur
        for rr, cc in [[r + 1, c], [r - 1, c], [r, c + 1], [r, c - 1]]:

            if (rr, cc) in snake_points and (rr, cc) not in visited:

                next_points.append((rr, cc))

        if len(next_points) == 0:

            return False

        else:

            for next_point in next_points:

                if recur(grid, snake_points, next_point, visited):

                    return True

                visited.remove(next_point)

            return False

def main():

    grid1 = [
        "......",
        "..SS..",
        "..S...",
        "..S...",
        "..SSS.",
        "....S.",
        "......"
    ]

    grid2 = [
        "......",
        "..SSS.",
        "..S.S.",
        ".SSSS.",
        "....S.",
        "......",
        "......"
    ]

    grid3 = [
        "....S.",
        ".SSSS.",
        ".S..S.",
        ".SSSS.",
        ".SSSS.",
        "......",
        "......"
    ]

    print(is_valid_snake(grid1))
    print(is_valid_snake(grid2))
    print(is_valid_snake(grid3))

if __name__ == '__main__':
    main()
