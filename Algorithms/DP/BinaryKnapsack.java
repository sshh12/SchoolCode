
public class BinaryKnapsack {

    static class Item {

        int weight, value;

        public Item(int v, int w) {

            value = v;
            weight = w;
            
        }

    }

    public static int getMaxValue(int capacity, Item[] items, int n) {

        if (capacity == 0 || n == 0) {

            return 0;

        } else if (items[n - 1].weight > capacity) {

            return getMaxValue(capacity, items, n - 1);

        } else {

            return Math.max(items[n - 1].value + getMaxValue(capacity - items[n - 1].weight, items, n - 1),
                                                 getMaxValue(capacity, items, n - 1));

        }

    }

    public static int getMaxValue2(int capacity, Item[] items, int n) {

        int[][] db = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {

            for (int weight = 0; weight <= capacity; weight++) {

                if (i == 0 || weight == 0) {

                    db[i][weight] = 0;

                } else if (items[i - 1].weight <= weight) {

                    db[i][weight] = Math.max(items[i - 1].value + db[i - 1][weight - items[i - 1].weight],
                                                                  db[i - 1][weight]);

                } else {

                    db[i][weight] = db[i - 1][weight];

                }

            }

        }

        return db[n][capacity];

    }

    public static void main(String[] args) {

        Item[] items = new Item[]{
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        System.out.println(getMaxValue(50, items, items.length));
        System.out.println("------");
        System.out.println(getMaxValue2(50, items, items.length));

    }

}
