package Y2017;

import java.util.HashMap;
import java.util.Map;

public class Day18 {

    public static void main(String[] args) {
        String[][] input = createInput();

        int result = lastNotePlayed(input);

        // 7481 is too low
        // 2734 is too low
    }

    private static int lastNotePlayed(String[][] input) {
        int lastNotePlayed = 0;

        Map<String,Integer> map = createMap(input);

        for(int i = 0; i < input.length; i++) {
            String command = input[i][0];
            String register = input[i][1];
            String value = null;
            boolean valueIsNumber = false;
            if (input[i].length == 3) {
                value = input[i][2];
                valueIsNumber = !Character.isAlphabetic(value.charAt(0));
                System.out.println(value + "||" + valueIsNumber);
            }

            if(command.equals("snd")) {
                lastNotePlayed = map.get(register);
                System.out.println("Played note: " + lastNotePlayed);
            }else if(command.equals("set")) {
                if (valueIsNumber) {
                    map.replace(register,Integer.parseInt(value));
                } else {
                    map.replace(register,map.get(value));
                }
            }else if(command.equals("add")) {
                if (valueIsNumber) {
                    map.replace(register,map.get(register) + Integer.parseInt(value));
                } else {
                    map.replace(register,map.get(register) + map.get(value));
                }
            }else if(command.equals("mul")) {
                if (valueIsNumber) {
                    map.replace(register,map.get(register) * Integer.parseInt(value));
                } else {
                    map.replace(register,map.get(register) * map.get(value));
                }
            }else if(command.equals("mod")) {
                if (valueIsNumber) {
                    map.replace(register,map.get(register) % Integer.parseInt(value));
                    if (map.get(register) < 0) {
                        map.replace(register,map.get(register) + Integer.parseInt(value));
                    }
                } else {
                    map.replace(register,map.get(register) % map.get(value));
                    if (map.get(register) < 0) {
                        map.replace(register,map.get(register) + map.get(value));
                    }
                }
            }else if(command.equals("rcv")) {
                if(map.get(register) != 0) {
                    System.out.println("Last note played was: " + lastNotePlayed);
                    return lastNotePlayed;
                } else {
                    System.out.println("Register was zero, didn't return");
                }
            }else if(command.equals("jgz")) {
                if(map.get(register) != 0) {
                    if (valueIsNumber) {
                        i += Integer.parseInt(value) -1;
                    } else {
                        i += map.get(value) -1;
                    }
                } else {
                    System.out.println("Register was zero, didn't jump");
                }
            }
        }

        System.out.println("rip");
        return -1;
    }

    private static Map<String,Integer> createMap(String[][] input) {
        Map<String,Integer> map = new HashMap<>();

        for(int i = 0; i < input.length; i++) {
            String key = input[i][1];
            if(!map.containsKey(key)) map.put(key,0);
        }

        return map;
    }

    private static String[][] createInput() {
        String test = "set a 1\n" +
                "add a 2\n" +
                "mul a a\n" +
                "mod a 5\n" +
                "snd a\n" +
                "set a 0\n" +
                "rcv a\n" +
                "jgz a -1\n" +
                "set a 1\n" +
                "jgz a 1\n" +
                "jgz a -3";
        String start = "set i 31\n" +
                "set a 1\n" +
                "mul p 17\n" +
                "jgz p p\n" +
                "mul a 2\n" +
                "add i -1\n" +
                "jgz i -2\n" +
                "add a -1\n" +
                "set i 127\n" +
                "set p 622\n" +
                "mul p 8505\n" +
                "mod p a\n" +
                "mul p 129749\n" +
                "add p 12345\n" +
                "mod p a\n" +
                "set b p\n" +
                "mod b 10000\n" +
                "snd b\n" +
                "add i -1\n" +
                "jgz i -9\n" +
                "jgz a 3\n" +
                "rcv b\n" +
                "jgz b -1\n" +
                "set f 0\n" +
                "set i 126\n" +
                "rcv a\n" +
                "rcv b\n" +
                "set p a\n" +
                "mul p -1\n" +
                "add p b\n" +
                "jgz p 4\n" +
                "snd a\n" +
                "set a b\n" +
                "jgz 1 3\n" +
                "snd b\n" +
                "set f 1\n" +
                "add i -1\n" +
                "jgz i -11\n" +
                "snd a\n" +
                "jgz f -16\n" +
                "jgz a -19";

        String[] str1 = test.split("\n");
        String[][] matrix = new String[str1.length][];
        for (int i = 0; i < matrix.length; i++) {
            String[] str2 = str1[i].split(" ");
            matrix[i] = new String[str2.length];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = str2[j];
            }
        }

        return matrix;
    }
}
