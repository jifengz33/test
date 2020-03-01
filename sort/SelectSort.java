package com.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author
 * @date 2019-12-30 15:15
 */
public class SelectSort {
    public static void main(String[] args) {
//        int arr[] = {20,3,9, -1, 9,10, 5};
//
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//
//        //测试选择排序
//        selectSort(arr);
//
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

        int arr2[] = {20,3,9, -1, 9,10, 5};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr2));


        selectSort(arr2);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr2));



    }

    public static void test(int[] arr) {
        for (int i = 0; i <arr.length-1; i++){
            arr[i+1] = arr[i];
        }
    }

    public static void selectSort(int[] arr) {

        for (int i = 0; i <arr.length-1; i++){
            int minIndex = i;
            int minValue = arr[i];
            for (int j = i+1; j< arr.length;j++){
                if (minValue > arr[j]){
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }
}
