package myobj.machine;

public class CellPhone implements Electronics{
	String equip;
	static final int needElec = 500; 
	static final int sendText = 50;
	static final int call = 100;
	int cellphoneElec = 0;
	int totalElec = 0;
	
	public CellPhone(String equip) {
		super();
		this.equip = equip;
	}

	@Override
	public String useElec(int elec) {
		System.out.println("\t" +this.equip + "가 " + elec + "만큼 전력을 사용합니다.");
		totalElec += elec;
		cellphoneElec -= elec;
		return null;
	}

	@Override
	public String provideElec() {
		System.out.println(equip + "에 " + needElec + " 만큼의 전력을 공급합니다.");
		cellphoneElec += needElec;
		return null;
	}

	@Override
	public void totalUseElec() {
		System.out.println(equip + "의 총 전력 사용량은 " + totalElec + "입니다.");
	}
	
	public void sendText() {
		if(cellphoneElec <= 0) {
			System.out.println("전력이 모두 소모 되어 재공급합니다.");
			provideElec();
			return;
		}
		System.out.println("<문자보내기>" );
		useElec(sendText);

	}
	
	public void call() {
		if(cellphoneElec <= 0) {
			System.out.println("전력이 모두 소모 되어 재공급합니다.");
			provideElec();
			return;
		}
		System.out.println("<통화하기>" );
		useElec(call);
	}




}
