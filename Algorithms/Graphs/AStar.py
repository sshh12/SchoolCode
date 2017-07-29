from heapq import heappush, heappop

def _in_bounds(grid, point):

    r, c = point
    return min(r, c) >= 0 and r < len(grid) and c < len(grid[0])

def _get_neighbors(grid, point):

    r, c = point
    for rr, cc in [[r + 1, c], [r - 1, c], [r, c + 1], [r, c - 1]]:
        if _in_bounds(grid, (rr, cc)) and grid[rr][cc] == '.':
            yield rr, cc

def _dist(a, b):

    return (a[0] - b[0])**2 + (a[1] - b[1])**2

def solve(grid, start, end):

    visited = []
    parents = {}

    q = [(99, start)]

    while len(q) > 0:

        _, cur = heappop(q)
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

                    heappush(q, (_dist(n, end), n))
                    parents.update({n : cur})

    return None

def main():

    grid = [
        ".####",
        ".#...",
        ".#.#.",
        "...#.",
        ".##.."
    ]

    for point in solve(grid, (0,0), (4,4)):
        print(point)

if __name__ == '__main__':
    main()
