package com.hashtab;

/**
 * @author
 * @date 2020-01-02 21:00
 */
public class HashTabDemo {
}

//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next; //next 默认为 null

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

class HashTab {
    private EmpLinkedList empLinkedList[];
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedList = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        int index = hashFun(emp.id);
        empLinkedList[index].add(emp);
    }

    //遍历所有的链表,遍历hashtab
    public void list() {
        for(int i = 0; i < size; i++) {
            empLinkedList[i].list(i);
        }
    }

    //根据输入的id,查找雇员
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedList[empLinkedListNO].findEmpById(id);
        if(emp != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    public int hashFun(int id) {
        return id % size;
    }
}

class EmpLinkedList {
    private Emp head; //默认null

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
        }
        Emp cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = emp;
    }

    public void list(int no) {
        if (head == null) { //说明链表为空
            System.out.println("第 " + (no + 1) + " 链表为空");
            return;
        }
        System.out.print("第 " + (no + 1) + " 链表的信息为");
        Emp curEmp = head; //辅助指针
        while (true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp cur = head;
        while (true) {
            if (cur.id == id) {
                break;
            }
            if (cur.next == null) {
                cur = null;
                break;
            }
            cur = cur.next;
        }
        return cur;
    }
}
