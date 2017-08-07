"use strict";



let flip = (nums, endIndex) => {

    let startIndex = 0;

    while(startIndex < endIndex){

      [nums[startIndex], nums[endIndex]] = [nums[endIndex], nums[startIndex]];

      startIndex++; endIndex--;

    }

}

let findMaxIndex = (nums, endIndex) => {

  let maxIndex = 0;

  for(let i = 0; i < nums.length; i++){

    if(nums[i] > nums[maxIndex]){

      maxIndex = i;

    }

  }

  return maxIndex;

}

let pancakeSort = (nums) => {

  for(let size = nums.length; size > 1; size--){

    let maxIndex = findMaxIndex(nums, size);

    if(maxIndex != size - 1){

      flip(nums, maxIndex);
      console.log(nums)
      flip(nums, size - 1);

    }

  }

}

let nums = [12, 3, 33, 1, 88, 100, 50, 40, 60, 25, 2, 4, 6, 22];

console.log(nums);

pancakeSort(nums);

console.log(nums);
