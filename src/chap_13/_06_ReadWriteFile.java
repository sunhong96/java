package chap_13;

import java.io.*;

public class _06_ReadWriteFile {
    public static void main(String[] args) {
        // BufferedReader : 파일에서 내용을 읽어올 때
        // BufferedWriter : 파일에 내용을 쓸 때
        // Buffered 는 잠시 저장할 공간을 생성한다고생각

        //파일쓰기
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter("goodjob.txt", true))){
////            bw.write("이제 거의 끝이 보여요.");
////            bw.newLine();
////            bw.write("여기까지 오신 여러분들 정말 대단해요!");
////            bw.newLine();
//            //내용을 추가려면 ture (append)를 추가해줘야댐
//            bw.write("조금만더 힘내요");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //파일 열기
        try (BufferedReader br = new BufferedReader(new FileReader("goodjob.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
