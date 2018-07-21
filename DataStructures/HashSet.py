
class HashSet1:

    def __init__(self, num_buckets=10):

        self.buckets = [ None ] * num_buckets

    def _hash(self, item):

        return item % len(self.buckets)

    def add(self, item):

        index = self._hash(item)

        if self.buckets[index] == None:

            self.buckets[index] = [item]

        elif item not in self.buckets[index]:

            self.buckets[index].append(item)

    def remove(self, item):

        index = self._hash(item)

        self.buckets[index].remove(item)

    def __contains__(self, item):

        index = self._hash(item)

        return item in self.buckets[index]

class HashSet2:

    def __init__(self):

        self.hashset = set() # set() is O(1)

    def add(self, item):

        self.hashset.add(item)

    def remove(self, item):

        self.hashset.discard(item)

    def __contains__(self, item):

        return item in self.hashset

def main():

    for hashset_class in [HashSet1, HashSet2]:

        hashset = hashset_class()

        hashset.add(1)
        hashset.add(2)
        hashset.add(1)

        print(1 in hashset)

        hashset.remove(1)

        print(1 in hashset)

        print(2 in hashset)

        print("------")

if __name__ == '__main__':
    main()
