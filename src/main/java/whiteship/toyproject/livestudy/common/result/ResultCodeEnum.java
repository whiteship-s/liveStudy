package whiteship.toyproject.livestudy.common.result;

public enum ResultCodeEnum {

	SUCCESS(0, "SUCCESS")
	,ERROR (1, "ERROR");
	
	private final int code;
	private final String description;
	
	private ResultCodeEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
}