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
## stream 객체 생성
### collection 을 사용하여 stream 객체 생성하기
> collection interface를 상속받는 List, Set, Queue
> 
> 이 collection 객체를 통해 stream 의 메소드들을 사용가능

- 스트림은 사용한 후 다시 사용 불가능 하다.
- 즉 전체 데이터에 대한 처리가 이루어지면 사라진다.
```
Stream<Customer> stream = list.stream();
```
### stream builde를 사용하여 stream 객체 생성
많이 사용하지는 않는다.
```
Stream.Builder<Customer> builder = Stream.builder();
```
## stream 연산
- stream 의 연산은 각 연산의 연결을 통해 파이프라인을 구성할 수 있다.
- stream 의 연산은 중간연산과 최종연산으로 나누어진다.
---
### 중간연산
- filter 나 mapping 이 이에 해당
- stream 으로 반환해준다.
### 최종연산
- forEach count collect sum reduce
- void 혹은 컬렉션 타입 을 반환
- 최종 연산 훙는 소모된 스트림은 닫히고 재사용이 불가능하다.
---
```
        list.stream()
                .filter(customer ->customer.age>23)
                .sorted()
                .map(Customer::getName)
                .collect(Collectors.toList())
                .forEach(name -> System.out.println(name));
```
- 중간연산은 filter, sort, map이 이에 해당
- 최종연산은 forEach로 void를 return
## filter
- 데이터에서 원하는 데이터만 추출하는 메소드
- filter(), 혹은 distinct() 와 같은 메소드를 이용한다.
- 람다식을 사용한다.
### 예제 1
```
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("동현", 25));
        list.add(new Customer("민지", 32));
        list.add(new Customer("성만", 23));
        Customer jung = new Customer("정현", 343);
        list.add(jung);
        list.add(jung);
        list.add(jung);
        list.add(jung);
```
----
```
        stream.filter(c->c.getAge()>23)
                .distinct()
                .forEach(c-> System.out.println(c.getName()));
```
의 출력값은
```
동현
민지
정현
```
---
```
        stream.filter(c->c.getAge()>23)
                .forEach(c-> System.out.println(c.getName()));
```
의 출력값은 
```
동현
민지
정현
정현
정현
정현
```