package chap_11;

public class _02_Catch {
    public static void main(String[] args) {
        try {//시도하려는 소스코드
//            System.out.println(3 / 0);

//            int[] arr = new int[3];
//            arr[5] = 100;
//
//            Object obj = "test";
//            System.out.println((int) obj);

            String s = null;
            System.out.println(s.toLowerCase());

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e/* 뜨는 오류의 이름을 그대로 클래스이름으로 받아서 씀(이렇게 두개를 쓸수도 있음)*/){
            System.out.println("뭔가 잘못 계산을 했습니다.");
        } /* catch (ArrayIndexOutOfBoundsException e){
            System.out.println("인덱스를 잘못 설정했습니다.");
        }*/ catch (ClassCastException e/* 뜨는 오류의 이름을 그대로 클래스이름으로 받아서 씀*/){
            System.out.println("잘못된 형 변환입니다.");
        } catch (Exception e/* Exception 모든 오류의 조샅 클래스*/) {//문제가 발
            // 생하면 여기서 실행
            System.out.println("그 외의 모든 에러가 여기서 실행");
            System.out.println("이런 문제가 발생했습니다 => " + e.getMessage());
            e.printStackTrace();//빨갛게 표시되는 구문
            //둘다 오류를 출력하는구문
        }
        System.out.println("프로그램 정상 종료");
    }
}
