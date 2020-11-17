package myobj;

import java.util.Arrays;

public class FcSquad {
	static final int fieldPlayer; //필드플레이어
	static String director;		  //감독
	String captain; 		  	  //주장명
	String sub[];				  //교체선수
	int subCount;				  //교체횟수
	String position[];			  //포지션

	public static void main(String[] args) {
		
		String [] sub = {"Dembele", "Pjanic", "Pati", "Busquets", "Neto", "Araújo"};
		String [] position = {"Shadow Striker", "Attacking Midfielder", "Holding Midfielder", "CenterBack" , "Swipper", "SideWingBack", "Wing Forward", "GoalKeeper"};
		
		FcSquad fs = new FcSquad(sub, "Messi", sub.length, position);
		
		System.out.println(fs.toString());
		System.out.println(FcSquad.director);
		
		changeDirect("Ronald Koeman");
		
		System.out.println( "Change Director > " + FcSquad.director);
	}
	
	static {
		fieldPlayer = 11;
		director = "Quique Setién";
	}

	public FcSquad(String[] sub , String captain , int subCount, String[] position) {
		super();
		this.sub = sub;
		this.subCount = subCount;
		this.position = position;
		this.captain = captain;
	}

	public static void changeDirect(String chgDirect) {
		director = chgDirect;
	}

	@Override
	public String toString() {
		return "FcSquad [captain=" + captain + ", sub=" + Arrays.toString(sub) + ", subCount=" + subCount
				+ ", position=" + Arrays.toString(position) + "]";
	}
	
	
}
