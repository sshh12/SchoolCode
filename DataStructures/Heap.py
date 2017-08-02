from heapq import heappop, heappush

class Heap(object):

    def __init__(self):

        self.heap = []

    def add(self, item):

        self.heap.append(item)

        self._shift_down(len(self.heap) - 1)

    def remove(self):

        bottom_item = self.heap.pop()
        return_item = self.heap[0]

        self.heap[0] = bottom_item

        self._shift_up(0)

        return return_item

    def _shift_down(self, index, start_index=0):

        item = self.heap[index]

        while index > start_index:

            parent_index = (index - 1) >> 1
            parent = self.heap[parent_index]

            if item < parent:

                self.heap[index] = parent
                index = parent_index

                continue

            break

        self.heap[index] = item

    def _shift_up(self, index):

        end_index, start_index = len(self.heap), index

        item = self.heap[index]

        child_index = 2 * index + 1

        while child_index < end_index:

            right_index = child_index + 1

            if right_index < end_index and self.heap[child_index] >= self.heap[right_index]:

                child_index = right_index

            self.heap[index] = self.heap[child_index]

            index, child_index = child_index, 2 * index + 1

        self.heap[index] = item

        self._shift_down(index, start_index)



class Heap2(object):

    def __init__(self):

        self.heap = []

    def add(self, item):

        heappush(self.heap, item)

    def remove(self):

        return heappop(self.heap)

def main():

    for heap_class in [Heap, Heap2]:

        heap = heap_class()

        heap.add(3)
        heap.add(5)
        heap.add(1)

        print(heap.remove())

        heap.add(4)

        print(heap.remove())

        print("------")

if __name__ == '__main__':
    main()
