package il.org.spartan.tables;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class TableRendererTest {
  String NL = System.getProperty("line.separator");

  @Test public void TXT_afterHeader() {
    azzert.that(TableRenderer.builtin.TEX.afterHeader(), is("\\midrule" + NL));
  }

  @Test public void TXT_afterTable() {
    azzert.that(TableRenderer.builtin.TEX.afterTable(), is("\\bottomrule" + NL));
  }

  @Test public void TXT_arraySeparator() {
    azzert.that(TableRenderer.builtin.TEX.arraySeparator(), is(", "));
  }

  @Test public void TXT_beforeFooter() {
    azzert.that(TableRenderer.builtin.TEX.beforeFooter(), is("\\midrule" + NL));
  }

  @Test public void TXT_beforeTable() {
    azzert.that(TableRenderer.builtin.TEX.beforeTable(), is("\\toprule" + NL));
  }

  @Test public void TXT_nil() {
    azzert.that(TableRenderer.builtin.TEX.nil(), is("$\\#$"));
  }

  @Test public void TXT_recordEnd() {
    azzert.that(TableRenderer.builtin.TEX.recordEnd(), is(" \\\\" + NL));
  }

  @Test public void TXT_recordSeparator() {
    azzert.that(TableRenderer.builtin.TEX.recordSeparator(), is("\t&\t"));
  }

  @Test public void TXT_render() {
    azzert.that(TableRenderer.builtin.TEX.render(Statistic.Σ), is("\\hfill$\\Sum$"));
    azzert.that(TableRenderer.builtin.TEX.render(Statistic.σ), is("\\hfill$\\sigma$"));
    azzert.that(TableRenderer.builtin.TEX.render(Statistic.max), is("\\hfill$\\" + Statistic.max + "$"));
    azzert.that(TableRenderer.builtin.TEX.render(Statistic.min), is("\\hfill$\\" + Statistic.min + "$"));
    azzert.that(TableRenderer.builtin.TEX.render(Statistic.MAD), is("\\hfill" + Statistic.MAD));
  }

  @Test public void TXT2_afterHeader() {
    azzert.that(TableRenderer.builtin.TEX2.afterHeader(), is("\\hline" + NL));
  }

  @Test public void TXT2_afterTable() {
    azzert.that(TableRenderer.builtin.TEX2.afterTable(), is("\\hline" + NL));
  }

  @Test public void TXT2_arraySeparator() {
    azzert.that(TableRenderer.builtin.TEX2.arraySeparator(), is(", "));
  }

  @Test public void TXT2_beforeFooter() {
    azzert.that(TableRenderer.builtin.TEX2.beforeFooter(), is("\\hline" + NL));
  }

  @Test public void TXT2_beforeTable() {
    azzert.that(TableRenderer.builtin.TEX2.beforeTable(), is("\\hline" + NL));
  }

  @Test public void TXT2_footerEnd() {
    azzert.that(TableRenderer.builtin.TEX2.footerEnd(), is("\\\\" + NL));
  }

  @Test public void TXT2_recordSeparator() {
    azzert.that(TableRenderer.builtin.TEX2.recordSeparator(), is("\t&\t"));
  }

  @Test public void CSV_footerEnd() {
    azzert.that(TableRenderer.builtin.CSV.footerEnd(), is(NL));
  }

  @Test public void CSV_recordSeparator() {
    azzert.that(TableRenderer.builtin.CSV.recordSeparator(), is(","));
  }

  @Test public void MARKDOWN_afterHeader() {
    TableRenderer.builtin.MARKDOWN.setHeaderCount(3);
    azzert.that(TableRenderer.builtin.MARKDOWN.afterHeader(), is("| --- |" + NL));
    TableRenderer.builtin.MARKDOWN.setHeaderCount(3);
    azzert.that(TableRenderer.builtin.MARKDOWN.afterHeader(), is("| --- |--- |--- |" + NL));
    TableRenderer.builtin.MARKDOWN.setHeaderCount(0);
    azzert.that(TableRenderer.builtin.MARKDOWN.afterHeader(), is("| " + NL));
  }

  @Test public void MARKDOWN_afterTable() {
    azzert.that(TableRenderer.builtin.MARKDOWN.afterTable(), is(NL));
  }

  @Test public void MARKDOWN_beforeTable() {
    azzert.that(TableRenderer.builtin.MARKDOWN.beforeTable(), is(NL));
  }

  @Test public void MARKDOWN_recordBegin() {
    azzert.that(TableRenderer.builtin.MARKDOWN.recordBegin(), is("|"));
  }

  @Test public void MARKDOWN_recordEnd() {
    azzert.that(TableRenderer.builtin.MARKDOWN.recordEnd(), is(" |" + NL));
  }

  @Test public void MARKDOWN_recordSeparator() {
    azzert.that(TableRenderer.builtin.MARKDOWN.recordSeparator(), is(" | "));
  }

  enum TableRendererForTest implements TableRenderer {
    TABLE;
    static int lastSize;

    @Override public void setHeaderCount(final int size) {
      builtin.lastSize = size;
    }
  }

  @Test public void cellReal() {
    azzert.that(TableRendererForTest.TABLE.cellReal(box.it(5.0)), is("5"));
    azzert.that(TableRendererForTest.TABLE.cellReal(box.it(123.4)), is("123.4"));
  }

  @Test public void empty() {
    azzert.that(TableRenderer.empty(), is(""));
  }

  @Test public void tab() {
    azzert.that(TableRenderer.tab(), is("\t"));
  }

  @Test public void afterFooter() {
    azzert.that(TableRendererForTest.TABLE.afterFooter(), is(""));
  }

  @Test public void afterHeader() {
    azzert.that(TableRendererForTest.TABLE.afterHeader(), is(""));
  }

  @Test public void afterTable() {
    azzert.that(TableRendererForTest.TABLE.afterTable(), is(""));
  }

  @Test public void arraySeparator() {
    azzert.that(TableRendererForTest.TABLE.arraySeparator(), is("; "));
  }

  @Test public void beforeFooter() {
    azzert.that(TableRendererForTest.TABLE.beforeFooter(), is(""));
  }

  @Test public void beforeHeader() {
    azzert.that(TableRendererForTest.TABLE.beforeHeader(), is(""));
  }

  @Test public void beforeTable() {
    azzert.that(TableRendererForTest.TABLE.beforeTable(), is(""));
  }

  @Test public void cellArray() {
    final Integer[] arr = new Integer[3];
    azzert.that(TableRendererForTest.TABLE.cellArray(arr), is(""));
    arr[0] = box.it(1);
    azzert.that(TableRendererForTest.TABLE.cellArray(arr), is("1"));
    arr[1] = box.it(2);
    arr[2] = box.it(3);
    azzert.that(TableRendererForTest.TABLE.cellArray(arr), is("1; 2; 3"));
  }

  @Test public void cellInt() {
    azzert.that(TableRendererForTest.TABLE.cellInt(box.it(1L)), is("1"));
  }

  @Test public void extension() {
    azzert.that(TableRendererForTest.TABLE.extension(), is("table"));
  }

  @Test public void footerBegin() {
    azzert.that(TableRendererForTest.TABLE.footerBegin(), is(""));
  }

  @Test public void footerEnd() {
    azzert.that(TableRendererForTest.TABLE.footerEnd(), is(NL));
  }

  @Test public void footerSeparator() {
    azzert.that(TableRendererForTest.TABLE.footerSeparator(), is("\t"));
  }

  @Test public void headerLineBegin() {
    azzert.that(TableRendererForTest.TABLE.headerLineBegin(), is(""));
  }

  @Test public void headerLineEnd() {
    azzert.that(TableRendererForTest.TABLE.headerLineEnd(), is(NL));
  }

  @Test public void headerSeparator() {
    azzert.that(TableRendererForTest.TABLE.headerSeparator(), is("\t"));
  }

  @Test public void nil() {
    azzert.that(TableRendererForTest.TABLE.nil(), is("Nº"));
  }

  @Test public void recordBegin() {
    azzert.that(TableRendererForTest.TABLE.recordBegin(), is(""));
  }

  @Test public void recordEnd() {
    azzert.that(TableRendererForTest.TABLE.recordEnd(), is(NL));
  }

  @Test public void render() {
    azzert.that(TableRendererForTest.TABLE.render(Statistic.MAD), is("M.A.D"));
  }

  @Test public void renderRow_Object() {
    final Collection<Object> arr = new ArrayList<>(3);
    arr.add(box.it(1));
    arr.add(box.it(2));
    arr.add(box.it(3));
    azzert.that(TableRendererForTest.TABLE.renderRow(arr), is("1\t2\t3" + NL));
  }

  @Test public void renderRow_Integer() {
    final Collection<Object> arr = new ArrayList<>(3);
    arr.add(box.it(1L));
    arr.add(box.it(2L));
    arr.add(box.it(3L));
    azzert.that(TableRendererForTest.TABLE.renderRow(arr), is("1\t2\t3" + NL));
  }

  @Test public void stringField() {
    azzert.that(TableRendererForTest.TABLE.stringField("s"), is("s"));
  }
}
