package com.sangchual.algorithm.tree;

public class BinaryTreeBuilder {
    public static BinaryTree getTree1() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(new Node<Integer>(1));
        tree.add(new Node<Integer>(2));
        tree.add(new Node<Integer>(3));
        tree.add(new Node<Integer>(4));
        tree.add(new Node<Integer>(5));
        tree.add(new Node<Integer>(6));
        tree.add(new Node<Integer>(7));
        tree.add(new Node<Integer>(8));
        tree.add(new Node<Integer>(9));
        tree.add(new Node<Integer>(10));
        tree.add(new Node<Integer>(11));
        tree.add(new Node<Integer>(12));
        tree.add(new Node<Integer>(13));
        tree.add(new Node<Integer>(14));

        return tree;
    }

    public static BinaryTree getTree2() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(new Node<Integer>(7));
        tree.add(new Node<Integer>(6));
        tree.add(new Node<Integer>(8));
        tree.add(new Node<Integer>(4));
        tree.add(new Node<Integer>(5));
        tree.add(new Node<Integer>(11));
        tree.add(new Node<Integer>(10));
        tree.add(new Node<Integer>(2));
        tree.add(new Node<Integer>(3));
        tree.add(new Node<Integer>(12));
        tree.add(new Node<Integer>(9));
        tree.add(new Node<Integer>(1));
        tree.add(new Node<Integer>(13));
        tree.add(new Node<Integer>(14));

        return tree;
    }
}
