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
 * 利用dom4j操作元素节点
 */
public class Demo2 {
	/*
	 * 2.查询第二本书的售价，并输出到控制台 3.给第一本书添加一个特价节点（2种方式） 4.给第二本书在作者节点前插入一个特价节点
	 * 5.删除第二本书的特价节点（2种方式） 6.更新第一本书的特价节点的内容为19.8元
	 */
	public static void main(String[] args)
			throws Exception {
		// 2.查询第二本书的售价，并输出到控制台
		// findPrice();
		
		// 3.给第一本书添加一个特价节点（2种方式）
		//addPrice();
		
		// 4.给第二本书在作者节点前插入一个特价节点
		//insertPrice2();
		
		// 5.删除第二本书的特价节点（2种方式）
		// deletePrice();
		
		//6.更新第一本书的特价节点的内容为19.8元
		Document dom = XMLUtils.getDocument("book.xml");
		Element root = dom.getRootElement();
		
		root.element("书").element("特价").setText("19.8元");
		
		//更新文件
		XMLUtils.write2Xml("book.xml", dom);
	}

	private static void deletePrice() {
		Document dom = XMLUtils.getDocument("book.xml");
		Element root = dom.getRootElement();
		
		//获取第二本书
		Element book2Ele = (Element) root.elements().get(1);
		
		/*
		//方式一
		//获取要删除的特价节点
		Element price2Ele = book2Ele.element("特价");
		
		//解除父子关系
		book2Ele.remove(price2Ele);
		*/
		
		//方式二
		book2Ele.elements().remove(1);
		
		//更新xml文件
		XMLUtils.write2Xml("book.xml", dom);
	}

	private static void insertPrice2() {
		// 4.给第二本书在作者节点前插入一个特价节点
		Document dom = XMLUtils.getDocument("book.xml");
		Element book2Ele = (Element)dom.getRootElement().elements().get(1);
		List list = book2Ele.elements();
		Element price2Ele = DocumentHelper.createElement("特价");
		price2Ele.setText("8.8元");
		
		list.add(1, price2Ele);
		
		//更新文件
		XMLUtils.write2Xml("book.xml", dom);
	}

	private static void addPrice()
			throws UnsupportedEncodingException,
			FileNotFoundException, IOException {
		// 3.给第一本书添加一个特价节点（2种方式）
		// 获取dom对象
		Document dom = XMLUtils.getDocument("book.xml");
		Element root = dom.getRootElement();

		// 获取第一本书(父节点)
		Element bookEle = root.element("书");
		
		/*
		//方式一
		// 创建游离节点
		Element price2Ele = DocumentHelper
				.createElement("特价");
		price2Ele.setText("9.8元");

		// 将游离节点挂载到父节点上
		bookEle.add(price2Ele);
		*/
		
		//方式二:
		Element price2Ele = bookEle.addElement("特价");
		price2Ele.setText("9.9元");

		// 更新xml文件(将document对象再写回xml文件)
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
		// 2.查询第二本书的售价，并输出到控制台
		// 创建解析器
		SAXReader reader = new SAXReader();
		// 解析xml返回DOM对象
		Document dom = reader.read("book.xml");
		// 获取root元素
		Element root = dom.getRootElement();

		// 获取第二本书
		// elements()--返回当前元素下所有子元素组成的集合
		List<Element> list = root.elements();
		Element bookEle2 = list.get(1);

		// 获取售价
		Element priceEle = bookEle2.element("售价");
		System.out.println(priceEle.getText());
		System.out.println(priceEle.getTextTrim());
	}

}
