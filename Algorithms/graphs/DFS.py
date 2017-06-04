
def _in_bounds(grid, point):

    r, c = point
    return min(r, c) >= 0 and r < len(grid) and c < len(grid[0])

def get_neighbors(grid, point):

    r, c = point
    for rr, cc in [[r + 1, c], [r - 1, c], [r, c + 1], [r, c - 1]]:
        if _in_bounds(grid, (rr, cc)) and grid[rr][cc] == '.':
            yield rr, cc

def solve(grid, start, end):

    visited = []
    parents = {}

    stack = [start]

    while len(stack) > 0:

        cur = stack.pop()
        visited.append(cur)

        if cur == end:

            path = []
            node = cur

            while node != None:
                path.insert(0, node)
                node = parents.get(node)

            return path

        else:

            for n in get_neighbors(grid, cur):
                if n not in visited:
                    stack.append(n)
                    parents.update({n : cur})

    return None


def solve2(grid, cur, end, visited=None, path=None):

    if visited == None or path == None:
        return solve2(grid, cur, end, [], [])

    visited.append(cur)

    if cur == end:
        path.append(cur)
        return path
    else:
        for n in get_neighbors(grid, cur):
            if n not in visited:
                path.append(cur)
                new_path = solve2(grid, n, end, visited, path)
                if new_path:
                    return new_path
                else:
                    path.remove(cur)
    return None

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
for p in solve2(grid, (0,0), (4,4)):
    print(p)
