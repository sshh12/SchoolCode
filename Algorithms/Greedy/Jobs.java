
import java.util.*;

public class Jobs {

    static class Job implements Comparable<Job> {

        String name;
        int deadline, profit;

        public Job(String n, int d, int p) {
            name = n;
            deadline = d;
            profit = p;
        }

        @Override
        public int compareTo(Job b) {
            return b.profit - profit;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    public static void printBestOrder(List<Job> jobs) {

        Collections.sort(jobs);

        int n = jobs.size();

        int[] results = new int[n];
        boolean[] times = new boolean[n];

        for (int i = 0; i < n; i++) {

            for (int j = Math.min(n, jobs.get(i).deadline) - 1; j >= 0; j--) {

                if (!times[j]) {

                    results[j] = i;
                    times[j] = true;
                    break;

                }

            }

        }

        for (int i = 0; i < n; i++) {
            if (times[i]) {
                System.out.println(jobs.get(results[i]));
            }
        }

    }

    public static void main(String[] args) {

        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("A", 6, 100));
        jobs.add(new Job("B", 2, 100));
        jobs.add(new Job("C", 1, 5));
        jobs.add(new Job("D", 1, 25));
        jobs.add(new Job("E", 3, 90));
        jobs.add(new Job("F", 2, 70));

        printBestOrder(jobs);

    }

}
