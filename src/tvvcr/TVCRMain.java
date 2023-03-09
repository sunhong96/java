package tvvcr;

public class TVCRMain {

	public static void main(String[] args) {
		//new Electronics("삼성");  추상클래스는 객체 생성불가
		TV tv = new TV("삼성");
		System.out.println(tv);
		tv.channelUp();
		
		tv.power();
		tv.channelUp();
		System.out.println(tv.channel); //1. 필드에 직접 접근
		System.out.println(tv.getChannel()); //2.메서드를 이용해서 필드에 간접 접근

		int i;
		for(i=1;i<=100;i++) {//카운팅
			tv.channelUp();
			System.out.println(tv.channel);
		}
		
		tv.channelDown();
		System.out.println(tv.channel);
		
		tv.setChannel(0);
		tv.setChannel(101);
		
		tv.setChannel(50);
		System.out.println(tv.channel);
		
		
		System.out.println("----TVCR-----");
		
		TVCR tvcr = new TVCR("LG");
		System.out.println(tvcr);
		tvcr.channelUp();
		System.out.println(tvcr.getChannel()); //2.메서드를 이용해서 필드에 간접 접근

		tvcr.power();
				
		
		for(i=1;i<=101;i++) {//카운팅
			tvcr.channelUp();
			System.out.println(tvcr.channel);
		}
				
		tvcr.channelDown();
		System.out.println(tvcr.channel);
		
		tvcr.play();
		tvcr.stop();
	}

}
