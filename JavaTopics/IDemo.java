package JavaTopics;

public interface IDemo  {

    void run();

    void dance();

   default void laugh(){
       System.out.println("Laughing");
   }

   private void worKOut(){

   }

   default void work(){
       System.out.println("Working");
   }

}
