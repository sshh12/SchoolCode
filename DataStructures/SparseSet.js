"use strict";

class SparseSet1 {

  constructor(capacity = 10, maxVal = 10) {

    this.dense = new Array(capacity);
    this.sparse = new Array(maxVal + 1);
    this.capacity = capacity;
    this.maxVal = maxVal;
    this.items = 0;

  }

  add(item) {

    if (item > this.maxVal || this.items >= this.capacity || this.find(item) != -1) {
      return;
    }

    this.dense[this.items] = item;
    this.sparse[item] = this.items;

    this.items++;

  }

  remove(item) {

    if (this.find(item) == -1) {
      return;
    }

    let temp = this.dense[this.items - 1];
    this.dense[this.sparse[item]] = temp;
    this.sparse[temp] = this.sparse[item];

    this.items--;

  }

  find(item) {

    if (item <= this.maxVal && this.sparse[item] < this.items && this.dense[this.sparse[item]] == item) {
      return this.sparse[item];
    }

    return -1;

  }

  clear() {

    this.items = 0;

  }

}

for (let sparseSetClass of [SparseSet1]) {

  let sparseSet = new sparseSetClass();

  sparseSet.add(2);
  sparseSet.add(4);

  console.log(sparseSet.find(4));
  console.log(sparseSet.find(6));

  sparseSet.add(6);
  sparseSet.add(8);

  console.log(sparseSet.find(6));

  sparseSet.remove(6);

  console.log(sparseSet.find(6));
  console.log(sparseSet.find(8));

  sparseSet.clear();

  console.log(sparseSet.find(2));
  console.log(sparseSet.find(8));

  console.log("------");

}
