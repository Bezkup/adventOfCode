package main.kotlin._2024;

import main.kotlin.UtilJava;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    private static final Pattern pattern1 = Pattern.compile("mul\\(\\d+,\\d+\\)");
    private static final Pattern pattern2 = Pattern.compile("\\d+,\\d+");

    private static final Pattern pattern3 = Pattern.compile("do\\(\\)|don't\\(\\)|mul\\(\\d+,\\d+\\)");

    private static void part1(List<String> input) {
        int result = 0;
        for (String line : input) {
            Matcher matcher = pattern1.matcher(line);
            while (matcher.find()) {
                String group = matcher.group();
                Matcher matcher2 = pattern2.matcher(group);
                if (matcher2.find()) {
                    String[] split = matcher2.group().split(",");
                    int a = Integer.parseInt(split[0]);
                    int b = Integer.parseInt(split[1]);
                    result += a * b;
                }
            }
        }
        System.out.println(result);
    }

    private static void part2(List<String> input) {
        int result = 0;
        boolean isEnabled = true;
        for (String line : input) {
            Matcher matcher = pattern3.matcher(line);
            while (matcher.find()) {
                String group = matcher.group();
                if (group.equals("do()")) {
                    isEnabled = true;
                } else if (group.equals("don't()")) {
                    isEnabled = false;
                }
                if (isEnabled && group.startsWith("mul")) {
                    Matcher matcher2 = pattern2.matcher(group);
                    if (matcher2.find()) {
                        String[] split = matcher2.group().split(",");
                        int a = Integer.parseInt(split[0]);
                        int b = Integer.parseInt(split[1]);
                        result += a * b;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        List<String> input = UtilJava.readInput("_2024/day3.txt");
        part1(input);
        part2(input);
    }
}
