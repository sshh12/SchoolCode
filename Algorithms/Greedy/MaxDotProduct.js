"use strict";

let getMaxDotProduct = (a, b) => {

    let numSort = (num1, num2) => num1 - num2;

    a.sort(numSort);
    b.sort(numSort);

    let sum = 0;

    for (let i in a) {

        sum += a[i] * b[i];

    }

    return sum;

}

let a = [1, 3, -5];

let b = [-2, 4, 1];

console.log(getMaxDotProduct(a, b));
