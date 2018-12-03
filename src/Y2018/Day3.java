package Y2018;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Day3 {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("D:\\Users\\Tobias\\Documents\\GitHub\\AoC\\src\\Y2018\\Day3.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }


        /*lines.clear();
        lines.add("#1 @ 1,3: 4x4");
        lines.add("#2 @ 3,1: 4x4");
        lines.add("#3 @ 5,5: 2x2");*/

        System.out.println("Result: " + findOverlapping(lines));
    }

    private static int findOverlapping(List<String> lines) {
        List<List<List<Integer>>> fabricList = new ArrayList<List<List<Integer>>>(1000);
        Map<Integer,List<Position>> mapId = new HashMap<>(2000);
        Map<Position,List<Integer>> mapPos = new HashMap<>(1000000);
        int[][] fabric = new int[1000][1000];

        for(String string : lines) {
            StringBuilder stringBuilder = new StringBuilder(string);
            StringBuilder startX = new StringBuilder();
            StringBuilder startY = new StringBuilder();
            StringBuilder sizeX = new StringBuilder();
            StringBuilder sizeY = new StringBuilder();

            StringBuilder id = new StringBuilder();
            boolean fistTime = true;
            for(int i = 1; i < stringBuilder.length(); i++) {
                while (fistTime && stringBuilder.charAt(i) != ' ') {
                    id.append(stringBuilder.charAt(i));
                    i++;
                }
                fistTime = false;
                if(string.charAt(i) == '@') {
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
                }
            }
            int iStartX = Integer.parseInt(startX.toString());
            int iStartY = Integer.parseInt(startY.toString());
            int iSizeX = Integer.parseInt(sizeX.toString());
            int iSizeY = Integer.parseInt(sizeY.toString());

            for (int i = 0; i < iSizeX; i++) {
                for (int j = 0; j < iSizeY; j++) {
                    fabric[iStartX+i][iStartY+j] += 1;
                    Position thisPosition = new Position(iStartX+i,iStartY+j);
                    if(mapId.get(Integer.parseInt(id.toString())) == null) {
                        mapId.put(Integer.parseInt(id.toString()),new ArrayList<>());
                    }
                    mapId.get(Integer.parseInt(id.toString())).add(thisPosition);

                    if(mapPos.get(thisPosition) == null) {
                        mapPos.put(thisPosition,new ArrayList<>());
                    }
                    mapPos.get(thisPosition).add(Integer.parseInt(id.toString()));
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

        for(Position pos: mapPos.keySet()) {
            List<Integer> list = mapPos.get(pos);
            if(list.size() > 1) {
                for(Integer integer : list) {
                    mapId.remove(integer);
                }
            }
        }

        for(Integer integer : mapId.keySet()) {
            System.out.println(integer);
        }

        return result;
    }
}

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
