package polis.sort;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;


/**
 * Created by dysha on 20.11.2016.
 */
//QuickSort с фиксированным выбором элемента
public class QuickSort{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String[] str = in.nextLine().split(" ");
        int[] mas = new int[str.length];
        for (int i = 0; i < str.length; i++)
            mas[i] = Integer.parseInt(str[i]);

        int[] sorted = qSort(mas);
        for (int i: sorted)
            pw.print(i + " ");
        pw.flush();
    }

    public static int[] qSort(int[] arr) {
        qSort(arr, 0, arr.length-1);
        return arr;
    }

    private static void qSort(int[] arr, int left, int right) {
        Random rand = new Random();
        int i = left;
        int j = right;
        int x = arr[(left + right)/2];
        while (i <= j) {
            while (arr[i] < x)
                i++;
            while (arr[j] > x)
                j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;j--;
            }
        }
        if (left<j)
            qSort(arr, left, j);
        if(i<right)
            qSort(arr, i, right);
    }
}
