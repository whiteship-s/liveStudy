package whiteship.toyproject.livestudy.common.result;

import java.util.HashMap;

public class ResultMap extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public void add(String key, Object value){
		this.put(key, value);
	}
	
}