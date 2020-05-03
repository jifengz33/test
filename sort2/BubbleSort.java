package com.sort2;

import java.util.Arrays;

/**
 * @author
 * @date 2020-01-04 14:36
 */
public class BubbleSort {


    public static void main(String[] args) {
        int arr[] = {20, 30, 90, 40, 70, 110, -1, 60, 10, 100, 50, 80,2};
        //int arr[] = {1,2,7,3,4,5,6};
        bubbleSort(arr);

        System.out.println("排序后=" + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i=0; i<arr.length-1; i++){
            boolean flag = false;
            for(int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                   temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                   flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
