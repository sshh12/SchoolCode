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

let heapSort = (nums) => {

    let heap = new Heap();

    for (let n of nums) {

        heap.push(n)

    }

    for (let i in nums) {

        nums[i] = heap.remove();

    }

}

let nums = [24, 43, 1, 33, 3, 41, 99, 102, 6, 78, 8];

console.log(nums);

heapSort(nums);

console.log(nums);
