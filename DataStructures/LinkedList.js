"use strict";

class Node {

    constructor(data, nextNode = null) {

        this.data = data;
        this.nextNode = nextNode;

    }

}

class LinkedList1 {

    constructor() {

        this.root = null;
        this.length = 0;

    }

    add(item) {

        if (!this.root) {

            this.root = new Node(item);

        } else {

            let node = this.root;

            while (node.nextNode) {

                node = node.nextNode;

            }

            node.nextNode = new Node(item);

        }

        this.length++;

    }

    addFront(item) {

        this.root = new Node(item, this.root);

        this.length++;

    }

    remove() {

        let node = this.root;

        if (node.nextNode) {

            while (node.nextNode.nextNode) {

                node = node.nextNode;

            }

            node.nextNode = null;


        } else {

            this.root = null;

        }

        this.length--;

    }

    removeFront() {

        this.root = this.root.nextNode;

        this.length--;

    }


    get(index) {

        let node = this.root;

        for (let i = 0; i < index; i++) {

            node = node.nextNode;

        }

        return node.data;

    }

    set(index, item) {

        let node = this.root;

        for (let i = 0; i < index; i++) {

            node = node.nextNode;

        }

        node.data = item;

    }

}

for (let linkedListClass of [LinkedList1]) {

    let linkedList = new linkedListClass();

    console.log(linkedList.length);

    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);

    console.log(linkedList.get(2));

    linkedList.set(1, 4);

    console.log(linkedList.get(1));

    console.log(linkedList.get(0));

    linkedList.removeFront();

    linkedList.add(5);

    linkedList.remove();

    console.log(linkedList.get(0));

    linkedList.addFront(6);

    console.log(linkedList.get(0));

    console.log(linkedList.get(1));

    linkedList.add(7);
    linkedList.add(8);

    console.log(linkedList.length);

    console.log("------");

}
