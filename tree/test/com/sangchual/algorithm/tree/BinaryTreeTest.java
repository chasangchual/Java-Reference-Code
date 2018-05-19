package com.sangchual.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void search_root() throws Exception {
        BinaryTree<Integer> tree = BinaryTreeBuilder.getTree2();
        Node node = tree.search(7);
        assertEquals(7, node.getValue());
        assertEquals(6, node.getLeft().getValue());
        assertEquals(8, node.getRight().getValue());
        assertNull(node.getParent());
    }

    @Test
    public void search_two_children() throws Exception {
        BinaryTree<Integer> tree = BinaryTreeBuilder.getTree2();
        Node node = tree.search(11);
        assertEquals(11, node.getValue());
        assertEquals(10, node.getLeft().getValue());
        assertEquals(12, node.getRight().getValue());
        assertEquals(8, node.getParent().getValue());
    }

    @Test
    public void search_one_child() throws Exception {
        BinaryTree<Integer> tree = BinaryTreeBuilder.getTree2();
        Node node = tree.search(10);
        assertEquals(10, node.getValue());
        assertEquals(9, node.getLeft().getValue());
        assertNull(node.getRight());
        assertEquals(11, node.getParent().getValue());
    }

    @Test
    public void search_leaf() throws Exception {
        BinaryTree<Integer> tree = BinaryTreeBuilder.getTree2();
        Node node = tree.search(1);
        assertEquals(1, node.getValue());
        assertNull(node.getLeft());
        assertNull(node.getRight());
        assertEquals(2, node.getParent().getValue());
    }

    @Test
    public void search_fail() throws Exception {
        BinaryTree<Integer> tree = BinaryTreeBuilder.getTree2();
        Node node = tree.search(120);
        assertNull(node);
    }

    @org.junit.Test
    public void add() throws Exception {
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
    }
}