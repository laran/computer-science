from cs.structures.trees.BinarySearchTreeNode import BinarySearchTreeNode

"""
Create a new node at the correct position in the tree under the root node
based on the value in the context of the binary search tree ordering
constraints.
"""
def insert(root, value):
    if root is None or value is None:
        pass

    node = root
    while node is not None:
        if value == node.value:
            return False
        elif value < node.value:
            if node.left is None:
                node.left = BinarySearchTreeNode(value)
                return True
            else:
                node = node.left
        else:
            if node.right is None:
                node.right = BinarySearchTreeNode(value)
                return True
            else:
                node = node.right
    return False
