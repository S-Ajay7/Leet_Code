

// https://leetcode.com/problems/uncommon-words-from-two-sentences/description/?envType=daily-question&envId=2024-09-17



/** A sentence is a string of single-space separated words where each word consists only of lowercase letters.

 A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

 Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.



 Example 1:

 Input: s1 = "this apple is sweet", s2 = "this apple is sour"

 Output: ["sweet","sour"]

 Explanation:

 The word "sweet" appears only in s1, while the word "sour" appears only in s2.

 Example 2:

 Input: s1 = "apple apple", s2 = "banana"

 Output: ["banana"]  */

 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.Arrays;

public class Uncommon_Words {

    static String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> al = new ArrayList<>();
        al.addAll(Arrays.asList(s1.split(" ")));
        al.addAll(Arrays.asList(s2.split(" ")));
        int start = 0;
        int end = start + 1;
        Collections.sort(al);
        int len = al.size();
        while (end < len) {
            if(al.get(start).equals(al.get(end))) {
                while (end < len && al.get(start).equals(al.get(end))) {
                    end++;
                }
                for(int i = end - 1; i >= start; i--) {
                    al.remove(i);
                }
                start = 0;
                end = start + 1;
                len = al.size();
            } else {
                start ++;
                end = start + 1;
            }
        }
        String[] res = new String[al.size()];
        int k = 0;
        for (String data : al) {
            res[k++] = data;
        }
        return res;
    }


    public static void main(String[] args) {
        String s1 = "s z z z s";
        String s2 = "s z ejt";
        String[] res = uncommonFromSentences(s1, s2);
        System.out.println(Arrays.toString(res));
    }
}
