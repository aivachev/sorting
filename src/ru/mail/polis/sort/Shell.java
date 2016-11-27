package polis.sort;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by dysha on 21.11.2016.
 */
public class Shell {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String[] str = in.nextLine().split(" ");
        int[] mas = new int[str.length];
        for (int i = 0; i < str.length; i++)
            mas[i] = Integer.parseInt(str[i]);

        shell(mas);
        for (int i: mas)
            pw.print(i + " ");
        pw.flush();
    }

    public static int[] retArr(int[] a){
        shell(a);
        return a;
    }

    public static void shell(int[] a) {

        int increment = a.length / 2;
        while (increment > 0) {
            for (int i = increment; i < a.length; i++) {
                int j = i;
                int temp = a[i];
                while (j >= increment && a[j - increment] > temp) {
                    a[j] = a[j - increment];
                    j = j - increment;
                }
                a[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }
}
