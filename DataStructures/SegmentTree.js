"use strict";

class SegmentTree1 {

    constructor(nums) {

        this.nums = nums;

        let levels = Math.ceil(Math.log(nums.length) / Math.log(2)),
            maxSize = 2 * Math.floor(Math.pow(2, levels)) - 1;

        this.tree = [];

        this._construct(0, nums.length - 1, 0);

    }

    _getMiddleIndex(startIndex, endIndex) {

        return startIndex + Math.floor((endIndex - startIndex) / 2);

    }

    _construct(startIndex, endIndex, curIndex) {

        if (startIndex == endIndex) {

            this.tree[curIndex] = this.nums[startIndex];

            return this.nums[startIndex];

        }

        let middleIndex = this._getMiddleIndex(startIndex, endIndex);

        this.tree[curIndex] = this._construct(startIndex, middleIndex, curIndex * 2 + 1) +
                              this._construct(middleIndex + 1, endIndex, curIndex * 2 + 2);

        return this.tree[curIndex];

    }

    sum(rangeStart, rangeEnd, startIndex = 0, endIndex = this.nums.length - 1, curIndex = 0) {

        if (rangeStart <= startIndex && rangeEnd >= endIndex) {

            return this.tree[curIndex];

        } else if (endIndex < rangeStart || startIndex > rangeEnd) {

            return 0;

        } else {

            let middleIndex = this._getMiddleIndex(startIndex, endIndex);

            return this.sum(rangeStart, rangeEnd, startIndex, middleIndex, curIndex * 2 + 1) +
                   this.sum(rangeStart, rangeEnd, middleIndex + 1, endIndex, curIndex * 2 + 2);

        }

    }

    get(index) {

        return this.nums[index];

    }

    set(index, value, startIndex = 0, endIndex = this.nums.length - 1, curIndex = 0, diff = 0) {

        if (diff == 0) {

            diff = value - this.nums[index];

            this.nums[index] = value;

        }

        if (index >= startIndex && index <= endIndex) {

            this.tree[curIndex] += diff;

            if (startIndex != endIndex) {

                let middleIndex = this._getMiddleIndex(startIndex, endIndex);

                this.set(index, null, startIndex, middleIndex, curIndex * 2 + 1, diff);
                this.set(index, null, middleIndex + 1, endIndex, curIndex * 2 + 2, diff);

            }

        }

    }

}

let nums = [1, 2, 4, 6, 10, 20, 22];

for (let segTreeClass of [SegmentTree1]) {

    let segTree = new segTreeClass(nums);

    console.log(segTree.sum(2, 5));

    segTree.set(3, 10);

    console.log(segTree.sum(2, 5));

    console.log("------");

}
