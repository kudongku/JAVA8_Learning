import java.util.*;
import java.util.stream.Collectors;

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
        list.add(new Customer("민지", 21));
        // ...


        list.stream()
                .filter(customer ->customer.age>23)
                .sorted()
                .map(Customer::getName)
                .collect(Collectors.toList())
                .forEach(name -> System.out.println(name));
    }
}
class Customer {
    String name;
    int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
}
