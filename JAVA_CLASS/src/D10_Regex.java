import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D10_Regex {
	public static void main(String[] args) {
		
		System.out.println(Pattern.matches("s[lh]eep" , "sleep"));
		System.out.println(Pattern.matches("s[lh]eep" , "sheep"));
		// [] : 해당 위치의 한 글자에 어떤 문자들이 올 수 있는지 정의.
		// abc : a b c 만 허용
		// ^abc : a b c 를 제외한 모두 허용
		// a-z : a부터 z까지 허용
		// && : 교집합
		
		
		// # 여러 문자를 간단하게 표현하는 것들
		// . : 해당 자리에 모든 문자를 허용 - # [] 밖에 써야함.
		// \d : 해당 자리에 숫자 허용
		// \D : 해당 자리에 숫자를 제외한 모든 것을 허용
		// \s : 해당 자리에 공백을 허용 [\t\n\r.. 등의 모든 공백들]
		// \S : 해당 자리에 공백을 제외한 모든 것들을 허용.
		// \w : 일반적인 문자들을 허용 [a-zA-Z_0-9]
		// \W : 일반적인 문자들을 제외한 모든 것을 허용
		
		//
		//Pattern.compile(regex) - 전달한 정규표현식을 이용해 생성한 인스턴스를 반환한다.
		Pattern email_regex = Pattern.compile("[\\w]+@[a-zA-Z0-9]+[.][a-zA-Z.]+");
		
		Pattern split_regex = Pattern.compile("/");
		
		//생성된 Pattern 인스턴스로 split 하기
		String [] fruits = split_regex.split("apple/banana/orange/kiwi");
		System.out.println(Arrays.toString(fruits));
		
		// # 생성된 Pattern 인스턴스로 matcher 생성하기.
		//# Matcher
		// - 문자열을 처음부터 끝까지 검사하면서 정규표현식과 일치하는 인덱스를 찾은 결과.
		//Matcher matcher = split_regex.matcher("apple/banana/orange/kiwi");
		
		Pattern fruit_regex =  Pattern.compile("[a-zA-Z^/]+");
		Matcher matcher = fruit_regex.matcher("apple/banana/orange/kiwi");
		
		//find : 정규표현식을 통해 찾은 것이 있으면 true
		while (matcher.find()) {
			System.out.println("찾은 것 : " + matcher.group());
			System.out.println(matcher.start() + " to " + matcher.end());
			
		}
	}
}
