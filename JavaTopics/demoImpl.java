package JavaTopics;

public class demoImpl implements IDemo{

    //eventhough demoImpl2 is implemented the methods all the impl classed of interface need to implement the
    // all abstract methods in interface


    @Override
    public void run() {

    }

    @Override
    public void dance() {

    }

    public static void main(String[] args) {

        IDemo iDemo = new demoImpl();

        iDemo.laugh();

       // iDemo.work(); showing error because i cant access tghe static methods in interface unlike abstract class

    }
}
