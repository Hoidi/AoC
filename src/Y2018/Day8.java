package Y2018;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Day8 {

    static class Node {
        List<Integer> metadata = new ArrayList<>();
        List<Node>  childNodes = new ArrayList<>();

        Node(int NOChildNodes, Deque<Integer> stack) {
            int NOMetadata = stack.poll();
            while(NOChildNodes != 0) {
                childNodes.add(new Node(stack.poll(), stack));
                NOChildNodes--;
            }

            while(NOMetadata != 0) {
                metadata.add(stack.poll());
                NOMetadata--;
            }
        }

        int getSumOfMetadata() {
            int sum = 0;
            for(Integer integer: metadata) sum += integer;
            return sum;
        }

        int getTotalSum() {
            int sum = getSumOfMetadata();
            for(Node node: childNodes) sum += node.getTotalSum();
            return sum;
        }

        int getTotalSum2() {
            int sum = 0;
            if(childNodes.isEmpty()) {
                sum += getSumOfMetadata();
            } else {
                for(Integer integer : metadata) {
                    if(integer != 0 && integer <= childNodes.size()) {
                        Node child = childNodes.get(integer - 1);
                        if(child != null) {
                            sum += child.getTotalSum2();
                        }
                    }
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("D:\\Users\\Tobias\\Documents\\GitHub\\AoC\\src\\Y2018\\Day8.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }

        //lines.clear();
        //lines.add("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2");

        //System.out.println(calculateWords(lines));

        List<String> strList = new ArrayList<>(Arrays.asList(lines.get(0).split(" ")));
        List<Integer> intList = new ArrayList<>();
        for(String s : strList) intList.add(Integer.valueOf(s));

        System.out.println(metadata(intList));
    }

    private static int metadata(List<Integer> list) {
        Deque<Integer> stack = new ArrayDeque<>(list);
        Node startingNode = new Node(stack.poll(), stack);
        return startingNode.getTotalSum2();
    }

}
