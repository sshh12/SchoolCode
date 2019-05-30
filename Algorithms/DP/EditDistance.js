"use strict";

let make2DArray = (rows, cols = row, fill = 0) => {
    var array = [], row = [];
    while (cols--) row.push(fill);
    while (rows--) array.push(row.slice());
    return array;
}

let getEditDistance = (a, b, indexA = a.length, indexB = b.length) => {
    if (indexA == 0) {
        return indexB;
    } else if (indexB == 0) {
        return indexA;
    } else if (a[indexA - 1] === b[indexB - 1]) {
        return getEditDistance(a, b, indexA - 1, indexB - 1);
    } else {
        return 1 + Math.min(getEditDistance(a, b, indexA - 1, indexB),
                            getEditDistance(a, b, indexA, indexB - 1),
                            getEditDistance(a, b, indexA - 1, indexB - 1));
    }
}

let getEditDistance2 = (a, b) => {

    let alen = a.length,
        blen = b.length;

    let db = make2DArray(alen + 1, blen + 1);

    for (let i = 0; i <= alen; i++) {
        for (let j = 0; j <= blen; j++) {
            if (i == 0) {
                db[i][j] = j;
            } else if (j == 0) {
                db[i][j] = i;
            } else if (a[i - 1] === (b[j - 1])) {
                db[i][j] = db[i - 1][j - 1];
            } else {
                db[i][j] = 1 + Math.min(db[i - 1][j],
                                        db[i][j - 1],
                                        db[i - 1][j - 1]);
            }
        }
    }

    return db[alen][blen];

}

let a = "i like pie".split(" ");
let b = "he like much potato".split(" ");

console.log(getEditDistance(a, b));

console.log("------");

console.log(getEditDistance2(a, b));
