package xmlSample;

import football.Football;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLSample {
    private  final  String  FILE_data = "data.xml";
    private         List<Football>  football;

    /*private void writeDataXML()
    {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db  = null;
        Document doc = null;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db  = dbf.newDocumentBuilder();
            doc = (Document) db.newDocument();

            Element e_root   = doc.createElement("Football");
            e_root.setAttribute("lang", "en");
            Element e_users  = doc.createElement("Users");
            e_root.appendChild(e_users);
            doc.appendChild(e_root);
            if (football.size() == 0)
                return;

            List<String> users  = new ArrayList<String>();
            for (int i = 0; i < football.size(); i++){
                if (!users.contains(posts.get(i).getUsername()))
                    users.add(posts.get(i).getUsername());
            }
            System.out.println("    пользователей : " +
                    users.size());
            for (String user : users) {
                Element e = doc.createElement("user");
                e.setTextContent(user);
                e_users.appendChild (e);
            }
            System.out.println("    форумов : " + forums.size());
            for (String forum : forums) {
                Element e = doc.createElement("forum");
                e.setTextContent(forum);
                e_forums.appendChild (e);
            }
        } catch (ParserConfigurationException | ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            // Сохраняем Document в XML-файл
            if (doc != null)
                writeDocument(doc, FILE_data);
        }
    }*/

    private void writeDocument(Document document, String path)
            throws TransformerFactoryConfigurationError
    {
        Transformer trf = null;
        DOMSource src = null;
        FileOutputStream fos = null;
        try {
            trf = TransformerFactory.newInstance()
                    .newTransformer();
            src = new DOMSource(document);
            fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
