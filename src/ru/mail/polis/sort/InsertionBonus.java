package mail.polis.sort;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by dysha on 21.11.2016.
 */
//Сортировка вставками + random для опорного + разделение на 3 части
public class InsertionBonus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String[] str = in.nextLine().split(" ");
        int[] mas = new int[str.length];
        for (int i = 0; i < str.length; i++)
            mas[i] = Integer.parseInt(str[i]);

        int[] sorted = retArr(mas);
        for (int i: sorted)
            pw.print(i + " ");
        pw.flush();
    }

    public static int[] retArr(int[] a){
        a = insertionSort(a, a.length);
        return a;
    }

    static int binarySearch(int a[], int item, int low, int high)
    {
        if (high <= low)
            return (item > a[low])? (low + 1): low;
        int mid = (low + high)/2;
        if(item == a[mid])
            return mid+1;
        if(item > a[mid])
            return binarySearch(a, item, mid+1, high);
        return binarySearch(a, item, low, mid-1);
    }

    // Function to sort an array a[] of size 'n'
    static int[] insertionSort(int a[], int n)
    {
        int[] b = new int[n];
        int sizeB = 1; b[0] = a[0];
        int i, loc, j, k, selected, lowG = 0;

        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = a[i];
            loc = binarySearch(b, selected, 0, sizeB);
            while (j >= loc) {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1] = selected;
            sizeB++;
        }
        return b;
    }
}