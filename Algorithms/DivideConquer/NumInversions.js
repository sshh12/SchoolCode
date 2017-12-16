"use strict";

let merge = (nums, leftIndex, middleIndex, rightIndex) => {

    let inversions = 0;

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

            inversions += (leftSize - left);

        }

    }

    while (left < leftSize) {

        nums[index++] = leftElements[left++];

    }

    while (right < rightSize) {

        nums[index++] = rightElements[right++];

    }

    return inversions;

}

let getNumInversions = (nums, leftIndex = 0, rightIndex = nums.length - 1) => {

    let count = 0;

    if (leftIndex < rightIndex) {

        let middleIndex = Math.floor((leftIndex + rightIndex) / 2);

        count += getNumInversions(nums, leftIndex, middleIndex);
        count += getNumInversions(nums, middleIndex + 1, rightIndex);

        count += merge(nums, leftIndex, middleIndex, rightIndex);

    }

    return count;

}

let nums = [3, 15, 61, 11, 7, 9, 2];

console.log(getNumInversions(nums));
