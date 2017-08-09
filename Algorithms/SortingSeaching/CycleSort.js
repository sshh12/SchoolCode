"use strict";

let cycleSort = (nums) => {

    const n = nums.length;

    for (let cycleIndex = 0; cycleIndex <= n - 2; cycleIndex++) {

        let item = nums[cycleIndex],
            index = cycleIndex;

        for (let i = cycleIndex + 1; i < n; i++) {

            if (nums[i] < item) {

                index++;

            }

        }

        if (index == cycleIndex) {

            continue;

        }

        while (item == nums[index]) {

            index++;

        }

        [nums[index], item] = [item, nums[index]];

        while (index != cycleIndex) {

            index = cycleIndex;

            for (let i = cycleIndex + 1; i < n; i++) {

                if (nums[i] < item) {

                    index++;

                }

            }

            while (item == nums[index]) {

                index++;

            }

            [nums[index], item] = [item, nums[index]];

        }

    }

}

let nums = [3, 654, 3, 33, 10, 8, 2, 99, 101, 94, 60];

console.log(nums);

cycleSort(nums);

console.log(nums);
