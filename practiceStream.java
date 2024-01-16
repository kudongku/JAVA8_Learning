import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class practiceStream {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("Kim","Lee","Ku");
//
//        Iterator<String> it = list.iterator();
//        while(it.hasNext()){
//            System.out.print(it.next());
//        }
//        //KimLeeKu
//
//        list.stream().forEach(str -> System.out.print(str));
//        //KimLeeKu
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("동현", 25));
        list.add(new Customer("민지", 32));
        list.add(new Customer("성만", 23));
        Customer jung = new Customer("정현", 343);
        list.add(jung);
        list.add(jung);
        list.add(jung);
        list.add(jung);

        // ...


        Stream<Customer> stream = list.parallelStream();
        stream.filter(c->c.getAge()>23)
                .sorted()
                .map(Customer::getName)
                .forEach(System.out::println);
        System.out.println("---");
//        stream.filter(c->c.getAge()>23)
//                .distinct()
//                .forEach(c-> System.out.println(c.getName()));

        Stream.Builder<Customer> builder = Stream.builder();

    }
}