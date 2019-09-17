package demo.springboot;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import com.carrotsearch.junitbenchmarks.annotation.LabelType;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * Run with VM options '-Djub.consumers=CONSOLE,H2 -Djub.db.file=.benchmarks'
 */
@BenchmarkHistoryChart(labelWith = LabelType.CUSTOM_KEY, maxRuns = 20)
@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "benchmark-lists")
@BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 3, concurrency = 2)
public class BenchmarkWithCharts {

    private static Object singleton = new Object();
    private static int COUNT = 50000;
    private static int [] rnd;

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    /** Prepare random numbers for tests. */
    @BeforeClass
    public static void prepare() {
        rnd = new int [COUNT];

        final Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            rnd[i] = Math.abs(random.nextInt());
        }
    }

    @Test
    public void arrayList() {
        runTest(new ArrayList<>());
    }

    @Test
    public void linkedList() {
        runTest(new LinkedList<>());
    }

    @Test
    public void vector() {
        runTest(new Vector<>());
    }

    private void runTest(List<Object> list) {
        assert list.isEmpty();

        // First, add a number of objects to the list.
        for (int i = 0; i < COUNT; i++)
            list.add(singleton);

        // Randomly delete objects from the list.
        for (int value : rnd) list.remove(value % list.size());
    }
}
