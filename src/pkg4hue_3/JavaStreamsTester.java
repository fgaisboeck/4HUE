package pkg4hue_3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamsTester {
    private static int getCountEmptyString(List<String> strings)
    {
         return strings.stream().filter(s -> s.isEmpty()).collect(Collectors.toList()).size();
    }
    
    private static int getCountLength3(List<String> strings)
    {
        return strings.stream().filter(s -> s.length()==3).collect(Collectors.toList()).size();
    }
    
    private static List<String> deleteEmptyStrings(List<String> strings)
    {
        return strings.stream().filter(s -> !s.equals("")).collect(Collectors.toList());
    }
    
    private static String getMergedString(List<String> strings, String separator)
    {
        return strings.stream().reduce((x, y)->x+separator+y).get();
    }
    
    private static List<Integer> getSquares(List<Integer> numbers)
    {
        return numbers.stream().map(i->(int)Math.pow(i, 2)).collect(Collectors.toList());
    }
    
    private static int getMax(List<Integer>numbers)
    {
        return numbers.stream().mapToInt(v->v).max().orElseThrow();
    }
    
    private static int getMin(List<Integer>numbers)
    {
        return numbers.stream().mapToInt(v->v).min().orElseThrow();
    }
    
    private static int getSum(List<Integer>numbers)
    {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
    
    private static int getAverage(List<Integer>numbers)
    {
        return (int) numbers.stream().mapToInt(Integer::intValue).average().orElseThrow();
    }
    
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("abc");
        strings.add("def");
        strings.add("ghi");
        
        System.out.println("empty: " + getCountEmptyString(strings));
        System.out.println("3: " + getCountLength3(strings));
        System.out.println("delete emty: ");
        deleteEmptyStrings(strings).stream().forEach(n -> System.out.println(n));
        System.out.println("merge: " + getMergedString(strings, ";"));
        
        List<Integer> numbers = new ArrayList<>();
        
        numbers.add(0);
        numbers.add(15);
        numbers.add(550);
        numbers.add(2);
        
        System.out.println("max: " + getMax(numbers));
        System.out.println("min: " + getMin(numbers));
        System.out.println("sum: " + getSum(numbers));
        System.out.println("average: " + getAverage(numbers));
        
    }
}
