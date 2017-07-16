
let merge = (nums, leftIndex, middleIndex, rightIndex) => {

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

        }

    }

    while (left < leftSize) {

        nums[index++] = leftElements[left++];

    }

    while (right < rightSize) {

        nums[index++] = rightElements[right++];

    }

}

let mergeSort = (nums, leftIndex = 0, rightIndex = nums.length - 1) => {

    if (leftIndex < rightIndex) {

        let middleIndex = Math.floor((leftIndex + rightIndex) / 2);

        mergeSort(nums, leftIndex, middleIndex);
        mergeSort(nums, middleIndex + 1, rightIndex);

        merge(nums, leftIndex, middleIndex, rightIndex);

    }

}

let nums = [1, 32, 33, 5, 99, 23, 12, 4, 100, 26, 24];

console.log(nums);

mergeSort(nums);

console.log(nums);
