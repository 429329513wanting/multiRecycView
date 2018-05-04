package com.sendinfo.okgodemo.HttpUtil;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/**
 * 项目名称: BaseProject
 * 作用: Json解析,拼装类
 * 作者: 赵小白 email:vvtale@gmail.com  
 * 日期: 2015-11-09-0009 14:02 
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class JsonUtil
{
	/**
	 * 将json解析成指定泛型并返回
	 *
	 * @param string json数据
	 * @param <T>    指定泛型
	 */
	public static <T> T getObject(String string, Class<T> t)
	{
		return new Gson().fromJson(string, t);
	}

	private static Gson getGson()
	{
		GsonBuilder gb = new GsonBuilder();
		gb.setLongSerializationPolicy(LongSerializationPolicy.STRING);
		gb.registerTypeAdapter(Double.class, new JsonSerializer<Double>()
		{
			@Override public JsonElement serialize(Double originalValue, Type typeOf, JsonSerializationContext context)
			{
				BigDecimal bigValue = BigDecimal.valueOf(originalValue);
				if(originalValue == bigValue.intValue())
				{
					return new JsonPrimitive(bigValue.intValue());
				}
				return new JsonPrimitive(originalValue);
			}
		});
		gb.registerTypeAdapter(Integer.class, new JsonSerializer<Integer>()
		{
			@Override public JsonElement serialize(Integer originalValue, Type typeOf, JsonSerializationContext context)
			{
				BigDecimal bigValue = BigDecimal.valueOf(originalValue);

				return new JsonPrimitive(bigValue.toPlainString());
			}
		});
		gb.registerTypeAdapter(new TypeToken<TreeMap<String, Object>>()
		{
		}.getType(), new JsonDeserializer<TreeMap<String, Object>>()
		{
			@Override public TreeMap<String, Object> deserialize(JsonElement json, Type typeOfT,
				JsonDeserializationContext context) throws JsonParseException
			{

				TreeMap<String, Object> treeMap = new TreeMap<>();
				JsonObject jsonObject = json.getAsJsonObject();
				Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
				for(Map.Entry<String, JsonElement> entry : entrySet)
				{
					treeMap.put(entry.getKey(), entry.getValue());
				}
				return treeMap;
			}
		});
		return gb.create();
	}

	/**
	 * Gosn解析
	 * TypeToken token =  new TypeToken<ArrayList<BannerVo>>(){};
	 * val list: List<FilterParkVo> = JsonUtil.getObject(response.datas, object : TypeToken<ArrayList<FilterParkVo>>(){}) as List<FilterParkVo>
	 *
	 * @param obj   json数据的object
	 * @param token 解析类型token
	 */
	public static Object getObject(Object obj, TypeToken token)
	{
		Gson gson = getGson();
		String data = gson.toJson(obj);
		if(TextUtils.isEmpty(data))
		{
			data = "";
		}
		return gson.fromJson(data, token.getType());
	}

	/**
	 * @param obj 指定类型
	 * @param <T> 指定泛型
	 * @return 将指定类变成Json型数据返回
	 */
	public static <T> String getJsonString(T obj)
	{
		Gson gson = getGson();
		String data = gson.toJson(obj);
		if(TextUtils.isEmpty(data))
		{
			data = "";
		}
		return data;
	}

	/**
	 * 将object解析成指定泛型并返回
	 *
	 * @param obj json数据的object
	 * @param <T> 指定泛型
	 */
	public static <T> T getObjectFromObject(Object obj, Class<T> t)
	{
		Gson gson = getGson();
		String data = gson.toJson(obj);
		if(TextUtils.isEmpty(data))
		{
			data = "";
		}
		return gson.fromJson(data, t);
	}

	/**
	 * 将object解析成Map
	 *
	 * @param jsonStr json数据的object
	 */
	public static Map<String, String> getMapForJson(String jsonStr)
	{
		JSONObject jsonObject;
		try
		{
			jsonObject = new JSONObject(jsonStr);

			Iterator<String> keyIter = jsonObject.keys();
			String key;
			String value;
			Map<String, String> valueMap = new HashMap<>();
			while(keyIter.hasNext())
			{
				key = keyIter.next();
				value = jsonObject.get(key)
				                  .toString();
				if(!TextUtils.isEmpty(value))
				{
					valueMap.put(key, value);
				}
			}
			return valueMap;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将object解析成Map
	 *
	 * @param obj 数据object
	 */
	public static Map<String, String> getMapForObj(Object obj)
	{
		String jsonStr = getJsonString(obj);

		JSONObject jsonObject;
		try
		{
			jsonObject = new JSONObject(jsonStr);

			Iterator<String> keyIter = jsonObject.keys();
			String key;
			String value;
			Map<String, String> valueMap = new HashMap<>();
			while(keyIter.hasNext())
			{
				key = keyIter.next();
				value = jsonObject.get(key)
				                  .toString();
				if(!TextUtils.isEmpty(value))
				{
					valueMap.put(key, value);
				}
			}
			return valueMap;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
