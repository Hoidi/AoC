package Y2018;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Format;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Day6 {

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("D:\\Users\\Tobias\\Documents\\GitHub\\AoC\\src\\Y2018\\Day6.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }

        /*try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\Tobias\\Documents\\AoC\\src\\Y2018\\Day4Example.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }*/

        /*lines.clear();
        lines.add("1, 1");
        lines.add("1, 6");
        lines.add("8, 3");
        lines.add("3, 4");
        lines.add("5, 5");
        lines.add("8, 9");*/

        System.out.println(area(lines));

        System.out.println(mDistance(0,0,2,2));
    }

    private static int area(List<String> lines) {
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();


        for(String currentLine : lines) {
            StringBuilder xSb = new StringBuilder();
            StringBuilder ySb = new StringBuilder();
            int lineIndex = 0;
            while(currentLine.charAt(lineIndex) != ',') {
                xSb.append(currentLine.charAt(lineIndex));
                lineIndex++;
            }
            lineIndex += 2;
            while(lineIndex < currentLine.length()) {
                ySb.append(currentLine.charAt(lineIndex));
                lineIndex++;
            }
            int x = Integer.parseInt(xSb.toString());
            int y = Integer.parseInt(ySb.toString());

            xs.add(x);
            ys.add(y);
        }

        Point[][] points = new Point[findMax(xs)][findMax(ys)];

        for(int i = 0; i < xs.size(); i++) {
            for(int j = 0; j < points.length; j++) {
                for(int k = 0; k < points[0].length; k++) {
                    if(points[j][k] == null) {
                        points[j][k] = new Point(j,k);
                    }
                    points[j][k].distanceTo(xs.get(i),ys.get(i),i);
                }
            }
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                if(points[i][j].closestTo == null) {
                    System.out.print(". ");
                } else if (points[i][j].distanceToClosest == 0) {
                    System.out.print("x ");
                } else {
                    System.out.print(points[i][j].closestTo + " ");
                }

            }
            System.out.println();
        }

        //List<Integer> ids = new ArrayList<>(10);
        Map<Integer,Integer> ids = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points[0].length; j++) {
                Point thisPoint = points[i][j];
                //if(ids.get())
                if(null == ids.get(thisPoint.closestTo)) {
                    ids.put(thisPoint.closestTo,1);
                } else {
                    ids.put(thisPoint.closestTo, ids.get(thisPoint.closestTo) + 1);
                }
            }
        }
        ids.remove(null);
        //ids.sort(Integer::compareTo);

        for(int i = 0; i < points[0].length; i++) {
            ids.remove(points[0][i].closestTo);
        }
        for(int i = 0; i < points.length; i++) {
            ids.remove(points[i][0].closestTo);
        }
        for(int i = 0; i < points[0].length; i++) {
            ids.remove(points[points.length-1][i].closestTo);
        }
        for(int i = 0; i < points.length; i++) {
            ids.remove(points[i][points.length-1].closestTo);
        }

        return ids.get(ids.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());
    }

    private static int findMax(List<Integer> list) {
        List<Integer> listCopy = new ArrayList<>(list);
        listCopy.sort(Integer::compareTo);
        return listCopy.get(listCopy.size()-1);
    }

    public static int mDistance(int x1, int y1, int x2, int y2) {
        int x=Math.abs(x1-x2);
        int y=Math.abs(y1-y2);
        return (x+y);
    }

    static class Point {
        Integer closestTo = null;
        int distanceToClosest = 10000000;
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void distanceTo(int x, int y, int id) {
            if(mDistance(this.x,this.y,x,y) == distanceToClosest) {
                closestTo = null;
            } else if(mDistance(this.x,this.y,x,y) < distanceToClosest) {
                closestTo = id;
                distanceToClosest = mDistance(this.x,this.y,x,y);
            } /*else if(closestTo == null) {
                closestTo = id;
                distanceToClosest = mDistance(this.x,this.y,x,y);
            }*/
        }
    }
}
