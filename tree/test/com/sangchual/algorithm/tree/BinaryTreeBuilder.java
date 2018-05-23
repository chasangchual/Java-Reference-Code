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

    public static BinaryTree getTree3() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(new Node<Integer>(25));
        tree.add(new Node<Integer>(12));
        tree.add(new Node<Integer>(37));
        tree.add(new Node<Integer>(6));
        tree.add(new Node<Integer>(18));
        tree.add(new Node<Integer>(4));
        tree.add(new Node<Integer>(10));
        tree.add(new Node<Integer>(15));
        tree.add(new Node<Integer>(21));
        tree.add(new Node<Integer>(1));

        tree.add(new Node<Integer>(30));
        tree.add(new Node<Integer>(42));
        tree.add(new Node<Integer>(28));
        tree.add(new Node<Integer>(35));
        tree.add(new Node<Integer>(32));
        tree.add(new Node<Integer>(39));
        tree.add(new Node<Integer>(38));
        tree.add(new Node<Integer>(40));
        tree.add(new Node<Integer>(50));
        tree.add(new Node<Integer>(31));

        return tree;
    }
}
