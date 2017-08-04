"use strict";

class HashSet1 {

    constructor(numBuckets = 10) {

        this.buckets = [];
        while (this.buckets.push([]) < numBuckets);

    }

    _hash(item) {

        return item % this.buckets.length;

    }

    add(item) {

        let index = this._hash(item);

        if (!this.buckets[index].includes(item)) {

            this.buckets[index].push(item);

        }

    }

    has(item) {

        let index = this._hash(item);

        return this.buckets[index].includes(item);

    }

    remove(item) {

        let index = this._hash(item);

        this.buckets[index].splice(this.buckets[index].indexOf(item), 1);

    }

}

class HashSet2 {

    constructor(buckets = 10) {

        this.hashTable = {}; // Object pairs are implemented as a hash table

    }

    add(item) {

        this.hashTable[item] = true;

    }

    has(item) {

        return this.hashTable[item] || false;

    }

    remove(item) {

        this.hashTable[item] = false;

    }

}

for (let hashSetClass of [HashSet1, HashSet2]) {

    let hashSet = new hashSetClass();

    hashSet.add(1);
    hashSet.add(2);
    hashSet.add(1);

    console.log(hashSet.has(1));

    hashSet.remove(1);

    console.log(hashSet.has(1));

    console.log(hashSet.has(2));

    console.log("------");

}
