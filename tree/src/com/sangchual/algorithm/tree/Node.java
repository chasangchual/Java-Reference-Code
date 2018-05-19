package com.sangchual.algorithm.tree;

import java.util.Optional;

public class Node<T extends Comparable<T>> implements Comparable{
    private final T value;
    private Node left = null;
    private Node right = null;
    private Node parent = null;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> parent) {
        this.value = value;
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }


    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    @Override
    public int compareTo(Object obj) {
        if(obj instanceof Node) {
            T value = (T)((Node) obj).value;
            return this.value.compareTo(value);
        } else {
            throw new IllegalArgumentException("only Node object is allowed");
        }
    }

    public void add(Node child) {
        if(child.compareTo(this) > 0) {
            if(right == null) {
                right = child;
                child.setParent(this);
            } else {
                throw new IllegalArgumentException("child already allocated.");
            }
        } else if(child.compareTo(this) < 0) {
            if(left == null) {
                left = child;
                child.setParent(this);
            } else {
                throw new IllegalArgumentException("child already allocated.");
            }
        }
    }

    public Node<T> deleteLeft() {
        if(this.left != null) {
         return new Node<>(this.left.getValue());
        }
        return null;
    }

    public Node<T> deleteRight() {
        if(this.right != null) {
            return new Node<>(this.right.getValue());
        }
        return null;
    }

    public void deleteChildren() {
        deleteLeft();
        deleteRight();
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }
}
