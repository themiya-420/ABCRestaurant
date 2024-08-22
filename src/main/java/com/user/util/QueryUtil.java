package com.user.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class QueryUtil extends CommonUtil {
	
	public static String QueryById(String id) throws SAXException, IOException, ParserConfigurationException{

        NodeList nodeList;
        Element element = null;

        nodeList = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "/wtpwebapps/ABCRestaurant/WEB-INF/queries.xml"))
                .getElementsByTagName(CommonConstants.Tag_Name);

        for (int i = 0; i < nodeList.getLength(); i++) {
            element = (Element) nodeList.item(i);

            if (element.getAttribute(CommonConstants.Attrib_Name).equals(id)) {
                break;
            }
        }

        return element.getTextContent().trim();

    }
	
}
