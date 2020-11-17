
public class C06_Cat extends C06_Animal {
	
	String kind;
	
	public C06_Cat(String kind) {
		super();
		this.kind = kind;
	}

	@Override
	public String howling() {
		String result = "Meow Meow Meow Meow";
		return result;
	}

	@Override
	public boolean swimming() {
		boolean result = false; 
		return result;
	}

}
