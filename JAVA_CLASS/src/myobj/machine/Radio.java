package myobj.machine;

public class Radio implements Electronics {
	String equip;
	static final int needElec = 300; 
	static final int playMusic = 70;
	static final int adjust = 20;
	int radioElec = 0;
	int totalElec = 0;

	public Radio(String equip) {
		super();
		this.equip = equip;
	}

	@Override
	public String useElec(int elec) {
		System.out.println("\t" + this.equip + "가 " + elec + "만큼 전력을 사용합니다.");
		totalElec += elec;
		radioElec -= elec;
		return null;
	}

	@Override
	public String provideElec() {
		System.out.println(this.equip + "에 " + needElec + "만큼의 전력을 공급합니다.");
		radioElec += needElec;
		return null;
	}

	@Override
	public void totalUseElec() {
		System.out.println(equip+ "의 총 전력 사용량은 " + totalElec + "입니다.");
	}
	
	public void playMusic() {
		if(radioElec <= 0) {
			System.out.println("전력이 모두 소모 되어 재공급합니다.");
			provideElec();
			return;
		}
		System.out.println("<음악듣기>");
		useElec(playMusic);
	}
	
	public void adjust() {
		if(radioElec <= 0) {
			System.out.println("전력이 모두 소모 되어 재공급합니다.");
			provideElec();
			return;
		}
		System.out.println("<주파수조정>");
		useElec(adjust);
	}

}
