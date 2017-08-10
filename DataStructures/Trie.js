"use strict";

class Trie1 {

    constructor() {

        this.root = {
            children: []
        };

    }

    _get_index(char) {

        return char.charCodeAt(0) - 97;

    }

    add(item) {

        let node = this.root;

        for (let i in item) {

            let index = this._get_index(item[i]);

            if (typeof node.children[index] == 'undefined') {

                node.children[index] = {
                    children: [],
                    isEnd: false
                };

            }

            node = node.children[index];

        }

        node.isEnd = true;

    }

    has(item) {

        let node = this.root;

        for (let i in item) {

            let index = this._get_index(item[i]);

            if (typeof node.children[index] == 'undefined') {

                return false;

            }

            node = node.children[index];

        }

        return (node && node.isEnd);

    }

}

for (let trieClass of [Trie1]) {

    let trie = new trieClass();

    trie.add("the");
    trie.add("a");
    trie.add("there");
    trie.add("any");
    trie.add("by");
    trie.add("bye");
    trie.add("answer");

    console.log(trie.has("the"));
    console.log(trie.has("bye"));
    console.log(trie.has("t"));
    console.log(trie.has("these"));
    console.log(trie.has("ant"));

    trie.add("ant");

    console.log(trie.has("ant"));

    console.log("------");

}
