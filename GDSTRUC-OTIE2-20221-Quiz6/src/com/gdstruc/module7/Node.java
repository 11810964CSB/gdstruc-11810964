package com.gdstruc.module7;

public class Node {
    private int data;
    private Node rightChild;
    private Node leftChild;

    public Node(int _data) {
        data = _data;
    }

    public void insert(int value) {
        if (value == data) {
            return;
        }

        if (value < data) {     // left subtree
            if (leftChild == null) {
                leftChild = new Node(value);
            }
            else {
                leftChild.insert(value);
            }
        }
        else {                  // right subtree
            if (rightChild == null) {
                rightChild = new Node(value);
            }
            else {
                rightChild.insert(value);
            }
        }
    }

    public void traverseInOrder() {
        // left subtree
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }

        // print current node (root or subtree)
        System.out.println("Data: " + data);

        // right subtree
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }
    public void traverseDesc() {
        // 11810964: just switched the left subtree and right subtree code order to traverse descending
        // right subtree
        if (rightChild != null) {
            rightChild.traverseDesc();
        }
        // print current node (root or subtree)
        System.out.println("Data: " + data);

        // left subtree
        if (leftChild != null) {
            leftChild.traverseDesc();
        }
    }
   //
        // 11810964: forgive me but i am too weak to actually implement this code..
        // 11810964: what I do know is that in pseudocode terms you'd just get the leftChild of the leftChild endlessly until leftChild is null
        // 11810964: same goes for getMax(), get rightChild until rightChild returns null
   //
   public Node getMin() {
       if (leftChild.getLeftChild() != null) {
           leftChild.setLeftChild(leftChild.getLeftChild());
           return leftChild.getMin();
       }
        return leftChild;
   }
    public Node getMax() {
        if (rightChild.getRightChild() != null) {
            rightChild.setRightChild(rightChild.getRightChild());
            return rightChild.getMax();
        }
        return rightChild;
    }
    public Node get(int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            if (leftChild != null) {
                return  leftChild.get(value);
            }
        }
        else {
            if (rightChild != null) {
                return  rightChild.get(value);
            }
        }

        return null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
