
import java.util.ArrayList;

public class Set {

    private interface SetDataStructure {

        public void add(int item);

        public boolean contains(int item);

        public void remove(int item);

    }

    private static class Set1 implements SetDataStructure {

        ArrayList<Integer> items;

        public Set1() {

            items = new ArrayList<>();

        }

        public void add(int item) {

            if (!items.contains(item)) {

                items.add(item);

            }

        }

        public boolean contains(int item) {

            return items.contains(item);

        }

        public void remove(int item) {

            items.remove(new Integer(item)); // Force object method

        }

    }

    private static class Set2 implements SetDataStructure {

        java.util.Set<Integer> items;

        public Set2() {

            items = new java.util.HashSet<>();

        }

        public void add(int item) {

            items.add(item);

        }

        public boolean contains(int item) {

            return items.contains(item);

        }

        public void remove(int item) {

            items.remove(item);

        }

    }

    public static void main(String[] args) {

        SetDataStructure[] setClasses = new SetDataStructure[]{new Set1(), new Set2()};

        for (SetDataStructure set : setClasses) {

            set.add(1);
            set.add(2);
            set.add(1);

            System.out.println(set.contains(1));

            set.remove(1);

            System.out.println(set.contains(1));

            System.out.println(set.contains(2));

            System.out.println("------");

        }

    }

}
