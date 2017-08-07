"use strict";

let isSorted = (nums) => {

    for (let i = 1; i < nums.length; i++) {

        if (nums[i - 1] > nums[i]) {

            return false;

        }

    }

    return true;

}

let shuffle = (nums) => {

    for (let i = 0; i < nums.length; i++) {

        let randIndex = Math.floor(Math.random() * nums.length);

        [nums[i], nums[randIndex]] = [nums[randIndex], nums[i]];

    }

}

let bogoSort = (nums) => {

    while (!isSorted(nums)) {

        shuffle(nums);

    }

}

let nums = [7, 3, 1, 10, 5, 2, 9, 4, 6, 8];

console.log(nums);

bogoSort(nums);

console.log(nums);
