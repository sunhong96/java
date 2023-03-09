package chap_12;

public class _04_MultiThread { //한개가 오류난다고해도 한개는 돌아감
    public static void main(String[] args) {
        Runnable cleaner1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("-- 직원1 청소 시작  --");
                for (int i = 1; i <= 10; i += 2) {
                    System.out.println("(직원1)" + i + "번방 청소 중 ");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("-- 직원1 청소 끝  --");
            }
        };

        Runnable cleaner2 = () -> {
            System.out.println("-- 직원2 청소 시작  --");
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("(직원2)" + i + "번방 청소 중 ");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("-- 직원2 청소 끝  --");
        };

        Thread cleanerThread1 = new Thread(cleaner1);
        Thread cleanerThread2 = new Thread(cleaner2);

        cleanerThread1.start();
        cleanerThread2.start();
    }
}
