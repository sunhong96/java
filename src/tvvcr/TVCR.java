package tvvcr;

/**
 * 1. 미완성된 추상 메서드가 1개라도 있으면 이 클래스는 추상 클래스(미완성)가 된다.
 * 2. 추상클래스는 객체 생성이 불가능하다.
 * 3. 그러나, 부모 역할 가능
 */

abstract class Electronics { //전자제품(부모):자식의 공통된 속성(필드)이나 기능(메서드)
	final String makeCountry="korea";
	String company; //제조회사
	boolean power; //전원 기본값 false
		
	Electronics(String company) {
		super();
		this.company = company;
		
	}

	//기본생성자
	
	//void power() {} //완성된 메서드-자식에서 재정의하지 않아도 오류가 없음.
	abstract void power(); //미완성된 추상메서드
}

 //extends기능 : Electronics 부모 TV가 자식(상속관계 형성)
class TV extends Electronics {     
	//추가
	int channel; //기본값 0

	//기본생성자 TV(){super();}

	TV(String company) {
		super(company);
	}
	
	@Override //부모의 메서드 재정의
	void power() {
		power= !power;  //미완성된 추상메서드를 다시 부정재정의
		if(power==true)	System.out.println("TV 전원 ON");
		else System.out.println("TV 전원 OFF");
	}

	@Override
	public String toString() {
		return "TV [channel=" + channel + ", makeCountry=" + makeCountry + ", company=" + company + ", power=" + power
				+ "]";
	}
	
	
	//2개 메서드 추가 (1~100사이)

	

	void channelUp() {
		if(power==true) {
			if(0<=channel && channel<=99) channel++;
			else if(channel==100) channel = 1;
		}
		else System.out.println("TV전원을 켜 주세여!");
	}
	
	
	void channelDown() {
		if(power==true) {
			if(2<=channel && channel<=101) channel--;
			else if(channel==1) channel = 100;
		}
		else System.out.println("TV전원을 켜 주세여!");
	}

	int getChannel() {
		return channel;
	}

	void setChannel(int channel) {
		if (1>channel || channel>100)
		System.out.println("해당채널은 존재하지 않습니다.");
		else this.channel = channel;
	}
	
	
	
}

class VCR extends Electronics {
	
	VCR(String company) {
		super(company);
	}

	@Override
	void power() {
		power= !power;  //미완성된 추상메서드를 다시 부정재정의
		if(power==true)	System.out.println("VCR 전원 ON");
		else System.out.println("VCR 전원 OFF");
	}
	
	void play() {
		System.out.println("재생");
	}
	
	void stop() {
		System.out.println("멈춤");
	}

	@Override
	public String toString() {
		return "VCR [makeCountry=" + makeCountry + ", company=" + company + ", power=" + power + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}

/**[재활용 방법]
 * 부모의 필드와 메서드는 상속받아 사용가능 (예:TVCR extends TV->TVCR이 TV에게 상속)
 * (상속 제외:생성자, private, 초기화블록(인스턴스,클래스) )
 * 포함관계는 반드시 포함객체와 연결된 필드 ((예)VCR vcr)로 접근하여 그안의 매서드 사용
 */


public class TVCR extends TV{//TV(부모1개)+VCR(포함관계)
	private VCR vcr; //포함 순서1
	
	TVCR(String company) {
		super(company);
		vcr = new VCR(company); //포함 순서2
	}
	
	
	
	
	
	//포함 순서3-버턴(외부에 노출) 누르면 실질적인 기능까지 메서드 호출
	
	@Override //vcr에 체크하면 VCR 객체안의 필드값도 문자열에 포함시킴
	public String toString() {
		return "TVCR [vcr=" + vcr + ", channel=" + channel + ", makeCountry=" + makeCountry + ", company=" + company
				+ ", power=" + power + "]";
	}





	public void play() {
		vcr.play();
	}
	
	public void stop() {
		vcr.stop();
	}
	
	
	
}
