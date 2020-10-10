package my.test.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        //method 1：array create Stream
        String[] arry = new String[]{"abc","abc", "", "bc", "efg", "abcd","", "jkl"};
        //filter
        List<String> collect = Arrays.stream(arry).filter(str -> !str.isEmpty()).collect(Collectors.toList());
        System.out.println("method 1 result 1:" + collect);
        List<String> abc = Arrays.stream(arry).filter(str -> str.equals("abc")).collect(Collectors.toList());
        System.out.println("method 1 result 2:" + abc);

        //distinct
        List<String> distinct = Arrays.stream(arry).distinct().collect(Collectors.toList());
        System.out.println("method 1 result 3 distinct:" + distinct);

        //limit
        List<String> limit = Arrays.stream(arry).limit(3).collect(Collectors.toList());
        System.out.println("method 1 result 4 limit:" + limit);

        //map
        List<String> map = Arrays.stream(arry).map(str -> str + "-aaa").collect(Collectors.toList());
        System.out.println("method 2 result 5 mapSort:" + map);

        //sort
        List<String> sort = Arrays.stream(arry).sorted().collect(Collectors.toList());
        System.out.println("method 2 result 5 mapSort:" + sort);


        //method 2：List create Stream
        List<String> stringList = Arrays.asList(arry);
        List<String> bc = stringList.stream().filter(str -> str.equals("bc")).collect(Collectors.toList());
        System.out.println("method 2 result 1:" + bc);

        //method 3: Stream.of() create Stream
        List<String> streamOf = Stream.of("abc", "", "bc").collect(Collectors.toList());
        System.out.println("method 3 result 1:" + streamOf);

        //method 4: use Stream.generate() or Stream.iterate() create Stream
    }
}
