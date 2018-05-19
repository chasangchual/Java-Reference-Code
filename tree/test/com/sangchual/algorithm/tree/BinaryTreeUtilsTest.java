package com.sangchual.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeUtilsTest {
    @Test
    public void travel() throws Exception {
        BinaryTree tree = BinaryTreeBuilder.getTree2();
        BinaryTreeUtils.travelBFS(tree);
        System.out.println("");
        BinaryTreeUtils.travelDFS(tree);
    }

    @Test
    public void travelBFS() throws Exception {
        BinaryTree tree = BinaryTreeBuilder.getTree2();
        BinaryTreeUtils.travelBFS(tree.getRoot(), 1);
    }

    @Test
    public void travelBFS2() throws Exception {
        BinaryTree tree = BinaryTreeBuilder.getTree2();
        BinaryTreeUtils.travelBFS2(tree.getRoot(), 1);
    }

    @Test
    public void printTree() throws Exception {
        BinaryTree tree = BinaryTreeBuilder.getTree2();
        BinaryTreeUtils.printTree(tree);
    }
}