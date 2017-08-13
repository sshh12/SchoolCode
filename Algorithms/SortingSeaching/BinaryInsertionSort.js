"use strict";

let findIndex = (nums, value, leftIndex, rightIndex) => {

    if (rightIndex <= leftIndex) {

        return value > nums[leftIndex] ? leftIndex + 1 : leftIndex;

    }

    let middleIndex = Math.floor((leftIndex + rightIndex) / 2);

    if (value == nums[middleIndex]) {

        return middleIndex + 1;

    } else if (value > nums[middleIndex]) {

        return findIndex(nums, value, middleIndex + 1, rightIndex);

    } else {

        return findIndex(nums, value, leftIndex, middleIndex - 1);

    }

}

let binaryInsertionSort = (nums) => {

    for (let i in nums) {

        let n = nums[i],
            j = i - 1,
            correctIndex = findIndex(nums, n, 0, j);

        while (j >= correctIndex) {

            nums[j + 1] = nums[j];

            j--;

        }

        nums[j + 1] = n;

    }

}

let nums = [1, 2, 0, 8, 22, 189, 221, 10, 88, 67, 45, 34];

console.log(nums);

binaryInsertionSort(nums);

console.log(nums);
