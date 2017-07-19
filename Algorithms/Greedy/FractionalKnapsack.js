"use strict";

class Item {

    constructor(p, w) {

        this.price = p;
        this.weight = w;

    }

    get ratio() {

        return this.price / this.weight;

    }

}

let getMaxValue = (items, maxWeight) => {

    items.sort((a, b) => b.ratio - a.ratio);

    let currentWeight = 0,
        currentValue = 0;

    for (let item of items) {

        if (currentWeight + item.weight <= maxWeight) {

            currentWeight += item.weight;
            currentValue += item.price;

        } else {

            let remaining = maxWeight - currentWeight;

            currentValue += remaining * item.ratio;

            break;

        }

    }

    return currentValue;

}

let items = [
    new Item(60, 10),
    new Item(100, 20),
    new Item(20, 50),
    new Item(120, 30),
    new Item(10, 2)
];

console.log(getMaxValue(items, 75));
