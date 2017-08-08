
class Node(object):

    def __init__(self, data, left=None, right=None):

        self.data = data
        self.left = left
        self.right = right

class BinaryTree1(object):

    def __init__(self):

        self.root = None

    def add(self, item, node=None):

        if not node:

            if not self.root:

                self.root = Node(item)

                return

            node = self.root

        if item < node.data:

            if node.left:

                self.add(item, node.left)

            else:

                node.left = Node(item)

        else:

            if node.right:

                self.add(item, node.right)

            else:

                node.right = Node(item)

    def remove(self, item):

        self.root = self._delete_item(self.root, item)

    def _min_item(self, node):

        while node.left:

            node = node.left

        return node

    def _delete_item(self, node, item):

        if node:

            if item < node.data:

                node.left = self._delete_item(node.left, item)

            elif item > node.data:

                node.right = self._delete_item(node.right, item)

            else:

                if not node.left:

                    return node.right

                elif not node.right:

                    return node.left

                else:

                    min_node = self._min_item(node.right)

                    node.data = min_node.data

                    node.right = self._delete_item(node.right, min_node.data)

        return node

    def get_preorder(self, node=None, items=None):

        if not node:

            node, items = self.root, []

            if not self.root:

                return items

        items.append(node.data)

        if node.left:

            self.get_inorder(node.left, items)

        if node.right:

            self.get_inorder(node.right, items)

        return items

    def get_inorder(self, node=None, items=None):

        if not node:

            node, items = self.root, []

            if not self.root:

                return items

        if node.left:

            self.get_inorder(node.left, items)

        items.append(node.data)

        if node.right:

            self.get_inorder(node.right, items)

        return items

    def get_postorder(self, node=None, items=None):

        if not node:

            node, items = self.root, []

            if not self.root:

                return items

        if node.left:

            self.get_inorder(node.left, items)

        if node.right:

            self.get_inorder(node.right, items)

        items.append(node.data)

        return items

    def __contains__(self, item, node=None):

        if not node:

            if self.root == None:

                return False

            node = self.root

        if item == node.data:

            return True

        elif node.left and item < node.data:

            return self.__contains__(item, node.left)

        else:

            return self.__contains__(item, node.right)


def main():

    for bintree_class in [BinaryTree1]:

        bintree = bintree_class()

        bintree.add(1)
        bintree.add(0)
        bintree.add(2)

        print(2 in bintree);
        print(bintree.get_inorder())
        print(bintree.get_preorder())
        print(bintree.get_postorder())

        bintree.remove(1)

        bintree.add(3)
        bintree.add(-1)
        bintree.add(-3)
        bintree.add(-2)

        print(1 in bintree)
        print(bintree.get_inorder())

        print("------")

if __name__ == '__main__':
    main()
