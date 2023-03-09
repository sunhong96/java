package chap_12;

import chap_12.clean.Room;

public class _05_Synchronization {
    public static void main(String[] args) {
        Room room = new Room();

        Runnable cleaner1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("-- 직원1 청소 시작  --");
                for (int i = 1; i <= 5; i++) {
                    room.clean("직원1");
                }
                System.out.println("-- 직원1 청소 끝  --");
            }
        };

        Runnable cleaner2 = () -> {
            System.out.println("-- 직원2 청소 시작  --");
            for (int i = 1; i <= 5; i++) {
                room.clean("직원2");
            }
            System.out.println("-- 직원2 청소 끝  --");
        };

        Thread cleanerThread1 = new Thread(cleaner1);
        Thread cleanerThread2 = new Thread(cleaner2);

        cleanerThread1.start();
        cleanerThread2.start();
        //1번방 청소를 같이 접근이 되어서 둘다 실행됨 이때 synchronized 를 써서 동시에 실행이안되게 해줄 수 있음
    }
}
