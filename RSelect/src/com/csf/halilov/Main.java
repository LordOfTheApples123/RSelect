package com.csf.halilov;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr = getRandomArray();
        System.out.println("Массив: ");
        for (int value : arr) {
            System.out.print(value + ", ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            int[] arr2 = arr.clone();
            System.out.println(i + 1 + " Элемент = " + RSelect(arr2, 0, 9, i));

        }
    }

    private static int[] getRandomArray(){
        Random rnd = new Random();
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = rnd.nextInt(1000);
        }
        return arr;
    }

    public static int RSelect(int[] a, int left, int right, int k) {
        int index = chooseRandomElement(left, right);
        index = partition(a, left, right, index);
        if (k == index) return a[index];
        else if (k > index) return RSelect(a, index + 1, right, k);
        else return RSelect(a, left, index - 1, k);
    }

    private static int chooseRandomElement(int left, int right) {
        Random rnd = new Random();
        return rnd.nextInt(right - left + 1)+left;
    }

    public static int partition(int[] a, int left, int right, int pivot) {
        int pivotValue = a[pivot];
        swap(a, pivot, right);
        int storeIndex = left;
        for (int i = left; i <= right; i++) {
            if (a[i] < pivotValue) {
                swap(a, storeIndex, i);
                storeIndex++;
            }
        }
        swap(a, right, storeIndex);
        return storeIndex;
    }

    public static void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }

}
