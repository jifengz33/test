package com.sort2;

import java.util.Arrays;

/**
 * @author
 * @date 2020-01-11 13:41
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 35, 5, 50, 20, 1000, 500, 1};
        insertSort(arr); //调用插入排序算法
        System.out.println(Arrays.toString(arr));
    }

    //插入排序 {101, 34, 119, 35, 5, 50, 20, 1000, 500, 1};
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = i - 1;
            int temp = arr[i];
            while (k >= 0 && temp < arr[k]) {
                arr[k+1] = arr[k];
                k--;
            }
            arr[k+1] = temp;
        }
    }
}
