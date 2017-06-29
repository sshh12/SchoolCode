
public class SubsetSum {

    public static boolean containsSumSubset(int[] nums, int sum, int index) {

        if (sum == 0) {

            return true;

        } else if (index < 0 && sum != 0) {

            return false;

        } else if (nums[index] > sum) {

            return containsSumSubset(nums, sum, index - 1);

        } else {

            return containsSumSubset(nums, sum, index - 1)
                    || containsSumSubset(nums, sum - nums[index], index - 1);

        }

    }

    public static boolean containsSumSubset2(int[] nums, int sum) {

        boolean[][] db = new boolean[sum + 1][nums.length + 1];

        for (int i = 0; i <= nums.length; i++) {

            db[0][i] = true;

        }

        for (int i = 0; i <= sum; i++) {

            for (int j = 1; j <= nums.length; j++) {

                db[i][j] = db[i][j - 1];

                if (!db[i][j] && i >= nums[j - 1]) {

                    db[i][j] = db[i - nums[j - 1]][j - 1];

                }

            }

        }

        return db[sum][nums.length];

    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 5, 4, 10};

        System.out.println(containsSumSubset(nums, 19, nums.length - 1));

        System.out.println("------");

        System.out.println(containsSumSubset2(nums, 19));
    }

}
