from collections import deque

class Node(object):

    def __init__(self, data, next_node=None):

        self.data = data
        self.next_node = next_node

class LinkedList1(object):

    def __init__(self):

        self.root = None
        self.length = 0

    def add(self, item):

        if not self.root:

            self.root = Node(item)

        else:

            node = self.root

            while node.next_node:

                node = node.next_node

            node.next_node = Node(item)

        self.length += 1

    def add_front(self, item):

        self.root = Node(item, self.root)

        self.length += 1

    def remove(self):

        node = self.root

        if node.next_node:

            while node.next_node.next_node:

                node = node.next_node

            node.next_node = None

        else:

            self.root = None

        self.length -= 1

    def remove_front(self):

        self.root = self.root.next_node

        self.length -= 1

    def __getitem__(self, index):

        node = self.root

        for i in range(index):

            node = node.next_node

        return node.data

    def __setitem__(self, index, item):

        node = self.root

        for i in range(index):

            node = node.next_node

        node.data = item

    def __len__(self):

        return self.length



class LinkedList2(object):

    def __init__(self):

        self.linkedlist = deque()

    def add(self, item):

        self.linkedlist.append(item)

    def add_front(self, item):

        self.linkedlist.appendleft(item)

    def remove(self):

        self.linkedlist.pop()

    def remove_front(self):

        self.linkedlist.popleft()

    def __getitem__(self, index):

        return self.linkedlist[index]

    def __setitem__(self, index, item):

        self.linkedlist[index] = item

    def __len__(self):

        return len(self.linkedlist)

def main():

    for linkedlist_class in [LinkedList1, LinkedList2]:

        linkedlist = linkedlist_class()

        print(len(linkedlist))

        linkedlist.add(1)
        linkedlist.add(2)
        linkedlist.add(3)

        print(linkedlist[2])

        linkedlist[1] = 4

        print(linkedlist[1])

        print(linkedlist[0])

        linkedlist.remove_front()

        linkedlist.add(5)

        linkedlist.remove()

        print(linkedlist[0])

        linkedlist.add_front(6)

        print(linkedlist[0])

        print(linkedlist[1])

        linkedlist.add(7)
        linkedlist.add(8)

        print(len(linkedlist))

        print("------")

if __name__ == '__main__':
    main()
