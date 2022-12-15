package pojo;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

public class PojoToJson {
	public static void main(String[] args ) throws SerializeException, ParseException {
		
		/************************************Serialization**************************************************/
		
		//pojo to json
		
		JsonSerializer js=JsonSerializer.DEFAULT_READABLE;
		String sellerNames[] ={"ABC","PQR","XYZ"};
		PojoClass pc=new PojoClass("MacBook",1000,"Blue",sellerNames);
		String json=js.serialize(pc);
		System.out.println(json);
		
		
		//pojo to xml
		
		XmlSerializer xmls=XmlSerializer.DEFAULT_NS_SQ_READABLE;
		String xml=xmls.serialize(pc);
		System.out.println(xml);
		
		//pojo to html
		
		HtmlSerializer htmls=HtmlSerializer.DEFAULT_SQ_READABLE;
		String html=htmls.serialize(pc);
		System.out.println(html);
		
/************************************DeSerialization**************************************************/
		
		JsonParser jsonParser = JsonParser.DEFAULT;
		String jsonVal = "{\r\n"
				+ "	\"color\": \"Blue\",\r\n"
				+ "	\"name\": \"MacBook\",\r\n"
				+ "	\"price\": 1000,\r\n"
				+ "	\"sellerName\": [\r\n"
				+ "		\"ABC\",\r\n"
				+ "		\"PQR\",\r\n"
				+ "		\"XYZ\"\r\n"
				+ "	]\r\n"
				+ "}";
		PojoClass pro = jsonParser.parse(jsonVal, PojoClass.class);
		System.out.println(pro.getColor());
	}

}
