"use strict";

String.prototype.hashCode = function() { // https://stackoverflow.com/questions/7616461/generate-a-hash-from-string-in-javascript-jquery
    var hash = 0,
        i, chr;
    if (this.length === 0) return hash;
    for (i = 0; i < this.length; i++) {
        chr = this.charCodeAt(i);
        hash = ((hash << 5) - hash) + chr;
        hash |= 0; // Convert to 32bit integer
    }
    return hash;
};

class BloomFilter {

    constructor(size = 10) {

        this.store = [];
        while (this.store.push(false) < size);

    }

    getHashes(item) {

        let hashes = [
            item.hashCode(),
            (item + "").hashCode(),
            (item + "!").hashCode()
        ];

        return hashes;

    }

    add(item) {

        for (let hash of this.getHashes(item)) {

            let index = hash % this.store.length;

            this.store[index] = true;

        }

    }

    mightContain(item) {

        for (let hash of this.getHashes(item)) {

            let index = hash % this.store.length;

            if (!this.store[index]) {
                return false;
            }

        }

        return true;

    }

}

for (let bloomClass of [BloomFilter]) {

    let bloom = new bloomClass();

    bloom.add("A");
    bloom.add("B");
    bloom.add("C");

    console.log(bloom.mightContain("A"));
    console.log(bloom.mightContain("Z"));

    console.log("------");

}
