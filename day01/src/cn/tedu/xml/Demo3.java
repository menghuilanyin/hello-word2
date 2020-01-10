package cn.tedu.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 利用dom4j操作属性节点
 */
public class Demo3 {
	/*
	 * 1.给第一本书添加一个属性，如：出版社="清华大学出版社"(2种方式)
	 * 2.在控制台上打印输出第一本书的出版社属性的值,并更新属性的值为“人民出版社”(3种方式) 
	 * 3.删除第一本书的出版社属性(2种方式)
	 */
	public static void main(String[] args) {
		//addAttr();
		
		//findAndUpdateAttr();
		
		//3.删除第一本书的出版社属性(2种方式)
		
		Document dom = XMLUtils.getDocument("book.xml");
		Element bookEle = dom.getRootElement().element("书");
		
		//Attribute attr = bookEle.attribute("出版社");
		//bookEle.remove(attr);
		
		bookEle.addAttribute("编号", null);
		
		//更新文件
		XMLUtils.write2Xml("book.xml", dom);
	}

	private static void findAndUpdateAttr() {
		//2.在控制台上打印输出第一本书的出版社属性的值,
			//并更新属性的值为“达内出版社”(3种方式) 
		Document dom = XMLUtils.getDocument("book.xml");
		Element root = dom.getRootElement();
		Attribute attr1 = root.element("书").attribute(1);
		Attribute attr2 = root.element("书").attribute("出版社");
		System.out.println(attr1.getValue()+":"+attr2.getValue());
		
		//String value = root.element("书").attributeValue("出版社");
		//System.out.println(value);
		
		//修改属性值
		attr1.setValue("达内出版社");
		
		//更新文件
		XMLUtils.write2Xml("book.xml", dom);
	}

	private static void addAttr() {
		Document dom = XMLUtils.getDocument("book.xml");
		Element root = dom.getRootElement();
		
		//获取第一本书
		Element bookEle = root.element("书");
		/*
		//方式一
		//创建游离的属性节点
		Attribute attr = DocumentHelper.createAttribute(bookEle, "出版社", "清华大学出版社");
		
		//将属性节点挂载到第一本书上
		bookEle.add(attr);
		*/
		
		//方式二
		bookEle.addAttribute("编号", "a01");
		
		//更新文件
		XMLUtils.write2Xml("book.xml", dom);
	}
}
