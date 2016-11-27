import org.junit.Test;
import polis.sort.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;
//import java.polis.sort;
/**
 * Created by dysha on 22.11.2016.
 */
public class testCase {
    @Test
    public void sort() throws Exception {
        QuickSort QB = new QuickSort();
        int[] Arr = Helper.gen(1000);
        int[] ArrRes = Arr;
        Arrays.sort(ArrRes);
        int[] n = QB.qSort(Arr);
        String k = ""; String m = "";
        for (int i = 0; i < Arr.length;i++)
        {
            k += n[i]+ " ";
            m += ArrRes[i]+ " ";
        }
        assertEquals(m, k);
    }

    @Test
    public void quicksort() throws Exception {
        QuickSort3 QB = new QuickSort3();
        int[] Arr = Helper.gen(1000);
        int[] ArrRes = Arr;
        Arrays.sort(ArrRes);
        int[] n = QB.quicksortEnter(Arr);
        String k = ""; String m = "";
        for (int i = 0; i < Arr.length;i++)
        {
            k += n[i]+ " ";
            m += ArrRes[i]+ " ";
        }
        assertEquals(m, k);
    }

    @Test
    public void insertionSortBonus() throws Exception { //сортировка вставками с бинарным поиском
        InsertionBonus srt = new InsertionBonus();
        int[] Arr = Helper.gen(1000);
        int[] ArrRes = Arr;
        Arrays.sort(ArrRes);
        int[] n = srt.retArr(Arr);
        String k = ""; String m = "";
        for (int i = 0; i < Arr.length;i++)
        {
            k += n[i]+ " ";
            m += ArrRes[i]+ " ";
        }
        assertEquals(m, k);
    }

    @Test
    public void insertionSort() throws Exception { //обычная сортировка вставками
        InsertionSort srt = new InsertionSort();
        int[] Arr = Helper.gen(1000);
        int[] ArrRes = Arr;
        Arrays.sort(ArrRes);
        int[] n = srt.retArr(Arr);
        String k = ""; String m = "";
        for (int i = 0; i < Arr.length;i++)
        {
            k += n[i]+ " ";
            m += ArrRes[i]+ " ";
        }
        assertEquals(m, k);
    }

    @Test
    public void Shell() throws Exception {
        Shell srt = new Shell();
        int[] Arr = Helper.gen(1000);
        int[] ArrRes = Arr;
        Arrays.sort(ArrRes);
        int[] n = srt.retArr(Arr);
        String k = ""; String m = "";
        for (int i = 0; i < Arr.length;i++)
        {
            k += n[i]+ " ";
            m += ArrRes[i]+ " ";
        }
        assertEquals(m, k);
    }

    @Test
    public void merge() throws Exception {
        Merge mms = new Merge();
        int[] Arr = Helper.gen(1000);
        int[] ArrRes = Arr;
        Arrays.sort(ArrRes);
        mms.sort(Arr);
        int[] n = mms.retArr();
        String k = ""; String m = "";
        for (int i = 0; i < Arr.length;i++)
        {
            k += n[i]+ " ";
            m += ArrRes[i]+ " ";
        }
        assertEquals(m, k);
    }

    @Test
    public void mergeWithoutMem() throws Exception {
        MergeWithoutMem mms = new MergeWithoutMem();
        int[] Arr = Helper.gen(1000);
        int[] ArrRes = Arr;
        Arrays.sort(ArrRes);
        int[] n = mms.retArr(Arr);
        String k = ""; String m = "";
        for (int i = 0; i < Arr.length;i++)
        {
            k += n[i]+ " ";
            m += ArrRes[i]+ " ";
        }
        assertEquals(m, k);
    }
}