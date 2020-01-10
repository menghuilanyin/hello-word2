package cn.tedu.xml;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 工具类
 */
public class XMLUtils {
	private XMLUtils() {
	}
	
	/**
	 * 工具方法: 解析xml文件, 返回document对象
	 * @return
	 */
	public static Document getDocument(String xmlpath) {
		try {
			// 创建解析器
			SAXReader reader = new SAXReader();
			// 解析xml返回DOM对象
			return reader.read(xmlpath);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 工具方法: 将指定dom写入的指定路径的xml文件中
	 * 
	 * @param xmlpath
	 * @param dom
	 */
	public static void write2Xml(String xmlpath,
			Document dom) {
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(xmlpath),
					"utf-8");
			OutputFormat format = OutputFormat
					.createPrettyPrint();
			XMLWriter writer = new XMLWriter(out,
					format);
			writer.write(dom);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
