package Y2018;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day4 {

    public static void main(String[] args) {
        List<String> lines = null;
        /*try {
            lines = Files.readAllLines(Paths.get("D:\\Users\\Tobias\\Documents\\GitHub\\AoC\\src\\Y2018\\Day4.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }*/

        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\Tobias\\Documents\\AoC\\src\\Y2018\\Day4Example.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }

        lines.sort(String::compareTo);


        System.out.println(sleepyTime(lines));
    }

    private static int sleepyTime(List<String> lines) {
        return 0;
    }
}
