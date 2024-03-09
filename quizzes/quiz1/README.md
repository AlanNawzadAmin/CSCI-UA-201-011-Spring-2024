# Quiz 1 (Recitation 3)

## Problem Prompt

Imagine we created IntegerDoublyLinkedList, a class with all the same attributes and methods as DoublyLinkedList, but with elements that must be integers. Recall that the attributes of DoublyLinkedList are Node header, Node trailer, int size, and the methods of Node are Node getNext(), Node getPrev(), void setNext(Node node), void setPrev(Node node).

1. Write a method for IntegerDoublyLinkedList, "public void maxToFront()" that finds the node with the largest integer and brings it to the first position in the list. If the list is empty, do nothing. Avoid using the methods remove and addBetween -- explicitly change the prev and next attributes of nodes yourself. (8 points)

2. If N is the size of the list, what is the worst case asymptotic complexity of this method? Briefly explain your reasoning. (2 points)

## Reference Solutions

```java
public void maxToFront() {
    // If the size is less than 2, do nothing
    if (size < 2) return;

    // Step 1: find the maximum element
    Node max, current;
    max = header.next();
    current = max.next();
    for (int i=0; i<size-1; i++) {
        if (current.getElement() > max.getElement()) {
            current = max;
        }
    }

    // Step 2: swap
    max.getPrev().setNext(max.getNext());
    max.getNext().setPrev(max.getPrev());
    max.setNext(header.next());
    header.next().setPrev(max);
    max.setPrev(header);
    header.setNext(max);
}
```

The worst case (actually also the best case) asymptotic complexity is $O(N)$ since the algorithm needs to iterate through the whole linked list to find the maximum element. Step 2 is just $O(1)$.

## Rubrics

Corner case: 1pt

Finding the maximum element: 4pt

Swapping nodes: 3pt (0.5pt for each link)

## Common errors

1. Initialization: some students store an integer to store the maximum value, which is fine. But it is incorrect to initialize the variable to be 0, because maybe the whole linked list is less than 0.
2. Node ≠ Int. Pay attention to the variable type. Integer doesn’t have “getElement()”.

## Statistics

Mean: 6

Median: 6.5

Maximum: 10