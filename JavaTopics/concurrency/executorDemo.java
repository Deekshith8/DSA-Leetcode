package JavaTopics.concurrency;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class executorDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

//        for(int i = 0;i< 5 ;i++){
//            executorService.submit(new task1());
//            Thread.sleep(1000);
//        }

        for(int i = 1;i<5;i++){
         Future<task2> future = executorService.submit(task2::new);

            System.out.println(future.get().message);
            Thread.sleep(1000);
        }


    }


}
class   task1 implements  Runnable{


    @Override
    public void run() {
        for(int i = 0;i< 5;i++){
            System.out.println(i+" "+Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class  task2 implements Callable{
   public   String message = "hii";
    @Override
    public String  call() throws Exception {
        Thread.sleep(1000);
        return message;
    }
}