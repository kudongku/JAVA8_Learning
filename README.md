# stream

## 개요
1. Stream API 를 활용하여, 데이터를 처리
2. Collection을 주로 처리
3. 람다를 필요로 한다.
### 예제1
```
List<String> list = Arrays.asList("Kim","Lee","Ku");
```
위 리스트를 활용한 코드 두개이다.
```
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
        //KimLeeKu
```
```
        list.stream().forEach(str -> System.out.print(str));
        //KimLeeKu
```
위의 2개의 코드는 출력되는 것이 똑같다.

### 예제2
```
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("동현", 25));
        list.add(new Customer("민지", 21));
        // ...
```
위 리스트를
1. 나이가 23살 이상인 customer 들만,
2. 나이 오름차순으로,
3. 이름들을 출력한다. 

어떻게 구현할 것인가?
> 1. 리스트를 순회하며 if 문을 통해, 23 이상의 customer를 담는 리스트 생성
> 2. 리스트를 순회하며 이름들만 담는, 리스트 생성
> 3. 리스트를 순회하며 출력

스트림을 사용한다면?
```
        list.stream()
                .filter(customer ->customer.age>23)
                .sorted()
                .map(Customer::getName)
                .collect(Collectors.toList())
                .forEach(name -> System.out.println(name));
```