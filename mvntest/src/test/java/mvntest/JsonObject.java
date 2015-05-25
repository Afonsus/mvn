package mvntest;

/**
 * @author cookie
 * @date 2015年5月25日 上午10:53:44
 **/
public class JsonObject {
	private int id;
	private String name;

	public JsonObject() {
	}

	public JsonObject(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
