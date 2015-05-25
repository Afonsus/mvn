package mvntest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author cookie
 * @date 2015年5月25日 上午10:50:00
 **/
public class JsonTest {
	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {
		// 生成较大的json
		List<JsonObject> list = new ArrayList<JsonObject>();
		for (int i = 0; i < 1000000; i++) {
			JsonObject obj = new JsonObject();
			obj.setId(i);
			obj.setName("name" + String.valueOf(i));
			list.add(obj);
		}
		Gson gson = new GsonBuilder().create();
		String str = gson.toJson(list);

		// 1,gson解析
		long start1 = System.currentTimeMillis();
		List l = gson.fromJson(str, new TypeToken<List<JsonObject>>() {
		}.getType());
		System.out.println("gson time elapse:"
				+ (System.currentTimeMillis() - start1));
		System.out.println(l.size());

		// 2,jackson解析
		ObjectMapper mapper = new ObjectMapper();
		long start2 = System.currentTimeMillis();
		List l2 = mapper.readValue(str, new TypeReference<List<JsonObject>>() {
		});
		System.out.println("jackson time elapse:"
				+ (System.currentTimeMillis() - start2));
		System.out.println(l2.size());
	}

}
