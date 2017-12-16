
def get_line_dist(a, b, x):

    return (x[1] - a[1]) * (b[0] - a[0]) - (b[1] - a[1]) * (x[0] - a[0])

def sign(value):

    if value == 0:
        return 0

    else:
        return (1 if value > 0 else -1)

def _find_hull(points, hull, a, b, side):

    max_index, max_dist = -1, 0

    for i, point in enumerate(points):

        dist = get_line_dist(a, b, point)

        cur_dist = abs(dist)
        cur_side = sign(dist)

        if cur_side == side and cur_dist > max_dist:

            max_index, max_dist = i, cur_dist

    if max_index == -1:

        hull.add(a)
        hull.add(b)

    else:

        _find_hull(points, hull, points[max_index], a, -sign(get_line_dist(points[max_index], a, b)))
        _find_hull(points, hull, points[max_index], b, -sign(get_line_dist(points[max_index], b, a)))

def get_hull(points):

    hull = set()

    point_min_x = min(points, key=lambda p: p[0])
    point_max_x = max(points, key=lambda p: p[0])

    _find_hull(points, hull, point_min_x, point_max_x, 1)
    _find_hull(points, hull, point_min_x, point_max_x, -1)

    return hull

def main():

    points = [
        (0, 3),
        (1, 1),
        (2, 2),
        (4, 4),
        (0, 0),
        (1, 2),
        (3, 1),
        (3, 3)
    ]

    for p in get_hull(points):
        print(p)

if __name__ == '__main__':
    main()
