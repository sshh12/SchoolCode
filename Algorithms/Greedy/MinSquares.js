"use strict";

let getMinSquares = (length, width) => {

    let result = 0;

    let largeSide = Math.max(length, width),
        smallSide = Math.min(length, width);

    while (smallSide > 0) {

        result += Math.floor(largeSide / smallSide);

        let temp = largeSide % smallSide;

        largeSide = smallSide;
        smallSide = temp;

    }

    return result;

}

console.log(getMinSquares(13, 29));
