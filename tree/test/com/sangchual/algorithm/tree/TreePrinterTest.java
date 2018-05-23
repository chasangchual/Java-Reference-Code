package com.sangchual.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreePrinterTest {

    @Test
    public void printNode() {
        BinaryTree tree = BinaryTreeBuilder.getTree2();
        TreePrinter.printNode(tree);
    }
}