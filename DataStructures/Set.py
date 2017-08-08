
class Set1(object):

    def __init__(self):

        self.items = []

    def add(self, item):

        if not item in self.items:

            self.items.append(item)

    def remove(self, item):

        self.items.remove(item)

    def __contains__(self, item):

        return item in self.items

class Set2(object):

    def __init__(self):

        self.items = set()

    def add(self, item):

        self.items.add(item)

    def remove(self, item):

        self.items.discard(item)

    def __contains__(self, item):

        return item in self.items

def main():

    for set_class in [Set1, Set2]:

        set_ = set_class()

        set_.add(1)
        set_.add(2)
        set_.add(1)

        print(1 in set_)

        set_.remove(1)

        print(1 in set_)

        print(2 in set_)

        print("------")

if __name__ == '__main__':
    main()
