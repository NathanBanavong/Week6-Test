package com.example.consultants.week6_test;

import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        int numList[]  = {12,20,9,31,28,54,46,69,46,55,18,2,26,19,7,32,24,99,62,33};
        System.out.println("Given Array");
        System.out.println(numList);

        MergeSort leSort = new MergeSort();
        System.out.println("Sorted Array");
        leSort.sort(numList, 0, numList.length - 1);
    }

    public void merge(int[] numberList, int first, int middle, int last) {


        int num1 = middle - first + 1;
        int num2 = last - middle;

        int list1[] = new int[num1];
        int list2[] = new int[num2];

        for (int x = 0; x < num1; ++x) {
            list1[x] = numberList[first + x];
        }
        for (int y = 0; y < num2; ++y) {
            list2[y] = numberList[middle + 1 + y];
        }

        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = first;
        while (i < num1 && j < num2) {
            if (list1[i] <= list2[j]) {
                numberList[k] = list1[i];
                i++;
            } else {
                numberList[k] = list2[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < num1)
        {
            numberList[k] = list1[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < num2)
        {
            numberList[k] = list2[j];
            j++;
            k++;
        }

        for (int n = 0; n < numberList.length; n++) {
            System.out.print(numberList[n] + " ");
        }

    }

    public void sort(int[] sortInteger, int first, int last) {

        if (first < last) {
            // Find the middle point
            int middle = (first + last) / 2;

            // Sort first and second halves
            sort(sortInteger, first, middle);
            sort(sortInteger, middle + 1, last);

            // Merge the sorted halves
            merge(sortInteger, first, middle, last);
        }
    }

}
