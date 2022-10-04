package com.epam.rd.autotasks.words;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int counterWords = 0;
        if (words == null || words.length == 0) {
            return 0;
        }
        if (sample == null || sample.isEmpty()) {
            return 0;
        }
        for (String val:words) {
            if (val.strip().equalsIgnoreCase(sample.strip())) {
                counterWords++;
            }
        }
        return counterWords;
    }

    public static String[] splitWords(String text) {
        String regex = "\\W+";
        if (text == null || text.isEmpty()) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex.strip());
        String[] splitArr = pattern.split(text.strip());
        if (Pattern.matches(pattern.toString(), text)) {
            return null;
        }
        return emptyArrCleaner(splitArr);
    }


    public static String convertPath(String path, boolean toWin) {
        String regexUnix = "(\\.{1,2})?(~)?([a-zA-Z0-9_\\s/]+)?(\\.{2})?([/a-zA-Z0-9_]+)?(\\.[a-zA-Z0-9]+)?";
        String regexWin = "(\\.{1,2})?(C:)?([a-zA-Z0-9_\\s\\\\]+)?(\\.{2})?([\\\\a-zA-Z0-9_]+)?(\\.[a-zA-Z0-9]+)?";
        Pattern patternUnix = Pattern.compile(regexUnix);
        Pattern patternWin = Pattern.compile(regexWin);
        if (path == null || path.length() == 0) {
            return null;
        }

        if (Pattern.matches(patternUnix.toString(), path) && !toWin || Pattern.matches(patternWin.toString(), path) && toWin) {
            return path;
        }
        if (Pattern.matches(patternWin.toString(), path) && !toWin) {
            String repFirst = path;

            if (path.startsWith("C:")) {
                repFirst = path.replaceFirst("C:", "");
                if (repFirst.startsWith("\\User")) {
                    repFirst = repFirst.replaceFirst("\\\\User", "~");
                }
            }
            
            if (path.startsWith("..\\")) {
                repFirst = path.replaceFirst("(\\.){2}\\\\", "../");
            }

            return repFirst.replaceAll("\\\\", "/");
        }
        if (Pattern.matches(patternUnix.toString(), path) && toWin) {
            String repFirst = path;
            if (path.startsWith("~")) {
                repFirst = path.replaceFirst("~", "C:\\\\User");
            }
            if (path.startsWith("/")) {
                repFirst = path.replaceFirst("/", "C:\\\\");
            }
            if (path.startsWith("../")) {
                repFirst = path.replaceFirst("(\\.){2}/", "..\\\\");
            }

            return repFirst.replaceAll("/", "\\\\");
        }
        return null;
    }

    public static String joinWords(String[] words) {
        boolean allNull = true;
        boolean allEmpty = true;
        if (words == null) {
            return null;
        }
        for (String val : words) {
            if (!val.isEmpty()) {
                allEmpty = false;
                break;
            }
        }
        for (String val : words) {
            if (val != null) {
                allNull = false;
                break;
            }
        }
        if (words.length == 0 || allNull || allEmpty) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < emptyArrCleaner(words).length; i++) {
            if (emptyArrCleaner(words)[i] != null && emptyArrCleaner(words)[i].length() != 0) {
                if (i == 0) {
                    builder.append("[");
                }
                builder.append(emptyArrCleaner(words)[i]);
                if (i < emptyArrCleaner(words).length - 1) {
                    builder.append(",");
                    builder.append(" ");
                }
                if (i == emptyArrCleaner(words).length - 1) {
                    builder.append("]");
                }
            }
        }
        return builder.toString();
    }
    public static String[] emptyArrCleaner(String[] array){
        int emptyValues = 0;
        for (String val : array) {
            if (val.isEmpty()) {
                emptyValues++;
            }
        }
        if (emptyValues > 0) {
            String[] withoutEmptyArr = new String[array.length - emptyValues];
            for (int i = 0, j = 0; i < array.length; i++) {
                if (!array[i].isEmpty()) {
                    withoutEmptyArr[j] = array[i];
                    j++;
                }
            }
            return withoutEmptyArr;
        }
        return array;
    }
    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}