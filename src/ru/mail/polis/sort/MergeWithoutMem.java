package mail.polis.sort;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeWithoutMem {
    static void mergeG(int a[], int n, int st1, int st2, int st3) {
        swapG(a, n, st1, st3);
        int take1 = 0;
        int take2 = 0;
        for (int i = 0; i < 2 * n; i++) {
            if ((take2 == n) || ((take1 < n) && (a[take1 + st3] < a[take2 + st2]))) {
                int t = a[st1 + i];
                a[st1 + i] = a[take1 + st3];
                a[take1 + st3] = t;
                take1++;
            } else {
                int t = a[st1 + i];
                a[st1 + i] = a[take2 + st2];
                a[take2 + st2] = t;
                take2++;
            }
        }
    }

    static public int[] retArr(int[] a){
        //int cnt = 20;
        //int Arr[] = {1,1,2,6,9,12,13,4,5,6,10,11,13,21,50,45,31,11,22,33};
        sort(a);
        return a;
    }

    // сортировка выбором
    static void slowsort(int a[], int st, int en) {
        for (int i = st; i < en; i++)
            for (int j = i + 1; j < en; j++) {
                if (a[i] > a[j]) {
                    int k = a[i];
                    a[i] = a[j];
                    a[j] = k;
                }
            }
    }


    // обмен местами двух групп елементов одинакового размера
    static void swapG(int a[], int n, int st1, int st2) {
        for (int i = 0; i < n; i++) {
            int k = a[st1 + i];
            a[st1 + i] = a[st2 + i];
            a[st2 + i] = k;
        }
    }


    //слияние
    static void merge(int[] a, int n) {
        if (n <= 16) {
            slowsort(a, 0, n);
            return;
        }
        int sizeG = (int) Math.sqrt(n);
        int rem = n % sizeG;
        int numberGrp = n / sizeG - 1;
        int pos = 0;
        while ((pos < sizeG * numberGrp) && (a[pos] <= a[pos + 1]))
            pos++;
        swapG(a, sizeG, numberGrp * sizeG, pos - pos % sizeG);
        rem += sizeG;
        for (int i = 0; i < numberGrp - 1; i++) {
            int minnum = i;
            for (int j = i + 1; j < numberGrp; j++)
                if ((a[j * sizeG] < a[minnum * sizeG])
                        || ((a[j * sizeG] == a[minnum * sizeG])
                        && (a[(j + 1) * sizeG - 1] < a[(minnum + 1) *sizeG-1])))
                    minnum = j;
            swapG(a, sizeG, i * sizeG, minnum * sizeG);
        }
        for (int i = 0; i < numberGrp - 1; i++) {
            mergeG(a, sizeG, i * sizeG, (i + 1) * sizeG, numberGrp * sizeG);
        }
        slowsort(a, n - 2 * rem, n);
        for (int i = n - 2 * rem; i >= rem; i -= rem)
            mergeG(a, rem, i - rem, i, n - rem);

        slowsort(a, 0, 2 * rem);
        slowsort(a, n - rem, n);
    }

    // сортировка
    static void sort(int[] a) {
        int n = a.length;
        for (int stp2 = 1; stp2 <= n; stp2 *= 2)
            for (int i = 0; i < n; i += stp2) {
                int size = Math.min(n, i + stp2) - i;
                swapG(a, size, 0, i);      // для удобства реализации перемещаем
                merge(a, size);                // требуемый кусок масcива в начало
                swapG(a, size, 0, i);      // там его сортируем и возвращаем обратно
            }
        if (n > 16)
            merge(a, n);
    }

    void run() throws IOException {
        //for (int i = 0; i < 10; i++) {
        //    testsort();
        //}
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String[] str = in.nextLine().split(" ");
        int[] mas = new int[str.length];
        for (int i = 0; i < str.length; i++)
            mas[i] = Integer.parseInt(str[i]);

        sort(mas);

        for (int i = 0; i < mas.length; i++) {
            pw.print(mas[i] + " ");
        }
        pw.flush();
    }


    public static void main(String[] args) throws IOException {
        new MergeWithoutMem().run();
    }
}