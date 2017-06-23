
import java.util.Arrays;

public class FractionalKnapsack {

    static class Item implements Comparable<Item> {

        int weight, value;

        public Item(int v, int w) {
            value = v;
            weight = w;
        }

        double getRatio() {
            return value / (double) weight;
        }

        @Override
        public int compareTo(Item b) {
            return Double.compare(b.getRatio(), getRatio());
        }

    }

    static double getMaxValue(Item[] items, int maxWeight) {

        Arrays.sort(items);

        int currentWeight = 0;
        double currentValue = 0.0;

        for (Item item : items) {

            if (currentWeight + item.weight <= maxWeight) {

                currentWeight += item.weight;
                currentValue += item.value;

            } else {

                int remaining = maxWeight - currentWeight;

                currentValue += remaining * item.getRatio();

                break;

            }

        }

        return currentValue;

    }

    public static void main(String[] args) {

        Item[] items = new Item[]{
            new Item(60, 10),
            new Item(100, 20),
            new Item(20, 50),
            new Item(120, 30),
            new Item(10, 2)
        };

        System.out.println(getMaxValue(items, 75));

    }

}
