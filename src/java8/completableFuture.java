package java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class completableFuture {
    //기존 future은 예외처리용 api가 제공안되고
    //여러 future을 조합하기 어렵고
    //블로킹코드 get()을 사용하지않고는 작업이 끝났을때 롤백을 실행할수없다
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.completedFuture("keesun");
        //ForkJoinPool은 병렬처리에 최적화된 스레드풀로, CPU 코어의 수에 맞게 스레드를 생성하고 작업을 분할하여 처리하므로,
        // 멀티코어 CPU에서 성능을 향상시킬 수 있습니다.

        System.out.println(future.get());

        System.out.println("------------------------------");

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        }); // runAsync는 리턴값이 없는 completablefuture

        System.out.println(future1.get());

        System.out.println("------------------------------");

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }); // supplyAsync 리턴값을 가지는 completablefuture
        System.out.println(future2.get()); //get을 했을때 위의 작업이 실행되는거임

        System.out.println("------------------------------");

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        // 이전에는 get을 호출하기전에 콜백으로 재정의가 안됐는데 completablefuture 여기서는 가능
        // return이 없을때는 thenApply 대신 thenAccept
        // 그냥 하기만 하면된다 thenApply 대신 thenRun

        System.out.println(future3.get());

        System.out.println("------------------------------");

        //조합하기

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> future4 = hello.thenCompose(completableFuture::getWorld);
        System.out.println(future4.get());
        //future 간의 의존성이 있는 경우(순서가 있다거나 이런거) 이렇게 씀
        //밑에 매서드를 만들어서

        System.out.println("------------------------------");

        CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello1 " + Thread.currentThread().getName());
            return "Hello1";
        });

        CompletableFuture<String> world1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("world1 " + Thread.currentThread().getName());
            return "world1";
        });

        CompletableFuture<String> future5 = hello1.thenCombine(world1, (h, w) -> h + " " + w);
        System.out.println(future5.get());

        //thenCompose() 메서드는 두 번째 CompletableFuture 객체가 첫 번째 CompletableFuture 객체의 결과값에 의존하는 경우에 사용되고,
        //thenCombine() 메서드는 두 개의 CompletableFuture 객체가 모두 완료된 후에 두 개의 결과값을 결합하여 새로운 결과값을 생성하는 경우에 사용됩니다.

        System.out.println("------------------------------");

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(hello1, world1)
                .thenAccept(System.out::println); // null값이 출력됨

        System.out.println(voidCompletableFuture);

        List<CompletableFuture<String>> futures = Arrays.asList(hello1, world1);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<Object>> listCompletableFuture = CompletableFuture.allOf(hello1, world1)
                .thenApply(v -> {
                    return futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                });

        listCompletableFuture.get().forEach(System.out::println);
        //allOf 는 두 객체가 모두 완료될 때까지 기다리는 메서드이다
        //hello1과 world1의 두 개의 비동기 작업이 모두 완료되어야 반환값이 생성됩니다.

        System.out.println("------------------------------");

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.anyOf(hello1, world1).thenAccept(System.out::println);
        voidCompletableFuture1.get();
        //둘중 아무거나 먼저 도착하는거

        System.out.println("------------------------------");

        boolean throwError = true;

        CompletableFuture<String> hello3 = CompletableFuture.supplyAsync(() ->{
            if (throwError) {
                throw new IllegalArgumentException();
            }
                System.out.println("world3 " + Thread.currentThread().getName());
                return "world3";

        }).exceptionally(ex -> {
            System.out.println(ex);
           return "Error!";
        }); //예외처리 구문 에러가 있으면 .exceptionally 이걸 실행해줌

        System.out.println(hello3.get());

        System.out.println("------------------------------");

        CompletableFuture<String> hello4 = CompletableFuture.supplyAsync(() ->{
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("world3 " + Thread.currentThread().getName());
            return "world3";

        }).handle((result, ex) ->{
            if(ex != null){
                System.out.println(ex);
                return  "Error!";
            }
            return result;
        }); // 정상값일때와 예외일때 두개를 처리할수 있는 .handle

        System.out.println(hello4.get());


    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + "World";
        });
    }


}
