"use strict";

let getTripletSumZero = (nums) => {

    let triplets = [];

    nums.sort((a, b) => a - b);

    for (let i = 0; i < nums.length - 2; i++) {

        let a = nums[i],
            start = i + 1,
            end = nums.length - 1;

        while (start < end) {

            let b = nums[start],
                c = nums[end];

            if (a + b + c >= 0) {

                if (a + b + c == 0) {

                    triplets.push([a, b, c]);

                }

                end--;

            } else {

                start++;

            }

        }

    }

    return triplets;

}

let nums = [-25, -10, -7, -3, 2, 4, 8, 10];

for (let triplet of getTripletSumZero(nums)) {

    console.log(triplet);

}
