package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B09_is_containi_alpha {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		char arr[] = str.toCharArray();
		
		boolean rs = false;
		
		for(int i=0; i<arr.length; i++) {
			
			if( (arr[i]>='a' && arr[i]<='z') || (arr[i]>='A' && arr[i]<='Z')) {
				rs = true;
				break;
			}
			else
				continue;
			
		}
	
		System.out.println(rs);
	
	}
}
