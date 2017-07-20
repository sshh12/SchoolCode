"use strict";

let getSmallestNum = (digitSum, ndigits) => {

    if (digitSum <= 0 || digitSum > 9 * ndigits) {
        return -1;
    }

    let result = new Array(ndigits);

    digitSum -= 1;

    for (let i = ndigits - 1; i > 0; i--) {

        if (digitSum > 9) {

            result[i] = 9;
            digitSum -= 9;

        } else {

            result[i] = digitSum;
            digitSum = 0;

        }

    }

    result[0] = digitSum + 1;

    let n = 0;

    for (let i = ndigits - 1, pow = 1; i >= 0; i--, pow *= 10) {

        n += pow * result[i];

    }

    return n;

}

console.log(getSmallestNum(10, 3));
