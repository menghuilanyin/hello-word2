package cn.tedu.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j快速入门
 */
public class Demo1 {
	public static void main(String[] args)
			throws Exception {
		// 1.查询第一本书的书名，并输出到控制台
		// 1.创建解析器
		SAXReader reader = new SAXReader();
		// 2.解析xml文档, 返回document对象
		Document dom = reader.read("book.xml");
		// 3.获取根元素
		Element root = dom.getRootElement();
		// 4.获取第一本书
		// element("") 返回指定名称的第一个子元素
		Element bookEle = root.element("书");
		// 获取书名
		Element bookNameEle = bookEle.element("书名");
		// 获取书名中的文本内容
		String bookName = bookNameEle.getText();
		System.out.println("第一本书的书名:" + bookName);
	}
}
