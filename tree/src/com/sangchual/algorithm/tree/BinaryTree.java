package com.sangchual.algorithm.tree;

import java.util.Optional;

public class BinaryTree<T extends Comparable<T>> {
    Node<T> root = null;

    public Node<T> getRoot() {
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
        Node<T> node = search(value);
        if(node != null) {
            Node<T> parent = getParent(value);

            if(isLeaf(node)) {
                if(parent != null) {
                    if(parent.getValue().compareTo(node.getValue()) > 0) {
                        parent.deleteLeft();
                    } else {
                        parent.deleteRight();
                    }
                } else { // only root node has the null parent.
                    root = null;
                }
            } else if(hasBoth(node)) {
                Node<T> minChild = getMinimum(node.getRight()); // smallest descendant
                minChild.addToLeft(node.getLeft());
                minChild.addToRight(node.getRight());

                if(parent.compareTo(minChild) > 0) {
                    parent.addToLeft(minChild);
                } else {
                    parent.addToRight(minChild);
                }

                getParent(node.getValue()).deleteLeft();
            } else {
                Node<T> child = node.hasLeft() ? node.getLeft() : node.getRight();
                parent.repalce(child);
            }
            node = null; // assign null to be released by GC
        } else {
            throw new IllegalArgumentException(String.format("%s does not exists in the tree.", value));
        }
    }

    private Node<T> getMinimum(Node<T> node) {
        if(node != null) {
            Node<T> curr = node;
            while(curr.getLeft() != null) {
                curr = curr.getLeft();
            }
            return curr;
        } else {
            throw new IllegalArgumentException("null node is not allowed.");
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

    public Node<T> getParent(T value) {
        return getParent(null, root, value);
    }

    public Node<T> getParent(Node<T> parent, Node<T> node, T value){
        if(node == null) {
            return null;
        }

        if(node.getValue().compareTo(value) == 0) {
            return parent;
        }
        else if(node.getValue().compareTo(value) > 0) {
            return getParent(node, node.getLeft(), value);
        }
        else {
            return getParent(node, node.getRight(), value);
        }
    }

    public Node<T> search(T value) {
        return search(root, value);
    }

    private Node<T> search(Node<T> node, T value) {
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
