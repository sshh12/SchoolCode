"use strict";

let partition = (nums, low, high) => {

    let pivot = nums[high],
        i = low - 1;

    for (let j = low; j < high; j++) {

        if (nums[j] <= pivot) {

            i++;

            [nums[j], nums[i]] = [nums[i], nums[j]];

        }

    }

    [nums[i + 1], nums[high]] = [nums[high], nums[i + 1]]

    return i + 1;

}

let quickSort = (nums, low = 0, high = nums.length - 1) => {

    if (low < high) {

        let index = partition(nums, low, high);

        quickSort(nums, low, index - 1);
        quickSort(nums, index + 1, high);

    }

}

let nums = [1, 5, 2, 6, 10, 25, 15, 12, 8];

console.log(nums);

quickSort(nums);

console.log(nums);
