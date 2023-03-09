package chap_12;

import chap_12.clean.CleanRunnable;

public class _03_Join {
    public static void main(String[] args) {
        CleanRunnable cleanRunnable = new CleanRunnable();
        Thread thread = new Thread(cleanRunnable);
        thread.start();

        try {
            thread.join(2500);//조인의 역할은 이 쓰레드가 끝날때 까지 기다렸다가 다음 메서드 실행
            //2.5초까지 기다렸다가 끝나지않으면 다음줄로 이동해 실행
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cleanByBoss();
    }
    public static void cleanByBoss(){
        System.out.println("-- 사장 청소 시작 --");
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("(사장)" + i + "번방 청소 중");

            try {
                Thread.sleep(1000);//1초간격으로 출력
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }//쓰레드를 잠시동안 일시정지시키는 것
        }
        System.out.println("-- 사장 청소 끝 --");
    }
}
