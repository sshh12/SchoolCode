"use strict";

class UnionFind1 {

    constructor(numNodes) {

        this.parents = [];
        this.ranks = [];
        this.groups = numNodes;

        for (let i = 0; i < numNodes; i++) {

            this.parents.push(i);
            this.ranks.push(0);

        }

    }

    find(node) {

        while (node != this.parents[node]) {

            node = this.parents[node];

        }

        return node;

    }

    union(a, b) {

        let aGroup = this.find(a),
            bGroup = this.find(b);

        if (aGroup != bGroup) {

            if (this.ranks[aGroup] > this.ranks[bGroup]) {

                this.parents[bGroup] = aGroup;

            } else if (this.ranks[bGroup] > this.ranks[aGroup]) {

                this.parents[aGroup] = bGroup;

            } else {

                this.parents[bGroup] = aGroup;

                this.ranks[aGroup]++;

            }

            this.groups--;

        }

    }

    isConnected(a, b) {

        return this.find(a) == this.find(b);

    }

}

for (let unionFindClass of [UnionFind1]) {

    let uf = new unionFindClass(10);

    console.log(uf.groups);

    uf.union(0, 1);
    uf.union(2, 3);
    uf.union(4, 5);

    console.log(uf.isConnected(0, 3));

    uf.union(1, 2);

    console.log(uf.isConnected(0, 3));

    console.log(uf.isConnected(0, 2));

    console.log(uf.isConnected(2, 5));

    console.log(uf.groups);

    console.log("------");

}
