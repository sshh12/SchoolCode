
public class NumSubsetSum {

    public static int countSubsetSums(int[] nums, int sum, int index) {

        if (sum == 0) {

            return 1;

        } else if (index < 0 && sum != 0) {

            return 0;

        } else if (nums[index] > sum) {

            return countSubsetSums(nums, sum, index - 1);

        } else {

            return countSubsetSums(nums, sum, index - 1)
                    + countSubsetSums(nums, sum - nums[index], index - 1);

        }

    }

    public static int countSubsetSums2(int[] nums, int sum) {

        int[] db = new int[sum + 1];

        db[0] = 1;

        for (int n : nums) {

            for (int i = sum - n; i >= 0; i--) {

                if (db[i] > 0) {

                    db[i + n] += db[i];

                }

            }

        }

        return db[sum];

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(countSubsetSums(nums, 17, nums.length - 1));

        System.out.println("------");

        System.out.println(countSubsetSums2(nums, 17));

    }

}
