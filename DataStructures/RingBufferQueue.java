
public class RingBufferQueue {

    private interface RingBufferQueueDataStructure {

        public boolean add(Object item);

        public Object peek();

        public Object remove();

    }

    private static class RingBufferQueue1 implements RingBufferQueueDataStructure {

        Object[] items;
        int size, writeIndex, used;

        public RingBufferQueue1(int size) {

            items = new Object[size];
            this.size = size;

        }

        public boolean add(Object item) {

            if(this.used != this.size) {

                this.items[this.writeIndex] = item;

                this.writeIndex = (this.writeIndex + 1) % this.size;

                this.used++;

                return true;

            }

            return false;

        }

        public Object peek() {

            return this.items[(this.writeIndex + (this.size - this.used)) % this.size];

        }

        public Object remove() {

            if(this.used > 0) {

                Object item = peek();

                this.used--;

                return item;

            }

            return null;

        }

    }

    public static void main(String[] args) {

        RingBufferQueueDataStructure[] rbqClasses = new RingBufferQueueDataStructure[]{new RingBufferQueue1(10)};

        for (RingBufferQueueDataStructure queue : rbqClasses) {

            queue.add("1");
            queue.add("2");

            System.out.println(queue.peek());
            System.out.println(queue.remove());

            queue.add("3");

            System.out.println(queue.remove());

            System.out.println("------");

        }

    }

}
