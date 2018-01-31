"use strict";

let merge = (nums, index, length, increasing) => {

  if (length > 1) {

    let half = Math.floor(length / 2);

    for (let i = index; i < index + half; i++) {

      if ((nums[i] > nums[i + half] && increasing) ||
          (nums[i] < nums[i + half] && !increasing)) {

        [nums[i], nums[i + half]] = [nums[i + half], nums[i]];

      }

    }

    merge(nums, index, half, increasing);
    merge(nums, index + half, half, increasing);

  }

}

let bitonicSort = (nums, index = 0, length = nums.length, increasing = true) => {

  if (length > 1) {

    let half = Math.floor(length / 2);

    bitonicSort(nums, index, half, true);
    bitonicSort(nums, index + half, half, false);

    merge(nums, index, length, increasing);

  }

}

let nums = [1, 5, 77, 34, 2, 18, 19, 20, 21, 10, 43, 99, 101, 77, 75, 71]; // Must be pow of 2

console.log(nums);

bitonicSort(nums);

console.log(nums);
