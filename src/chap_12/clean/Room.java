package chap_12.clean;

public class Room {
    public int number = 1;
    synchronized public void clean(String name){
        System.out.println(name + " : " + number + "번방 청소 중");
        number++;
    }
}
