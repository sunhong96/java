package chap_12;

import chap_12.clean.CleanTread;

import static chap_12.clean.CleanTread.cleanByBoss;

public class _01_Thread {
    public static void main(String[] args) {
        // 하나의 프로세스 (Process)
        // 쓰레드 (Thread) // 동시실행

        // 1 3 5 7 9 (방 번호)
        // 복도
        // 2 4 6 8 10
//        cleanBySelf();

        CleanTread cleanTread = new CleanTread();
//        cleanTread.run(); // 직원 청소
        cleanTread.start(); //스타트를 써줘야 같이 돌아감

        cleanByBoss(); // 사장 청소
    }
    public static void cleanBySelf(){
        System.out.println("-- 혼자 청소 시작 --");
        for (int i = 1; i <= 10; i++) {
            System.out.println("(혼자)" + i + "번방 청소 중");
        }
        System.out.println("-- 혼자 청소 끝 --");
    }
}
