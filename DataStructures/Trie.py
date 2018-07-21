
class Node:

    def __init__(self):

        self.children = [ None ] * 26
        self.is_end = False

class Trie1:

    def __init__(self):

        self.root = Node()

    def _get_index(self, char):

        return ord(char) - 97 # ord('a')

    def add(self, item):

        node = self.root

        for i, char in enumerate(item):

            index = self._get_index(char)

            if not node.children[index]:

                node.children[index] = Node()

            node = node.children[index]

        node.is_end = True

    def remove(self, item, node=None, depth=None):

        if not node and not depth:

            self.remove(item, self.root, 0)

        elif node:

            if depth == len(item):

                node.is_end = False

                return not any(node.children)

            else:

                index = self._get_index(item[depth])

                if self.remove(item, node.children[index], depth + 1):

                    node.children[index] = None

                    return (not node.is_end and not any(node.children))

        return False

    def __contains__(self, item):

        node = self.root

        for i, char in enumerate(item):

            index = self._get_index(char)

            if not node.children[index]:

                return False

            node = node.children[index]

        return (node and node.is_end)

def main():

    for trie_class in [Trie1]:

        trie = trie_class()

        trie.add("the")
        trie.add("a")
        trie.add("there")
        trie.add("any")
        trie.add("by")
        trie.add("bye")

        print("the" in trie)
        print("bye" in trie)
        print("t" in trie)
        print("these" in trie)
        print("ant" in trie)

        trie.add("ant")
        trie.remove("bye")

        print("ant" in trie)
        print("bye" in trie)

        print("------")

if __name__ == '__main__':
    main()
