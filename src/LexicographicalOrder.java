
/*
Submissions	Leaderboard	Discussions	Editorial	Topics
Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:

It must be greater than the original word
It must be the smallest word that meets the first condition
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
 class ResultLexicographicalOrder {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */
    static class Tuple {
         Character c;
         int pos;
         Tuple(Character c, int pos) {
             this.c =c;
             this.pos = pos;
         }
    }

    public static String biggerIsGreater(String w) {
        // Write your code here
       List<Character> alphaArray = "abcdefghijklmnopqrstuvwxyz".chars().mapToObj(c -> (char)c).collect(toList());
       List<Tuple> tupleList = new ArrayList<>();
        w.chars().mapToObj(c-> (char) c).collect(toList()).forEach(c-> tupleList.add(new Tuple(c, alphaArray.indexOf(c))));
        for(int toCompareIndex = tupleList.size()-1; toCompareIndex > 0; toCompareIndex --) {
            for (int compareWIthIndex =toCompareIndex-1; compareWIthIndex>=0;compareWIthIndex--) {
                if(tupleList.get(toCompareIndex).pos> tupleList.get(compareWIthIndex).pos) {
                   // tupleList.add(toCompareIndex, tupleList.get(compareWIthIndex));
                    String word = w.substring(0,compareWIthIndex);
                    word = word+tupleList.get(toCompareIndex).c;
                    tupleList.get(toCompareIndex).c = tupleList.get(compareWIthIndex).c;
                    tupleList.get(toCompareIndex).pos = tupleList.get(compareWIthIndex).pos;
                    int finalCompareWIthIndex = compareWIthIndex;
                    List<Character> lastChars = tupleList.stream().filter(x-> tupleList.indexOf(x) > finalCompareWIthIndex).map(t ->
                            t.c).collect(Collectors.toList()).stream().sorted().collect(toList());
                    word = word + lastChars.stream()
                            .map(e->e.toString())
                            .reduce((acc, e) -> acc  + e)
                            .get();
                    return word;
                }
            }
        }
        return "no answer";
    }

}

public class LexicographicalOrder {
    public static void main(String[] args) throws IOException {
        System.out.println(ResultLexicographicalOrder.biggerIsGreater("dcba"));
    }
}

