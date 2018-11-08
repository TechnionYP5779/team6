package il.org.spartan.utils;

import fluent.ly.as;
import fluent.ly.azzert;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import static fluent.ly.azzert.is;

public class AccumulatorTest {
    @Test
    public void booleanAdds() {
        final @NotNull Accumulator.Last c = new Accumulator.Last();
        azzert.that(as.bit(false), is(0));
        azzert.that(c.value(), is(0));
        c.add(true);
        azzert.that(c.value(), is(1));
        azzert.that(as.bit(false), is(0));
        c.add(false);
        azzert.that(c.value(), is(0));
        c.add(false);
        azzert.that(c.value(), is(0));
        c.add(true);
        azzert.that(c.value(), is(1));
        c.add(true);
        azzert.that(c.value(), is(1));
    }

    @Test public void emptyAdds() {
        final @NotNull Accumulator.Last c = new Accumulator.Last();
        for (int ¢ = 0; ¢ < 19; ++¢)
            c.add(¢);
        c.add(11);
        azzert.that(c.value(), is(11));
    }
}

