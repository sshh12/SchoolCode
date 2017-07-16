
import java.util.*;

public class BucketSort {

    private static int max(int[] nums) {

        int max = nums[0];

        for (int n : nums) {

            max = Math.max(max, n);

        }

        return max;

    }

    public static void bucketSort(int[] nums, int numBuckets) {

        ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[numBuckets];

        for (int i = 0; i < numBuckets; i++) {

            buckets[i] = new ArrayList<>();

        }

        double mx = max(nums) + 1;

        for (int i = 0; i < nums.length; i++) {

            int index = (int)(nums[i] / mx * numBuckets);

            buckets[index].add(nums[i]);

        }

        int arrayIndex = 0;

        for (int i = 0; i < numBuckets; i++) {

            Collections.sort(buckets[i]);

            for (int j = 0; j < buckets[i].size(); j++) {

                nums[arrayIndex++] = buckets[i].get(j);

            }

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{12, 32, 43, 11, 58, 60, 68, 90, 80, 99, 22};

        System.out.println(Arrays.toString(nums));

        bucketSort(nums, 4);

        System.out.println(Arrays.toString(nums));

    }

}
