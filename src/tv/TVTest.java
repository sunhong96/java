package tv;
//같은 패키지는 클래스는 import 생략가능
//import tv.TV;
public class TVTest {

	public static void main(String[] args) {
		TV t1 = new TV(); //t1이라는 객체에 Tv클래스 넣어줌
				
		System.out.println("--필드의 값을 얻는 방법들--");
		
		//1. 직접 필드에 접근하여 필드값을 얻는 방법()
		System.out.println(t1.onoff);//t1에서 저장된 클래스의 필드값 onoff에 초기화값을 불러옴
		
		//2. 메서드를 통해 간접적으로 필드에 접근하여 필드의 값을 얻는 방법
		System.out.println(t1.isOnoff());
		//boolean isOnoff() {
		//		return onoff;
		//}이 매서드를 통해 불러옴
		System.out.println((t1.getIp()));
		//private된 값을 getIp() 매서드를 통해 불러올수있음
//		t1.setIp("12.12.12"); //setIP라는 매서드를 만들어주지않아 실행이안댐
		System.out.println(t1.getIp());// 왜 한번더 써줬는지 물어볼거@@@@@

		t1.show();
		//void show(){
		//	System.out.println("TV [madeCountry=" + MADECOUNTRY + ", maker=" + maker + ", onoff=" + onoff + ", channel=" + channel
		//			+ ", volume=" + volume + "]");
		//	} 이매서드를 호출
		
		//t1:주소만으로도 객체안의 "값을 출력"하려면 toString()메서드가 재정의 되어있는 상태여야 한다.
		System.out.println(t1); //t1객체자체로 호출가능
		System.out.println(t1.toString());
		//public String toString() {
		//	return "TV [madeCountry=" + MADECOUNTRY + ", maker=" + maker + ", onoff=" + onoff + ", channel=" + channel
		//			+ ", volume=" + volume + "]";
		//} toString()매서드로 호출가능
		
		
		System.out.println("--필드의 값을 다른값으로 setting시키는 방법들--");
		
		t1.channel = 10; //직접변경
		int channel = t1.channel;  
		System.out.println(channel);		
		
		t1.setChannel(20);  //setChannel();이라는 매서드를 통해 변경
		channel = t1.getChannel();
		System.out.println("현재 채널:"+channel);
		
		System.out.println(t1);
		//채널이 20으로 바꼇음
		
		t1.setOnoff(true);//전원을 켜줌
		System.out.println("현재 전원:"+t1.onoff);//직접호출
		System.out.println("현재 전원:"+t1.isOnoff());//매서드를통해 호출
		
		/** static 멤버 접근 방법
		 * 1. 클래스 이름으로 접근(권장)
		 * 2. 객체 생성 후 주소로 접근가능(경고)
		 * 
		 */
		
		
		
		
		//t1.MADECOUNTRY="중국"; //final로 정의를 해주고 초기화를 해줬기 때문에 중국으로변경은 불가
		System.out.println("제조국:"+t1.MADECOUNTRY);
		System.out.println(t1);
		
//		TV.MADECOUNTRY = "대한민국"; //static 멤버 : 클래스 이름으로 접근한다.(권장)
		System.out.println("제조국:"+TV.MADECOUNTRY);
		
		TV t2 = new TV("삼성", true, 10, 5);
		//t2 객체생성 두번째 티비만들기

		System.out.println(t2);//t2출력
		
		TV t3 = new TV("LG", false, 20, 3);
		//t3객체생성 세번째 티비만들기

		System.out.println(t3);//t3출력

		System.out.println();//이게 왜 호출이 안되는지 물어보기@@


	}

}
