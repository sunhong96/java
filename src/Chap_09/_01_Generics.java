package Chap_09;

public class _01_Generics {
    public static void main(String[] args) {
        // 제너릭스
        //waffer클래스로 정의해주면댐
//        int[] iArray = {1, 2, 3, 4, 5};
        Integer[] iArray = {1, 2, 3, 4, 5};
//        double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0};

        String[] sArray = {"A", "B", "C", "D", "E"};

        printIntArray(iArray);
        printDoubleArray(dArray);
        printStringArray(sArray);

        System.out.println("------------------------------");
        printAnyArray(iArray);
        printAnyArray(dArray);
        //제너릭스타입은 기본자료형은 쓸수없음
        printAnyArray(sArray);

    }
    // T : Type을 말하는 것 아무거나 자기가 원하는거 정의해줘두댐
    private static <T> void  printAnyArray(T[] array){
        for (T t: array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private static void printStringArray(String[] sArray) {
        for (String s : sArray) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void printDoubleArray(Double[] dArray) {
        for (double d : dArray) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    private static void printIntArray(Integer[] iArray) {
        for (int i : iArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
