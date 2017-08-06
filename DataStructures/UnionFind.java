
public class UnionFind {

    private interface UnionFindDataStructure {

        public int find(int node);

        public void union(int a, int b);

        public boolean isConnected(int a, int b);

        public int groups();

    }

    private static class UnionFind1 implements UnionFindDataStructure {

        int[] parents, ranks;
        int groups;

        public UnionFind1(int numNodes) {

            parents = new int[numNodes];
            ranks = new int[numNodes];
            groups = numNodes;

            for (int i = 0; i < numNodes; i++) {

                parents[i] = i;

            }

        }

        public int find(int node) {

            while (node != parents[node]) {

                node = parents[node];

            }

            return node;

        }

        public void union(int a, int b) {

            int aGroup = find(a), bGroup = find(b);

            if (aGroup != bGroup) {

                if (ranks[aGroup] > ranks[bGroup]) {

                    parents[bGroup] = aGroup;

                } else if (ranks[bGroup] > ranks[aGroup]) {

                    parents[aGroup] = bGroup;

                } else {

                    parents[bGroup] = aGroup;

                    ranks[aGroup]++;

                }

                groups--;

            }

        }

        public boolean isConnected(int a, int b) {

            return find(a) == find(b);

        }

        public int groups() {

            return groups;

        }

    }

    public static void main(String[] args) {

        UnionFindDataStructure[] unionFindClasses = new UnionFindDataStructure[]{new UnionFind1(10)};

        for (UnionFindDataStructure uf : unionFindClasses) {

            System.out.println(uf.groups());

            uf.union(0, 1);
            uf.union(2, 3);
            uf.union(4, 5);

            System.out.println(uf.isConnected(0, 3));

            uf.union(1, 2);

            System.out.println(uf.isConnected(0, 3));

            System.out.println(uf.isConnected(0, 2));

            System.out.println(uf.isConnected(2, 5));

            System.out.println(uf.groups());

            System.out.println("------");

        }

    }

}
