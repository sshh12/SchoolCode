
import java.util.*;

public class ThreeSUM {

    public static List<int[]> getTripletSumZero(int[] nums) {

        List<int[]> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int a = nums[i], start = i + 1, end = nums.length - 1;

            while (start < end) {

                int b = nums[start], c = nums[end];

                if (a + b + c >= 0) {

                    if (a + b + c == 0) {

                        triplets.add(new int[]{a, b, c});

                    }

                    end--;

                } else {

                    start++;

                }

            }

        }

        return triplets;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{-25, -10, -7, -3, 2, 4, 8, 10};

        for (int[] triplet : getTripletSumZero(nums)) {

            System.out.println(Arrays.toString(triplet));

        }

    }

}
