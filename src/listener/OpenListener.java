package listener;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class OpenListener implements ActionListener {
    private JFileChooser fileChooser;
    private JsonObject football;
    private JFrame frame;
    private JsonElement number;
    private JsonElement age;
    private JsonElement salary;
    private JsonElement position;
    private JTextField numberField;
    private JTextField ageField;
    private JTextField salaryField;
    private JTextField  positionField;

    public OpenListener() {
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

    public void setFootball(JsonObject football) {
        this.football = football;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JsonObject getFootball() {
        return football;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public JsonElement getNumber() {
        return number;
    }

    public JsonElement getPosition() {
        return position;
    }

    public JsonElement getAge() {
        return age;
    }

    public JsonElement getSalary() {
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
        int result = fileChooser.showOpenDialog(frame);
        if (result== JFileChooser.APPROVE_OPTION) {
            File file1 = fileChooser.getSelectedFile();
            JsonObject jsonObject = null;
            try {
                jsonObject = (JsonObject) readJsonSimpleDemo(file1);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            football = jsonObject;
            number = football.get("number");
            salary = football.get("salary");
            age = football.get("age");
            position = football.get("position");
            numberField.setText(number.getAsString());
            salaryField.setText(salary.getAsString());
            ageField.setText(age.getAsString());
            positionField.setText(position.getAsString());
           // System.out.println(jsonObject);
            //System.out.println(jsonObject.get("age"));
                                   /* try {
                                        document.setPage(file1.toURI().toURL());

                                    } catch(Exception e) {
                                        e.printStackTrace();
                                    }*/
        }

    }

    private Object readJsonSimpleDemo(File file) throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(reader);
    }
    }

