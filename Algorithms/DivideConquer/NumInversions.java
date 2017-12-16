
import java.util.Arrays;

public class NumInversions {

    private static int merge(int[] nums, int leftIndex, int middleIndex, int rightIndex) {

        int inversions = 0;

        int leftSize = middleIndex - leftIndex + 1;
        int rightSize = rightIndex - middleIndex;

        int leftElements[] = Arrays.copyOfRange(nums, leftIndex, leftIndex + leftSize);
        int rightElements[] = Arrays.copyOfRange(nums, middleIndex + 1, middleIndex + rightSize + 1);

        int left = 0, right = 0, index = leftIndex;

        while (left < leftSize && right < rightSize) {

            if (leftElements[left] <= rightElements[right]) {

                nums[index++] = leftElements[left++];

            } else {

                nums[index++] = rightElements[right++];

                inversions += (leftSize - left);

            }

        }

        while (left < leftSize) {

            nums[index++] = leftElements[left++];

        }

        while (right < rightSize) {

            nums[index++] = rightElements[right++];

        }

        return inversions;

    }

    public static int getNumInversions(int[] nums, int leftIndex, int rightIndex) {

        int count = 0;

        if (leftIndex < rightIndex) {

            int middleIndex = (leftIndex + rightIndex) / 2;

            count += getNumInversions(nums, leftIndex, middleIndex);
            count += getNumInversions(nums, middleIndex + 1, rightIndex);

            count += merge(nums, leftIndex, middleIndex, rightIndex);

        }

        return count;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 15, 61, 11, 7, 9, 2};

        System.out.println(getNumInversions(nums, 0, nums.length - 1));

    }

}
