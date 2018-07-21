
class RingBufferQueue:

    def __init__(self, size=10):

        self.items = [None] * size
        self.size = size
        self.write_index = 0
        self.used = 0

    def add(self, item):

        if self.used != self.size:

            self.items[self.write_index] = item

            self.write_index = (self.write_index + 1) % self.size

            self.used += 1

            return True

        return False

    def peek(self):

        return self.items[(self.write_index + (self.size - self.used)) % self.size]

    def remove(self):

        if self.used > 0:

            item = self.peek()

            self.used -= 1

            return item

        return None

def main():

    for rbq_class in [RingBufferQueue]:

        queue = rbq_class()

        queue.add("1")
        queue.add("2")

        print(queue.peek())
        print(queue.remove())

        queue.add("3")

        print(queue.remove())

        print("------")

if __name__ == '__main__':
    main()
