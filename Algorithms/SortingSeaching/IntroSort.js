"use strict";

class Heap { // Insert Actual Heap Here...

  constructor() {

    this.items = [];
    this.numSort = (a, b) => a - b;

  }

  push(item) {

    this.items.push(item);
    this.items.sort(this.numSort);

  }

  remove() {

    return this.items.shift();

  }

}

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

let heapSort = (nums, leftIndex, rightIndex) => {

  let heap = new Heap();

  for (let i = leftIndex; i <= rightIndex; i++) {

    heap.push(n)

  }

  for (let i = leftIndex; i <= rightIndex; i++) {

    nums[i] = heap.remove();

  }

}

let median = (a, b, c) => a + b + c - Math.min(a, b, c) - Math.max(a, b, c);

let partition = (nums, leftIndex, rightIndex) => {

  let pivot = nums[rightIndex],
      i = leftIndex - 1;

  for (let j = leftIndex; j < rightIndex; j++) {

    if (nums[j] <= pivot) {

      i++;

      [nums[j], nums[i]] = [nums[i], nums[j]];

    }

  }

  [nums[i + 1], nums[rightIndex]] = [nums[rightIndex], nums[i + 1]]

  return i + 1;

}

let introUtil = (nums, leftIndex, rightIndex, depthLimit) => {

  let size = rightIndex - leftIndex;

  if (size < 16) {

    insertionSort(nums, leftIndex, rightIndex);

  } else if (depthLimit == 0) {

    heapSort(nums, leftIndex, rightIndex);

  } else {

    let pivot = median(leftIndex, leftIndex + Math.floor(size / 2), rightIndex);

    [nums[pivot], nums[rightIndex]] = [nums[rightIndex], nums[pivot]];

    let index = partition(nums, leftIndex, rightIndex);

    introUtil(nums, leftIndex, index - 1, depthLimit - 1)
    introUtil(nums, index + 1, rightIndex, depthLimit - 1)

  }

}

let introSort = (nums) => {

  let leftIndex = 0,
      rightIndex = nums.length - 1;

  let depthLimit = Math.floor(2 * Math.log(rightIndex - leftIndex))

  introUtil(nums, leftIndex, rightIndex, depthLimit);

}

let nums = [3, 23, 44, 143, 0, 4, 68, 9, 1, 59, 31, 32, 33, 34, 35, 9, 21, 22, 5];

console.log(nums);

introSort(nums);

console.log(nums);
