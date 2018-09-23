// helper functions
// ---

var isUndefined = function(o) {
	return typeof o === 'undefined';
};

var isEqualTo = function(o, p) {
	return o === p;
};

// classes
// ---

var Node = function (value, left, right) {
	this.value = value;
	this.left = left;
	this.right = right;
};

// Enum of the allowed orders for DFS search
Node.Orders = {
	PRE: 'pre',
	IN: 'in',
	POST: 'post'
};

Node.prototype.evaluateInOrder = function (evaluate, visit) {
	var result;
	if (evaluate) {
		if (this.left) {
			result = this.left.evaluateInOrder(evaluate, visit);
		}
		if (isUndefined(result)) {
			if (visit) {
				visit(this);
			}
			result = evaluate(this);
			if (isUndefined(result)) {
				if (this.right) {
					result = this.right.evaluateInOrder(evaluate, visit);
				}
			}
		}
	}
	return result;
};

Node.prototype.evaluatePreOrder = function (evaluate, visit) {
	var result;
	if (evaluate) {
		if (visit) {
			visit(this);
		}
		result = evaluate(this);
		if (isUndefined(result)) {
			if (this.left) {
				result = this.left.evaluatePreOrder(evaluate, visit);
			}
			if (isUndefined(result)) {
				if (this.right) {
					result = this.right.evaluatePreOrder(evaluate, visit);
				}
			}
		}
	}
	return result;
};

Node.prototype.evaluatePostOrder = function (evaluate, visit) {
	var result;
	if (evaluate) {
		if (this.left) {
			result = this.left.evaluatePostOrder(evaluate, visit);
		}
		if (isUndefined(result)) {
			if (this.right) {
				result = this.right.evaluatePostOrder(evaluate, visit);
			}
			if (isUndefined(result)) {
				if (visit) {
					visit(this);
				}
				result = evaluate(this);
			}
		}
	}
	return result;
};

Node.prototype.dfs = function (evaluate, order, visit) {
	if (!order) {
		throw "order must be defined.";
	}

	if (order === Node.Orders.PRE) {
		return this.evaluatePreOrder(evaluate, visit);
	} else if (order === Node.Orders.IN) {
		return this.evaluateInOrder(evaluate, visit);
	} else if (order === Node.Orders.POST) {
		return this.evaluatePostOrder(evaluate, visit);
	} else {
		throw "order was not recognized as a valid type (See: Node.Orders)";
	}
};

Node.prototype.bfs = function (evaluate, visit) {
	var q = [this];
	while (q.length > 0) {
		var node = q.shift();
		if (visit) {
			visit(node);
		}
		var result = evaluate(node);
		if (!isUndefined(result)) {
			return result;
		}
		if (node.left)
			q.push(node.left);
		if (node.right)
			q.push(node.right);
	}
};

// Binary Tree class
// ---

var BinaryTree = function (...values) {
	this.root = new Node();
	if (values && values.length > 0) {
		values.forEach((v) => {
			this.add(v);
		});
	}
	return this;
};

BinaryTree.prototype.add = function (...values) {
	var i;
	for (i = 0; i < values.length; i++) {
		var value = values[i];

		var node = this.root;
		if (isUndefined(node.value)) {
			node.value = value;
		} else {
			while (node) {
				if (value === node.value) {
					break; // short-circuit duplicate values
				} else if (value < node.value) {
					if (!node.left) {
						node.left = new Node(value);
						break;
					} else {
						node = node.left;
					}
				} else if (value > node.value) {
					if (!node.right) {
						node.right = new Node(value);
						break;
					} else {
						node = node.right;
					}
				}
			}
		}
	}

	return this;
};

// https://en.wikipedia.org/wiki/Binary_tree#Deletion
BinaryTree.prototype.remove = function (value) {
	var scope = {
		parents: {}, // A hashtable of parents for quick lookup later
		needle: value // The value of the node to delete
	};

	var toDelete = this.root.dfs(function(node) {
		if (node.value === value) {
			return node;
		}
	}, Node.Orders.PRE, function(node) {
		if (!isUndefined(node.left)) {
			this.parents[node.left.value] = node;
		}
		if (!isUndefined(node.right)) {
			this.parents[node.right.value] = node;
		}
	}.bind(scope));

	if (!isUndefined(toDelete)) {

		var parent = scope.parents[toDelete.value];

		if (isUndefined(parent)) {
			// it's the root node
			toDelete.value = undefined;
			toDelete.left = undefined;
			toDelete.right = undefined;
		} else if (!isUndefined(toDelete.left) && !isUndefined(toDelete.right)) {
			// BOTH left and right children exist. Can't delete reliably.
			throw "Cannot unambiguosly remove node with two children.";
		} else {

			// EITHER left OR right child exists. Re-parent the existing child.
			if (isUndefined(parent.right)
				|| !isUndefined(parent.left)
				&& isEqualTo(parent.left.value, toDelete.value)) {

				// toDelete is on the left side
				if (isUndefined(toDelete.left)) {
					if (isUndefined(toDelete.right)) {
						parent.left = undefined;
					} else if (toDelete.right.value < parent.value) {
						parent.left = toDelete.right;
					} else {
						throw "Cannot delete node: Cannot re-parent right child";
					}
				} else if (isUndefined(toDelete.right)) {
					parent.left = toDelete.left;
				}
			} else {

				// toDelete is on the right side
				if (isUndefined(toDelete.right)) {
					if (isUndefined(toDelete.left)) {
						parent.right = undefined;
					} else if (toDelete.left.value > parent.value) {
						parent.right = toDelete.left;
					} else {
						throw "Cannot remove node: Cannot re-parent left child";
					}
				} else if (isUndefined(toDelete.left)) {
					parent.right = toDelete.right;
				}
			}
		}
	}
	return this;
};

module.exports = {
	BinaryTree,
	Node
};