package mail.polis.sort;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by dysha on 22.11.2016.
 */
//Сортировка вставками
public class Merge{

    private int[] array;

    private int[] tempMergArr;
    private int length;

    public static void main(String a[]){

        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String[] str = in.nextLine().split(" ");
        int[] mas = new int[str.length];
        for (int i = 0; i <str.length; i++) {
            mas[i] = Integer.parseInt(str[i]);
        }
        Merge mms = new Merge();
        mms.sort(mas);
        for(int i=0;i<str.length;i++){
            pw.print(mas[i] + " ");
        }
        pw.flush();
    }

    public int[] retArr(){
        return array;
    }

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
}
