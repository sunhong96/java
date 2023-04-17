package java8;

import java.util.concurrent.*;

public class callable {
    //runnable 과 유사하지만 다르게 return 값을 가질 수 있다
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //리턴하려는 타입을 제너릭 타입으로주면댐
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        //Future는 비동기적으로 실행되는 작업의 결과를 나타내는 인터페이스입니다.
        // Future는 작업의 진행 상태를 추적하고 작업이 완료되면 결과를 얻을 수 있도록 해줍니다.
        // Future는 java.util.concurrent 패키지에 정의되어 있으며, ExecutorService와 함께 자주 사용됩니다.
        //
        //Future 인터페이스의 주요 메서드는 다음과 같습니다.
        //
        //isDone(): 작업이 완료되었는지 여부를 반환합니다.
        //get(): 작업이 완료될 때까지 기다리고, 결과를 반환합니다.
        //get(timeout, unit): 작업이 완료될 때까지 지정된 시간만큼 기다리고, 결과를 반환합니다.
        //cancel(mayInterruptIfRunning): 작업을 취소합니다.

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

        //get 이전까지는 안기다리고 실행이됨
        helloFuture.get(); // get 을 만난순간 멈추고 결과값을 가져올때까지 기다림

        System.out.println(helloFuture.isDone());
        System.out.println("End!!");
        executorService.shutdown();

        helloFuture.cancel(true);
        //cancel(true): 작업이 실행 중인 상태라면, 해당 작업에 인터럽트(interrupt)를 보냅니다.
        // 인터럽트를 받은 작업은 InterruptedException 예외를 발생시키고 종료됩니다. 작업이 실행되지 않은 상태라면, 해당 작업은 취소됩니다.
        //cancel(false): 해당 작업을 취소합니다. 실행 중인 작업은 완료될 때까지 계속 실행됩니다.
        // 인터럽트를 발생시키지 않습니다.
        //즉, cancel(true) 메서드를 호출하면, 현재 작업이 실행 중인 경우 인터럽트를 보내 작업을 취소할 수 있습니다.
        // 그러나 실행 중이지 않은 경우 즉시 작업을 취소할 수 있습니다.
        // 반면, cancel(false) 메서드는 인터럽트를 발생시키지 않고 작업을 취소합니다.

        // 인터럽트(Interrupt)란, 하나의 쓰레드(Thread)에서 다른 쓰레드로 신호를 보내는 것을 말합니다.
        // 쓰레드가 인터럽트를 받으면, 현재 수행 중인 작업을 중단하고 인터럽트 신호를 처리합니다.
        // 이를 통해 쓰레드 간 통신과 작업 제어를 할 수 있습니다.
    }
}
