package com.ethan.algorithm.bst;

/**
 * Created by Ethan on 2016-01-11.
 */
public class AppMain {
    public static void main(String[] args) {
        AppMain app = new AppMain() ;
        Node root = app.buidTree1() ;
    }

    public Node buidTree1() {
        Node root = new Node(17, new Node(7,  new Node(5,  new Node(3), new Node(6)),
                                              new Node(10, new Node(8), new Node(13))),
                                 new Node(34, new Node(24), new Node(42, null, new Node(59, new Node(48), null)))) ;
        Node left = new Node(3) ;
        Node right = new Node(6) ;
        Node node = new Node(5) ;
        node.setLeft(left);
        node.setRight(right);

        return root ;
    }
}
