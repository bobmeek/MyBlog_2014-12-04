/**  
 * @Title: CustomDateSerializer.java
 * @Package org.myblog.common
 * @Description: TODO
 * @author bobmeek
 * @date Jan 11, 2015 3:52:45 PM
 * @version V1.0  
 */
package org.myblog.common;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * @ClassName: CustomDateSerializer
 * @Description: 自定义返回JSON 数据格中日期格式化处理.
 * 解决问题：针对于springmvc使用jackson返回json数据时 ,date类型的数据只能返回时间戳,比如:138898645000
 * @author bobmeek
 * @date Jan 11, 2015 3:52:45 PM
 */
public class CustomDateSerializer extends JsonSerializer<Timestamp>
{

	@Override
	public void serialize(Timestamp value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException, JsonProcessingException
	{
		try
		{
			String time = DateUtil.convertString("yyyy-MM-dd HH:mm",value);
//			time = DateUtil.convertDateFormat(date);
			jsonGenerator.writeString(time);
		}
		catch (Exception e) 
		{
		}
		
	}
	
}
