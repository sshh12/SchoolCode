
def _in_bounds(grid, point):

    r, c = point
    return min(r, c) >= 0 and r < len(grid) and c < len(grid[0])

def _get_neighbors(grid, point):

    r, c = point
    for rr, cc in [[r + 1, c], [r - 1, c], [r, c + 1], [r, c - 1]]:
        if _in_bounds(grid, (rr, cc)) and grid[rr][cc] == '.':
            yield rr, cc

def solve(grid, start, end):

    visited = []
    parents = {}

    q = [start]

    while len(q) > 0:

        cur = q.pop(0)
        visited.append(cur)

        if cur == end:

            path = []
            node = cur

            while node != None:
                path.insert(0, node)
                node = parents.get(node)

            return path

        else:

            for n in _get_neighbors(grid, cur):
                if n not in visited:
                    q.append(n)
                    parents.update({n : cur})

    return None


def solve2(grid, end, visited=None, parents=None, q=None, start=None):

    if visited == None or parents == None or q == None:

        q = [start]

        return solve2(grid, end, [], {}, q)

    elif len(q) == 0:
        return None

    cur = q.pop(0)

    visited.append(cur)

    if cur == end:

        path = []
        node = cur

        while node != None:
            path.insert(0, node)
            node = parents.get(node)

        return path

    else:

        for n in _get_neighbors(grid, cur):

            if n not in visited:

                parents.update({n : cur})

                q.append(n)

                new_path = solve2(grid, end, visited, parents, q)

                if new_path:

                    return new_path

    return None

def main():

    grid = [
        ".####",
        ".#...",
        ".#.#.",
        "...#.",
        ".##.."
    ]

    for p in solve(grid, (0,0), (4,4)):
        print(p)
    print("------")
    for p in solve2(grid, (4,4), start=(0,0)):
        print(p)

if __name__ == '__main__':
    main()
