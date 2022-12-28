package listener;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import football.Football;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OpenXMLListener implements ActionListener {
    private JFileChooser fileChooser;
    private Football football;
    private JFrame frame;
    private int number;
    private int age;
    private int salary;
    private String position;
    private JTextField numberField;
    private JTextField ageField;
    private JTextField salaryField;
    private JTextField  positionField;
    private String[] strings;
    private int l;

    public OpenXMLListener() {
        fileChooser = new JFileChooser();
        numberField = new JTextField();
        ageField = new JTextField();
        salaryField = new JTextField();
        positionField = new JTextField();
    }

    public void setAgeField(JTextField ageField) {
        this.ageField = ageField;
    }

    public void setSalaryField(JTextField salaryField) {
        this.salaryField = salaryField;
    }

    public void setPositionField(JTextField positionField) {
        this.positionField = positionField;
    }

    public void setNumberField(JTextField numberField) {
        this.numberField = numberField;
    }

    public void setFileChooser(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    public void setFootball(Football football) {
        this.football = football;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Football getFootball() {
        return football;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public JTextField getAgeField() {
        return ageField;
    }

    public JTextField getNumberField() {
        return numberField;
    }

    public JTextField getPositionField() {
        return positionField;
    }

    public JTextField getSalaryField() {
        return salaryField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        strings = new String[4];
        l = 0;
        int result = fileChooser.showOpenDialog(frame);
        if (result== JFileChooser.APPROVE_OPTION) {
            File file1 = fileChooser.getSelectedFile();

            try {
                // Создается построитель документа
                DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                // Создается дерево DOM документа из файла
                Document document = documentBuilder.parse(file1);

                // Получаем корневой элемент
                Node root = document.getDocumentElement();

                // Просматриваем все подэлементы корневого - т.е. книги
                NodeList footballsPlayer = root.getChildNodes();
                for (int i = 0; i < footballsPlayer.getLength(); i++) {
                    Node player = footballsPlayer.item(i);
                    // Если нода не текст, то это книга - заходим внутрь
                    if (player.getNodeType() != Node.TEXT_NODE) {
                        NodeList footballProps = player.getChildNodes();
                        for (int j = 0; j < footballProps.getLength(); j++) {
                            Node footballProp = footballProps.item(j);
                            // Если нода не текст, то это один из параметров книги - печатаем
                            if (footballProp.getNodeType() != Node.TEXT_NODE) {
                                // System.out.println(footballProp.getNodeName() + ":" + footballProp.getChildNodes().item(0).getTextContent());
                                String str = footballProp.getChildNodes().item(0).getTextContent();
                                strings[l] = str;
                                if (l == 0) {
                                    age = Integer.parseInt(strings[l]);
                                    ageField.setText(strings[l]);
                                } else if (l == 1) {
                                    number = Integer.parseInt(strings[l]);
                                    numberField.setText(strings[l]);
                                } else if (l == 2) {
                                    position = strings[l];
                                    positionField.setText(position);
                                } else if (l == 3) {
                                    salary = Integer.parseInt(strings[l]);
                                    salaryField.setText(strings[l]);
                                }
                                l++;
                                // System.out.println(str);
                            }
                        }
                    }
                }

            } catch (
                    ParserConfigurationException ex) {
                ex.printStackTrace(System.out);
            } catch (
                    SAXException ex) {
                ex.printStackTrace(System.out);
            } catch (
                    IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

}


