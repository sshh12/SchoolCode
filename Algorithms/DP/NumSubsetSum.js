"use strict";

let countSubsetSums = (nums, sum, index = nums.length - 1) => {

    if (sum == 0) {

        return 1;

    } else if (index < 0 && sum != 0) {

        return 0;

    } else if (nums[index] > sum) {

        return countSubsetSums(nums, sum, index - 1);

    } else {

        return countSubsetSums(nums, sum, index - 1) +
               countSubsetSums(nums, sum - nums[index], index - 1);

    }

}

let countSubsetSums2 = (nums, sum) => {

    let db = [1];
    while (db.push(0) < sum + 1);

    for (let n of nums) {

        for (let i = sum - n; i >= 0; i--) {

            if (db[i]) {

                db[i + n] += db[i];

            }

        }

    }

    return db[sum];

}

let nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

console.log(countSubsetSums(nums, 17));

console.log("------")

console.log(countSubsetSums2(nums, 17));
