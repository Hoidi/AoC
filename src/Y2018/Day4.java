package Y2018;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day4 {

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("D:\\Users\\Tobias\\Documents\\GitHub\\AoC\\src\\Y2018\\Day4.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }

        /*try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\Tobias\\Documents\\AoC\\src\\Y2018\\Day4Example.txt"), Charset.defaultCharset());
        } catch(IOException e) {
            e.printStackTrace();
        }*/

        lines.sort(String::compareTo);


        System.out.println(sleepyMinutes(lines));
    }

    private static int sleepyMinutes(List<String> lines) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        DateFormat format = new SimpleDateFormat("[yyyy-MM-dd HH:mm]");

        int guardId = 0;
        int lineIndex = 0;
        List<Date> dates = new ArrayList<>();
        while(lineIndex < lines.size()) {
            while(lines.get(lineIndex).charAt(19) != 'G') {
                try {
                    dates.add(format.parse(lines.get(lineIndex)));
                } catch(ParseException e) {
                    e.printStackTrace();
                }
                lineIndex++;
                if(lineIndex == lines.size()) {
                    break;
                }
                // now we have a list of dates, every other the guard wakes up and falls asleep
            }
            List<Integer> sleepingTime = calculateSleepyTimes(dates);
            dates.clear();
            // now add all the sleeping time to the guard in the map
            if(map.get(guardId) == null) {
                List<Integer> list = sleepingTime;
                map.put(guardId,sleepingTime);  // found new guard
            } else {
                map.get(guardId).addAll(sleepingTime); // old guard, add more sleep
            }
            if(lineIndex == lines.size()) {
                break;
            }
            // the current line is a line with a new guard
            StringBuilder guardIdString = new StringBuilder(lines.get(lineIndex).substring(26));
            guardIdString.reverse().delete(0,13).reverse(); // removed " begins shift"
            guardId = Integer.parseInt(guardIdString.toString());
            lineIndex++;
        }

        //map.remove(0);
        int guardWithMostSleep = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer).size() > map.get(guardWithMostSleep).size()) {
                guardWithMostSleep = integer;
            }
        }

        int mostCommonMinute = mostCommon(map.get(guardWithMostSleep));

        return mostCommonMinute*guardWithMostSleep;
    }

    private static List<Integer> calculateSleepyTimes(List<Date> dates) {
        List<Integer> sleepingMinutes = new ArrayList<>();
        while(dates.size() >= 2) {Date wentToSleep = dates.get(0);
            Calendar wentToSleepCal = toCalendar(wentToSleep);
            Date wokeUp = dates.get(1);
            Calendar wokeUpCal = toCalendar(wokeUp);
            int totalTimeAsleep = (int) getDateDiff(wentToSleep,wokeUp,TimeUnit.MINUTES);
            dates.remove(0);
            dates.remove(0);
            while(totalTimeAsleep > 0) {
                sleepingMinutes.add(wokeUpCal.get(Calendar.MINUTE)-totalTimeAsleep);
                totalTimeAsleep--;
            }
        }
        return sleepingMinutes;
    }

    private static int sleepyTime(List<String> lines) {
        Map<Integer, Integer> map = new HashMap<>();
        DateFormat format = new SimpleDateFormat("[yyyy-MM-dd HH:mm]");

        int guardId = 0;
        int lineIndex = 0;
        List<Date> dates = new ArrayList<>();
        while(lineIndex < lines.size()) {
            System.out.println(lineIndex);
            System.out.println(lines.size());
            System.out.println("------------");
            while(lines.get(lineIndex).charAt(19) != 'G') {
                try {
                    dates.add(format.parse(lines.get(lineIndex)));
                } catch(ParseException e) {
                    e.printStackTrace();
                }
                lineIndex++;
                System.out.println(lineIndex);
                System.out.println(lines.size());
                System.out.println("------------");
                if(lineIndex == lines.size()) {
                    break;
                }
                // now we have a list of dates, every other the guard wakes up and falls asleep
            }
            int sleepingTime = calculateSleepyTime(dates);
            dates.clear();
            // now add all the sleeping time to the guard in the map
            if(map.get(guardId) == null) {
                map.put(guardId,sleepingTime);  // found new guard
            } else {
                map.replace(guardId,map.get(guardId)+sleepingTime); // old guard, add more sleep
            }
            if(lineIndex == lines.size()) {
                break;
            }
            // the current line is a line with a new guard
            StringBuilder guardIdString = new StringBuilder(lines.get(lineIndex).substring(26));
            guardIdString.reverse().delete(0,13).reverse(); // removed " begins shift"
            guardId = Integer.parseInt(guardIdString.toString());
            lineIndex++;
        }

        map.remove(0);
        int guardWithMostSleep = 0;
        for (Integer integer : map.keySet()) {
            if (integer > guardWithMostSleep) {
                guardWithMostSleep = integer;
            }
        }

        int result = map.get(guardWithMostSleep)*guardWithMostSleep;

        return result;
    }

    private static int calculateSleepyTime(List<Date> dates) {
        int totalTimeAsleep = 0;
        while(dates.size() >= 2) {
            Date wentToSleep = dates.get(0);
            Calendar wentToSleepCal = toCalendar(wentToSleep);
            Date wokeUp = dates.get(1);
            Calendar wokeUpCal = toCalendar(wokeUp);
            totalTimeAsleep += getDateDiff(wentToSleep,wokeUp,TimeUnit.MINUTES);
            dates.remove(0);
            dates.remove(0);
        }
        return totalTimeAsleep;
    }

    /**
     * Get a diff between two dates
     * @param date1 the oldest date
     * @param date2 the newest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

    public static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue()) {
                max = e;
            }
        }

        return max.getKey();
    }

    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    
}
