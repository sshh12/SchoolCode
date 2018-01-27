
import java.util.*;

public class IntroSort {

    private static void insertionSort(int[] nums, int leftIndex, int rightIndex) {

        for (int i = leftIndex + 1; i <= rightIndex; i++) {

            int n = nums[i], j = i - 1;

            while (j >= leftIndex && nums[j] > n) {

                nums[j + 1] = nums[j];

                j--;

            }

            nums[j + 1] = n;

        }

    }

    private static void heapSort(int[] nums, int leftIndex, int rightIndex) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = leftIndex; i <= rightIndex; i++) {

            heap.add(nums[i]);

        }

        for (int i = leftIndex; i <= rightIndex; i++) {

            nums[i] = heap.remove();

        }

    }

    private static int median(int a, int b, int c) {

        return a + b + c - Math.min(a, Math.min(b, c)) - Math.max(a, Math.max(b, c));

    }

    private static void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    private static int partition(int[] nums, int leftIndex, int rightIndex) {

        int pivot = nums[rightIndex], i = leftIndex - 1;

        for (int j = leftIndex; j < rightIndex; j++) {

            if (nums[j] <= pivot) {

                i++;
                swap(nums, i, j);

            }

        }

        swap(nums, i + 1, rightIndex);

        return i + 1;

    }

    private static void introUtil(int[] nums, int leftIndex, int rightIndex, int depthLimit) {

        int size = rightIndex - leftIndex;

        if (size < 16) {

            insertionSort(nums, leftIndex, rightIndex);

        } else if (depthLimit == 0) {

            heapSort(nums, leftIndex, rightIndex);

        } else {

            int pivot = median(leftIndex, leftIndex + size / 2, rightIndex);

            swap(nums, pivot, rightIndex);

            int index = partition(nums, leftIndex, rightIndex);

            introUtil(nums, leftIndex, index - 1, depthLimit - 1);
            introUtil(nums, index + 1, rightIndex, depthLimit - 1);

        }

    }

    public static void introSort(int[] nums) {

        int leftIndex = 0, rightIndex = nums.length - 1;

        int depthLimit = (int) (2 * Math.log(rightIndex - leftIndex));

        introUtil(nums, leftIndex, rightIndex, depthLimit);

    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 23, 44, 143, 0, 4, 68, 9, 1, 59, 31, 32, 33, 34, 35, 9, 21, 22, 5};

        System.out.println(Arrays.toString(nums));

        introSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}
