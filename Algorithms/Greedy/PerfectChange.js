"use strict";

let getNumCoins = (values, amt) => {

    let coins = 0;

    for (let v of values) {

        while (amt >= v) {

            amt -= v;
            coins++;

        }

    }

    return coins;

}

let values = [10, 5, 1];

console.log(getNumCoins(values, 28));
