package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author
 * @date 2019-12-31 0:35
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {10,15, 8, 9,20, 1, 7, 2, 3, 5,12,56,45,10, 4, 6, 0 };

        shellSort2(arr);//移位方式

        System.out.println(Arrays.toString(arr));

//        // 创建要给80000个的随机的数组
//        int[] arr = new int[10000000];
//        for (int i = 0; i < 10000000; i++) {
//            arr[i] = (int) (Math.random() * 10000000); // 生成一个[0, 8000000) 数
//        }
//
//        System.out.println("排序前");
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);
//
//        //shellSort(arr); //交换式
//        shellSort2(arr);//移位方式
//
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是=" + date2Str);
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort1(int[] arr) {

        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {

        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++){
                int temp = arr[i];
                int k = i - gap;
                while (k >=0 && temp < arr[k]){
                    arr[k+gap] = arr[k];
                    k -= gap;
                }
                arr[k+gap] = temp;
            }
        }
    }











//    //对交换式的希尔排序进行优化->移位法
//    public static void shellSort2(int[] arr) {
//
//        // 增量gap, 并逐步的缩小增量
//        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//
//            int j;
//            int temp;
//            // 从第gap个元素，逐个对其所在的组进行直接插入排序
//            for (int i = gap; i < arr.length; i++) {
//                temp = arr[i];
//                j = i - gap;
//                while (j >= 0 && temp < arr[j]) {
//                    //移动
//                    arr[j + gap] = arr[j];
//                    j -= gap;
//                }
//                //当退出while后，就给temp找到插入的位置
//                arr[j + gap] = temp;
//
//
//            }
//        }
//    }

}



