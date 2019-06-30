
import java.util.*;

public class HeapSort {

    public static void heapSort(int[] nums) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int n : nums) {
            heap.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = heap.remove();
        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{24, 43, 1, 33, 3, 41, 99, 102, 6, 78, 8};

        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));

    }

}
