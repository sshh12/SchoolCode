"use strict";

class BinaryTree1 {

    constructor() {
        this.root = null;
    }

    add(item, node = this.root) {

        if (!node) {

            this.root = {
                data: item,
                left: null,
                right: null
            };

        } else {

            if (item < node.data) {

                if (node.left) {
                    this.add(item, node.left);
                } else {
                    node.left = {
                        data: item,
                        left: null,
                        right: null
                    }
                }

            } else {

                if (node.right) {
                    this.add(item, node.right);
                } else {
                    node.right = {
                        data: item,
                        left: null,
                        right: null
                    }
                }

            }

        }

    }

    remove(item) {
        this.root = this._deleteItem(this.root, item);
    }

    _minItem(node) {
        while (node.left) {
            node = node.left;
        }
        return node;
    }

    _deleteItem(node, item) {
        if (node) {
            if (item < node.data) {
                node.left = this._deleteItem(node.left, item);
            } else if (item > node.data) {
                node.right = this._deleteItem(node.right, item);
            } else {
                if (!node.left) {
                    return node.right;
                } else if (!node.right) {
                    return node.left;
                } else {
                    let minNode = this._minItem(node.right);
                    node.data = minNode.data;
                    node.right = this._deleteItem(node.right, minNode.data);
                }
            }
        }
        return node;
    }

    has(item, node = this.root) {
        if (!node) {
            return false;
        } else if (item == node.data) {
            return true;
        } else if (item < node.data) {
            return this.has(item, node.left);
        } else {
            return this.has(item, node.right);
        }
    }

    getPreOrder(node = this.root, items = []) {

        if (!node) {
            return items;
        }

        items.push(node.data);

        this.getPreOrder(node.left, items);
        this.getPreOrder(node.right, items);

        return items;

    }

    getInOrder(node = this.root, items = []) {

        if (!node) {
            return items;
        }

        this.getInOrder(node.left, items);

        items.push(node.data);

        this.getInOrder(node.right, items);

        return items;

    }

    getPostOrder(node = this.root, items = []) {

        if (!node) {
            return items;
        }

        this.getPostOrder(node.left, items);
        this.getPostOrder(node.right, items);

        items.push(node.data);

        return items;

    }

}

for (let binTreeClass of [BinaryTree1]) {

    let binTree = new binTreeClass();

    binTree.add(1);
    binTree.add(0);
    binTree.add(2);

    console.log(binTree.has(2));
    console.log(binTree.getInOrder());
    console.log(binTree.getPreOrder());
    console.log(binTree.getPostOrder());

    binTree.remove(1);
    binTree.add(3);
    binTree.add(-1);
    binTree.add(-3);
    binTree.add(-2);

    console.log(binTree.has(1));
    console.log(binTree.getInOrder());

    console.log("------");

}
