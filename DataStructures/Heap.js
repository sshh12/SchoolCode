"use strict";

class Heap1 {

    constructor() {

        this.heap = [];

    }

    add(item) {

        this.heap.push(item);

        this._shiftDown(this.heap.length - 1)

    }

    remove() {

        let bottomItem = this.heap.pop(),
            returnItem = this.heap[0];

        this.heap[0] = bottomItem;

        this._shiftUp(0);

        return returnItem;

    }

    _shiftDown(index, startIndex = 0) {

        let item = this.heap[index];

        while (index > startIndex) {

            let parentIndex = (index - 1) >> 1,
                parent = this.heap[parentIndex];

            if (item < parent) {

                this.heap[index] = parent;
                index = parentIndex;

                continue;

            }

            break;

        }

        this.heap[index] = item;

    }

    _shiftUp(index) {

        let endIndex = this.heap.length,
            startIndex = index;

        let item = this.heap[index];

        let childIndex = 2 * index + 1;

        while (childIndex < endIndex) {

            let rightIndex = childIndex + 1;

            if (rightIndex < endIndex && this.heap[childIndex] >= this.heap[rightIndex]) {

                childIndex = rightIndex;

            }

            this.heap[index] = this.heap[childIndex];

            index = childIndex;
            childIndex = 2 * index + 1;

        }

        this.heap[index] = item;

        this._shiftDown(index, startIndex);

    }

}

for (let heapClass of [Heap1]) {

    let heap = new heapClass();

    heap.add(3);
    heap.add(5);
    heap.add(1);

    console.log(heap.remove());

    heap.add(4);

    console.log(heap.remove());

    console.log("------");

}
