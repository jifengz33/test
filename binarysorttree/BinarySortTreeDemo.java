package com.binarysorttree;


/**
 * @author
 * @date 2020-01-05 15:17
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.createBinarySortTree(arr);
        binarySortTree.inOrder();

        binarySortTree.delNode(12);
//
//
      binarySortTree.delNode(2);
//        binarySortTree.delNode(10);
//        //binarySortTree.delNode(2);
//        //binarySortTree.delNode(3);
//
        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(7);


        System.out.println("root=" + binarySortTree.getRoot());
        binarySortTree.inOrder();

//        System.out.println("删除结点后");
//        binarySortTree.inOrder();

    }

}

//创建二叉排序树
class BinarySortTree {
    private Node root;

    public Node search(int value) {
        if (root != null) {
            return root.search(value);
        } else {
            return null;
        }
    }

    //编写方法:
    //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
    //2. 删除node 为根结点的二叉排序树的最小结点

    /**
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //去找到targetNode的父结点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
//                if (parent.left != null && parent.left.value == value) {
////                    parent.left = null;
////                } else if (parent.right != null && parent.right.value == value) {
////                    parent.right = null;
////                }
                if (parent.left == targetNode) {
                    parent.left = null;
                } else if (parent.right == targetNode) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) { //删除有两颗子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else { //只有一颗子树的结点
                if (targetNode.left != null) {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
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
        if (root != null) {
            root.inOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }

    public Node getRoot() {
        return root;
    }
}

//创建Node结点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && value < this.value) {
                return this.left.searchParent(value);
            } else if (this.right != null && value >= this.value) {
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

    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inOrder();
        }
    }


}