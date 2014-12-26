package org.myblog.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GetEntityClassUtil 
{
	// 获取父类泛型中的参数（参数是某个数据类型class）
	@SuppressWarnings("rawtypes")
	public static Class getEntityClass(Class c)
	{
		Type type = c.getGenericSuperclass(); // 通过反射得到泛型父类类型
		
		if(type instanceof ParameterizedType) // 判断是否是泛型
		{
			// 返回表示此类型实际类型参数的Type对象的数组
			Type[] ptype = ((ParameterizedType)type).getActualTypeArguments();
			
			return (Class)ptype[0]; // 得到父类类型的第一个参数 
		}
		
		return Object.class;
	}
}