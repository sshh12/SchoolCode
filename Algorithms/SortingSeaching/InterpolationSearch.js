"use strict";

let interpolationSearch = (nums, x) => {

    let bottom = 0,
        top = nums.length - 1;

    while (bottom <= top && x >= nums[bottom] && x <= nums[top]) {

        let position = Math.floor(bottom + (top - bottom) / (nums[top] - nums[bottom])) * (x - nums[bottom]);

        if (nums[position] == x) {

            return position;

        } else if (nums[position] < x) {

            bottom = position + 1;

        } else {

            top = position - 1;

        }

    }

    return -1;

}

let nums = [2, 15, 28, 34, 44, 51, 67, 79, 87, 93, 10];

nums.sort((a, b) => a - b);

console.log(nums)

console.log(interpolationSearch(nums, 15));
