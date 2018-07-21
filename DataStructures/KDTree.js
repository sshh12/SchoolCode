"use strict";

class KDTree1 {

  constructor(kdims) {

    this.k = kdims;
    this.root = null;

  }

  add(point, node = null, depth = -1) {

    if (depth == -1) {
      this.root = add(point, this.root, 0);
      return this.root;
    }

    if (!node) {
      return {
        point: point,
        left: null,
        right: null
      };
    }

    let dim = depth % this.k;

    if (point[dim] < node.point[dim]) {
      node.left = add(point, node.left, depth + 1);
    } else {
      node.right = add(point, node.right, depth + 1);
    }

    return node;

  }

  has(point, node = this.root, depth = 0) {

    if (!node) {
      return false;
    } else if (point == node.point) {
      return true;
    }

    let dim = depth % this.k;

    if (point[dim] < node.point[dim]) {
      return has(point, node.left, depth + 1);
    } else {
      return has(point, node.right, depth + 1);
    }

  }

}

for (let kdTreeClass of [KDTree1]) {

  let kdTree = new kdTreeClass(2);

  kdtree.add([1, 2]);
  kdtree.add([3, 4]);
  kdtree.add([5, 6]);
  kdtree.add([-1, 1]);
  kdtree.add([10, -10]);
  kdtree.add([2, 2]);
  kdtree.add([5, 5]);

  console.log(kdtree.has([-1, 1]));
  console.log(kdtree.has([10, 10]));

  console.log("------");

}
