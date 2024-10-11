# Quiz 2

First, write down your name (**first name and last name**) and your **netid**.

In a tree, multiple positions can hold the same data. Write a method for LinkedTree<E> `public int maxDepth(E element)` which returns the depth of the deepest node containing the element. If the element is not in the tree, return -1. The root node has depth 0.

**Requirements:** Utilize the provided class and interface methods

**Hint:** There are two directions: recursion or one of the search algorithms learned in class.

```java
public interface Position<E> {
    public E getElement();
}
// Partial declarations of the class LinkedTree
public class LinkedTree<E> implements Tree<E>{
    Node root; int size; 
    int depth(Position<E> p);
    public Position<E> parent(Position<E> p);
    public GoodList< Position<E> >  children(Position<E> p);
    public int numChildren(Position<E> p);
    public boolean isInternal(Position<E> p);
    public boolean isExternal(Position<E> p);
    public boolean isRoot(Position<E> p);
// Partial declarations for the interface GoodList
public interface GoodList<E> {
    public abstract int size();
    public abstract E getAtIndex(int Index);
}
```

## Common mistakes

1. No one writes a correct O(N) algorithms
2. root.getElement() == element doesn’t mean 0 should be returned.
3. The distinction between E and Position<E> is unclear, such as why invoking children(E) would be inappropriate.
4. Improper use of a for loop. The condition in the middle of the for loop statement is evaluated only a single time. For instance, when using stack.size() as this condition, the value remains unchanged throughout the loop's execution, even if elements are added to the stack during the loop.
5. Excessive random codes
6. Brackets are not aligned

# Reference Solutions

You are expected to know the $O(N)$ solution.

## $O(N \log N)$ Solutions

DFS/BFS

```java
public int maxDepth(E element, Position<E> p) {
    Stack<Position<E>> stack = new LinkedStack<Position<E>>();
    stack.push(root);
    int max=-1;
    while (stack.size() > 0) {
        <Position<E>> p = stack.pop();
        if (p.getElement() == element && depth(p) > max)
            max = d;
        for (int i=0; i<numchildren(p); i++) {
            stack.push(children(p).getAtIndex(i));
        }

    }
    return max;
}
```

## $O(N)$ Solutions

Recursion:

```java
public int maxDepth(E element, Position<E> p) {
    if (p.getElement() == E) return 0;
    if (isExternal(p)) return -1;

    GoodList<Position<E>> child = children(p);
    int depth = -1;
    for (int i=0; i<child.size(); i++) {
        int d = maxDepth(element, child.getAtIndex(i));
        if (d>depth) {
            depth = d;
        }
    }
    if (depth == -1) return -1;
    else return depth + 1;
}
public int maxDepth(E element) {
    return maxDepth(element, root);
}
```

DFS/BFS:

```java
public int maxDepth(E element, Position<E> p) {
    Stack<Position<E>> stack = new LinkedStack<Position<E>>();
    Stack<Integer> depth = new LinkedStack<Integer>();
    stack.push(root);
    depth.push(0);
    int max=-1;
    while (stack.size() > 0) {
        <Position<E>> p = stack.pop();
        Integer d = depth.pop();
        if (p.getElement() == element)
            max = d;
        for (int i=0; i<numchildren(p); i++) {
            stack.push(children(p).getAtIndex(i));
            depth.push(d + 1);
        }

    }
    return max;
}
```