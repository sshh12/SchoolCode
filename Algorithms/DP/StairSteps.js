"use strict";

let countWays = (steps) => {

    if (steps <= 1) {

        return steps;

    } else {

        let sum = 0;

        for (let i = 1; i <= Math.min(steps, 3); i++) {

            sum += countWays(steps - i);

        }

        return sum;

    }

}

let countWays2 = (steps) => {

    if (steps == 1) {

        return 1;

    } else {

        let db = [0, 1, 2, 4];
        while (db.push(0) < steps + 1);

        for (let i = 4; i <= steps; i++) {

            db[i] = db[i - 1] + db[i - 2] + db[i - 3];

        }

        return db[steps];

    }

}

console.log(countWays(22 + 1));

console.log("------");

console.log(countWays2(22));
