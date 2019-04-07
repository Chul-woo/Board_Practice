package kr.kcw.practice.Util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Convert {

	public Map<String, Object> convertObjectToMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			try {
				map.put(fields[i].getName(), fields[i].get(obj));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public Object convertMapToObject(Map<String, Object> map, Object obj) {
		String keyAttribute = null;
		String setMethodString = "set";
		String methodString = null;
		Iterator<String> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			keyAttribute = (String) itr.next();
			methodString = setMethodString + keyAttribute.substring(0, 1).toUpperCase() + keyAttribute.substring(1);
			Method[] methods = obj.getClass().getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				if (methodString.equals(methods[i].getName())) {
					try {
						methods[i].invoke(obj, map.get(keyAttribute));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return obj;
	}
	
	public Date convertStringToDate(String dates) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(dates);
		return date;
	}

}
