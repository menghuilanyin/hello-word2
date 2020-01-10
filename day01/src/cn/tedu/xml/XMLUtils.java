package cn.tedu.xml;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * ������
 */
public class XMLUtils {
	private XMLUtils() {
	}
	
	/**
	 * ���߷���: ����xml�ļ�, ����document����
	 * @return
	 */
	public static Document getDocument(String xmlpath) {
		try {
			// ����������
			SAXReader reader = new SAXReader();
			// ����xml����DOM����
			return reader.read(xmlpath);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * ���߷���: ��ָ��domд���ָ��·����xml�ļ���
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
