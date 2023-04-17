package java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class callable2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(4); //쓰레드가 4칸이 들어갈수있음

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> keesun = () -> {
            Thread.sleep(1000L);
            return "Keesun";
        };

//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, keesun));
//        for (Future<String> f : futures){
//            System.out.println(f.get());
//        } //한번에 출력하는것
//        // invokeAll 은 가장 늦게 나오는 게 끝날때까지 기다린다음 한번에 출력함

        String s = executorService.invokeAny(Arrays.asList(hello, java, keesun));
        System.out.println(s);
        // invokeAny 는 제일 먼저 끝나는거 먼저 출력함

        executorService.shutdown();
    }
}
