"use strict";

class Trie1 {

    constructor() {

        this.root = {
            children: []
        };

        this.noChild = child => typeof child == 'undefined';

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

    remove(item, node = this.root, depth = 0) {

        if (node) {

            if (depth == item.length) {

                node.isEnd = false;

                return node.children.every(this.noChild);

            } else {

                let index = this._get_index(item[depth]);

                if (this.remove(item, node.children[index], depth + 1)) {

                    delete node.children[index];

                    return (!node.isEnd && node.children.every(this.noChild));

                }

            }

        }

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

    console.log(trie.has("the"));
    console.log(trie.has("bye"));
    console.log(trie.has("t"));
    console.log(trie.has("these"));
    console.log(trie.has("ant"));

    trie.add("ant");
    trie.remove("bye");

    console.log(trie.has("ant"));
    console.log(trie.has("bye"));

    console.log("------");

}
