package com.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        HeroNode node6 = new HeroNode(6, "张三");
        HeroNode node7 = new HeroNode(7, "李四");
        HeroNode node8 = new HeroNode(8, "王五");
        HeroNode node9 = new HeroNode(9, "赵六");
        HeroNode node10 = new HeroNode(10, "田七");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node6);
        node2.setRight(node7);
        node6.setLeft(node8);
        node6.setRight(node9);
        node7.setLeft(node10);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        //binaryTree.preOrder();
        binaryTree.postOrder();
        //HeroNode heroNode = binaryTree.preOrderSearch(50);
        //System.out.println(heroNode);

    }

}

//定义BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除结点
    public void delNode(int no) {
        if(root != null) {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if(root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        }else{
            System.out.println("空树，不能删除~");
        }
    }

    //前序遍历
    public void preOrder(){
        if (root != null){
            root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }
    //中序遍历
    public void inOrder(){
        if (root != null){
            root.inOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }
    //后序遍历
    public void postOrder(){
        if (root != null){
            root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //前序查找
    public HeroNode preSearch(int no) {
        if(root != null) {
            return root.preSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode inSearch(int no) {
        if(root != null) {
            return root.inSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }


}

//先创建HeroNode 结点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //默认null
    private HeroNode right; //默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }

    //递归删除结点
    //1.如果删除的节点是叶子节点，则删除该节点
    //2.如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no) {

        //思路
		/*
		 * 	1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
			2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
			3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
			4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
			5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.

		 */
		if (this.left != null && this.left.no == no){
		    this.left = null;
		    return;
        }

        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        if (this.left != null){
		    this.left.delNode(no);
        }

        if (this.right != null){
            this.right.delNode(no);
        }


    }


    //前序查找
    public HeroNode preSearch(int no){
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preSearch(no);
        }
        return resNode;
    }

    //中序查找
    public HeroNode inSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.inSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resNode = this.right.inSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {

        //判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null) {//说明在左子树找到
            return resNode;
        }

        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if(this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }
        System.out.println("进入后序查找");
        //如果左右子树都没有找到，就比较当前结点是不是
        if(this.no == no) {
            return this;
        }
        return resNode;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void inOrder(){
        if (this.left != null){
            this.left.inOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.inOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
}

//


