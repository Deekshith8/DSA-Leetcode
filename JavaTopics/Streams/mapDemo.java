package JavaTopics.Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class mapDemo {

    public static void main(String[] args) {

        int[]arr = new int[]{2,3,4,5,6,7};

       arr= Arrays.stream(arr).map(i-> i*3).toArray();
        System.out.println(Arrays.toString(arr));


        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0,Arrays.asList("Deekshith","Divya"));
        map.put(1,Arrays.asList("Harsha","Sai"));
        map.put(2,Arrays.asList("Indhu","Sandhya"));
        map.put(3,Arrays.asList("Shraddha","Priya"));


        List<List<String>>strings = map.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        System.out.println(strings);

        List<String> asFlatStrings = map.entrySet().stream().flatMap(e->e.getValue().stream()).collect(Collectors.toList());
        System.out.println(asFlatStrings);


        List<User> users = new ArrayList<>();
        users.add(new User("Deekshith",24,Arrays.asList("User","Admin")));
        users.add(new User("Divya",25,Arrays.asList("Manager","Admin")));
        users.add(new User("Indhu",23,Arrays.asList("User","Admin")));
        users.add(new User("Harsha",20,Arrays.asList("Student","Admin")));

        List<String> userNames = users.stream().map(user -> user.getUserName()).collect(Collectors.toList());
        System.out.println(userNames);

        List<List<String>> roles = users.stream().map(user -> user.getRoles()).collect(Collectors.toList());
        System.out.println(roles);

        //to get as a single list we need to do flattering
        List<String> roless = users.stream().flatMap(user -> user.getRoles().stream()).collect(Collectors.toList());
        System.out.println(roless);

    }

}

class User{

    private String userName ;

    private int age ;

    private List<String> Roles;

    public User(String userName, int age, List<String> roles) {
        this.userName = userName;
        this.age = age;
        Roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getRoles() {
        return Roles;
    }

    public void setRoles(List<String> roles) {
        Roles = roles;
    }
}
