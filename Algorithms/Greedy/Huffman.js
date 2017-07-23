"use strict";

class Heap { // Insert Actual Heap Here...

    constructor() {

        this.items = [];
        this.nodeSort = (a, b) => a.freq - b.freq;

    }

    push(item) {

        this.items.push(item);
        this.items.sort(this.nodeSort);

    }

    remove() {

        return this.items.shift();

    }

    get size() {

        return this.items.length;

    }

}

class Node {

    constructor(ch, f) {

        this.value = ch;
        this.freq = f;
        this.left = null;
        this.right = null;

    }

}

let getFreqMap = (msg) => {

    let map = {};

    for (let c of msg) {

        if (c in map) {

            map[c]++;

        } else {

            map[c] = 1;

        }

    }

    return map;

}

let addCodes = (node, codes, prefix) => {

    if (node != null) {

        if (node.value != '*') {

            codes[node.value] = prefix;

        }

        addCodes(node.left, codes, prefix + "0");
        addCodes(node.right, codes, prefix + "1");

    }

}

let getHuffmanCodes = (msg) => {

    let freqs = getFreqMap(msg);

    let heap = new Heap();

    for (let c in freqs) {

        heap.push(new Node(c, freqs[c]));

    }

    while (heap.size > 1) {

        let left = heap.remove(),
            right = heap.remove();

        let combined = new Node('*', left.freq + right.freq);

        combined.left = left;
        combined.right = right;

        heap.push(combined);

    }

    let codes = {};

    addCodes(heap.remove(), codes, "");

    return codes;

}

let encode = (msg, codes) => {

    let compressed = "";

    for (let c of msg) {

        compressed += codes[c];

    }

    return compressed;

}

let msg = "This is a test of huffman encoding............";

console.log(msg);

let codes = getHuffmanCodes(msg);

for (let c in codes) {

    console.log(`${c} ${codes[c]}`);

}

console.log(encode(msg, codes));
