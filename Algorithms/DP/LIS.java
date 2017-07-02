
public class LIS {

    private static int bestOverall = 1;

    private static int getLengthLIS(int[] nums, int index) {

        if (index == 0) {

            return 1;

        } else {

            int best = 1;

            for (int i = 0; i < index; i++) {

                int subLength = getLengthLIS(nums, i);

                if (nums[i] < nums[index] && subLength + 1 > best) {

                    best = subLength + 1;

                }

            }

            bestOverall = Math.max(bestOverall, best);

            return best;

        }

    }

    public static int getLengthLIS(int[] nums) {

        bestOverall = 1;

        getLengthLIS(nums, nums.length - 1);

        return bestOverall;

    }

    public static int getLengthLIS2(int[] nums) {

        int n = nums.length, best = 0;

        int[] db = new int[n];

        for (int i = 0; i < n; i++) {

            db[i] = 1;

        }

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j] && db[j] + 1 > db[i]) {

                    db[i] = db[j] + 1;

                }

            }

        }

        for (int i = 0; i < n; i++) {

            best = Math.max(db[i], best);

        }

        return best;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{10, 22, 9, 33, 21, 50, 41, 60};

        System.out.println(getLengthLIS(nums));

        System.out.println("------");

        System.out.println(getLengthLIS2(nums));

    }

}
