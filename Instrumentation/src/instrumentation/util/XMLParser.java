/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author User
 */
public class XMLParser {
    private static String launcher = "";
    private static String launcherLabel = "";
    private static String buildPackage = "";
    private static String devPackage = "";
    private static String testProjName = "";
    
    private static ArrayList<String> editedProjects = new ArrayList<String>();
    
    private static String permExt = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static String permInt = "android.permission.INTERNET";
    private static String permLoc = "android.permission.ACCESS_FINE_LOCATION";
    private static String permWifi = "android.permission.ACCESS_WIFI_STATE";
    private static String permPhone = "android.permission.READ_PHONE_STATE";
    private static String permNet = "android.permission.ACCESS_NETWORK_STATE";
    private static String permBoot = "android.permission.RECEIVE_BOOT_COMPLETED";

    public static String getXmlPropertyValue(String element, String property, String file){
        String res = "";
        File fXmlFile = new File(file);
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            Element cElem = doc.getDocumentElement();
            if(cElem.hasAttribute(property)){
                res = cElem.getAttribute(property);
                return res;
            }
            NodeList list = cElem.getElementsByTagName(element);
            for(int i=0; i<list.getLength(); i++){
                Element x = (Element)list.item(i);
                if(x.hasAttribute(property)) res = x.getAttribute(property);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    public static void parseManifest(String file) {
        buildPackage = "";
        devPackage = "";
        try {
            String cName="", cLabel="", cPack="";
            File fXmlFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            Element cElem = doc.getDocumentElement();
            cPack = cElem.hasAttribute("package") ? cElem.getAttribute("package") : "";
            buildPackage = cPack;
            
            NodeList appList = doc.getElementsByTagName("application");
            Element app = (Element)appList.item(0);
            NodeList nList = app.getElementsByTagName("activity");


            for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element eElement = (Element) nNode;
                            
                            cName = eElement.hasAttribute("android:name") ? eElement.getAttribute("android:name") : "";
                            cLabel = eElement.hasAttribute("android:label") ? eElement.getAttribute("android:label") : "";
                            if(cName.startsWith(".")){
                                cName = cPack+cName;
                                devPackage = cName.substring(0, cName.lastIndexOf("."));
                            }else{
                                devPackage = cName.substring(0, cName.lastIndexOf("."));
                                if(buildPackage.equals("")){
                                    buildPackage = devPackage;
                                }
                            }
                            //System.out.println("Name : " + eElement.getAttribute("android:name"));
                            //System.out.println("Label : " + eElement.getAttribute("android:label"));
                            NodeList intents = eElement.getElementsByTagName("intent-filter");
                            for(int i = 0; i< intents.getLength(); i++){
                                Node nIntent = intents.item(i);
                                if (nIntent.getNodeType() == Node.ELEMENT_NODE) {
                                    Element eIntent = (Element) nIntent;
                                    NodeList categories = eIntent.getElementsByTagName("category");
                                    for(int j = 0; j< categories.getLength(); j++){
                                        Node nCategory = categories.item(j);
                                        if(nCategory.getNodeType() == Node.ELEMENT_NODE){
                                            Element eCategory = (Element)nCategory;
                                            if(eCategory.getAttribute("android:name").contains("LAUNCHER")){
                                                launcher = cName;
                                                launcherLabel = cLabel;
                                            }
                                        }
                                    }
                                }
                            }
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 
   }
    
    public static void editManifest(String file){
        try {
                String pName = "";
                boolean hasExt = false, hasInt = false, hasLoc = false, hasWifi  = false, hasPhone = false, hasNet = false, hasBoot  = false;
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(file);
 
		// Get the root element
		Node manifest = doc.getElementsByTagName("manifest").item(0);
                
		NodeList permissions = doc.getElementsByTagName("uses-permission");
                if(permissions == null){
                    
                }else{
                    for(int i = 0; i<permissions.getLength(); i++){
                        Node n = permissions.item(i);
                        if(n.getNodeType() == Node.ELEMENT_NODE){
                            Element e = (Element)n;
                            pName = e.hasAttribute("android:name") ? e.getAttribute("android:name") : "";
                            if(pName.equals(permExt)){
                                hasExt = true;
                            }if(pName.equals(permBoot)){
                                hasBoot = true;
                            }if(pName.equals(permInt)){
                                hasInt = true;
                            }if(pName.equals(permLoc)){
                                hasLoc = true;
                            }if(pName.equals(permWifi)){
                                hasWifi = true;
                            }if(pName.equals(permPhone)){
                                hasPhone = true;
                            }if(pName.equals(permNet)){
                                hasNet = true;
                            }
                        }
                    }
                }
                if(!hasExt){
                    Element nPerm = doc.createElement("uses-permission");
                    nPerm.setAttribute("android:name", permExt);
                    manifest.appendChild(nPerm);
                }if(!hasBoot){
                    Element nPerm = doc.createElement("uses-permission");
                    nPerm.setAttribute("android:name", permBoot);
                    manifest.appendChild(nPerm);
                }if(!hasInt){
                    Element nPerm = doc.createElement("uses-permission");
                    nPerm.setAttribute("android:name", permInt);
                    manifest.appendChild(nPerm);
                }if(!hasLoc){
                    Element nPerm = doc.createElement("uses-permission");
                    nPerm.setAttribute("android:name", permLoc);
                    manifest.appendChild(nPerm);
                }if(!hasWifi){
                    Element nPerm = doc.createElement("uses-permission");
                    nPerm.setAttribute("android:name", permWifi);
                    manifest.appendChild(nPerm);
                }if(!hasPhone){
                    Element nPerm = doc.createElement("uses-permission");
                    nPerm.setAttribute("android:name", permPhone);
                    manifest.appendChild(nPerm);
                }if(!hasNet){
                    Element nPerm = doc.createElement("uses-permission");
                    nPerm.setAttribute("android:name", permNet);
                    manifest.appendChild(nPerm);
                }

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(file));
		transformer.transform(source, result);
 
 
	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   }
    }
    
    public static void editProjectDesc(String file){
         try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(file);
                String pName = "";
		// Get the root element
		Node description = doc.getElementsByTagName("projectDescription").item(0);
                
		NodeList list = description.getChildNodes();
                for(int i = 0; i < list.getLength(); i++){
                    Node tag = list.item(i);
                    if(tag.getNodeName().equals("name")){
                        editedProjects.add(tag.getTextContent());
                        pName = "__"+tag.getTextContent();
                        testProjName = pName;
                        tag.setTextContent(pName);
                    }else if(tag.getNodeName().equals("projects")){
                        NodeList projects = tag.getChildNodes();
                        for(int j = 0; j < projects.getLength(); j++){
                            Node p = projects.item(j);
                            if(editedProjects.contains(p.getTextContent())){
                                p.setTextContent("__"+p.getTextContent());
                            }
                        }
                    }
                }

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(file));
		transformer.transform(source, result);
 
 
	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   }
    }
    
