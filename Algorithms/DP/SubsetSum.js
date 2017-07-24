"use strict";

let make2DArray = (rows, cols = row, fill = 0) => {

    var array = [], row = [];
    while (cols--) row.push(fill);
    while (rows--) array.push(row.slice());
    return array;

}

let containsSumSubset = (nums, sum, index = nums.length - 1) => {

    if (sum == 0) {

        return true;

    } else if (index < 0 && sum != 0) {

        return false;

    } else if (nums[index] > sum) {

        return containsSumSubset(nums, sum, index - 1);

    } else {

        return containsSumSubset(nums, sum, index - 1) ||
               containsSumSubset(nums, sum - nums[index], index - 1);

    }

}

let containsSumSubset2 = (nums, sum) => {

    let db = make2DArray(sum + 1, nums.length + 1);

    for (let i in db[0]) {

        db[0][i] = true;

    }

    for (let i in db) {

        for (let j = 1; j <= nums.length; j++) {

            db[i][j] = db[i][j - 1];

            if (!db[i][j] && i >= nums[j - 1]) {

                db[i][j] = db[i - nums[j - 1]][j - 1];

            }

        }

    }

    return db[sum][nums.length];

}

let nums = [2, 5, 4, 10];

console.log(containsSumSubset(nums, 19));

console.log("------")

console.log(containsSumSubset2(nums, 19));
