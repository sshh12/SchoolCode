"use strict";

let getNumCoins = (coins, balance, i = coins.length) => {

    if (balance == 0) {

        return 1;

    } else if ((balance < 0) || (i <= 0 && balance >= 1)) {

        return 0;

    }

    return getNumCoins(coins, balance, i - 1) +
           getNumCoins(coins, balance - coins[i - 1], i);

}

let getNumCoins2 = (coins, balance) => {

    let db = [1];
    while (db.push(0) < balance + 1);

    for (let k in coins) {

        for (let j = coins[k]; j <= balance; j++) {

            db[j] += db[j - coins[k]];

        }

    }

    return db[balance];

}

let coins = [1, 2, 8, 12];

console.log(getNumCoins(coins, 25));

console.log("------")

console.log(getNumCoins2(coins, 25));
