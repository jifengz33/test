package com.sort;

import java.util.Arrays;

/**
 * @author
 * @date 2019-12-30 14:36
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {20,3,9, 9, 100,-1, 10, 5};

		System.out.println("排序前");
		System.out.println(Arrays.toString(arr));

        //测试冒泡排序
        bubbleSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    // 将前面额冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr) {
        int temp ;
        for (int i = 0;i < arr.length-1; i++){
            boolean flag = false; // 标识变量，表示是否进行过交换
            for (int j = 0; j< arr.length - 1 -i;j++){
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            }

        }

    }
}
