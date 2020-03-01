package com.linkedList;

/**
 * @author
 * @date 2019-12-29 13:36
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(3, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(6, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(10, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);


        doubleLinkedList.list();
        System.out.println("------------");

        doubleLinkedList.addByOrder(new HeroNode2(5,"555","55"));
        doubleLinkedList.addByOrder(new HeroNode2(2,"22","2"));
        doubleLinkedList.addByOrder(new HeroNode2(3,"22","2"));

        doubleLinkedList.list();

        //修改
//        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
//        doubleLinkedList.update(newHeroNode);
//        System.out.println("修改后的链表情况");
//        doubleLinkedList.list();

//        // 删除
//        doubleLinkedList.del(3);
//        System.out.println("删除后的链表情况~~");
//        doubleLinkedList.list();



    }

}

// 创建一个双向链表的类
class DoubleLinkedList {

    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no>heroNode.no){
                break;
            }else if (temp.no==heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("准备插入的英雄编号%d 已经存在了, 不能加入\n", heroNode.no);
        } else {
//            heroNode.next = temp.next;
//            temp.next.pre = heroNode;
//            heroNode.pre = temp;
//            temp.next = heroNode;
            heroNode.pre = temp.pre;
            heroNode.next = temp;
            temp.pre.next = heroNode;
            temp.pre = heroNode;

        }

    }

    // 遍历双向链表的方法
    // 显示链表[遍历]
    public void list() {
        if (head.next == null){
            System.out.println("链表为空");
        }
        HeroNode2 temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 添加一个节点到双向链表的最后.
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
    // 只是 节点类型改成 HeroNode2
    public void update(HeroNode2 newHeroNode) {
        // 判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp.no  == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { // 没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }

    }

    // 从双向链表中删除一个节点,
    // 说明
    // 1 对于双向链表，我们可以直接找到要删除的这个节点
    // 2 找到后，自我删除即可
    public void del(int no) {
        // 判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp.no  == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要删除的节点
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        } else { // 没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n",no);
        }
    }

}

// 定义HeroNode2 ， 每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点, 默认为null
    public HeroNode2 pre; // 指向前一个节点, 默认为null
    // 构造器

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}