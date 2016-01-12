package com.ethan.algorithm.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethan on 2016-01-11.
 */
public class BSTPath {

    public static void main(String[] args) {
        Node root = AppMain.buidTree1() ;
        BSTPath.path1(root, 3, 13);
        System.out.println("");
        BSTPath.path1(root, 3, 59);
        System.out.println("");
        BSTPath.path1(root, 24, 48);
        System.out.println("");
        BSTPath.path1(root, 8, 13);
        System.out.println("");
    }

    public static void path1(Node root, Integer v1, Integer v2)  {
        List<Node> set1 = new ArrayList<>() ;
        List<Node> set2 = new ArrayList<>() ;

        findPath(root, v1, set1) ;
        findPath(root, v2, set2) ;

        Node commonLeast = null ;

        for(int i = set1.size() - 1; commonLeast == null && i >= 0; i--) {
            System.out.print(set1.get(i).getValue() + "\t") ;
            if(contains(set2, set1.get(i).getValue())) {
                commonLeast = set1.get(i) ;
            }
        }

        for(int i = indexOf(set2, commonLeast.getValue()) + 1; i < set2.size(); i ++) {
            System.out.print(set2.get(i).getValue() + "\t") ;
        }

    }

    private static int indexOf(List<Node> set, Integer value) {
        int index = -1 ;

        for(int i = 0 ; index == -1 && i < set.size(); i++) {
            if(set.get(i).getValue() == value) {
                index = i ;
            }
        }

        return index ;
    }

    private static boolean contains(List<Node> set, Integer value) {
        if(set == null) return false ;

        boolean found = false ;
        for(int i = 0 ; !found && i < set.size(); i++) {
            if(set.get(i).getValue() == value) {
                found = true ;
            }
        }

        return found ;
    }

    public static boolean findPath(Node node, Integer v, List<Node> path) {
        if(node == null) return false ;

        path.add(node) ;

        if(node.getValue() == v) {
            return true ;
        }

        if(v < node.getValue()) {
            return findPath(node.getLeft(), v, path) ;
        }
        else {
            return findPath(node.getRight(), v, path) ;
        }
    }

}
