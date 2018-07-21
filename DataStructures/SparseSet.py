
class SparseSet1:

    def __init__(self, capacity=10, maxVal=10):

        self.dense = [0] * capacity
        self.sparse = [0] * (maxVal + 1)
        self.capacity = capacity
        self.maxVal = maxVal
        self.items = 0

    def add(self, item):

        if item > self.maxVal or self.items >= self.capacity or self.index(item) != -1:
            return

        self.dense[self.items] = item
        self.sparse[item] = self.items

        self.items += 1

    def remove(self, item):

        if self.index(item) == -1:
            return

        temp = self.dense[self.items - 1]
        self.dense[self.sparse[item]] = temp
        self.sparse[temp] = self.sparse[item]

        self.items -= 1

    def index(self, item):

        if item <= self.maxVal and self.sparse[item] < self.items and self.dense[self.sparse[item]] == item:
            return self.sparse[item]

        return -1

    def clear(self):

        self.items = 0

def main():

    for sparse_set_class in [SparseSet1]:

        sparse_set = sparse_set_class()

        sparse_set.add(2);
        sparse_set.add(4);

        print(sparse_set.index(4));
        print(sparse_set.index(6));

        sparse_set.add(6);
        sparse_set.add(8);

        print(sparse_set.index(6));

        sparse_set.remove(6);

        print(sparse_set.index(6));
        print(sparse_set.index(8));

        sparse_set.clear();

        print(sparse_set.index(2));
        print(sparse_set.index(8));

        print("------")

if __name__ == '__main__':
    main()
