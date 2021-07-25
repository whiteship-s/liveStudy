package whiteship.toyproject.livestudy.common.result;

public class Result {

	private int code = ResultCodeEnum.ERROR.getCode();

	private String message = ResultCodeEnum.ERROR.getDescription();

	private ResultMap resultMap;

	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultMap getResultMap() {
		return resultMap;
	}

	public void setResultMap(ResultMap resultMap) {
		this.resultMap = resultMap;
	}

	public String toSting(){
		
		final StringBuilder sb = new StringBuilder();
	
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("결과 코드 [ " + code + " ] \n");
		sb.append("메시지    [ " + message + " ] \n");
		
		return sb.toString();
	}
	
}