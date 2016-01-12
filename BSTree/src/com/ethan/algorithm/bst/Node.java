package com.ethan.algorithm.bst;

/**
 * Created by Ethan on 2016-01-11.
 */
public class Node implements Comparable<Node> {
    private Node left = null ;
    private Node right = null ;
    private Integer value ;

    public Node(Integer value) {
        this.value = value ;
    }

    public Node(Integer value, Node left, Node right) {
        this.value = value ;
        this.left = left ;
        this.right = right ;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getValue() {
        return value ;
    }

    public void setValue(Integer value) {
        this.value = value ;
    }

    @Override
    public int compareTo(Node o) {
        return value - o.getValue() ;
    }
}
