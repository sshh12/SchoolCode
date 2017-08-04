"use strict";

class Set1 {

    constructor() {

        this.items = [];

    }

    add(item) {

        if (!this.items.includes(item)) {

            this.items.push(item);

        }

    }

    has(item) {

        return this.items.includes(item);

    }

    remove(item) {

        this.items.splice(this.items.indexOf(item), 1);

    }

}

class Set2 {

    constructor() {

        this.items = new Set();

    }

    add(item) {

        this.items.add(item);

    }

    has(item) {

        return this.items.has(item);

    }

    remove(item) {

        this.items.delete(item);

    }

}

for (let setClass of [Set1, Set2]) {

    let set = new setClass();

    set.add(1);
    set.add(2);
    set.add(1);

    console.log(set.has(1));

    set.remove(1);

    console.log(set.has(1));

    console.log(set.has(2));

    console.log("------");

}
