# Binary Tree Construction from Preorder and Inorder Traversals

## Problem Overview

This algorithm reconstructs a binary tree given two arrays:
- **Preorder traversal**: Root → Left → Right
- **Inorder traversal**: Left → Root → Right

The key insight is that these two traversals provide complementary information that uniquely determines the tree structure.

## Algorithm Breakdown

### Main Method: `buildTree`

```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        indexMap.put(inorder[i], i);
    }
    return build(preorder, 0, 0, inorder.length - 1, indexMap);
}
```

**Purpose**: Initialize the algorithm and create an optimization structure.

**Key Steps**:
1. **Create Index Map**: Maps each value in the inorder array to its index position
    - **Why?** Instead of searching for the root position in inorder array every time (O(n) operation), we can look it up in O(1) time
    - **Example**: If inorder = [9, 3, 15, 20, 7], the map becomes {9→0, 3→1, 15→2, 20→3, 7→4}

2. **Call Recursive Helper**: Starts the recursive construction process

### Recursive Helper Method: `build`

```java
private TreeNode build(int[] preorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> indexMap)
```

**Parameters**:
- `preorder`: The preorder traversal array
- `preStart`: Current position in preorder array (where to find the current root)
- `inStart`, `inEnd`: Boundaries of the current subtree in inorder array
- `indexMap`: Quick lookup for inorder positions

### Step-by-Step Execution

#### 1. Base Case Check
```java
if (inStart > inEnd || preStart >= preorder.length) {
    return null;
}
```
- **When `inStart > inEnd`**: No elements left in current subtree
- **When `preStart >= preorder.length`**: No more nodes to process in preorder

#### 2. Create Root Node
```java
int rootVal = preorder[preStart];
TreeNode root = new TreeNode(rootVal);
```
- **Key Insight**: In preorder traversal, the first element is always the root of the current subtree
- Create a new tree node with this value

#### 3. Find Root Position in Inorder
```java
int inorderIndex = indexMap.get(rootVal);
```
- **Purpose**: Locate where the root appears in the inorder traversal
- **Why Important**: This position divides the inorder array into left and right subtrees

#### 4. Calculate Left Subtree Size
```java
int leftTreeSize = inorderIndex - inStart;
```
- **Logic**: Everything before the root in inorder belongs to the left subtree
- **Example**: If inorder = [9, 3, 15, 20, 7] and root is 3 (at index 1), left subtree has 1 element (just 9)

#### 5. Recursive Calls for Subtrees
```java
root.left = build(preorder, preStart + 1, inStart, inorderIndex - 1, indexMap);
root.right = build(preorder, preStart + 1 + leftTreeSize, inorderIndex + 1, inEnd, indexMap);
```

**Left Subtree**:
- `preStart + 1`: Skip current root, start with next element in preorder
- `inStart` to `inorderIndex - 1`: Left portion of inorder array

**Right Subtree**:
- `preStart + 1 + leftTreeSize`: Skip root and all left subtree nodes in preorder
- `inorderIndex + 1` to `inEnd`: Right portion of inorder array

## Detailed Example

Let's trace through an example:
- **Preorder**: [3, 9, 20, 15, 7]
- **Inorder**: [9, 3, 15, 20, 7]

### Initial Call
- `preStart = 0`, `inStart = 0`, `inEnd = 4`
- Root = 3 (preorder[0])
- Root position in inorder = 1
- Left subtree size = 1 - 0 = 1

### Tree Structure
```
    3
   / \
  9   20
     /  \
    15   7
```

### Recursive Breakdown

1. **Root = 3**
    - Left subtree: preorder[1:1] = [9], inorder[0:0] = [9]
    - Right subtree: preorder[2:4] = [20,15,7], inorder[2:4] = [15,20,7]

2. **Left Subtree (Root = 9)**
    - Base case: creates leaf node

3. **Right Subtree (Root = 20)**
    - Left subtree: preorder[3:3] = [15], inorder[2:2] = [15]
    - Right subtree: preorder[4:4] = [7], inorder[4:4] = [7]

## Time and Space Complexity

### Time Complexity: O(n)
- Each node is visited exactly once
- HashMap lookup is O(1)
- Total: O(n) where n is the number of nodes

### Space Complexity: O(n)
- HashMap storage: O(n)
- Recursion stack: O(h) where h is tree height
    - Best case: O(log n) for balanced tree
    - Worst case: O(n) for skewed tree
- Total: O(n)

## Key Insights

1. **Preorder gives us root identification**: First element is always the current subtree root
2. **Inorder gives us subtree boundaries**: Root position divides left and right subtrees
3. **Index mapping optimization**: Avoids repeated linear searches in inorder array
4. **Recursive structure**: Each subtree follows the same pattern as the original problem

## Alternative Approaches

- **Without HashMap**: Search for root in inorder array each time (O(n²) worst case)
- **Iterative**: Use explicit stack instead of recursion (more complex but same complexity)
- **Postorder + Inorder**: Similar approach but traverse from the end of postorder array