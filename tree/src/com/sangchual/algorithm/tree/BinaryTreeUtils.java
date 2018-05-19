package com.sangchual.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeUtils {
    public static void travelBFS(BinaryTree tree) {
        Node node = tree.getRoot();
        Queue<Node> queue = new LinkedList<Node>() ;

        if(node != null) {
            queue.add(node);
            while(!queue.isEmpty()) {
                Node curr = queue.poll();
                if(curr.hasLeft()) queue.add(curr.getLeft());
                if(curr.hasRight()) queue.add(curr.getRight());
                System.out.print(curr.getValue().toString() + " - ");
            }
        }
    }

    public static void travelDFS(BinaryTree tree) {
        Node node = tree.getRoot();
        Stack<Node> stack = new Stack<Node>() ;

        if(node != null) {
            stack.push(node);
            while(!stack.isEmpty()) {
                Node curr = stack.pop();
                if(curr.hasLeft()) stack.add(curr.getLeft());
                if(curr.hasRight()) stack.add(curr.getRight());
                System.out.print(curr.getValue().toString() + " - ");
            }
        }
    }

    public static int travelBFS(Node node, int depth) {
        if(node != null) {
            System.out.print(node.getValue() + "  ");
            int leftDepth = travelBFS(node.getLeft(), ++depth);
            int rightDepth = travelBFS(node.getRight(), ++depth);
            System.out.println("");
            return leftDepth > rightDepth ? leftDepth : rightDepth;
        } else {
            return depth;
        }
    }

    public static int travelBFS2(Node node, int depth) {
        if(node != null) {
            System.out.println("");
            int leftDepth = travelBFS2(node.getLeft(), ++depth);
            int rightDepth = travelBFS2(node.getRight(), ++depth);
            System.out.print(node.getValue() + "  ");
            return leftDepth > rightDepth ? leftDepth : rightDepth;
        } else {
            return depth;
        }

    }

    public static void printTree(BinaryTree tree) {
        Node node = tree.getRoot();
        Stack<Node> stack = new Stack<Node>() ;

        if(node != null) {
            stack.push(node);
            while(!stack.isEmpty()) {
                Node curr = stack.pop();
                System.out.printf("[%s] - L(%s) - R(%s)\n", curr.getValue().toString(),
                        curr.hasLeft() ? curr.getLeft().getValue().toString() : "_",
                        curr.hasRight() ? curr.getRight().getValue().toString() : "_");
                if(curr.hasLeft()) stack.add(curr.getLeft());
                if(curr.hasRight()) stack.add(curr.getRight());
            }
        }
    }

}
