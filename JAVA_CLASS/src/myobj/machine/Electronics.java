package myobj.machine;

public interface Electronics {
	//	전자기기 인터페이스
	// 1. 모든 전자기기는 전력 공급을 받을 수 있다.
	// 2. 모든 전자기기는 콘솔에 한번 출력할때마다
	//		전력 소비량 만큼의 전력을 소비한다.
	// 3. 모든 전자기기는 가지고 있는 동작을 콘솔에 출력한다
	
	public String useElec(int elec);	// 각 기기마다 동작 후 전력 소모
	public String provideElec();		// 각 기기에 전력 공급	 
	public void totalUseElec();			// 사용 후 총 전력 사용량 출력
}
