package cn.tedu.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * ����dom4j����Ԫ�ؽڵ�
 */
public class Demo2 {
	/*
	 * 2.��ѯ�ڶ�������ۼۣ������������̨ 3.����һ�������һ���ؼ۽ڵ㣨2�ַ�ʽ�� 4.���ڶ����������߽ڵ�ǰ����һ���ؼ۽ڵ�
	 * 5.ɾ���ڶ�������ؼ۽ڵ㣨2�ַ�ʽ�� 6.���µ�һ������ؼ۽ڵ������Ϊ19.8Ԫ
	 */
	public static void main(String[] args)
			throws Exception {
		// 2.��ѯ�ڶ�������ۼۣ������������̨
		// findPrice();
		
		// 3.����һ�������һ���ؼ۽ڵ㣨2�ַ�ʽ��
		//addPrice();
		
		// 4.���ڶ����������߽ڵ�ǰ����һ���ؼ۽ڵ�
		//insertPrice2();
		
		// 5.ɾ���ڶ�������ؼ۽ڵ㣨2�ַ�ʽ��
		// deletePrice();
		
		//6.���µ�һ������ؼ۽ڵ������Ϊ19.8Ԫ
		Document dom = XMLUtils.getDocument("book.xml");
		Element root = dom.getRootElement();
		
		root.element("��").element("�ؼ�").setText("19.8Ԫ");
		
		//�����ļ�
		XMLUtils.write2Xml("book.xml", dom);
	}

	private static void deletePrice() {
		Document dom = XMLUtils.getDocument("book.xml");
		Element root = dom.getRootElement();
		
		//��ȡ�ڶ�����
		Element book2Ele = (Element) root.elements().get(1);
		
		/*
		//��ʽһ
		//��ȡҪɾ�����ؼ۽ڵ�
		Element price2Ele = book2Ele.element("�ؼ�");
		
		//������ӹ�ϵ
		book2Ele.remove(price2Ele);
		*/
		
		//��ʽ��
		book2Ele.elements().remove(1);
		
		//����xml�ļ�
		XMLUtils.write2Xml("book.xml", dom);
	}

	private static void insertPrice2() {
		// 4.���ڶ����������߽ڵ�ǰ����һ���ؼ۽ڵ�
		Document dom = XMLUtils.getDocument("book.xml");
		Element book2Ele = (Element)dom.getRootElement().elements().get(1);
		List list = book2Ele.elements();
		Element price2Ele = DocumentHelper.createElement("�ؼ�");
		price2Ele.setText("8.8Ԫ");
		
		list.add(1, price2Ele);
		
		//�����ļ�
		XMLUtils.write2Xml("book.xml", dom);
	}

	private static void addPrice()
			throws UnsupportedEncodingException,
			FileNotFoundException, IOException {
		// 3.����һ�������һ���ؼ۽ڵ㣨2�ַ�ʽ��
		// ��ȡdom����
		Document dom = XMLUtils.getDocument("book.xml");
		Element root = dom.getRootElement();

		// ��ȡ��һ����(���ڵ�)
		Element bookEle = root.element("��");
		
		/*
		//��ʽһ
		// ��������ڵ�
		Element price2Ele = DocumentHelper
				.createElement("�ؼ�");
		price2Ele.setText("9.8Ԫ");

		// ������ڵ���ص����ڵ���
		bookEle.add(price2Ele);
		*/
		
		//��ʽ��:
		Element price2Ele = bookEle.addElement("�ؼ�");
		price2Ele.setText("9.9Ԫ");

		// ����xml�ļ�(��document������д��xml�ļ�)
		OutputStreamWriter out = new OutputStreamWriter(
				new FileOutputStream("book.xml"),
				"utf-8");
		// FileWriter out = new FileWriter(new File("book.xml"));

		OutputFormat format1 = OutputFormat
				.createCompactFormat();
		OutputFormat format2 = OutputFormat
				.createPrettyPrint();

		XMLWriter writer = new XMLWriter(out, format2);
		writer.write(dom);
		writer.close();
	}

	private static void findPrice()
			throws DocumentException {
		// 2.��ѯ�ڶ�������ۼۣ������������̨
		// ����������
		SAXReader reader = new SAXReader();
		// ����xml����DOM����
		Document dom = reader.read("book.xml");
		// ��ȡrootԪ��
		Element root = dom.getRootElement();

		// ��ȡ�ڶ�����
		// elements()--���ص�ǰԪ����������Ԫ����ɵļ���
		List<Element> list = root.elements();
		Element bookEle2 = list.get(1);

		// ��ȡ�ۼ�
		Element priceEle = bookEle2.element("�ۼ�");
		System.out.println(priceEle.getText());
		System.out.println(priceEle.getTextTrim());
	}

}
