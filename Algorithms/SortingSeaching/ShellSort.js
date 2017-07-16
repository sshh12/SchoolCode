
let shellSort = (nums) => {

    for (let gap = Math.floor(nums.length / 2); gap > 0; gap = Math.floor(gap / 2)) {

        for (let i = gap; i < nums.length; i++) {

            let j = i,
                temp = nums[i];

            while (j >= gap && nums[j - gap] > temp) {

                nums[j] = nums[j - gap];

                j -= gap;

            }

            nums[j] = temp;

        }

    }

}

let nums = [1, 52, 2, 25, 6, 10, 25, 200, 15, 12, 8, 2];

console.log(nums);

shellSort(nums);

console.log(nums);
