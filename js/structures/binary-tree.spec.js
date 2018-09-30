import BinaryTree, {Node} from './binary-tree';

describe('Binary Tree', () => {
	test('supports vararg inserts', () => {
		var tree = new BinaryTree(1, 2, 3, 4, 5);
		expect(tree.root).not.toBeUndefined();
		expect(tree.root.value).toBe(1);
	});

	test('properly handles duplicate value insertion', () => {
		var tree = new BinaryTree(1);

		expect(tree.root.value).toBe(1);
		expect(tree.root.left).toBe(undefined);
		expect(tree.root.right).toBe(undefined);
	});

	test('inserts in the correct order', () => {
		var tree = new BinaryTree(1, 2, 3);

		expect(tree.root.value).toBe(1);
		expect(tree.root.left).toBe(undefined);
		expect(tree.root.right.value).toBe(2);
		expect(tree.root.right.left).toBe(undefined);
		expect(tree.root.right.right.value).toBe(3);
		expect(tree.root.right.right.left).toBe(undefined);

		tree = new BinaryTree(2, 3, 1);
		expect(tree.root.value).toBe(2);
		expect(tree.root.left.value).toBe(1);
		expect(tree.root.right.value).toBe(3);
	});

	test('can DFS in order', () => {
		var tree = new BinaryTree(20, 30, 10, 15, 25);

		//           20
		//        /     \
		//      10      30
		//       \      /
		//       15   25

		var find = function(node) {
			if (node.value === this.needle) {
				return true;
			}
		};

		var visit = function(node) {
			this.path.push(node.value);
		};

		var scope = {needle: 1, path: []};
		tree.root.dfs(find.bind(scope), Node.Orders.PRE, visit.bind(scope));
		expect(scope.path).toEqual([20, 10, 15, 30, 25]);

		scope = {needle: 1, path: []};
		tree.root.dfs(find.bind(scope), Node.Orders.IN, visit.bind(scope));
		expect(scope.path).toEqual([10, 15, 20, 25, 30]);

		scope = {needle: 1, path: []};
		tree.root.dfs(find.bind(scope), Node.Orders.POST, visit.bind(scope));
		expect(scope.path).toEqual([15, 10, 25, 30, 20]);

		scope = {needle: 1, path: []};
		tree.root.dfs(find.bind(scope), Node.Orders.IN, visit.bind(scope));
		expect(scope.path).toEqual([10, 15, 20, 25, 30]);
	});

	test('can BFS in order', () => {
		var evaluate = function(node) {
			if (node.value === this.needle) {
				return true;
			}
		};

		var visit = function(node) {
			this.path.push(node.value);
		};

		var find = function(needle, tree, expected) {
			var scope = {needle: needle, path: []};
			tree.root.bfs(evaluate.bind(scope), visit.bind(scope));
			expect(scope.path).toEqual(expected);
		};

		find(25, new BinaryTree(20, 30, 10, 15, 25), [20, 10, 30, 15, 25]);
	});

	test('can delete the root node', () => {
		var tree = new BinaryTree(20, 30, 10).remove(20);
		expect(tree.root.left).toBeUndefined();
		expect(tree.root.right).toBeUndefined();
		expect(tree.root.value).toBeUndefined();
	});

	test('can delete a node with no children', () => {
		var tree = new BinaryTree(20, 30, 10).remove(10);
		expect(tree.root.left).toBeUndefined();
		expect(tree.root.right).not.toBeUndefined();
		expect(tree.root.right.value).toBe(30);

		tree = new BinaryTree(20, 30, 10).remove(30);
		expect(tree.root.right).toBeUndefined();
		expect(tree.root.left).not.toBeUndefined();
		expect(tree.root.left.value).toBe(10);
	});

	test('can delete a node with one child', () => {
		var tree = new BinaryTree(50, 40, 30, 35, 36).remove(35);
		expect(tree.root.left.left.value).toBe(30);
		expect(tree.root.left.left.right.value).toBe(36);
	});

	test('cannot delete a node with two children', () => {
		expect(() => {
			new BinaryTree(50, 30, 35, 25).remove(30);
		}).toThrow();
	});
});
