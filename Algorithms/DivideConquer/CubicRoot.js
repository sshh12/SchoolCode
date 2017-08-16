"use strict";

let calcError = (n, guess) => {

    return guess ** 3 - n;

}

let cubicRoot = (n, prec = 1e-7) => {

    let start = 0,
        end = n;

    while (true) {

        let guess = (start + end) / 2,
            error = calcError(n, guess);

        if (Math.abs(error) <= prec) {

            return guess;

        } else if (error > 0) {

            end = guess;

        } else {

            start = guess;

        }

    }

}

console.log(cubicRoot(3));
