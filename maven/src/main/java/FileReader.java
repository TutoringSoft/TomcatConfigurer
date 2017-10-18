import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Viviane Orge on 2017-07-05.
 */
public class FileReader {

    public void readFile() {

        try{
            File file = new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\conf\\server.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            System.out.println(file.toString());

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Connector");

            System.out.println("Shutdown | " + document.getDocumentElement().getAttribute("port"));

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    System.out.println(element.getAttribute("protocol") + " | " + element.getAttribute("port"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





