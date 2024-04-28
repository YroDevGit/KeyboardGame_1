
package database;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Data {
  public String databaseLocation(){
      return "src/database/mydata/";
  }
  
  public String HSCOREDB(){
      return "users.xml";
  }
  public String SPEEDSCORE(){
      return "speed.xml";
  }
    
    
     public void setScore(int score, String fl)throws ParserConfigurationException,
            TransformerException{
          
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        
        Element root = doc.createElementNS("score", "users");
        doc.appendChild(root);
        
       
           root.appendChild(createUser(doc, "XML_By_Tyrone_Limen_Malocon_AND_Razel_ann_Armilla",score+"")); 
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();
        
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        DOMSource source = new DOMSource(doc);

        File myFile = new File(databaseLocation()+fl);
        
        StreamResult file = new StreamResult(myFile);

        transf.transform(source, file);
    }

    private static Node createUser(Document doc, String id, String firstName) {
        
        Element user = doc.createElement("user");

        user.setAttribute("id", id);
        user.appendChild(createUserElement(doc, "highest", firstName));
        

        return user;
    }

    private static Node createUserElement(Document doc, String name, 
            String value) {

        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));

        return node;
    }
    
    
    
    
    public int highestScore(String fl){
        
        int x =0;
         
             File inputFile = new File(databaseLocation()+fl);
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder dBuilder;
         try {
             dBuilder = dbFactory.newDocumentBuilder();
         
             Document doc = dBuilder.parse(inputFile);
             doc.getDocumentElement().normalize();
             NodeList nList = doc.getElementsByTagName("user");
             
             for (int temp = 0; temp < nList.getLength(); temp++) {
                 Node nNode = nList.item(temp);
                 
                 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                     Element eElement = (Element) nNode;
                     
                    
                     
                     
                     x = Integer.parseInt(eElement
                                     .getElementsByTagName("highest")
                                     .item(0)
                                     .getTextContent());
                     
                 }
             }
         }
          catch (ParserConfigurationException ex) {
             Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SAXException ex) {
             Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
    }       
                 
       
}
