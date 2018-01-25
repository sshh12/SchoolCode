
public class BloomFilter {

    private interface BloomFilterDataStructure {

        public void add(Object item);

        public boolean mightContain(Object item);

    }

    private static class BloomFilter1 implements BloomFilterDataStructure {

        boolean[] store;

        public BloomFilter1(int size) {

            store = new boolean[size];

        }

        public int[] getHashes(Object item) {

            int[] hashes = new int[]{
                item.hashCode(),
                (item + " ").hashCode(),
                (item + "!").hashCode()
            };

            return hashes;

        }

        public void add(Object item) {

            for (int hash : getHashes(item)) {

                int index = hash % store.length;

                store[index] = true;

            }

        }

        public boolean mightContain(Object item) {

            for (int hash : getHashes(item)) {

                int index = hash % store.length;

                if (!store[index]) {
                    return false;
                }

            }

            return true;

        }

    }

    public static void main(String[] args) {

        BloomFilterDataStructure[] bloomClasses = new BloomFilterDataStructure[]{new BloomFilter1(10)};

        for (BloomFilterDataStructure bloom : bloomClasses) {

            bloom.add("A");
            bloom.add("B");
            bloom.add("C");

            System.out.println(bloom.mightContain("A"));
            System.out.println(bloom.mightContain("Z"));

            System.out.println("------");

        }

    }

}
