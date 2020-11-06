package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {


    public static void main(String[] args) {
        List<Word> wordList;
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        wordList = detectAllWords(crossword, "home", "same");
        for (Word w : wordList) {
            System.out.println(w);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            wordList.addAll(findWord(crossword, words[i]));

        }
        return wordList;
    }

    private static List<Word> findWord(int[][] crossword, String word) {
        List<Word> words = new ArrayList<>();
        Word wordOut;
        int firstLetter = word.charAt(0);
        int endLetter = word.charAt(word.length() - 1);
        int wordLength = word.length();
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                if (crossword[i][j] == firstLetter) {
                    //vector to 12 o'clock
                    if (i - (wordLength - 1) >= 0 && crossword[i - (wordLength - 1)][j] == endLetter) {
                        int count = 0;
                        int t = 0;
                        for (int k = i; k >= (i - (wordLength - 1)); k--) {
                            if (word.charAt(t) == crossword[k][j]) {
                                count++;
                                t++;
                            }
                        }
                        if (count == wordLength) {
                            wordOut = new Word(word);
                            wordOut.setStartPoint(j, i);
                            wordOut.setEndPoint(j, i - (wordLength - 1));
                            words.add(wordOut);
                        }


                    }
                    //vector to 6 o'clock
                    if (i + (wordLength - 1) <= crossword.length - 1 && crossword[i + (wordLength - 1)][j] == endLetter) {
                        int count = 0;
                        int t = 0;
                        for (int k = i; k <= (i + (wordLength - 1)); k++) {
                            if (word.charAt(t) == crossword[k][j]) {
                                count++;
                                t++;
                            }
                        }
                        if (count == wordLength) {
                            wordOut = new Word(word);
                            wordOut.setStartPoint(j, i);
                            wordOut.setEndPoint(j, i + (wordLength - 1));
                            words.add(wordOut);
                        }


                    }
                    //vector to 9 o'clock
                    if (j - (wordLength - 1) >= 0 && crossword[i][j - (wordLength - 1)] == endLetter) {
                        int count = 0;
                        int t = 0;
                        for (int k = j; k >= (j - (wordLength - 1)); k--) {
                            if (word.charAt(t) == crossword[i][k]) {
                                count++;
                                t++;
                            }
                        }
                        if (count == wordLength) {
                            wordOut = new Word(word);
                            wordOut.setStartPoint(j, i);
                            wordOut.setEndPoint(j - (wordLength - 1), i);
                            words.add(wordOut);
                        }

                    }
                    //vector to 3 o'clock
                    if (j + (wordLength - 1) <= crossword[i].length - 1 && crossword[i][j + (wordLength - 1)] == endLetter) {
                        int count = 0;
                        int t = 0;
                        for (int k = j; k <= (j + (wordLength - 1)); k++) {
                            if (word.charAt(t) == crossword[i][k]) {
                                count++;
                                t++;
                            }
                        }
                        if (count == wordLength) {
                            wordOut = new Word(word);
                            wordOut.setStartPoint(j, i);
                            wordOut.setEndPoint(j + (wordLength - 1), i);
                            words.add(wordOut);
                        }


                    }
                    //vector 10-30
                    if (i - (wordLength - 1) >= 0 && j - (wordLength - 1) >= 0 && crossword[i - (wordLength - 1)][j - (wordLength - 1)] == endLetter) {
                        int count = 0;
                        int t = 0;
                        for (int k = i; k >= (i - (wordLength - 1)); k--) {
                            if (word.charAt(t) == crossword[i-t][j-t]) {
                                count++;
                                t++;
                            }
                        }
                        if (count == wordLength) {
                            wordOut = new Word(word);
                            wordOut.setStartPoint(j, i);
                            wordOut.setEndPoint(j - (wordLength - 1), i - (wordLength - 1));
                            words.add(wordOut);
                        }

                    }
                    //vector 13-30
                    if (i - (wordLength - 1) >= 0 && j + (wordLength - 1) <= crossword[i].length - 1 && crossword[i - (wordLength - 1)][j + (wordLength - 1)] == endLetter) {
                        int count = 0;
                        int t = 0;
                        for (int k = i; k >= (i - (wordLength - 1)); k--) {
                            if (word.charAt(t) == crossword[i-t][j+t]) {
                                count++;
                                t++;
                            }
                        }
                        if (count == wordLength) {
                            wordOut = new Word(word);
                            wordOut.setStartPoint(j, i);
                            wordOut.setEndPoint(j + (wordLength - 1), i - (wordLength - 1));
                            words.add(wordOut);
                        }

                    }
                    //vector 16-30
                    if (i + (wordLength - 1) <= crossword.length - 1 && j + (wordLength - 1) <= crossword[i].length - 1 && crossword[i + (wordLength - 1)][j + (wordLength - 1)] == endLetter) {
                        int count = 0;
                        int t = 0;
                        for (int k = i; k <= (i + (wordLength - 1)); k++) {
                            if (word.charAt(t) == crossword[i+t][j+t]) {
                                count++;
                                t++;
                            }
                        }
                        if (count == wordLength) {
                            wordOut = new Word(word);
                            wordOut.setStartPoint(j, i);
                            wordOut.setEndPoint(j + (wordLength - 1), i + (wordLength - 1));
                            words.add(wordOut);
                        }

                    }
                    //vector 19-30
                    if (i + (wordLength - 1) <= crossword.length - 1 && j - (wordLength - 1) >= 0 && crossword[i + (wordLength - 1)][j - (wordLength - 1)] == endLetter) {
                        int count = 0;
                        int t = 0;
                        for (int k = j; k >= (j - (wordLength - 1)); k--) {
                            if (word.charAt(t) == crossword[i+t][j-t]) {
                                count++;
                                t++;
                            }
                        }
                        if (count == wordLength) {
                            wordOut = new Word(word);
                            wordOut.setStartPoint(j, i);
                            wordOut.setEndPoint(j - (wordLength - 1),i + (wordLength - 1) );
                            words.add(wordOut);
                        }

                    }


                }

            }
        }


        return words;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
