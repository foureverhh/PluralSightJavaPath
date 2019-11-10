package server_basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/*
* SAX
* */
public class XmlTest01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1.Get SAX parseFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.Get parser from the factory
        SAXParser parser = factory.newSAXParser();
        //3.Make handler
        PersonHandler personHandler = new PersonHandler();
        //4.Handle the xml file
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("person.xml")
                ,personHandler);

    }
}

class PersonHandler extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument()->解析文档开始");
    }


    //begin to handle tag one by one
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"--> 解析元素开始 ");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch,start,length).trim();
        if(content.length()>0){
         System.out.println("内容为"+content);
        }
    }

    //end to handle tag one by one
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"--> 解析元素结束");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument()->解析文档结束");
    }
}