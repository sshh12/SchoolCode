
class UnionFind1:

    def __init__(self, num_nodes):

        self.parents = [ i for i in range(num_nodes) ]
        self.ranks = [ 0 ] * num_nodes
        self.groups = num_nodes

    def find(self, node):

        while node != self.parents[node]:

            node = self.parents[node]

        return node

    def union(self, a, b):

        a_group, b_group = self.find(a), self.find(b)

        if a_group != b_group:

            if self.ranks[a_group] > self.ranks[b_group]:

                self.parents[b_group] = a_group

            elif self.ranks[b_group] > self.ranks[a]:

                self.parents[a_group] = b_group

            else:

                self.parents[b_group] = a_group

                self.ranks[a_group] += 1

            self.groups -= 1

    def is_connected(self, a, b):

        return self.find(a) == self.find(b)

def main():

    for unionfind_class in [UnionFind1]:

        uf = unionfind_class(10)

        print(uf.groups)

        uf.union(0, 1)
        uf.union(2, 3)
        uf.union(4, 5)

        print(uf.is_connected(0, 3))

        uf.union(1, 2)

        print(uf.is_connected(0, 3))

        print(uf.is_connected(0, 2))

        print(uf.is_connected(2, 5))

        print(uf.groups)

        print("------")

if __name__ == '__main__':
    main()
