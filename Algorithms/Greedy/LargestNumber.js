"use strict";

let getLargestNumber = (nums) => {

    let values = nums.map(String);

    values.sort((a, b) => (a + b) > (b + a) ? -1 : 1);

    return parseInt(values.join(''));

}

let nums = [22, 225, 53, 19, 100];

console.log(getLargestNumber(nums));
