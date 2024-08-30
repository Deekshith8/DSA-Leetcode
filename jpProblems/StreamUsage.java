package jpProblems;

import java.util.*;
import java.util.stream.Collectors;

public class StreamUsage   {

    private final int i ;

    public StreamUsage(int i) {
        this.i = i;
    }


    static class Employee {
        private String name;

        private int age;

        private int salary;

        private  String dept;

        public Employee(String name , int age , int salary,String dept){
            this.name =name;
            this.age = age;

            this.salary = salary;
            this.dept = dept;
        }
        public  int getAge(){
            return this.age;
        }
        @Override
        public String toString() {
            return "Employee{name='" + name + "', age=" + age + "}";
        }


    }
    public static void main(String[] args) {

        List<Integer> l1=new ArrayList<>();

        l1.add(20);
        l1.add(26);
        l1.add(12);
        l1.add(14);
        l1.add(10);



        List<?>result= l1.stream().filter(integer -> integer%2==0).sorted().collect(Collectors.toList());

        System.out.println(result);

         l1.stream().filter(integer -> integer%2==0).map(i->i*2).forEach(integer -> System.out.println(integer));



      //  l1.stream().sorted().forEach(integer -> System.out.println(integer));


       // System.out.println( l1.stream().count());


        List<String>l2= new ArrayList<>();
        l2.add("Harsha");
        l2.add("Deek");
        l2.add("Adi");
        l2.add("divya");
        l2.add("Indhu");
        l2.add("Bharath");

        List<String>sortedlist=l2.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedlist);

       List<Integer> list2 = Arrays.asList(10,20,9,8,15);

        System.out.println(list2);

        //list2.stream().map(Comparator::comparingInt);

        result =  list2.stream().map(i-> i*2).collect(Collectors.toList());
        System.out.println(result);


        Map<Integer , Employee>map = new HashMap<>();
        map.put(1, new Employee("Deek",51, 50000,"IT"));
        map.put(2, new Employee("Divya",55 , 40000,"IT"));
        map.put(3, new Employee("Harsha",65 , 65000,"IT"));
        map.put(4, new Employee("Indhu",45, 70000,"IT"));

        List<Map.Entry<Integer, Employee>> sortedList = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Employee::getAge)))
                .collect(Collectors.toList());

        System.out.println(sortedList);

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Deek",51, 40000 , "IT"));
        list.add(new Employee("Divya",55 , 40000, "CSE"));
        list.add(new Employee("Harsha",65 , 65000, "IT"));
        list.add(new Employee("Indhu",55, 70000,"CSE"));

        Optional<Employee> ans = list.stream()
                .filter((Employee e)-> e.age>50 && e.dept.equals("CSE"))
                .max((e1,e2)-> e1.salary- e2.salary);

        System.out.println(ans.toString());




    }

}
