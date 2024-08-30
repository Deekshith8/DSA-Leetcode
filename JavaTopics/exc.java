package JavaTopics;

public class exc {

    void m1() throws RuntimeException{
        System.out.println("in m1 of exc class");
    }
    private void m2(){
        System.out.println("in m2 of exc class");
    }

}
class exc2 extends  exc{

//    @Override
//    void m1() throws Exception {
//        System.out.println("in m1 of exc2 class");
//    }

    @Override
    void m1()throws RuntimeException{
        System.out.println("in m1 of exc2 class");
    }


}
class solution{
    public static void main(String[] args) throws Exception {
        exc ex = new exc2();

        ex.m1();

    }
}
