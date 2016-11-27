package mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import mail.polis.sort.Helper;
import mail.polis.sort.MergeWithoutMem;

import java.util.concurrent.TimeUnit;

/**
 * Created by dysha_000 on 27.11.2016.
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MergeMemBench {
    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a = Helper.gen(1000);
        //a=Helper.partitionArray(100000);
    }

    @Benchmark
    public void measureMergeMemSort(Blackhole bh) {bh.consume(MergeWithoutMem.retArr(a));}

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MergeMemBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
