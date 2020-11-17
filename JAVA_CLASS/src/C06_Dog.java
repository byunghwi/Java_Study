
public class C06_Dog extends C06_Animal{
	String kind;
	
	public C06_Dog(String kind) {
		super();
		this.kind = kind;
	}

	@Override
	public String howling() {
		String result = "bowwow bowwow bowwow";
		return result;
	}

	@Override
	public boolean swimming() {
		boolean result = true;
		return result;
	}
	
	
}
