import com.google.gson.Gson;
import football.Football;
import frame.Frame;
import menu.Menu;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xmlSample.XMLSample;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        new Menu();
        /*System.out.println ("ActionListener.actionPerformed : save");
       // Football user = new Football(1, 2, 456, 23);
         Gson gson = new Gson();

        try {
            FileWriter file = new FileWriter("test");
            gson.toJson(345, file);
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        Football user = new Football();
        XMLSample xmlSample = new XMLSample();
        String[] strings = new String[4];
        int l = 0;

        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("Book.xml.txt");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList footballsPlayer = root.getChildNodes();
            for (int i = 0; i < footballsPlayer.getLength(); i++) {
                Node player = footballsPlayer.item(i);
                // Если нода не текст, то это книга - заходим внутрь
                if (player.getNodeType() != Node.TEXT_NODE) {
                    NodeList bookProps = player.getChildNodes();
                    for (int j = 0; j < bookProps.getLength(); j++) {
                        Node footballProp = bookProps.item(j);
                        // Если нода не текст, то это один из параметров книги - печатаем
                        if (footballProp.getNodeType() != Node.TEXT_NODE) {
                           // System.out.println(footballProp.getNodeName() + ":" + footballProp.getChildNodes().item(0).getTextContent());
                            String str = footballProp.getChildNodes().item(0).getTextContent();
                            strings[l] = str;
                            if(l == 0) {
                                user.setAge(Integer.parseInt(strings[l]));
                            } else if(l == 1) {
                                user.setNumber(Integer.parseInt(strings[l]));
                            } else if (l == 2) {
                                user.setPosition(strings[l]);
                            } else if (l == 3) {
                                user.setSalary(Integer.parseInt(strings[l]));
                            }
                            l++;
                           // System.out.println(str);
                        }
                    }
                }
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        for (int k = 0; k < strings.length; k++) {
            System.out.println(strings[k]);
        }
       System.out.println(user);
    }

    }





