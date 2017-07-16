"use strict";

let selectionSort = (nums) => {

    for (let i in nums) {

        let minIndex = i;

        for (let j = i; j < nums.length; j++) {

            if (nums[j] < nums[minIndex]) {

                minIndex = j;

            }

        }

        [nums[i], nums[minIndex]] = [nums[minIndex], nums[i]]

    }

}

let nums = [12, 45, 1, 76, 23, 25, 33, 99, 65, 46];

console.log(nums);

selectionSort(nums);

console.log(nums);
