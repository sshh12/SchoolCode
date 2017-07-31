"use strict";

class Queue {

    constructor() {

        this.items = [];

    }

    add(item) {

        this.items.push(item);

    }

    remove() {

        return this.items.shift();

    }

}

for (let qClass of [Queue]) {

    let queue = new qClass();

    queue.add(1);
    queue.add(2);

    console.log(queue.remove());

    queue.add(3);

    console.log(queue.remove());

    console.log("------");

}
