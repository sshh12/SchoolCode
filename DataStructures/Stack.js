"use strict";

class Stack {

    constructor() {

        this.items = [];

    }

    add(item) {

        this.items.push(item);

    }

    pop() {

        return this.items.pop();

    }

}

for (let stackClass of [Stack]) {

    let stack = new stackClass();

    stack.add(1);
    stack.add(2);

    console.log(stack.pop());

    stack.add(3);

    console.log(stack.pop());

    console.log("------");

}
