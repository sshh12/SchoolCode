
class Node:

    def __init__(self, point, left=None, right=None):

        self.point = point
        self.left = left
        self.right = right

class KDTree1:

    def __init__(self, kdims):

        self.k = kdims
        self.root = None

    def add(self, point, node=None, depth=-1):

        if depth == -1:
            self.root = self.add(point, self.root, 0)
            return self.root

        if not node:
            return Node(point)

        dim = depth % self.k

        if point[dim] < node.point[dim]:
            node.left = self.add(point, node.left, depth + 1)
        else:
            node.right = self.add(point, node.right, depth + 1)

        return node

    def __contains__(self, point, node=None, depth=-1):

        if depth == -1:
            return self.__contains__(point, self.root, 0)

        if not node:
            return False
        elif point == node.point:
            return True

        dim = depth % self.k

        if point[dim] < node.point[dim]:
            return self.__contains__(point, node.left, depth + 1)
        else:
            return self.__contains__(point, node.right, depth + 1)


def main():

    for kdtree_class in [KDTree1]:

        kdtree = kdtree_class(2)

        kdtree.add( (1, 2) )
        kdtree.add( (3, 4) )
        kdtree.add( (5, 6) )
        kdtree.add( (-1, 1) )
        kdtree.add( (10, -10) )
        kdtree.add( (2, 2) )
        kdtree.add( (5, 5) )

        print((-1, 1) in kdtree)
        print((10, 10) in kdtree)

        print("------")

if __name__ == '__main__':
    main()
