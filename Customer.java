public class Customer implements Comparable<Customer>{
    String name;
    int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(Customer o) {

        if (this.age > o.getAge()) {
            return 1;
        }else if(this.age == o.getAge()){
            return -1;
        }else{
            return 0;
        }

    }
}
