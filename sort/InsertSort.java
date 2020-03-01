package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author
 * @date 2019-12-30 16:35
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 35, 5, 50, 20, 1000, 500, 1};
        // 创建要给80000个的随机的数组


        System.out.println("插入排序前");
        System.out.println(Arrays.toString(arr));
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);

        insertSort(arr); //调用插入排序算法
        System.out.println(Arrays.toString(arr));
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是=" + date2Str);

        //System.out.println(Arrays.toString(arr));


    }

    //插入排序 {34, 101, 119, 110};
//    public static void insertSort(int[] arr) {
//        int val;
//        int k;
//        for (int i = 1; i < arr.length; i++) {
//            val = arr[i];
//            k = i - 1;
//            while (k >= 0 && val < arr[k]) {
//                arr[k + 1] = arr[k];
//                k--;
//            }
//            arr[k + 1] = val;
//
//        }
//    }





    //插入排序 {101, 34, 119, 35, 5, 50, 20, 1000, 500, 1};
    public static void insertSort(int[] arr) {
        for (int i = 1;i<arr.length;i++){
            int k = i-1;
            int temp = arr[i];
            while (k>=0 && temp < arr[k]){
                arr[k+1] = arr[k];
                k--;
            }
            arr[k+1] = temp;
        }
    }


		/*


		//使用逐步推导的方式来讲解，便利理解
		//第1轮 {101, 34, 119, 1};  => {34, 101, 119, 1}


		//{101, 34, 119, 1}; => {101,101,119,1}
		//定义待插入的数
		int insertVal = arr[1];
		int insertIndex = 1 - 1; //即arr[1]的前面这个数的下标

		//给insertVal 找到插入的位置
		//说明
		//1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
		//2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
		//3. 就需要将 arr[insertIndex] 后移
		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}
		//当退出while循环时，说明插入的位置找到, insertIndex + 1
		//举例：理解不了，我们一会 debug
		arr[insertIndex + 1] = insertVal;

		System.out.println("第1轮插入");
		System.out.println(Arrays.toString(arr));

		//第2轮
		insertVal = arr[2];
		insertIndex = 2 - 1;

		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}

		arr[insertIndex + 1] = insertVal;
		System.out.println("第2轮插入");
		System.out.println(Arrays.toString(arr));


		//第3轮
		insertVal = arr[3];
		insertIndex = 3 - 1;

		while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}

		arr[insertIndex + 1] = insertVal;
		System.out.println("第3轮插入");
		System.out.println(Arrays.toString(arr)); */


}
