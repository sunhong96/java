package java8;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ArraysParallel {
    public static void main(String[] args) {
        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime(); //시작시간
        Arrays.sort(numbers); // 정렬
        System.out.println("serial sorting took " + (System.nanoTime() - start)); // 시작부터 걸린시간 차이출력
        //직렬정렬

        System.out.println("-----------------------");

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers); //배열이 있다고하면 배열을 계속 쪼개서 합치면서 정렬함
        System.out.println("parallel sorting took " + (System.nanoTime() - start));
        // 이게 왠만하면 더빠름 병렬정렬

        //배열의 크기가 작은 경우, 병렬 처리를 하는 것보다 직렬 처리를 하는 것이 더욱 효율적일 수 있습니다.
        // 이는 병렬 처리를 위한 추가적인 처리 시간이 소요되기 때문입니다.
        //
        //따라서, 만약 배열의 크기가 작다면, 병렬 정렬이 직렬 정렬보다 느릴 수 있습니다.
        // 이 코드에서는 배열의 크기를 1500으로 설정하여 비교하고 있습니다.
        // 이는 배열의 크기가 작은 범위에 속하므로, 직렬 정렬이 병렬 정렬보다 더욱 빠를 수 있습니다.
        //
        //그러나 배열의 크기가 큰 경우에는, 병렬 처리를 활용한 정렬이 더욱 효율적일 수 있습니다.
        // 이는 병렬 처리를 위한 추가적인 처리 시간이 큰 배열의 정렬에서는, 병렬 처리를 활용하여 처리 시간을 줄일 수 있기 때문입니다.
    }
}
