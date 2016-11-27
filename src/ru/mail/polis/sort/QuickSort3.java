package mail.polis.sort;

import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class QuickSort3 {
    static int i;
    static int j;
    static void partition(int a[], int l, int r)
    {
        i = l-1;
        j = r;
        int p = l-1, q = r;
        int v = a[r];

        while (true) {
            while (a[++i] < v);
            while (v < a[--j])
                if (j == l)
                    break;
            if (i >= j) break;
            swap(a, i, j);
            if (a[i] == v) {
                p++;
                swap(a, p, i); }
            if (a[j] == v) {
                q--;
                swap(a, j, q); } }
        swap(a, i, r);
        j = i-1;
        for (int k = l; k < p; k++, j--)
            swap(a, k, j);
        i = i+1;
        for (int k = r-1; k > q; k--, i++)
            swap(a, i, k);
    }

    // 3-way partition based quick sort
    private static void quicksort(int a[], int l, int r) {
        if (r <= l) return;
        partition(a, l, r);
        quicksort(a, l, j);
        quicksort(a, i, r);
    }

    public static int[] quicksortEnter(int a[]) {
        quicksort(a, 0, a.length-1);
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(int[] a) {
        PrintWriter pw = new PrintWriter(System.out);
        for (int g = 0; g < a.length; g++) {
            pw.print(a[g] + " ");
        }
        pw.flush();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] mas = new int[str.length];
        for (int i = 0; i < str.length; i++)
            mas[i] = Integer.parseInt(str[i]);
        int[] sorted = quicksortEnter(mas);
        show(sorted);
    }

}