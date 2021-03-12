package cf.dinhthanhphu.util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

	static ResourceBundle bundle = ResourceBundle.getBundle("message");
	
	public Map<String,String> getMessage(String message){
		Map<String,String> result = new HashMap<String, String>();
		if(message.contains("success")) {
			result.put("alter", "success");
		}else {
			result.put("alter", "danger");
		}
		result.put("message", bundle.getString(message));
		
		return result;
	}
}
