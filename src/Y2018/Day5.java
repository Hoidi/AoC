package Y2018;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5 {

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\Tobias\\Documents\\AoC\\src\\Y2018\\Day5.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }
        //lines.clear();
        //lines.add("dabAcCaCBAcCcaDA");

        String string = lines.get(0);

        System.out.println("Length: " + eliminatePolar(string).length());


        Map<Character,String> map = new HashMap<>();

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (char c: alphabet) {
            map.put(c, onlyEliminatePolar(string,c));
            map.replace(c,eliminatePolar(map.get(c)));
        }

        String tiny = "";
        for (String s: map.values()) {
            if(s.length() < tiny.length() || tiny.equals("")) {
                tiny = s;
            }
        }

        System.out.println("Shortest length: " + tiny.length());
    }

    private static String onlyEliminatePolar(String input, char onlyThis) {
        StringBuilder sb = new StringBuilder(input);

        boolean hasRemoved = false;
        do {
            hasRemoved = false;
            for (int i = 0; i < sb.length(); i++) {
                char c1 = sb.charAt(i);
                //char c2 = sb.charAt(i+1);

                if(verySameButDifferent(c1,onlyThis)) {
                    sb.deleteCharAt(i);
                    hasRemoved = true;
                }
            }
        } while (hasRemoved);

        return sb.toString();
    }

    private static String eliminatePolar(String input) {
        StringBuilder sb = new StringBuilder(input);

        boolean hasRemoved;
        do {
            hasRemoved = false;
            for (int i = 0; i < sb.length()-1; i++) {
                char c1 = sb.charAt(i);
                char c2 = sb.charAt(i+1);

                if(sameButDifferent(c1,c2)) {
                    sb.delete(i,i+2);
                    hasRemoved = true;
                }
            }
        } while (hasRemoved);

        return sb.toString();
    }

    private static boolean sameButDifferent(char c1, char c2) {
        if ((Character.isUpperCase(c1) && Character.isLowerCase(c2)) || (Character.isUpperCase(c2) && Character.isLowerCase(c1))) {
            return Character.toLowerCase(c1) == Character.toLowerCase(c2);
        }
        return false;
    }

    private static boolean verySameButDifferent(char c1, char onlyThis) {
        /*if ((Character.isUpperCase(c1) && Character.isLowerCase(c2)) || (Character.isUpperCase(c2) && Character.isLowerCase(c1))) {
            return Character.toLowerCase(c1) == onlyThis && Character.toLowerCase(c2) == onlyThis;
        }*/
        return Character.toLowerCase(c1) == onlyThis;
    }
}
