package com.sangchual.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

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

    public static int getHeight(BinaryTree tree) {
        if(tree.getRoot() != null) {
            int leftDepth = getHeight(tree.getRoot().getLeft(), 1) ;
            int rightDepth = getHeight(tree.getRoot().getRight(), 1) ;
            return leftDepth > rightDepth ? leftDepth : rightDepth;
        } else {
            return 0;
        }
    }

    public static int getHeight(Node node, int depth) {
        if(node == null) {
            return depth+2;
        } else {
            int leftDepth = getHeight(node.getLeft(), depth+1) ;
            int rightDepth = getHeight(node.getRight(), depth+1) ;

            return leftDepth > rightDepth ? leftDepth : rightDepth;
        }
    }

    public static void printPrettyTree(BinaryTree tree) {
        int height = getHeight(tree);

        for( int  i = 0; i < height; i++) {
            printLevel(tree.getRoot(), i, height);
            System.out.println();
        }
    }

    private static void printLevel(Node node, int level, int height){
        if(node == null)
            return;
        if(level == 0){
            System.out.print(node.getValue()+" ");
        }else{
            printLevel(node.getLeft(), level - 1, height);
            printLevel(node.getRight(), level - 1, height);
        }
    }
}
