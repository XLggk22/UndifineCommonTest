package my.test.java8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Lambda {

    public static void main(String[] args) {
        //一、无参，无返回值，Lambda 体只需一条语句
        Runnable r1 = () -> System.out.println("你妹哦！");
        r1.run();
        //Car必须是函数式接口，即里面只能有一个接口，否则会报错
        Car car = () -> System.out.println("你妹哦！");
        car.run();

        //二、有一个参数，括号不省略
        Consumer<String> consumer = (arg) -> {
            System.out.println(arg);
        };
        consumer.accept("你妹二");

        //三、有一个参数，括号省略
        Consumer<String> consumer1 = arg -> System.out.println(arg);
        consumer1.accept("你妹三！");

        //四、有两个参数、并且有返回值,多条语句
        BinaryOperator<Long> bo = (x,y) -> {
            System.out.println(" x + y =" +( x + y));
            return x + y;
        };
        System.out.println("你妹四：" + bo.apply(10L,20L));

        //五、两个参数，并且有返回值，省略大括号和return
        BinaryOperator<Long> bo2 = (x,y) -> x + y;
        System.out.println("你妹五：" + bo2.apply(10L,30L));

    }
}
