package com.sangchual.algorithm.tree;

import java.util.Optional;

public class BinaryTree<T extends Comparable> {
    Node<T> root = null;

    public Node getRoot() {
        return root;
    }

    public void add(T value) {
        add(new Node<T>(value)) ;
    }

    public void add(Node<T> node) {
        if(root != null) {
            addTo(root, node);
        } else {
            root = node;
        }
    }

    private void addTo(Node<T> parent, Node<T> child) {
        if(child.compareTo(parent) > 0) {
            if(parent.hasRight()) {
                addTo(parent.getRight(), child);
            } else {
                parent.add(child);
            }
        } else if(child.compareTo(parent) < 0){
            if(parent.hasLeft()) {
                addTo(parent.getLeft(), child);
            } else {
                parent.add(child);
            }
        }
    }

    public void delete(T value) {
        Node node = search(value);
        if(node != null) {
            if(isLeaf(node)) {
                if(node.getParent() != null) {
                    if(node.getValue().compareTo(node.getParent().getValue()) < 0) {
                    } else {
                    }
                }
            } else if(hasBoth(node)) {

            } else {

            }
        }
    }

    private boolean isLeaf(Node<T> node) {
        if(node != null) {
            return (node.getRight() == null && node.getLeft() == null) ;
        }
        return false;
    }

    private boolean hasBoth(Node<T> node) {
        if(node != null) {
            return (node.getRight() != null && node.getLeft() != null) ;
        }
        return false;
    }

    public Node<T> search(T value) {
        return search(root, value);
    }

    private Node<T> search(Node node, T value) {
        if(node == null) {
            return null ;
        }

        if(node.getValue().compareTo(value) == 0){
            return node;
        } else if (node.getValue().compareTo(value) > 0) {
            return search(node.getLeft(), value);
        } else {
            return search(node.getRight(), value);
        }
    }
}
