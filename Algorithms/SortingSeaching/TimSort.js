"use strict";

const RUN = 4;

let insertionSort = (nums, leftIndex, rightIndex) => {

    for (let i = leftIndex + 1; i <= rightIndex; i++) {

        let n = nums[i],
            j = i - 1;

        while (j >= leftIndex && nums[j] > n) {

            nums[j + 1] = nums[j];

            j--;

        }

        nums[j + 1] = n;

    }

}

let merge = (nums, leftIndex, middleIndex, rightIndex) => {

    let leftSize = middleIndex - leftIndex + 1,
        rightSize = rightIndex - middleIndex;

    let leftElements = nums.slice(leftIndex, leftIndex + leftSize),
        rightElements = nums.slice(middleIndex + 1, middleIndex + rightSize + 1);

    let left = 0,
        right = 0,
        index = leftIndex;

    while (left < leftSize && right < rightSize) {

        if (leftElements[left] <= rightElements[right]) {

            nums[index++] = leftElements[left++];

        } else {

            nums[index++] = rightElements[right++];

        }

    }

    while (left < leftSize) {

        nums[index++] = leftElements[left++];

    }

    while (right < rightSize) {

        nums[index++] = rightElements[right++];

    }

}

let timSort = (nums) => {

    const n = nums.length;

    for (let i = 0; i < n; i += RUN) {

        insertionSort(nums, i, Math.min(i + RUN - 1, n - 1));

    }

    for (let size = RUN; size < n; size *= 2) {

        for (let leftIndex = 0; leftIndex < n; leftIndex += size * 2) {

            let rightIndex = Math.min(leftIndex + 2 * size - 1, n - 1),
                middleIndex = Math.min(leftIndex + size - 1, rightIndex);

            merge(nums, leftIndex, middleIndex, rightIndex);

        }

    }

}

let nums = [1, 3, 88, 12, 3432, 32, 10, 5, 99, 111, 85, 939, 4, 0, 8, 101];

console.log(nums);

timSort(nums);

console.log(nums);