    public static void editClasspath(String file){
        try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(file);
                String pName = "";
		// Get the root element
		Node classpath = doc.getElementsByTagName("classpath").item(0);
                
		NodeList list = classpath.getChildNodes();
                for(int i = 0; i < list.getLength(); i++){
                    Node tag = list.item(i);
                    if(tag.hasAttributes()){
                        NamedNodeMap atts = tag.getAttributes();
                        if(atts.getNamedItem("combineaccessrules") != null){
                            pName = atts.getNamedItem("path").getTextContent().replaceFirst("/", "/__");
                            atts.getNamedItem("path").setTextContent(pName);
                        }
                        //pName = "__"+tag.getTextContent();
                        //tag.setTextContent(pName);
                    }
                }

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(file));
		transformer.transform(source, result);
 
 
	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   }
    }
    
    public static String getLauncher(){
        return launcher;
    }

    public static String getLauncherLabel() {
        return launcherLabel;
    }
    
    public static String getDevPackage(){
        return devPackage;
    }
    
    public static String getBuildPackage(){
        return buildPackage;
    }
    
    public static String getTestProjName(){
        return testProjName;
    }
    
    public static String getAppPackage(){
        String res = "";
        String[] tok = launcher.split("\\.");
        int tam = tok.length, i;
        for(i=0; i<tam-1; i++){
            res+=tok[i]+".";
        }
        return res.substring(0, res.length()-1);
    }

    public static void editRunConfiguration(String file, String value){
        try {
            String cName="", cLabel="", cPack="";
            File fXmlFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            
            NodeList attrList = doc.getElementsByTagName("stringAttribute");
            for(int i=0; i<attrList.getLength(); i++){
                Element elem = (Element)attrList.item(i);
                if(elem.hasAttribute("key")){
                    if(elem.getAttribute("key").equals("com.android.ide.adt.instrumentation")){
                        elem.setAttribute("value", value);
                    }
                }
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(file));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void editRunner(String file) {
    
    try {
            String cName="", cLabel="", cPack="";
            File fXmlFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            
            NodeList instList = doc.getElementsByTagName("instrumentation");
            Element inst = (Element)instList.item(0);
            if(inst.hasAttribute("android:name")){
                //inst.setAttribute("android:name", "pl.polidea.instrumentation.PolideaInstrumentationTestRunner");
                inst.setAttribute("android:name", "com.zutubi.android.junitreport.JUnitReportTestRunner");
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(file));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
   }
    
}
