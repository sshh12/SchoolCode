
from itertools import combinations
from math import sqrt

class Point:

    def __init__(self, x, y):
        self.x = x
        self.y = y

    def dist(self, other):
        return sqrt( (self.x - other.x)**2 + (self.y - other.y)**2 )

def brute_force(points):

    min_val = 9e10

    for a, b in combinations(points, 2):

        min_val = min(min_val, a.dist(b))

    return min_val

def _find_smallest(points_x, points_y):

    n = len(points_x)

    if n <= 3:
        return brute_force(points_x)

    middle = n // 2
    mid_point = points_x[middle]

    points_left, points_right = [], []

    for p in points_y:

        if p.x <= mid_point.x:
            points_left.append(p)
        else:
            points_right.append(p)

    smallest_left = _find_smallest(points_x[:middle+1], points_left)
    smallest_right = _find_smallest(points_x[middle+1:], points_right)

    smallest = min(smallest_left, smallest_right)

    splits = []
    for p in points_y:
        if abs(p.x - mid_point.x) < smallest:
            splits.append(p)

    splits.sort(key=lambda point: point.y)

    for i, p in enumerate(splits):

        j = i + 1

        while j < len(splits) and splits[j].y - p.y < smallest:

            smallest = min(smallest, p.dist(splits[j]))

            j += 1

    return smallest


def get_smallest_distance(points):

    points_x = list(points)
    points_y = list(points)

    points_x.sort(key=lambda point: point.x)
    points_y.sort(key=lambda point: point.y)

    return _find_smallest(points_x, points_y)

def main():

    points = [
        Point(2, 3),
        Point(11, 30),
        Point(40, 50),
        Point(5, 1),
        Point(12, 10),
        Point(3, 4)
    ]

    print(get_smallest_distance(points))

if __name__ == '__main__':
    main()
