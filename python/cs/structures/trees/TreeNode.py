class TreeNode:
    """
    A basic TreeNode for an unrestricted Tree.
    This does NOT meet the criteria for a Binary Tree.
    See BinaryTreeNode for that
    """
    def __init__(self, value):
        self.value = value
        self.children = []
