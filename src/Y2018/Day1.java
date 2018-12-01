package Y2018;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Day1 {

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("D:\\Users\\Tobias\\Documents\\GitHub\\AoC\\src\\Y2018\\Day1.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }


        Day1 day1 = new Day1();

        System.out.println(day1.calculateFreq(lines));
    }

    private Map<Integer,Boolean> map = new HashMap<>(5000);
    int sum = 0;

    private int calculateFreq(List<String> lines) {
        //int sum = 0;

        for(String string : lines) {
            if(map.get(sum) != null) {
                //if(map.get(sum))
                    return sum;
                    //map.put(sum,true);
            } else {
                map.put(sum,false);
            }

            if(string.charAt(0) == '+') {
                sum += Integer.parseInt(string.substring(1));
            } else if(string.charAt(0) == '-') {
                sum -= Integer.parseInt(string.substring(1));
            }
        }

        /*for(Integer integer : map.keySet()) {
            if(map.get(integer)) {
                return integer;
            }
        }*/
        calculateFreq(lines);

        return sum;
    }


    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
