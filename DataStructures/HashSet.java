
import java.util.ArrayList;

public class HashSet {

    private interface HashSetDataStructure {

        public void add(int item);

        public boolean contains(int item);

        public void remove(int item);

    }

    private static class HashSet1 implements HashSetDataStructure {

        ArrayList<ArrayList<Integer>> buckets;

        public HashSet1(int numBuckets) {

            buckets = new ArrayList<>();

            for (int i = 0; i < numBuckets; i++) {

                buckets.add(new ArrayList<>());

            }

        }

        private int hash(int item) {

            return item % buckets.size();

        }

        public void add(int item) {

            int index = hash(item);

            if (!buckets.get(index).contains(item)) {

                buckets.get(index).add(item);

            }

        }

        public boolean contains(int item) {

            int index = hash(item);

            return buckets.get(index).contains(item);

        }

        public void remove(int item) {

            int index = hash(item);

            buckets.get(index).remove(new Integer(item)); // Force object method

        }

    }

    private static class HashSet2 implements HashSetDataStructure {

        java.util.HashSet<Integer> hashSet;

        public HashSet2() {

            hashSet = new java.util.HashSet<>();

        }

        public void add(int item) {

            hashSet.add(item);

        }

        public boolean contains(int item) {

            return hashSet.contains(item);

        }

        public void remove(int item) {

            hashSet.remove(item);

        }

    }

    public static void main(String[] args) {

        HashSetDataStructure[] hashSetClasses = new HashSetDataStructure[]{new HashSet1(10), new HashSet2()};

        for (HashSetDataStructure hashSet : hashSetClasses) {

            hashSet.add(1);
            hashSet.add(2);
            hashSet.add(1);

            System.out.println(hashSet.contains(1));

            hashSet.remove(1);

            System.out.println(hashSet.contains(1));

            System.out.println(hashSet.contains(2));

            System.out.println("------");

        }

    }

}
