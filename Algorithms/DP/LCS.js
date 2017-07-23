"use strict";

let make2DArray = (rows, cols = row, fill = 0) => {

    var array = [], row = [];
    while (cols--) row.push(fill);
    while (rows--) array.push(row.slice());
    return array;

}

let getLengthLCS = (a, b, indexA = a.length - 1, indexB = b.length - 1) => {

    if (indexA < 0 || indexB < 0) {

        return 0;

    } else if (a[indexA] == b[indexB]) {

        return 1 + getLengthLCS(a, b, indexA - 1, indexB - 1);

    } else {

        return Math.max(
                getLengthLCS(a, b, indexA - 1, indexB),
                getLengthLCS(a, b, indexA, indexB - 1));

    }

}

let getLengthLCS2 = (a, b) => {

    let alen = a.length, blen = b.length;

    let db = make2DArray(alen + 1, blen + 1);

    for (let i = 0; i <= alen; i++) {

        for (let j = 0; j <= blen; j++) {

            if (i == 0 || j == 0) {

                db[i][j] == 0;

            } else if (a[i - 1] == b[j - 1]) {

                db[i][j] = 1 + db[i - 1][j - 1];

            } else {

                db[i][j] = Math.max(db[i - 1][j], db[i][j - 1]);

            }

        }

    }

    return db[alen][blen];

}

let a = "ilikepie", b = "helikepotato";

console.log(getLengthLCS(a, b));

console.log("------");

console.log(getLengthLCS(a, b));
