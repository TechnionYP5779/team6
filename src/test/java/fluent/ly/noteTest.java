package fluent.ly;

import java.io.*;
import java.util.logging.*;

import org.junit.*;

/** For tested interface please see {@link fluent.ly.note} . */
@SuppressWarnings("static-method") public class noteTest {
  class LogHndeler extends Handler {
    private String message;

    @Override public void publish(final LogRecord ¢) {
      message = ¢.getMessage();
    }

    public String message() {
      return message;
    }

    @Override public void close() {
      // do nothing
    }

    @Override public void flush() {
      // do nothing
    }
  }

  LogHndeler h;
  PrintStream originalErrStream = System.err;
  PrintStream newErrStream = new PrintStream(new ByteArrayOutputStream());

  @Before public void before() {
    h = new LogHndeler();
    Logger.getGlobal().addHandler(h);
    System.setErr(newErrStream);
  }

  @After public void after() {
    Logger.getGlobal().removeHandler(h);
    System.setErr(originalErrStream);
  }

  @Test public void bug() {
    note.bug();
    assert h.message().contains("Instance involved is a String");
    assert h.message().contains("A bug was detected in the vicinty of fluent.ly.note$__.trace");
  }

  @Test public void bug_Object() {
    note.bug("string");
    assert h.message().contains("Instance involved is a String");
    assert h.message().contains("A bug was detected in the vicinty of fluent.ly.note$__.trace");
  }

  @Test public void bug_ObjectAndThrowable() {
    note.bug("string", new Throwable());
    assert h.message().contains("String was hit by an Throwable exception");
    assert h.message().contains("This is an indication of a bug");
    assert h.message().contains("Throwable = 'java.lang.Throwable'");
  }

  @Test public void bug_Strings() {
    note.bug("stringA", "stringB");
    assert h.message().contains("A bug was detected in the vicinty of fluent.ly.note$__.trace");
  }

  @Test public void bug_Throwable() {
    note.bug(new Throwable());
    assert h.message().contains("A static method was hit by an Throwable exception");
    assert h.message().contains("This is an indication of a bug");
    assert h.message().contains("Throwable = 'java.lang.Throwable'");
  }

  @Test public void cancel_Exception() {
    note.cancel(new Exception());
    assert h.message().contains("(probably cancellation) exception.");
  }

  @Test public void cancel_ObjectAndException() {
    note.cancel("string", new Exception());
    assert h.message().contains("An instance of String");
    assert h.message().contains("was hit by a Exception (probably cancellation) exception.");
  }

  @Test public void ignore_ClassAndThrowable() {
    note.ignore(String.class, new Throwable());
    assert h.message().contains("A static method of Stringwas hit by an Throwable");
    assert h.message().contains("This is expected and printed only for the purpose of debugging");
  }

  @Test public void ignore_ObjectAndThrowable() {
    note.ignore("string", new Throwable());
    assert h.message().contains("An instance of String");
    assert h.message().contains("This is expected and printed only for the purpose of debugging");
  }

  @Test public void io_ExceptionAndMessage() {
    note.io(new IOException(), "a message");
    assert h.message().contains("(probably I/O exception)");
    assert h.message().contains("The exception says: 'java.io.IOException'");
    assert h.message().contains("The associated message is");
    assert h.message().contains(">>>'a message'<<<");
  }

  @Test public void io_IOException() {
    note.io(new IOException());
    assert h.message().contains("(probably I/O exception)");
    assert h.message().contains("The exception says: 'java.io.IOException'");
  }

  @Test public void logToFile() {
    note.logToFile(new IOException(), "param");
    assert h.message().contains("**");
  }

  @Test public void set_unset() {
    note.set(Logger.getGlobal().getLevel());
    note.unset();
  }
}
