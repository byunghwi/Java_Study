package myobj.item;
import java.util.HashMap;
import java.util.Iterator;
// 필드
// - 공격력
// - 강화수치
// - 레벨별 강화확률 (등급마다 강화 확률이 다름)
// - 레벨별 공격력 증가폭

//메서드
// - 강화하기 (성공률에 따라 성공 실패가 적용됨)
//		* 최대 강화 레벨까지 도달하기에 걸린 강화 횟수를 출력
// - 공격 (대상에게 공격력 만큼의 데미지를 입힘)
// 		* 공격의 대상이 되는 객체는 HP가 있어야 한다.

public class Sword {
	
	public int attack_pt; //공격력
	public int grade;     //등급
	public int percentNow;//등급별 강화확률
	public int level_gap;
	
	//grade to percent - 각 등급별 강화확률
	HashMap<Integer, int[]> gradePercent = new HashMap<Integer, int[]>();
	Iterator<Integer> gpIter = gradePercent.keySet().iterator();
	
	public Sword() {
	}
	
	//초기화 및 각 단계별 정보 세팅
	public Sword(int grade) {

		//각 등급별 강화확률/공격력
		int[][] gpArr = new int[][]{{100, 100}, {80, 200}, {60, 360}, {40, 450}, {20, 850}, {10, 1000}};

		for (int i = 0; i < gpArr.length; i++) {
			gradePercent.put(i+1, gpArr[i]);
		}
		
		this.grade = grade;
		this.percentNow= gradePercent.get(grade)[0];
		this.attack_pt = gradePercent.get(grade)[1];
	}
	
	//강화하기
	public String upGrade(int grade) {
		
		String result;
		
		double randomNum;
		randomNum = (int) (Math.random() * (100 - 1 + 1) + 1);
		System.out.println("랜덤확률 >" + randomNum);
		
		int percent = gradePercent.get(grade)[0];
		
		//강화 성공
		if(  randomNum > 0  && randomNum <= percent) {
			this.grade = grade+1;
			this.percentNow = gradePercent.get(this.grade)[0];
			this.attack_pt = gradePercent.get(this.grade)[1];
		
			return result = "\n==============강화결과==============\n" + "축하합니다! "+grade+"단계에서 " + this.grade + "로 강화되었습니다.";
		}
		else {
			return result = "\n강화 실패하였습니다. 현재 강화등급 > " + grade;
		}
	}

	@Override
	public String toString() {
		return "Sword [attack_pt=" + attack_pt + ", grade=" + grade + ", percentNow=" + percentNow + ", level_gap="
				+ level_gap + "]";
	}
	

}
