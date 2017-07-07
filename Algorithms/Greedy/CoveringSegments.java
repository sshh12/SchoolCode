
import java.util.*;

public class CoveringSegments {

    public static class Segment implements Comparable<Segment> {

        int start, end;

        public Segment(int s, int e) {

            start = s;
            end = e;

        }

        @Override
        public int compareTo(Segment other) {

            return end - other.end;

        }

    }

    public static List<Integer> getOptimalPoints(Segment[] segments) {

        Arrays.sort(segments);

        List<Integer> points = new ArrayList<>();

        int current = segments[0].end;

        points.add(current);

        for (int i = 1; i < segments.length; i++) {

            if (current < segments[i].start || current > segments[i].end) {

                current = segments[i].end;

                points.add(current);

            }

        }

        return points;

    }

    public static void main(String[] args) {

        Segment[] segments = new Segment[]{
            new Segment(4, 7),
            new Segment(1, 3),
            new Segment(2, 5),
            new Segment(5, 6)
        };

        for (int point : getOptimalPoints(segments)) {

            System.out.println(point);

        }

    }

}
