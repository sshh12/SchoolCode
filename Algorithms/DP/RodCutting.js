"use strict";

let getMaxPrice = (prices, index = prices.length - 1) => {

    if (index < 0) {

        return 0;

    }

    let max = 0;

    for (let i = 0; i <= index; i++) {

        max = Math.max(max, prices[i] + getMaxPrice(prices, index - i - 1));

    }

    return max;

}

let getMaxPrice2 = (prices) => {

    let db = [];
    while (db.push(0) < prices.length + 1);

    for (let i = 1; i <= prices.length; i++) {

        let max = 0;

        for (let j = 0; j < i; j++) {

            max = Math.max(max, prices[j] + db[i - j - 1]);

        }

        db[i] = max;

    }

    return db[prices.length];

}

let prices = [1, 5, 8, 9, 10, 17, 17, 20];

console.log(getMaxPrice(prices));

console.log("------");

console.log(getMaxPrice2(prices));
