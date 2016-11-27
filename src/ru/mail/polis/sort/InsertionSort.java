package polis.sort;

import java.io.PrintWriter;
import java.util.Scanner;
//Обычная сортировка вставками
public class InsertionSort{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] mas = new int[str.length];
        for (int i = 0; i < str.length; i++)
            mas[i] = Integer.parseInt(str[i]);
        insert_sort(mas);
        printArr(mas);
    }

    public static int[] retArr(int[] a){
        insert_sort(a);
        return a;
    }

    public static void insert_sort(int[] arr){
        int key = 0; int i = 0;
        for (int j = 1; j < arr.length; j++) {
            key = arr[j];
            i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i+1] = arr[i];
                i = i - 1;
            }
            arr[i+1] = key;
        }
    }

    public static void printArr(int[] arr){
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i<arr.length; i++)
            pw.print(arr[i] + " ");
        pw.println();
        pw.flush();
    }
}