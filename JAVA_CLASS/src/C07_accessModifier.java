import myobj.C07_diffPackage;

public class C07_accessModifier extends C07_diffPackage{
	public static void main(String[] args) {
		
		// # 객체지향에서의 캡슐화
		// - 접근제어자를 활용하여 다른 클래스에게는 보여줄 필요 없는 자원(변수/메서드) 을 은닉하는 것을 말한다.
		
		
		// - 같은 패키지의 자원은 private만 제외하고 모두 보인다. 
		System.out.println(C07_samePackage.package_sInt);
		System.out.println(C07_samePackage.protected_sInt);
		System.out.println(C07_samePackage.public_sInt);
		
		C07_samePackage same_package_instance =  new C07_samePackage();
		
		System.out.println(same_package_instance.pakage_int);
		System.out.println(same_package_instance.protected_int);
		System.out.println(same_package_instance.public_int);
		
		C07_diffPackage diff_package_instance = new C07_diffPackage();
		
		// 다른 패키지의 자원은 상속을 받으면 protect까지 보인다.
		System.out.println(diff_package_instance.public_sInt);
		System.out.println(diff_package_instance.protected_sInt);
		
		// 상속받은 객체의 인스턴스로 protected 자원에 접근할 수 있다.
		C07_accessModifier child = new C07_accessModifier(); 
		System.out.println(child.protected_int);
		System.out.println(child.public_int);
	}
}
