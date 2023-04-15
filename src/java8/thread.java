package java8;

public class thread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread" + Thread.currentThread().getName());
                try{
                    Thread.sleep(1000L);
                }catch (InterruptedException e){
                    System.out.println("exit!");
                    return;
                }
            }
        });
        thread.start();

        Thread.sleep(3000L);
        thread.interrupt(); // thread.sleep()으로 일시정지 상태일때 바로 종료해주는게아님 예외를 발생시켜주는것

        System.out.println("Hello" + Thread.currentThread().getName());
    }
}
