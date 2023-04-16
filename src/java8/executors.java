package java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class executors {
    //쓰레드 관리를 고수준의 api 에게 위임함
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> System.out.println("Thread" + Thread.currentThread().getName()));
        //다음 작업이 들어오기전까지 계속 수행함

        executorService.shutdown(); // 강제 종료 시켜줘야함
    }
}
