from cs.structures.trees.TreeNode import TreeNode

def test_shouldSupportAddingChildren():
    node = TreeNode(10)

    node.children.append(TreeNode(15))
    node.children.append(TreeNode(10))

    assert len(node.children) == 2