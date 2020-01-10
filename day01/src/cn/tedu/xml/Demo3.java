package cn.tedu.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * ����dom4j�������Խڵ�
 */
public class Demo3 {
	/*
	 * 1.����һ�������һ�����ԣ��磺������="�廪��ѧ������"(2�ַ�ʽ)
	 * 2.�ڿ���̨�ϴ�ӡ�����һ����ĳ��������Ե�ֵ,���������Ե�ֵΪ����������硱(3�ַ�ʽ) 
	 * 3.ɾ����һ����ĳ���������(2�ַ�ʽ)
	 */
	public static void main(String[] args) {
		//addAttr();
		
		//findAndUpdateAttr();
		
		//3.ɾ����һ����ĳ���������(2�ַ�ʽ)
		
		Document dom = XMLUtils.getDocument("book.xml");
		Element bookEle = dom.getRootElement().element("��");
		
		//Attribute attr = bookEle.attribute("������");
		//bookEle.remove(attr);
		
		bookEle.addAttribute("���", null);
		
		//�����ļ�
		XMLUtils.write2Xml("book.xml", dom);
	}

	private static void findAndUpdateAttr() {
		//2.�ڿ���̨�ϴ�ӡ�����һ����ĳ��������Ե�ֵ,
			//���������Ե�ֵΪ�����ڳ����硱(3�ַ�ʽ) 
		Document dom = XMLUtils.getDocument("book.xml");
		Element root = dom.getRootElement();
		Attribute attr1 = root.element("��").attribute(1);
		Attribute attr2 = root.element("��").attribute("������");
		System.out.println(attr1.getValue()+":"+attr2.getValue());
		
		//String value = root.element("��").attributeValue("������");
		//System.out.println(value);
		
		//�޸�����ֵ
		attr1.setValue("���ڳ�����");
		
		//�����ļ�
		XMLUtils.write2Xml("book.xml", dom);
	}

	private static void addAttr() {
		Document dom = XMLUtils.getDocument("book.xml");
		Element root = dom.getRootElement();
		
		//��ȡ��һ����
		Element bookEle = root.element("��");
		/*
		//��ʽһ
		//������������Խڵ�
		Attribute attr = DocumentHelper.createAttribute(bookEle, "������", "�廪��ѧ������");
		
		//�����Խڵ���ص���һ������
		bookEle.add(attr);
		*/
		
		//��ʽ��
		bookEle.addAttribute("���", "a01");
		
		//�����ļ�
		XMLUtils.write2Xml("book.xml", dom);
	}
}
