package Y2018;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\Tobias\\Documents\\AoC\\src\\Y2018\\Day3.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }

        /*
        lines.clear();
        lines.add("#1 @ 1,3: 4x4");
        lines.add("#2 @ 3,1: 4x4");
        lines.add("#3 @ 5,5: 2x2");*/

        System.out.println(findOverlapping(lines));
    }

    private static int findOverlapping(List<String> lines) {
        //List<List<Integer>> fabric = new ArrayList<>(1000);
        int[][] fabric = new int[1000][1000];
        //Fabric fabric = new Fabric();

        for(String string : lines) {
            //string.matches("#"+"1-2000"+" @ "+"0-2000"+","+"0-1000"+": "+"0-1000"+"x"+"0-1000");
            StringBuilder stringBuilder = new StringBuilder(string);
            StringBuilder startX = new StringBuilder();
            StringBuilder startY = new StringBuilder();
            StringBuilder sizeX = new StringBuilder();
            StringBuilder sizeY = new StringBuilder();
            for(int i = 0; i < stringBuilder.length(); i++) {
                //stringBuilder.deleteCharAt(i);
                if(string.charAt(i) == '@') {
                    //stringBuilder.deleteCharAt(i); // removes a space
                    i++;
                    i++;
                    while (stringBuilder.charAt(i) != ',') {
                        startX.append(stringBuilder.charAt(i));
                        i++;
                    }
                    i++;
                    while (stringBuilder.charAt(i) != ':') {
                        startY.append(stringBuilder.charAt(i));
                        i++;
                    }
                    //stringBuilder.deleteCharAt(i); // removes a space
                    i++;
                    i++;
                    while (stringBuilder.charAt(i) != 'x') {
                        sizeX.append(stringBuilder.charAt(i));
                        i++;
                    }
                    i++;
                    while (stringBuilder.length() > i) {
                        sizeY.append(stringBuilder.charAt(i));
                        i++;
                    }
                    break;
                } else {
                    //stringBuilder = stringBuilder.deleteCharAt(i);
                }
            }
            int iStartX = Integer.parseInt(startX.toString());
            int iStartY = Integer.parseInt(startY.toString());
            int iSizeX = Integer.parseInt(sizeX.toString());
            int iSizeY = Integer.parseInt(sizeY.toString());

            for (int i = 0; i < iSizeX; i++) {
                for (int j = 0; j < iSizeY; j++) {
                    fabric[iStartX+i][iStartY+j] += 1;
                }
            }

        }

        int result = 0;

        for (int i = 0; i < fabric.length; i++) {
            for (int j = 0; j < fabric.length; j++) {
                if (fabric[i][j] >= 2) {
                    result++;
                }
            }
        }

        return result;
    }
}

/*class Fabric {
    List<List<Integer>> fabric = new ArrayList<>();
    int needleX, needleY = 0;

    Fabric() {
    }
}*/
