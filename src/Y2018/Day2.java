package Y2018;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Day2 {

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("D:\\Users\\Tobias\\Documents\\GitHub\\AoC\\src\\Y2018\\Day2.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }

        /*2lines.clear();
        lines.add("abcde");
        lines.add("fghij");
        lines.add("klmno");
        lines.add("pqrst");
        lines.add("fguij");
        lines.add("axcye");
        lines.add("wvxyz");
        */
        //System.out.println(calculateWords(lines));

        System.out.println(similarTo(lines));
    }

    private static String similarTo(List<String> lines) {
        int maxSimilarity = 0;
        Tuple<String,String> tuple = new Tuple<>("","");

        for(String string : lines) {
            for(String compareTo : lines) {
                if(!string.equals(compareTo)) {
                    int similarity = similarStrings(string,compareTo);
                    if(similarity > maxSimilarity) {
                        maxSimilarity = similarity;
                        tuple = new Tuple<>(string,compareTo);
                    }
                }
            }
        }

        //TODO: Get right string from tuple
        String string1 = tuple.getX();
        String string2 = tuple.getY();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < string1.length(); i++) {
            if(string1.charAt(i) == string2.charAt(i)) {
                result.append(string1.charAt(i));
            }
        }

        return result.toString();
    }

    private static int similarStrings(String string1, String string2) {
        int result = 0;
        for(int i = 0; i < string1.length(); i++) {
            if(string1.charAt(i) == string2.charAt(i)) {
                result++;
            }
        }

        return result;
    }

    private static int calculateWords(List<String> lines) {
        int checksum = 1;
        Map<Integer,Integer> map = new HashMap<>();

        for(String string : lines) {
            List<Integer> previousNumberChars = new ArrayList<>();
            for(int i = 0; i < string.length(); i++) {
                int numberOfThisChar = 0;

                for(int j = 0; j < string.length(); j++) {
                    if(string.charAt(i) == string.charAt(j)) {
                        numberOfThisChar++;
                    }
                }
                if(!previousNumberChars.contains(numberOfThisChar)) {
                    previousNumberChars.add(numberOfThisChar);
                }
            }
            for(Integer integer : previousNumberChars) {
                map.merge(integer, 1, (a, b) -> a + b);
            }
        }

        for(Integer integer : map.keySet()) {
            System.out.println("Key: " + integer + "    Value:" + map.get(integer));
            if(integer != 1) {
                checksum *= map.get(integer);
            }
        }

        return checksum;
    }

}
