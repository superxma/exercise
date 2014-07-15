package com.mengangx.test.leetcode;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> wordQ = new LinkedList<String>();
        Queue<Integer> lenQ = new LinkedList<Integer>();
        wordQ.add(start);
        lenQ.add(1);
        while(wordQ.peek() != null) {
            String curWord = wordQ.poll();
            int len = lenQ.poll();
            if(curWord.equals(end)) { //find
                return len;
            } else {
                for (int i=0; i<curWord.length(); i++) {
                    char [] ch = curWord.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String str = String.valueOf(ch);
                        if (dict.contains(str)) {
                            wordQ.add(str);
                            lenQ.add(len + 1);
                            dict.remove(str);
                        }
                    }
                }
            }
        } //while
        return 0;
    }
}