package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10_GCD {
	public static void main(String[] args) throws IOException {
		//두 숫자를 입력받고 두 숫자의 최대공약수를 구하시오.
		//12 16
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        
        int num1 = Integer.parseInt(str[0]);
        int num2 = Integer.parseInt(str[1]);
  
        if(num1 > num2) {
        	int temp;
        	temp = num1;
        	num1 = num2;
        	num2 = temp;
        }

        for(int i=num1; i>=2; i--) {
        	if(num1%i==0 && num2%i==0) {
        		System.out.println(i);
        		break;
        	}else {
        		System.out.println(1);
        		break;
        	}
        }

	}
}
