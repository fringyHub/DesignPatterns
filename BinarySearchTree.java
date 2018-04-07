package com.company;

import java.util.LinkedList;
import java.util.List;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.right = this.left = null;
    }
}

public class BinarySearchTree {
    private Node root;
    public BinarySearchTree() { root = null; }

    void insert(int data) { root = insert(root, data); }

    private Node insert(Node root, int data) {
        if(root == null) {
            root = new Node(data);
        } else {
            if (data < root.data) root.left = insert(root.left, data);
            else if (data > root.data) root.right = insert(root.right, data);
        }
        return root;
    }

    void inOrder() { inOrder(root);}

    private void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }


    void levelOrder() {
        if(root == null) return;

        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        list.add(null);

        while(!list.isEmpty()) {
            Node temp = list.removeFirst();
            if(temp == null) {
                if(!list.isEmpty())
                    list.add(null);
                System.out.println();

            } else {
                System.out.print(temp.data + " ");
                if(temp.left != null) list.add(temp.left);
                if(temp.right != null) list.add(temp.right);
            }
        }
    }

    void printPath() { printPath(root, new int[100], 0);}

    void printPath(Node root, int path[], int current) {
        if(root == null) return;

        path[current] = root.data;
        current++;

        if(root.left == null && root.right == null) {
            for(int i = 0; i < current; i++) System.out.print(path[i] + " ");
            System.out.println();
        } else {
            printPath(root.left, path, current);
            printPath(root.right, path, current);
        }
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(3);
        bst.insert(18);
        bst.insert(5);
        bst.insert(1);

        //bst.inOrder();
        //bst.levelOrder();
        bst.printPath();
    }
}
