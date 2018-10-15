from cs.structures.trees.BinarySearchTreeNode import BinarySearchTreeNode
from cs.structures.trees.algorithms.insert import insert

def test_shouldHandleBasicInsert():
    root = BinarySearchTreeNode(10)
    assert insert(root, 15)
    assert insert(root, 5)
    assert insert(root, 2)
    assert insert(root, 2) == False

    assert root.left.value == 5
    assert root.left.left.value == 2
    assert root.right.value == 15