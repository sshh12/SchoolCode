"use strict";

let binarySearch = (nums, x) => {

  let bottom = 0, top = nums.length - 1;

  while(bottom <= top){

    let middle = Math.floor((top + bottom) / 2);

    if(nums[middle] == x){

      return middle;

    } else if(nums[middle] < x){

      bottom = middle + 1;

    } else {

      top = middle - 1;

    }

  }

  return -1;

}

let binarySearch2 = (nums, x, bottom = 0, top = nums.length-1) => {

  if(top >= bottom){

    let middle = Math.floor((top + bottom) / 2);

    if(nums[middle] == x){

      return middle;

    } else if(nums[middle] < x){

      return binarySearch2(nums, x, middle + 1, top);

    }

    return binarySearch2(nums, x, bottom, middle - 1);

  }

  return -1;

}

let nums = [3, 5, 657, 23, 5, 9, 2, 54, 22, 10, 14, 20, 42, 32, 15, 11];

nums.sort((a, b) => a - b);

console.log(nums)

console.log(binarySearch(nums, 10));

console.log("------");

console.log(binarySearch2(nums, 10));
