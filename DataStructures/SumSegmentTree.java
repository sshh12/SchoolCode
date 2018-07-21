
public class SumSegmentTree {

    private interface SumSegmentTreeDataStructure {

        public int sum(int rangeStart, int rangeEnd);

        public int get(int index);

        public void set(int index, int value);

    }

    private static class SumSegmentTree1 implements SumSegmentTreeDataStructure {

        int[] nums, tree;

        public SumSegmentTree1(int[] nums) {

            this.nums = nums;

            int levels = (int) Math.ceil(Math.log(nums.length) / Math.log(2)),
                maxSize = 2 * (int) Math.pow(2, levels) - 1;

            tree = new int[maxSize];

            construct(0, nums.length - 1, 0);

        }

        private int getMiddleIndex(int startIndex, int endIndex) {

            return startIndex + (endIndex - startIndex) / 2;

        }

        private int construct(int startIndex, int endIndex, int curIndex) {

            if (startIndex == endIndex) {

                tree[curIndex] = nums[startIndex];

                return nums[startIndex];

            }

            int middleIndex = getMiddleIndex(startIndex, endIndex);

            tree[curIndex] = construct(startIndex, middleIndex, curIndex * 2 + 1)
                             + construct(middleIndex + 1, endIndex, curIndex * 2 + 2);

            return tree[curIndex];

        }

        public int sum(int rangeStart, int rangeEnd) {

            return sum(rangeStart, rangeEnd, 0, nums.length - 1, 0);

        }

        private int sum(int rangeStart, int rangeEnd, int startIndex, int endIndex, int curIndex) {

            if (rangeStart <= startIndex && rangeEnd >= endIndex) {

                return tree[curIndex];

            } else if (endIndex < rangeStart || startIndex > rangeEnd) {

                return 0;

            } else {

                int middleIndex = getMiddleIndex(startIndex, endIndex);

                return sum(rangeStart, rangeEnd, startIndex, middleIndex, curIndex * 2 + 1)
                       + sum(rangeStart, rangeEnd, middleIndex + 1, endIndex, curIndex * 2 + 2);

            }

        }

        public int get(int index) {

            return nums[index];

        }

        public void set(int index, int value) {

            int diff = value - nums[index];

            nums[index] = value;

            set(index, 0, nums.length - 1, 0, diff);

        }

        private void set(int index, int startIndex, int endIndex, int curIndex, int diff) {

            if (index >= startIndex && index <= endIndex) {

                tree[curIndex] += diff;

                if (startIndex != endIndex) {

                    int middleIndex = getMiddleIndex(startIndex, endIndex);

                    set(index, startIndex, middleIndex, curIndex * 2 + 1, diff);
                    set(index, middleIndex + 1, endIndex, curIndex * 2 + 2, diff);

                }

            }

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 4, 6, 10, 20, 22};

        SumSegmentTreeDataStructure[] sumSegTreeClasses = new SumSegmentTreeDataStructure[]{new SumSegmentTree1(nums)};

        for (SumSegmentTreeDataStructure sumSegTree : sumSegTreeClasses) {

            System.out.println(sumSegTree.sum(2, 5));

            sumSegTree.set(3, 10);

            System.out.println(sumSegTree.sum(2, 5));

            System.out.println("------");

        }

    }

}
