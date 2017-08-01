from collections import deque

class Stack(object):

    def __init__(self):

        self.items = []

    def add(self, item):

        self.items.append(item)

    def pop(self):

        return self.items.pop()

class Stack2(object):

    def __init__(self):

        self.q = deque()

    def add(self, item):

        self.q.append(item)

    def pop(self):

        return self.q.pop()

def main():

    for stack_class in [Stack, Stack2]:

        stack = stack_class()

        stack.add(1)
        stack.add(2)

        print(stack.pop())

        stack.add(3)

        print(stack.pop())

        print("------")

if __name__ == '__main__':
    main()
