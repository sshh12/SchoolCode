
class Set(object):

    def __init__(self):

        self.items = []

    def add(self, item):

        if not item in self.items:

            self.items.append(item)

    def has(self, item):

        return item in self.items

    def remove(self, item):

        self.items.remove(item)

class Set2(object):

    def __init__(self):

        self.items = set()

    def add(self, item):

        self.items.add(item)

    def has(self, item):

        return item in self.items

    def remove(self, item):

        self.items.discard(item)

def main():

    for set_class in [Set, Set2]:

        set_ = set_class()

        set_.add(1)
        set_.add(2)
        set_.add(1)

        print(set_.has(1))

        set_.remove(1)

        print(set_.has(1))

        print(set_.has(2))

        print("------")

if __name__ == '__main__':
    main()
