package il.org.spartan.statistics;

import fluent.ly.azzert;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import static fluent.ly.azzert.is;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("static-method") public class RealStatisticsTest {

    final RealStatistics s11_20_5 = new RealStatistics().record(11).record(20).record(5);
    final RealStatistics s15 = new RealStatistics().record(5).record(3).record(1).record(2).record(4);
    final RealStatistics s07 = new RealStatistics().record(0).record(5).record(6).record(3).record(1).record(2).record(4).record(7);
    final RealStatistics s_4x0_5x1 = new RealStatistics().record(0).record(0).record(0).record(0)//
            .record(1).record(1).record(1).record(1).record(1);
    final ImmutableStatistics s = new RealStatistics().record(11).record(20).record(5);

    @Test
    public void all() {
        s11_20_5.median();
        s11_20_5.mad();
        final double @NotNull [] vs = s11_20_5.all();
        azzert.that(vs.length, is(3));
        assertEquals(11, vs[0], 1E-20);
        assertEquals(20, vs[1], 1E-20);
        assertEquals(5, vs[2], 1E-20);
    }

    @Test public void all0() {
        azzert.that(new RealStatistics().all().length, is(0));
    }

    @Test public void all1() {
        azzert.that(new RealStatistics().record(0).all().length, is(1));
    }

    @Test public void all5() {
        azzert.that(new RealStatistics().record(0, 1, 2, 4, 5).all().length, is(5));
    }

    @Test public void max() {
        assertEquals(20, s11_20_5.max(), 1E-6);
        assertEquals(5, s15.max(), 1E-6);
        assertEquals(7, s07.max(), 1E-6);
        assertEquals(1, s_4x0_5x1.max(), 1E-6);
    }

    @Test public void mean() {
        assertEquals(12, s11_20_5.mean(), 1E-6);
        assertEquals(3, s15.mean(), 1E-6);
        assertEquals(3.5, s07.mean(), 1E-6);
        assertEquals(5 / 9.0, s_4x0_5x1.mean(), 1E-6);
    }

    @Test(expected = ArithmeticException.class) public void meanEmpty() {
        final @NotNull RealStatistics x = new RealStatistics();
        assertEquals(0, x.mean(), 1E-20);
        x.relativeError();
    }

    @Test public void meanZero() {
        final @NotNull RealStatistics x = new RealStatistics().record(1).record(-1);
        assertEquals(0, x.mean(), 1E-20);
        x.relativeError();
    }

    @Test public void median() {
        assertEquals(11, s11_20_5.median(), 1E-6);
        assertEquals(3, s15.median(), 1E-6);
        assertEquals(3.5, s07.median(), 1E-6);
        assertEquals(1, s_4x0_5x1.median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(1).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(5).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(5).record(6).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
        assertEquals(0.5, s_4x0_5x1.record(0).median(), 1E-6);
        assertEquals(0, s_4x0_5x1.record(0).median(), 1E-6);
    }

    @Test(expected = ArithmeticException.class) public void medianEmpty() {
        new RealStatistics().median();
    }

    @Test public void medianMiddle() {
        assertEquals(0.5, s_4x0_5x1.record(0).median(), 1E-6);
    }

    @Test public void medianMovingDown() {
        assertEquals(0, s_4x0_5x1.record(0).record(0).median(), 1E-6);
    }

    @Test public void mediannMovingDown() {
        assertEquals(0, s_4x0_5x1.record(0).record(0).median(), 1E-6);
    }

    @Test public void medianNotMovingUp() {
        assertEquals(1, s_4x0_5x1.record(5).record(6).median(), 1E-6);
    }

    @Test public void min() {
        assertEquals(5, s11_20_5.min(), 1E-6);
        assertEquals(1, s15.min(), 1E-6);
        assertEquals(0, s07.min(), 1E-6);
        assertEquals(0, s_4x0_5x1.min(), 1E-6);
    }

    @Test public void n() {
        azzert.that(s11_20_5.n(), is(3));
        azzert.that(s15.n(), is(5));
        azzert.that(s07.n(), is(8));
        azzert.that(s_4x0_5x1.n(), is(9));
    }

    @Test public void simpleLength() {
        azzert.that(s.n(), is(3));
        azzert.that(s15.n(), is(5));
        azzert.that(s07.n(), is(8));
        azzert.that(s_4x0_5x1.n(), is(9));
    }

    @Test public void sum() {
        assertEquals(36, s11_20_5.sum(), 1E-6);
        assertEquals(15, s15.sum(), 1E-6);
        assertEquals(28, s07.sum(), 1E-6);
        assertEquals(5.0, s_4x0_5x1.sum(), 1E-6);
    }

    @Test public void testMax() {
        assertEquals(20, s.max(), 1E-6);
        assertEquals(5, s15.max(), 1E-6);
        assertEquals(7, s07.max(), 1E-6);
        assertEquals(1, s_4x0_5x1.max(), 1E-6);
    }

    @Test public void testMean() {
        assertEquals(12, s.mean(), 1E-6);
        assertEquals(3, s15.mean(), 1E-6);
        assertEquals(3.5, s07.mean(), 1E-6);
        assertEquals(5 / 9.0, s_4x0_5x1.mean(), 1E-6);
    }

    @Test public void testMedian() {
        assertEquals(11, s.median(), 1E-6);
        assertEquals(3, s15.median(), 1E-6);
        assertEquals(3.5, s07.median(), 1E-6);
        assertEquals(1, s_4x0_5x1.median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(1).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(5).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(5).record(6).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
        assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
        assertEquals(0.5, s_4x0_5x1.record(0).median(), 1E-6);
        assertEquals(0, s_4x0_5x1.record(0).median(), 1E-6);
    }

    @Test(expected = ArithmeticException.class) public void testMedianEmpty() {
        new RealStatistics().median();
    }

    @Test public void testMedianMiddle() {
        assertEquals(0.5, s_4x0_5x1.record(0).median(), 1E-6);
    }

    @Test public void testMedianNotMovingUp() {
        assertEquals(1, s_4x0_5x1.record(5).record(6).median(), 1E-6);
    }

    @Test public void testMin() {
        assertEquals(5, s.min(), 1E-6);
        assertEquals(1, s15.min(), 1E-6);
        assertEquals(0, s07.min(), 1E-6);
        assertEquals(0, s_4x0_5x1.min(), 1E-6);
    }

    @Test public void testSum() {
        assertEquals(36, s.sum(), 1E-6);
        assertEquals(15, s15.sum(), 1E-6);
        assertEquals(28, s07.sum(), 1E-6);
        assertEquals(5.0, s_4x0_5x1.sum(), 1E-6);
    }
}
