package server_basic.web;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WebXmlParsing {
    private List<Mapping> mappings = new LinkedList<>();
    private List<Entity> entities = new LinkedList<>();
    public void parse() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        WebXmlHandler handler = new WebXmlHandler();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"),handler);
        mappings = handler.getMappings();
        entities = handler.getEntities();
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

    class WebXmlHandler extends DefaultHandler{
        private List<Mapping> mappings;
        private List<Entity> entities;
        private Mapping mapping;
        private Entity entity;
        private String tag;
        private int index;

        @Override
        public void startDocument() throws SAXException {
            mappings = new ArrayList<>();
            entities = new ArrayList<>();
            tag = "";
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tag = qName;
            if(tag.equals("servlet")){
                index++;
                entity = new Entity();
                //System.out.println("new entity set up");

            }
            if(tag.equals("servlet-mapping")){
                index++;
                mapping = new Mapping();
                //System.out.println("new mapping set up");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch,start,length).trim();
            if(content.length()>0){
                if(tag.equals("servlet-name")){
                    if(entity!=null) {
                        entity.setName(content);
                    }
                    if(mapping!=null && index%2==0) {
                        mapping.setName(content);
                        System.out.println("name->" + content);
                    }
                }
                if(tag.equals("servlet-class") && entity!=null){
                    entity.setClz(content);
                    //System.out.println("Clz->"+content);
                }
                if(tag.equals("url-pattern") && mapping!=null){
                    mapping.addPattern(content);
                   System.out.println("url-pattern->"+content);
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equals("servlet")) {
                entities.add(entity);
            }
            if(qName.equals("servlet-mapping")) {
                mappings.add(mapping);
            }
            tag = "";
        }

        @Override
        public void endDocument() throws SAXException {
        }

        public List<Mapping> getMappings() {
            return mappings;
        }

        public List<Entity> getEntities() {
            return entities;
        }
    }
}
