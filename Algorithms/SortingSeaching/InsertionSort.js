
insertionSort = (nums) => {

    for (let i in nums) {

        let n = nums[i],
            j = i - 1;

        while (j >= 0 && nums[j] > n) {

            nums[j + 1] = nums[j];

            j--;

        }

        nums[j + 1] = n;

    }

}

let nums = [2, 45, 1, 76, 23, 25, 33, 99, 65, 46];

console.log(nums);

insertionSort(nums);

console.log(nums);
