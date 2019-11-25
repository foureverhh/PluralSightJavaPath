package server_basic.web;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        WebXmlParsing webXmlParsing = new WebXmlParsing();
        try {
            webXmlParsing.parse();
            List<Mapping> mappings = webXmlParsing.getMappings();
            List<Entity> entities = webXmlParsing.getEntities();
            for(Mapping mapping:mappings){
                System.out.println(mapping);
            }
            for(Entity entity:entities){
                System.out.println(entity);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
