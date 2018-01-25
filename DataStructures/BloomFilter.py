
class BloomFilter(object):

    def __init__(self, size=10):

        self.store = [False] * size

    def get_hashes(self, item):

        hashes = [
            hash(item),
            hash(item + " "),
            hash(item + "!")
        ]

        return hashes

    def add(self, item):

        for hash_ in self.get_hashes(item):

            index = hash_ % len(self.store)

            self.store[index] = True

    def might_contain(self, item):

        for hash_ in self.get_hashes(item):

            index = hash_ % len(self.store)

            if not self.store[index]:
                return False

        return True

def main():

    for bloom_class in [BloomFilter]:

        bloom = bloom_class()

        bloom.add("A")
        bloom.add("B")
        bloom.add("C")

        print(bloom.might_contain("A"))
        print(bloom.might_contain("Z"))

        print("------")

if __name__ == '__main__':
    main()
