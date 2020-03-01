package com.binarysorttree2;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.lang.model.element.VariableElement;

/**
 * @author
 * @date 2020-01-06 13:04
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.createBinarySortTree(arr);
        binarySortTree.inOrder(); binarySortTree.delNode(12);
//

//
        //binarySortTree.delNode(2);
//        binarySortTree.delNode(10);
//        //binarySortTree.delNode(2);
//        //binarySortTree.delNode(3);
//
        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(7);

        System.out.println("删除后");
        System.out.println("root=" + binarySortTree.root);
        binarySortTree.inOrder();

    }

}

class BinarySortTree {

    Node root;

    public Node search(int value) {
        if (root != null) {
            return root.search(value);
        } else {
            return null;
        }
    }

    //查找父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value) {
        Node targetNode = search(value);
        if (targetNode == null) {
            System.out.println("没有该节点");
            return;
        }
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        Node parentNode = searchParent(value);
        //叶子节点
        if (targetNode.left == null && targetNode.right == null) {
            if (parentNode.left == targetNode) {
                parentNode.left = null;
            } else if (parentNode.right == targetNode) {
                parentNode.right = null;
            }
            //删除有两个子树的节点
        } else if (targetNode.left != null && targetNode.right != null) {
            int minVal = delRightTreeMin(targetNode.right);
            targetNode.value = minVal;
            //删除只有一个子树的节点
        } else {
            if (targetNode.left != null) {
                if (parentNode != null) {
                    if (parentNode.left == targetNode) {
                        parentNode.left = targetNode.left;
                    } else {
                        parentNode.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }
            } else {
                if (parentNode != null) {
                    if (parentNode.left == targetNode) {
                        parentNode.left = targetNode.right;
                    } else {
                        parentNode.right = targetNode.right;
                    }
                } else {
                    root = targetNode.right;
                }
            }
        }

    }


    public void createBinarySortTree(int[] arr) {
        for (int value : arr) {
            if (root == null) {
                root = new Node(value);
            } else {
                root.add(new Node(value));
            }
        }
    }

    public void inOrder() {
        if (root == null) {
            System.out.println("链表为空");
        } else {
            root.inOerder();
        }
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void inOerder() {
        if (this.left != null) {
            this.left.inOerder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inOerder();
        }
    }


    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    public Node search(int value) {
        if (this.value == value) {
            return this;
        }
        if (value < this.value && this.left != null) {
            return this.left.search(value);
        } else if (value >= this.value && this.right != null) {
            return this.right.search(value);
        } else {
            return null;
        }
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}