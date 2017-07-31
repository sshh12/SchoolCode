from collections import deque

class Queue(object):

    def __init__(self):

        self.items = []

    def add(self, item):

        self.items.append(item)

    def remove(self):

        return self.items.pop(0)

class Queue2(object):

    def __init__(self):

        self.q = deque()

    def add(self, item):

        self.q.append(item)

    def remove(self):

        return self.q.popleft()

def main():

    for q_class in [Queue, Queue2]:

        queue = q_class()

        queue.add(1)
        queue.add(2)

        print(queue.remove())

        queue.add(3)

        print(queue.remove())

        print("------")

if __name__ == '__main__':
    main()
