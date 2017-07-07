
class Segment(object):

    def __init__(self, s, e):

        self.start = s
        self.end = e

def get_optimal_points(segments):

    segments.sort(key=lambda segment: segment.end)

    current = segments[0].end

    points = [current]

    for i in range(1, len(segments)):

        if current < segments[i].start or current > segments[i].end:

            current = segments[i].end

            points.append(current)

    return points

def main():

    segments = [
        Segment(4, 7),
        Segment(1, 3),
        Segment(2, 5),
        Segment(5, 6)
    ]

    for point in get_optimal_points(segments):

        print(point)

if __name__ == '__main__':
    main()
