package com.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args){

        int[] arr = {0,6,1,2,7,9,19,200,11,4,5,10,8,15,-1,100};

        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr,int start,int end){
       if (start > end){
           return ;
       }
       int i = start;
       int j = end;
       int pivot = arr[start];
       int temp;
       while (i < j){
           while (pivot<=arr[j] && i<j){
               j--;
           }
           while (pivot>=arr[i] && i<j){
               i++;
           }
           if (i < j){
               temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
           }
       }
       arr[start] = arr[i];
       arr[i] = pivot;
       quickSort(arr,start,i-1);
       quickSort(arr,i+1,end);
    }





//    public static void quickSort(int[] arr,int start,int end){
//        if(start>end){
//            return;
//        }
//        int i,j,pivot,temp;
//        i=start;
//        j=end;
//        //pivot就是基准位
//        pivot = arr[start];
//        while (i<j){
//            //先看右边，依次往左递减
//            while (pivot<=arr[j]&&i<j){
//                j--;
//            }
//            //再看左边，依次往右递增
//            while (pivot>=arr[i]&&i<j){
//                i++;
//            }
//            //如果满足条件则交换
//            if (i<j){
//                temp=arr[j];
//                arr[j]=arr[i];
//                arr[i]=temp;
//            }
//        }
////        System.out.println(i==j);
//        //最后将基准为与i和j相等位置的数字交换
//        arr[start] = arr[i];
//        arr[i] = pivot;
//        //递归调用左半数组
//        quickSort(arr, start, i-1);
//        //递归调用右半数组
//        quickSort(arr, i+1, end);
//    }

}
