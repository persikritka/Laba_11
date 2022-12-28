package menu;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import football.Football;
import listener.OpenListener;
import listener.OpenXMLListener;
import listener.SaveAsXMLListener;
import listener.SaveListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Menu extends JFrame{
    Gson gson;
    private int number;
    private int numberJSon;
    private int age;
    private int ageJSon;
    private int salary;
    private int salaryJSon;
    private String position;
    private String positionJSon;
    private String nameOfFile;
    private JTextField fileField;
    private JTextField ageField;
    private JTextField positionField;
    private JTextField numberField;
    private JTextField salaryField;
    private JsonObject footballObject;
    public Menu()
    {
        super("Системное меню");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLayout(new FlowLayout(FlowLayout.LEFT));
        // Создание строки главного меню
        JMenuBar menuBar = new JMenuBar();
        JPanel panelNumber = new JPanel(new FlowLayout());
        add(panelNumber);
        JLabel numberLabel = new JLabel("Enter number of football's player");
        panelNumber.add(numberLabel);
        numberField = new JTextField(5);
        panelNumber.add(numberField);

        JPanel panelPosition = new JPanel(new FlowLayout());
        add(panelPosition);
        JLabel positionLabel = new JLabel("Enter the position of football's player");
        panelPosition.add(positionLabel);
        positionField = new JTextField(5);
        panelPosition.add(positionField);

        JPanel panelSalary = new JPanel(new FlowLayout());
        add(panelSalary);
        JLabel salaryLabel = new JLabel("Enter the salary of football's player");
        panelSalary.add(salaryLabel);
        salaryField = new JTextField(5);
        panelSalary.add(salaryField);

        JPanel panelAge = new JPanel(new FlowLayout());
        add(panelAge);
        JLabel ageLabel = new JLabel("Enter the age of football's player");
        panelAge.add(ageLabel);
        ageField = new JTextField(5);
        panelAge.add(ageField);

        JPanel filePanel = new JPanel(new FlowLayout());
        add(filePanel);
        JLabel fileLabel = new JLabel("Enter the name of file");
        filePanel.add(fileLabel);
        fileField = new JTextField(10);
        filePanel.add(fileField);

        menuBar.add(createFileMenu());
        setJMenuBar(menuBar);
        setSize(500, 300);
       // pack();
        setVisible(true);
    }

    private JMenu createFileMenu() {
        // Создание выпадающего меню
        JMenu file = new JMenu("File");
        // Пункт меню "Открыть" с изображением
        JMenu open = new JMenu("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenu saveAs = new JMenu("Save as");
        JMenuItem gSon = new JMenuItem("Gson");
        JMenuItem xml = new JMenuItem("XML");
        JMenuItem gSonOpen = new JMenuItem("GSon");
        JMenu xmlOpen = new JMenu("XML");
        JMenuItem xmlDomOpen = new JMenuItem("Dom");
        JMenuItem xmlSaxOpen = new JMenuItem("SAX");
        JMenuItem xmlJaxbOpen = new JMenuItem("JAXB");
        // Пункт меню из команды с выходом из программы
        // Добавление к пункту меню изображения
        //exit.setIcon(new ImageIcon("images/exit.png"));
        // Добавим в меню пункта open
        file.add(open);
        // Добавление разделителя
        file.addSeparator();
        file.add(save);
        file.addSeparator();
        file.add(saveAs);
        saveAs.add(gSon);
        saveAs.addSeparator();
        saveAs.add(xml);
        open.add(gSonOpen);
        open.addSeparator();
        open.add(xmlOpen);
        xmlOpen.add(xmlDomOpen);
        xmlOpen.addSeparator();
        xmlOpen.add(xmlJaxbOpen);
        xmlOpen.addSeparator();
        xmlOpen.add(xmlSaxOpen);

        SaveListener saveListener = new SaveListener();
        saveListener.setFrame(this);
        saveListener.setFileField(fileField);
        saveListener.setAgeField(ageField);
        saveListener.setNumberField(numberField);
        saveListener.setPositionField(positionField);
        saveListener.setSalaryField(salaryField);
        save.addActionListener(saveListener);
        gSon.addActionListener(saveListener);

        OpenListener openListener = new OpenListener();
        openListener.setFrame(this);

        /*footballObject = openListener.getFootball();
        JsonElement numberElement = footballObject.get("number");
        numberField.setText(numberElement.toString());*/

        openListener.setAgeField(ageField);
        openListener.setPositionField(positionField);
        openListener.setNumberField(numberField);
        openListener.setSalaryField(salaryField);

        gSonOpen.addActionListener(openListener);

        numberField = openListener.getNumberField();
        ageField = openListener.getAgeField();
        salaryField = openListener.getSalaryField();
        positionField = openListener.getPositionField();

        OpenXMLListener openXMLListener = new OpenXMLListener();
        openXMLListener.setFrame(this);
        openXMLListener.setAgeField(ageField);
        openXMLListener.setPositionField(positionField);
        openXMLListener.setNumberField(numberField);
        openXMLListener.setSalaryField(salaryField);
        xmlDomOpen.addActionListener(openXMLListener);
        numberField = openXMLListener.getNumberField();
        salaryField = openXMLListener.getSalaryField();
        positionField = openXMLListener.getPositionField();
        ageField = openXMLListener.getAgeField();

        SaveAsXMLListener saveAsXMLListener = new SaveAsXMLListener();
        saveAsXMLListener.setFrame(this);
        saveAsXMLListener.setFileField(fileField);
        saveAsXMLListener.setAgeField(ageField);
        saveAsXMLListener.setNumberField(numberField);
        saveAsXMLListener.setSalaryField(salaryField);
        saveAsXMLListener.setPositionField(positionField);

        xml.addActionListener(saveAsXMLListener);

        return file;
    }



}
