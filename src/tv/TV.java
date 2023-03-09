/*
 * 클래스 2가지
 * 1. 실행형 클래스 main() 있는것
 * 2. 라이브러리용 클래스(=설계도) : main()이 없는것
 * 
 * 접근제한자(4가지)
 * 1. public : 어디서든지 접근가능
 * 2. protected : 같은 패키지에서만 접근 가능.
 *                자식은 같은 패키지든 다른 패키지든 관계없이 접근 가능.
 * 3.default(없는 것) : 같은 패키지에서만 접근 가능.
 * 4.private : 같은 클래스안에서만 접근 가능(정보은닉=>캡슐화). 상속에서 제외
 * 				private 필드는 접근가능한 메서드(같은 클래스)를 통해서 
 * 
 * ※ 클래스 앞에는 public 있고, public 없고(=default)
 * 	'필드','생성자','메서드'는 접근제한자 4가지 사용가능
 *  
 * 
 */

package tv;

public class TV {

	public static final String MADECOUNTRY="Korea"; // 제조국을 final을 써주어 korea로 초기화해 변경할수없게함
	static int price; //가격
	
	final String maker;//final을 써주어 한번 초기화하고나면 그다음 변경불가 위에서는 초기화를미리해줌
	boolean onoff=false; //전원
	int channel;  //채널
	int maxChannel; // 채널값 중 최대값
	int volume;   //볼륨
	private String ip="123.123.123.123";
	//ip값을 private를 써주어 접근을제한한다 get이나 set으로 변환가능
	//public String getIp(){
	// return ip;
	// }
	//public void setIp(String ip){
	// this.name = name;
	// } 이식을 넣어줘서 메인 클래스에서 불러오거나 변환가능
	//Tv.setIp("~~~");
	//Tv.getIp;

	// static 블록
	static {
		price = method();
	}// static 블록은 보통 클래스 변수를 초기화할때 사용하고 밑에 int method()를 정의하여 price에 계산된 hap값을 넣어준다.
	
	static int method() {
		int hap=0;
		for(int i=1;i<=100;i++) {
			hap =+i;
		}
		return hap;
	}

	{
		//2~100사이의 수 중 짝수의 합으로 초기화
		
		int i;  maxChannel=0;
		
		for(i=2;i<100;i+=2) {
			   
			maxChannel +=i;
			
		}

	}//변수 호출전 초기화를 시키기위해 인스턴스블록을써줌
	// 인스턴스 블럭은 field에 저장된값을 this.변수 를 통해불러올수있다
	
	
	//2. 생성자-반드시 존재
	/* 생성자 역할 : 필드에 값을 채워 객체를 생성(초기값). 객체 안에 존재하지 않음
	 * 생성자가 없으면 컴파일러가 검파일하기 전에 기본생성자를 자동으로 삽입해 줌.
	 * 기본생성자 TV(){super();} 필드를 기본값으로 채워줌
	 * 기본값 : 수-  0 (예:int 0, double 0.0)
	 *        boolean - false
	 *        클래스 타입 (예:String) - null
	 */


	public TV() {
		super(); //부모클래스의 생성자를 호출한다
		maker = "국제"; //final으로 지정해준 maker를 "국제"로 초기화시켜준다
	}
	
	public TV(int channel, int volume) {
		super(); //부모클래스의 생성자를 호출한다
		maker="경산"; //final 값을 국제로 초기화시켜줬으면 경산값은 안넣어지는거아닌지 물어볼거@@@@@
		this.channel = channel; //this.를 써주어 부모클래스의 값을 받지말고 자식에서 값을 정해주는 객체생성
		this.volume = volume;

	}

	public TV(String maker, boolean onoff, int channel, int volume) {
		super(); //부모클래스의 생성자를 호출한다
		this.maker = maker; //this.를 써주어 부모클래스의 값을 받지말고 자식에서 값을 정해주는 객체생성
		this.onoff = onoff;
		this.channel = channel;
		this.volume = volume;
	}
	//public TV() 이거를 여러개를 써준이유 질문하기@@@@@
	

	static void price() {
		System.out.println("가격:"+price);
		System.out.println("가격:"+MADECOUNTRY);
	}
	//static을 쓰면 객체를 생성해 호출하지않고도 사용가능
	//static필드값은 호출되는데 static메서드는 왜 호출이 안되는지 질문@@@

		
	String getIp() {
		return ip;
	}

	boolean isOnoff() {
		return onoff; //is 메소드가 뭔지 물거볼거@@@@@
	}
	void setOnoff(boolean onoff) {
		this.onoff = onoff;//this.를 써주어 setOnoff(true);로 껏다켯다가능
	}
	int getChannel() {
		return this.channel;
	}
	void setChannel(int channel) { 
		this.channel = channel;
	}
	int getVolume() {
		return volume;
	}
	void setVolume(int volume) {
		this.volume = volume;
	}

void show(){
	System.out.println("TV [madeCountry=" + MADECOUNTRY + ", maker=" + maker + ", onoff=" + onoff + ", channel=" + channel
			+ ", volume=" + volume + "]");
	}

/**[메서드 오버라이딩:재정의]
 * 재정의조건1:돌려주는 타입 매서드명(매개변수) 반드시 부모의 매서드와 동일해야 됨
 * 재정의조건2:접근제한자가 부모와 같거나 더 넓은 범위로
 * 재정의조건3:예외가 부모보다 많을 수 없다.
 * 재정의조건4:static O -X-> static X (반대도 안됨)
 */


//매서드 오버라이딩:재정의
@Override //어노테이션
public String toString() { 
	return "TV [madeCountry=" + MADECOUNTRY + ", maker=" + maker + ", onoff=" + onoff + ", channel=" + channel
			+ ", volume=" + volume + "]";
}//재정의해서 불러올수도있음

}	


//부모인 Object의 toString()을 그대로 상속받아 사용:"패키지명@16진수해쉬코드"

//@Override
//public String toString() {
//	return "TV [madeCountry=" + madeCountry + ", maker=" + maker + ", onoff=" + onoff + ", channel=" + channel
//			+ ", volume=" + volume + "]";
//}




