# Java Data Structures Package 🚀

Welcome to my Java Data Structures Package! This package provides a collection of essential data structures and utility classes for common operations.

All the classes have generic support, proper Exception handling with good javaDoc, comments and readability.

## Table of Contents

1. [Array](https://github.com/Vasudevshetty/javaDSA/tree/main/dsa/array)

   - [Array Implementation](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/array/Array.java)

2. [Linked List](https://github.com/Vasudevshetty/javaDSA/tree/main/dsa/list)

   - [Single Linked List](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/list/SingleLinkedList.java)
   - [Double Linked List](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/list/DoubleLinkedList.java)
   - [Circular Linked List](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/list/CircularLinkedList.java)
   - [Double Circular Linked List](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/list/DoubleCircularLinkedList.java)
   - [Single Circular Linked List](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/list/SingleCircularLinkedList.java)

3. [Queue](https://github.com/Vasudevshetty/javaDSA/tree/main/dsa/queue)

   - [Priority Queue](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/queue/PriorityQueue.java)
   - [Circular Queue](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/queue/CircularQueue.java)
   - [Deque](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/queue/Deque.java)

4. [Stack](https://github.com/Vasudevshetty/javaDSA/tree/main/dsa/stack)

   - [Stack Array Implementation](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/stack/StackArray.java)
   - [Stack Linked List Implementation](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/stack/StackLL.java)
   - [Notation Converter](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/stack/NotationConvertor.java)

5. [Trees](https://github.com/Vasudevshetty/javaDSA/tree/main/dsa/trees)

   - [Binary Tree Concrete class](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/trees/binaryTrees/BinaryTree.java)
   - [Expression Tree](https://github.com/Vasudevshetty/javaDSA/blob/main/dsa/trees/applications/ExpresssionTree.java)
   <!-- 6. [Usage](https://github.com/Vasudevshetty/javaDSA#usage)

<!-- 6. [Contributing](https://github.com/Vasudevshetty/javaDSA#contributing)

7. [License](https://github.com/Vasudevshetty/javaDSA/blob/main/LICENSE) --> 

## 📦 Data Structures

### 1. Queue

- **Description**: Implementation of a generic queue with common operations.
- **Features**: Enqueue, dequeue, front, rear, and more.
- **Usage**: `Queue<Integer> queue = new Queue<>();`
- **Types**: `Dequeue<String> or CircularQueue<Integer>`

### 2. Stack

- **Description**: A stack implementation supporting push, pop, peek, and more.
- **Features**: Dynamic resizing, generic support.
- **Usage**: `Stack<String> stack = new Stack<>();`
- **Types**: `StackLL<String> or StackArray<Integer>`

### 3. Linked List

- **Description**: Generic linked list with insert, delete, reverse, copy and search functionalities.
- **Features**: Singly, double and circualr linked list.
- **Usage**: `LinkedList<Double> list = new LinkedList<>();`
- **Types**: `SingleLinkedList<String> or SingleCircularLinkedList<Integer> or replace(Single, Double).`

### 4. Notation Converter Utility

- **Description**: Utility class for converting infix, postfix, and prefix notations.
- **Features**: Supports various types of expressions.
- **Path**: `javaDSA\dsa\stack\NotationConverter`
- **Usage**: `NotationConverter.postfix(Expression, ExpressionType(enum - prefix, postfix or infix));`
- **Types**: `postfix(expression, infix/prefix) or prefix(expression, infix/postfix) or infix(expression, prefix/postfix)`

### 5. Binary Trees

- **Description**
The `binaryTrees` sub-repository contains the implementation of generic binary trees with various functionalities.

- **Features** : 
 Basic binary tree structure with a `TreeNode` class.
 Generic `BinaryTree` class supporting common tree operations.
 Designed for flexibility and easy extension.

- **Usage Example**
```java
BinaryTree<Integer> tree = new BinaryTree<>();
TreeNode<Integer> root = new TreeNode<>(5);
tree.setRoot(root);
// Perform tree operations...
```
### 6. Expression Tree

- **Description**
The `ExpressionTree` class in the `applications` sub-repository serves as a utility for constructing and manipulating expression trees.

- **Features** :
   - `ExpressionTree` extends `BinaryTree<Character>` to represent expression trees.
   - Construction from postfix expressions: `ExpressionTree(String postfixExpression)`.

- **Usage Example**
```java
ExpressionTree expressionTree = new ExpressionTree("ab+");
// Perform expression tree operations...
```

## 🚀 Getting Started

1. Clone the repository: `git clone https://github.com/Vasudevshetty/javaDSA.git`
2. Include the JAR file in your Java project.
3. Explore and integrate the data structures into your application.

## 🌟 Contribution

Feel free to contribute to this project by submitting bug reports, feature requests, or pull requests.
If you like this please put up a star and motivate me. 😍

Happy coding! 🚀
