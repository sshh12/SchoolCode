"use strict";

class RingBufferQueue {

  constructor(size = 10) {

    this.items = new Array(size);
    this.size = size;
    this.writeIndex = 0;
    this.used = 0;

  }

  add(item) {

    if (this.used != this.size) {

      this.items[this.writeIndex] = item;

      this.writeIndex = (this.writeIndex + 1) % this.size;

      this.used++;

      return true;

    }

    return false;

  }

  peek() {

    return this.items[(this.writeIndex + (this.size - this.used)) % this.size];

  }

  remove() {

    if (this.used > 0) {

      let item = this.peek();

      this.used--;

      return item;

    }

    return null;

  }

}

for (let rbqClass of [RingBufferQueue]) {

  let queue = new rbqClass();

  queue.add("1");
  queue.add("2");

  console.log(queue.peek());
  console.log(queue.remove());

  queue.add("3");

  console.log(queue.remove());

  console.log("------");

}
