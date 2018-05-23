package com.sangchual.algorithm.tree;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private final T value;
    private Node left = null;
    private Node right = null;
    private Node parent = null;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> parent) {
        this(value);
        this.parent = parent;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this(value);
        this.left = left;
        this.right = right;
    }

    public Node(T value, Node<T> left, Node<T> right, Node<T> parent) {
        this(value, left, right);
        this.parent = parent;
    }

    public T getValue()  {
        return value;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
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

    public void repalce(Node child) {
        if(child.compareTo(this) > 0) {
            right = child;
            child.setParent(this);
        } else if(child.compareTo(this) < 0) {
            left = child;
            child.setParent(this);
        }
    }

    public void addToLeft(Node<T> child) {
        if(child.compareTo(this) < 0) {
            this.left = child;
        } else {
            throw new IllegalArgumentException("invalid node");
        }
    }

    public void addToRight(Node<T> child) {
        if(child.compareTo(this) > 0) {
            this.right = child;
        } else {
            throw new IllegalArgumentException("invalid node");
        }
    }

    public Node<T> deleteLeft() {
        if(this.left != null) {
            Node<T> deleted = new Node<>(this.left.getValue());
            this.left = null;
         return deleted;
        }
        return null;
    }

    public Node<T> deleteRight() {
        if(this.right != null) {
            Node<T> deleted = new Node<>(this.right.getValue());
            this.right = null;
            return deleted;
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

    @Override
    public int compareTo(Node<T> o) {
        return this.value.compareTo(o.value);
    }
}
