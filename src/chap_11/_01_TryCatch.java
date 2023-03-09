package chap_11;

public class _01_TryCatch {
    public static void main(String[] args) {
        //예외 처리
        // 오류 : 컴파일 오류, 런타임 오류 (에러 error, 예외 exception)

        try {//시도하려는 소스코드
//            System.out.println(3 / 0);

//            int[] arr = new int[3];
//            arr[5] = 100;

            Object obj = "test";
            System.out.println((int) obj);
        } catch (Exception e) {//문제가 발
            // 생하면 여기서 실행
            System.out.println("이런 문제가 발생했습니다 => " + e.getMessage());
            e.printStackTrace();//빨갛게 표시되는 구문
            //둘다 오류를 출력하는구문
        }
        System.out.println("프로그램 정상 종료");
    }
}
