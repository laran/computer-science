// https://medium.freecodecamp.org/all-you-need-to-know-about-tree-data-structures-bceacb85490c
import {isEqualTo, isUndefined} from '@laran/readable-helpers';

var Node = function (value, left, right) {
	this.value = value;
	this.left = left;
	this.right = right;
};

var BinarySearchTree = function (...values) {
	if (values && values.length > 0) {
		values.forEach((v) => {
			this.add(v);
		});
	}
	return this;
};

BinarySearchTree.prototype.add = function (...values) {
	var i;
	for (i = 0; i < values.length; i++) {
		var value = values[i];
		var node = this.root;
		if (isUndefined(node)) {
			node.value = value;
		} else {
			while(!isUndefined(node)) {
				if (isEqual(value, node.value)) {
					return; // ignore
				} else if (value < node.value) {
					if (isUndefined(node.left)) {
						node.left = new Node(value);
						break;
					} else {
						node = node.left;
					}
				} else if (value > node.value) {
					if (isUndefined(node.right)) {
						node.right = new Node(value);
						break;
					} else {
						node = node.right;
					}
				}
			}
		}
	}
};

BinarySearchTree.prototype.remove = function (value) {

};

module.exports = {
	BinarySearchTree,
	Node
};
