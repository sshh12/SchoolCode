
let sortCount = (nums, mask) => {

    let counts = new Array(10);
    counts.fill(0);
    
    let out = new Array(nums.length);
    out.fill(0);

    for (let n of nums) {
        counts[Math.floor(n / mask) % 10]++;
    }

    for (let i = 1; i < 10; i++) {
        counts[i] += counts[i - 1];
    }

    for (let i = nums.length; i >= 0; i--) {
        out[counts[Math.floor(nums[i] / mask) % 10] - 1] = nums[i];
        counts[Math.floor(nums[i] / mask) % 10]--;
    }

    nums.splice(0, nums.length, ...out);

}

let radixSort = (nums) => {

    let m = Math.max(...nums)

    for (let mask = 1; Math.floor(m / mask) > 0; mask *= 10) {

        sortCount(nums, mask);

    }

}

let nums = [1, 52, 2, 25, 6, 10, 25, 200, 15, 12, 8, 2];

console.log(nums);

radixSort(nums);

console.log(nums);
