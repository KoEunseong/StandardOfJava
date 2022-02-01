package exception;
class Customer{
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) throws FlashException {
		if(id == null) {
			throw new FlashException("아이디가 어떻게 널이냐");
		}
		else if (id.length()>15|| id.length()<8) {
			throw new FlashException("아이디 길이안맞추제 팍씨");
		}
		else this.id = id;
	}
	
	
}


public class FlashTest {
	public static void main(String[] args) throws Exception{
		Customer Lee = new Customer();
		String id = null;
		Lee.setId("flashflashyo	");
	}
}
