"use strict";

let getUniqueSummands = (num) => {

    let summands = [];

    if (num <= 2) {

        summands.push(num);

    } else {

        let k = 1;

        while (num > 2 * k) {

            num -= k;

            summands.push(k);

            k += 1;

        }

        summands.push(num);

    }

    return summands;

}

for (let n of getUniqueSummands(8)) {

    console.log(n);

}
