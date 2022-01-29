package progettoispw.letmeknow.controller;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ConnectionInfo {
    private static String FILENAME;
    private static String User;
    private static String Pass;
    private static String DB_URL;
    private static String DRIVER_CLASS_NAME;

    public ConnectionInfo(){
        FILENAME="src/main/resources/progettoispw/letmeknow/connection/ConnectionParameters.xml";
    }

    private void getElements(){

        String id;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));

            doc.getDocumentElement().normalize();

            //Node Element <connection>
            //get <parameters>
            NodeList list = doc.getElementsByTagName("parameters");

            for(int temp=0; temp < list.getLength(); temp++){
                Node node = list.item(temp);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    //Get attributes
                    id=element.getAttribute("id");

                    //Actual connection parameters from XML
                    User = element.getElementsByTagName("username").item(0).getTextContent();
                    Pass = element.getElementsByTagName("password").item(0).getTextContent();
                    DB_URL = element.getElementsByTagName("url").item(0).getTextContent();
                    DRIVER_CLASS_NAME = element.getElementsByTagName("driverName").item(0).getTextContent();

                }
            }

        }catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }

    }

    public Map<String,String> getConnectionInfo(){

        getElements();
        Map<String, String> parameters = new HashMap<>();

        parameters.put("username",User);
        parameters.put("password",Pass);
        parameters.put("url",DB_URL);
        parameters.put("driverName",DRIVER_CLASS_NAME);

        return parameters;
    }

}