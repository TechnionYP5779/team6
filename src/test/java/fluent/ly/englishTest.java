package fluent.ly;

import il.org.spartan.utils.Int;
import org.junit.Test;

import java.util.ArrayList;
@SuppressWarnings("static-method")
public class englishTest {
//    @Test
//    public void englishTestIndefinite1(){
//        String s = "str";
//        azzert.that(English.indefinite(s), azzert.is("a str"));
//
//
//        azzert.that(English.indefinite(1.1), azzert.is("an Double"));
//        azzert.that(English.indefinite("StrinG"), azzert.is("a StrinG"));
//    }
//
//    @Test
//    public void englishTestIndefinite2(){
//        Integer i = 1;
//        azzert.that(English.indefinite(i), azzert.is("a Integer"));
//    }
//
//    @Test
//    public void englishTestIndefinite3(){
//        azzert.that(English.indefinite(1.1), azzert.is("an Double"));
//    }

    @Test
    public void englishTestList1(){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("hi");
        azzert.that(English.list(arr), azzert.is("hi"));
    }

    @Test
    public void englishTestList2(){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("hi");
        arr.add("bye");
        azzert.that(English.list(arr), azzert.is("hi and bye"));
    }

    @Test
    public void englishTestlowerFirstLetter(){

        azzert.that(English.lowerFirstLetter("Hi"), azzert.is("hi"));
        English.lowerFirstLetter("");
    }

    @Test
    public void englishTestplurales1(){
        azzert.that(English.plurales("apple",1),azzert.is("one apple"));
    }

    @Test
    public void englishTestplurales2(){
        azzert.that(English.plurales("apple",(Integer)null),azzert.is("??? applees"));

    }

    @Test
    public void englishTestplurales3(){
        azzert.that(English.plurales("apple",Box.box(1)),azzert.is("one apple"));

    }

    @Test
    public void englishTestplurales4(){
        azzert.that(English.plurales("apple",Box.box(2)),azzert.is("2 applees"));

    }

    @Test
    public void englishTestplurales5(){
        azzert.that(English.plurales("apple",2),azzert.is("2 applees"));

    }

    @Test
    public void englishTestplurales6(){
        azzert.that(English.plurales("apple", Box.box(1)),azzert.is("one apple"));
    }

    @Test
    public void englishTestplurales7(){
        azzert.that(English.plurales("apple",Box.box(2)),azzert.is("2 applees"));

    }

//  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Test
    public void englishTestplurals1(){
        azzert.that(English.plurals("apple",1),azzert.is("one apple"));
    }

    @Test
    public void englishTestplurals2(){
        azzert.that(English.plurals("apple",(Integer)null),azzert.is("??? apples"));

    }

    @Test
    public void englishTestplurals3(){
        azzert.that(English.plurals("apple",Box.box(1)),azzert.is("one apple"));

    }

    @Test
    public void englishTestplurals4(){
        azzert.that(English.plurals("apple",Box.box(2)),azzert.is("2 apples"));

    }

    @Test
    public void englishTestplurals5(){
        azzert.that(English.plurals("apple",2),azzert.is("2 apples"));

    }

    @Test
    public void englishTestplurals6(){
        azzert.that(English.plurals("apple", Box.box(1)),azzert.is("one apple"));
    }

    @Test
    public void englishTestplurals7(){
        azzert.that(English.plurals("apple",Box.box(2)),azzert.is("2 apples"));

    }
    @Test
    public void englishTestPronounce(){
        String[] resArr = {
                "aey",
                "bee",
                "see",
                "dee",
                "eae",
                "eff",
                "gee",
                "eitch",
                "eye",
                "jay",
                "kay",
                "ell",
                "em",
                "en",
                "oh",
                "pee",
                "queue",
                "ar",
                "ess",
                "tee",
                "you",
                "vee",
                "some character",
                "exx",
                "why",
                "zee" };

        for (int ¢ = 0; ¢ < 26; ++¢)
          azzert.that(English.pronounce((char) (¢ + 'a')), azzert.is(resArr[¢]));
        azzert.that(English.pronounce('A'), azzert.is("aey"));
    }

    @Test
    public void englishTestRepeat(){
        azzert.that(English.repeat(2,'h'),azzert.is("hh"));
    }

    @Test
    public void englishTestTime(){
        azzert.that(English.time(222222222), azzert.is("0.22"));
    }

    @Test
    public void englishTestTrimeNull(){
        azzert.assertNull(English.trim(null));
    }

    @Test
    public void englishTestTrimeNotNull(){
        azzert.that(English.trim("hello world"),azzert.is("hello world"));
    }

    @Test
    public void englishTestTrimeNotAbs(){
        azzert.that(English.trimAbsolute("hello world", 10,"bye world"),azzert.is("hbye world"));
    }


    @Test
    public void englishTestupperFirstLetter1(){
        azzert.that(English.upperFirstLetter("hello world"),azzert.is("Hello world"));
    }

}
