package mail.polis.sort.valid;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import mail.polis.sort.*;

@RunWith(value = Parameterized.class)
public class Tester{

    private static final Random r = ThreadLocalRandom.current();

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };
    @Parameterized.Parameter
    public int[] array;

    private static int[] gen(int n) {
        int[] Array = new int[n];
        for (int i = Array.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(Array, i, j);
        }
        return Array;
    }

    private static int[] random(int N, int M) {
        Random rnd = new Random();
        int[] Array = new int[N];
        for (int i = 0; i < N; i++) Array[i] = rnd.nextInt(M);
        return Array;
    }

    private static int[] sawTooth(int n, int m) {
        int[] Array = new int[n];
        for (int i = 0; i < n; i++) {
            Array[i] = i % m;
        }
        return Array;
    }

    private static int[] stagger(int n, int m) {
        int[] Array = new int[n];
        for (int i = 0; i < n; i++) Array[i] = m * (i + 1) % n;
        return Array;
    }

    private static int[] plateau(int n, int m) {
        int[] Array = new int[n];
        for (int i = 0; i < n; i++) {
            Array[i] = Math.min(i, m);
        }
        return Array;
    }

    private static int[] reverse(int n, int head, int tail) {
        tail--;
        int[] Array = new int[n];
        for (int i = 0; i < n; i++) Array[i] = i;
        int k = (tail - head) / 2;
        for (int i = 0; i <=k ; i++)Helper.swap(Array, head+i,  tail-i);

        return Array;
    }

    private static int[] partSortArray(int n){
        int[] Array = new int[n];
        Random rndm=new Random();
        int r = rndm.nextInt(n/2+1)-(n/2-n/4);
        for (int i = 0; i < Array.length; i++) {
            Array[i]=r++;
            if (r==Array.length) r=1;
        }
        return Array;
    }

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        int n = 1000;
        int m = n*3/4;
        return Arrays.asList(new int[][]{partSortArray(n),gen(n)});
    }


    private boolean isSorted(int[] a) {
        boolean isSorted = true;
        int[] arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < a.length && isSorted; i++) {
            isSorted = a[i] == arr[i];
        }
        return isSorted;
    }

    @Test
    public void checkBubbleSort() throws IOException {
        Assert.assertTrue(isSorted(BubbleSort.sort(array)));
    }

    @Test
    public void checkInsertionSort() throws IOException {
        Assert.assertTrue(isSorted(InsertionSort.retArr(array)));
    }

    @Test
    public void checkInsertionBinSort() throws IOException {
        Assert.assertTrue(isSorted(InsertionBonus.retArr(array)));
    }

    @Test
    public void checkShellSort() throws IOException {
        Assert.assertTrue(isSorted(Shell.retArr(array)));
    }

    @Test
    public void checkMergeSort() throws IOException {
        Merge mms = new Merge();
        mms.sort(array);
        Assert.assertTrue(isSorted(mms.retArr()));
    }

    @Test
    public void checkMergeSortWithoutExtraMem() throws IOException {
        Assert.assertTrue(isSorted(MergeWithoutMem.retArr(array)));
    }

    @Test
    public void checkQuickSort() throws IOException {
        Assert.assertTrue(isSorted(QuickSort.qSort(array)));
    }

    @Test
    public void checkQuickRand3PartSort() throws IOException {
        Assert.assertTrue(isSorted(QuickSort3.quicksortEnter(array)));
    }

}