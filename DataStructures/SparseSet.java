

public class SparseSet {

    private interface SparseSetDataStructure {

        public void add(int item);

        public void remove(int item);

        public int find(int item);

        public void clear();

    }

    private static class SparseSet1 implements SparseSetDataStructure {

        int items, capacity, maxVal;
        int[] dense, sparse;

        public SparseSet1(int cap, int maxV) {

            dense = new int[cap];
            sparse = new int[maxV + 1];
            capacity = cap;
            maxVal = maxV;
            items = 0;

        }

        public void add(int item) {

            if(item > maxVal || items >= capacity || find(item) != -1) {
                return;
            }

            dense[items] = item;
            sparse[item] = items;

            items++;

        }

        public void remove(int item) {

            if(find(item) == -1) {
                return;
            }

            int temp = dense[items - 1];
            dense[sparse[item]] = temp;
            sparse[temp] = sparse[item];

            items--;

        }

        public int find(int item) {

            if(item <= maxVal && sparse[item] < items && dense[sparse[item]] == item) {
                return sparse[item];
            }

            return -1;

        }

        public void clear() {

            items = 0;

        }

    }

    public static void main(String[] args) {

        SparseSetDataStructure[] setClasses = new SparseSetDataStructure[]{new SparseSet1(10, 10)};

        for (SparseSetDataStructure sparseSet : setClasses) {

            sparseSet.add(2);
            sparseSet.add(4);

            System.out.println(sparseSet.find(4));
            System.out.println(sparseSet.find(6));

            sparseSet.add(6);
            sparseSet.add(8);

            System.out.println(sparseSet.find(6));

            sparseSet.remove(6);

            System.out.println(sparseSet.find(6));
            System.out.println(sparseSet.find(8));

            sparseSet.clear();

            System.out.println(sparseSet.find(2));
            System.out.println(sparseSet.find(8));

            System.out.println("------");

        }

    }

}
