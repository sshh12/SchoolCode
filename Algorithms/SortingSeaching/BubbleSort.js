"use strict";

let bubbleSort = (nums) => {

    let n = nums.length;

    for (let i = 0; i < n - 1; i++) {

        for (let j = 0; j < n - i - 1; j++) {

            if (nums[j] > nums[j + 1]) {

                [nums[j], nums[j + 1]] = [nums[j + 1], nums[j]];

            }

        }

    }

}

let nums = [1, 43, 12, 3, 4, 99, 65, 66, 32, 8];

console.log(nums);

bubbleSort(nums);

console.log(nums);
