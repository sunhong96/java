package java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class executors {
    //쓰레드 관리를 고수준의 api 에게 위임함
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> System.out.println("Thread" + Thread.currentThread().getName()));
        //다음 작업이 들어오기전까지 계속 수행함

        executorService.shutdown(); // 강제 종료 시켜줘야함


        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.submit(getRunnable("Hello"));
        executorService1.submit(getRunnable("Keesun"));
        executorService1.submit(getRunnable("The"));
        executorService1.submit(getRunnable("Java"));
        executorService1.submit(getRunnable("Thread"));

        executorService1.shutdown();

        //ThreadPool을 사용하면 다음과 같은 이점을 얻을 수 있습니다.
        //
        //작업 처리 비용을 줄일 수 있습니다.
        //스레드를 적극적으로 재사용하여 스레드 생성에 따른 부담을 줄일 수 있습니다.
        //스레드의 개수를 제한하여 너무 많은 스레드가 동시에 실행되는 것을 방지할 수 있습니다.
        //스레드의 라이프 사이클을 관리하고 스레드가 종료되면 재사용할 수 있도록 합니다.


        ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
        executorService2.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS); //3초 후에 실행하도록함

        executorService2.shutdown();
    }
    private static Runnable getRunnable(String message)   {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
