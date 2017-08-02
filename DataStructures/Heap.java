
import java.util.ArrayList;

public class Heap {

    private interface HeapDataStructure {

        public void add(int item);

        public int remove();

    }

    private static class Heap1 implements HeapDataStructure {

        ArrayList<Integer> heap;

        public Heap1() {

            heap = new ArrayList<>();

        }

        public void add(int item) {

            heap.add(item);

            shiftDown(heap.size() - 1, 0);

        }

        public int remove() {

            int bottomItem = heap.remove(heap.size() - 1),
                returnItem = heap.get(0);

            heap.set(0, bottomItem);

            shiftUp(0);

            return returnItem;

        }

        private void shiftDown(int index, int startIndex) {

            int item = heap.get(index);

            while (index > startIndex) {

                int parentIndex = (index - 1) >> 1,
                    parent = heap.get(parentIndex);

                if (item < parent) {

                    heap.set(index, parent);
                    index = parentIndex;

                    continue;

                }

                break;

            }

            heap.set(index, item);

        }

        private void shiftUp(int index) {

            int endIndex = heap.size(),
                startIndex = index;

            int item = heap.get(index);

            int childIndex = 2 * index + 1;

            while (childIndex < endIndex) {

                int rightIndex = childIndex + 1;

                if (rightIndex < endIndex && heap.get(childIndex) >= heap.get(rightIndex)) {

                    childIndex = rightIndex;

                }

                heap.set(index, heap.get(childIndex));

                index = childIndex;
                childIndex = 2 * index + 1;

            }

            heap.set(index, item);

            shiftDown(index, startIndex);

        }

    }

    private static class Heap2 implements HeapDataStructure {

        java.util.PriorityQueue<Integer> heap;

        public Heap2() {

            heap = new java.util.PriorityQueue();

        }

        public void add(int item) {

            heap.add(item);

        }

        public int remove() {

            return heap.remove();

        }

    }

    public static void main(String[] args) {

        HeapDataStructure[] heapClasses = new HeapDataStructure[]{new Heap1(), new Heap2()};

        for (HeapDataStructure heap : heapClasses) {

            heap.add(3);
            heap.add(5);
            heap.add(1);

            System.out.println(heap.remove());

            heap.add(4);

            System.out.println(heap.remove());

            System.out.println("------");

        }

    }

}
