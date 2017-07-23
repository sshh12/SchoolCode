"use strict";

class Item {

    constructor(v, w) {

        this.value = v;
        this.weight = w;

    }

}

let make2DArray = (rows, cols = row, fill = 0) => {

    var array = [], row = [];
    while (cols--) row.push(fill);
    while (rows--) array.push(row.slice());
    return array;

}

let getMaxValue = (capacity, items, n = items.length) => {

    if (capacity == 0 || n == 0) {

        return 0;

    } else if (items[n - 1].weight > capacity) {

        return getMaxValue(capacity, items, n - 1);

    } else {

        return Math.max(items[n - 1].value + getMaxValue(capacity - items[n - 1].weight, items, n - 1),
                                             getMaxValue(capacity, items, n - 1));

    }

}

let getMaxValue2 = (capacity, items) => {

    let n = items.length;

    let db = make2DArray(n + 1, capacity);

    for (let i = 0; i <= n; i++) {

        for (let weight = 0; weight <= capacity; weight++) {

            if (i == 0 || weight == 0) {

                db[i][weight] = 0;

            } else if (items[i - 1].weight <= weight) {

                db[i][weight] = Math.max(items[i - 1].value + db[i - 1][weight - items[i - 1].weight],
                                                              db[i - 1][weight]);

            } else {

                db[i][weight] = db[i - 1][weight];

            }

        }

    }

    return db[n][capacity];

}

let items = [
    new Item(60, 10),
    new Item(100, 20),
    new Item(120, 30)
];

console.log(getMaxValue(50, items));

console.log("------");

console.log(getMaxValue2(50, items));
