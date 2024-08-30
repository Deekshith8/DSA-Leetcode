package jpProblems;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class executorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);
       for(int i = 0 ;i< 100 ;i++) {
           Future<String> result = service.submit(() -> {
               System.out.println("Hii im thread " + Thread.currentThread());
               return "Hii im thread " + Thread.currentThread();
           });
       }

//       String s =  result.get();
//        System.out.println(s);

    }
}
