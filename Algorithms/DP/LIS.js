"use strict";

let bestOverall = 1;

let recurLIS = (nums, index = nums.length - 1) => {

    if (index == 0) {

        return 1;

    } else {

        let best = 1;

        for (let i = 0; i < index; i++) {

            let subLength = recurLIS(nums, i);

            if (nums[i] < nums[index] && subLength + 1 > best) {

                best = subLength + 1;

            }

        }

        bestOverall = Math.max(bestOverall, best);

        return best;

    }

}

let getLengthLIS = (nums) => {

    bestOverall = 1;

    recurLIS(nums);

    return bestOverall;

}

let getLengthLIS2 = (nums) => {

    let n = nums.length, best = 0;

    let db = [];
    while (db.push(1) < n);

    for (let i = 1; i < n; i++) {

        for (let j = 0; j < i; j++) {

            if (nums[i] > nums[j] & db[j] + 1 > db[i]) {

                db[i] = db[j] + 1;

            }

        }

    }

    return Math.max(...db);

}

let nums = [10, 22, 9, 33, 21, 50, 41, 60];

console.log(getLengthLIS(nums));

console.log("------")

console.log(getLengthLIS2(nums));
