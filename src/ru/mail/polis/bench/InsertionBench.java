package mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import mail.polis.sort.Helper;
import mail.polis.sort.InsertionSort;

import java.util.concurrent.TimeUnit;

/**
 * Created by dysha_000 on 27.11.2016.
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class InsertionBench {
    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        // a = Helper.gen(10000); //n-случайная перестановка
        // a = Helper.sortArray(10000); //для лучшего случая
        a = Helper.reverse(10000);// для худшего случая
    }

    @Benchmark
    public void measureInsertionSort(Blackhole bh) {
        bh.consume(InsertionSort.retArr(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(InsertionBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
