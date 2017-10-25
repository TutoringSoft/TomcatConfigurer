import com.sun.javafx.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class TomcatPort {

    private static final Logger LOG = new Logger();

    private static String filePath = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/conf/server.xml";

    public static void main(String args[]) throws Exception {
    	
    }

    public static void readFile(String filePath) {
        try{
            File file = new File(filePath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            document.getDocumentElement().normalize();
            System.out.println("Shutdown | " + document.getDocumentElement().getAttribute("port"));

            NodeList nodeList = document.getElementsByTagName("Connector");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    System.out.println(element.getAttribute("protocol") + " | " + element.getAttribute("port"));
                }
            }
        } catch (Exception e) {
            LOG.addMessage(e.getMessage());
        }
    }
}