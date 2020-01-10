package cn.tedu.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j��������
 */
public class Demo1 {
	public static void main(String[] args)
			throws Exception {
		// 1.��ѯ��һ����������������������̨
		// 1.����������
		SAXReader reader = new SAXReader();
		// 2.����xml�ĵ�, ����document����
		Document dom = reader.read("book.xml");
		// 3.��ȡ��Ԫ��
		Element root = dom.getRootElement();
		// 4.��ȡ��һ����
		// element("") ����ָ�����Ƶĵ�һ����Ԫ��
		Element bookEle = root.element("��");
		// ��ȡ����
		Element bookNameEle = bookEle.element("����");
		// ��ȡ�����е��ı�����
		String bookName = bookNameEle.getText();
		System.out.println("��һ���������:" + bookName);
	}
}
