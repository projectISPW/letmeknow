package progettoispw.letmeknow.controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ConnectionInfo {
    private static final String FILENAME="src/main/resources/progettoispw.letmeknow/connection/ConnectionParameters.xml";
    private static String user;
    private static String pass;
    private static String dbUrl;
    private static String driverClassName;
    private static void getElements(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));

            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("parameters");

            for(int temp=0; temp < list.getLength(); temp++){
                Node node = list.item(temp);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    //Get attributes
                    //Actual connection parameters from XML
                    user = element.getElementsByTagName("username").item(0).getTextContent();
                    pass = element.getElementsByTagName("password").item(0).getTextContent();
                    dbUrl = element.getElementsByTagName("url").item(0).getTextContent();
                    driverClassName = element.getElementsByTagName("driverName").item(0).getTextContent();

                }
            }

        }catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
    }
    public Map<String,String> getConnectionInfo(){

        getElements();
        Map<String, String> parameters = new HashMap<>();

        parameters.put("username", user);
        parameters.put("password", pass);
        parameters.put("url", dbUrl);
        parameters.put("driverName", driverClassName);

        return parameters;
    }

}