import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Students {
    public String secondName;
    public int age;
    public String address;

    Students(String secondName, int age, String address) {
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    Students() {
    }

    public static void main(String args[]) {
        init();
    }

    private static void init() {
        JFrame frame = new JFrame("Lab_7");
        frame.setSize(800, 600);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        HashMap<String, Students> map = new HashMap<String, Students>();

        DefaultListModel<String> listModel = new DefaultListModel<String>();
        JList<String> list = new JList<String>();
        JScrollPane scroll = new JScrollPane(list);

        Box studentInfo = new Box(BoxLayout.Y_AXIS);
        JLabel studentName = new JLabel("Имя : ");
        JLabel studentAge = new JLabel("Возраст : ");
        JLabel studentAddress = new JLabel("Адрес : ");

        studentInfo.add(studentName);
        studentInfo.add(studentAge);
        studentInfo.add(studentAddress);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        list.setModel(listModel);

        Box textField = new Box(BoxLayout.Y_AXIS);
        JTextField text = new JTextField("Введите через пробел данные о студенте : 'Имя' : 'Возраст' : 'Адрес'");

        textField.add(text);

        Box buttons = new Box(BoxLayout.X_AXIS);

        JButton addButton = new JButton("Добавить в список");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] attributes = text.getText().split(" ");
                try {
                    Students chel = new Students(attributes[0], Integer.parseInt(attributes[1]), attributes[2]);
                    System.out.print(chel.address);
                    map.put(chel.secondName, chel);
                    listModel.addElement(chel.secondName);
                } catch (Exception error) {
                    text.setText("Неккоректно введены данные");
                }

            }
        });

        JButton deleteButton = new JButton("Убрать из списка");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (map.get(list.getSelectedValue().toString()) != null) {
                    Students student = map.get(list.getSelectedValue().toString());
                    listModel.removeElement(student.secondName);
                }
            }
        });

        JButton clearButton = new JButton("Очистить список");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.clear();
                listModel.clear();
            }
        });

        Box slButtons = new Box(BoxLayout.X_AXIS);

        FileDialog fdlg = new FileDialog(frame, "");

        JButton loadButton = new JButton("Загрузить файл");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fdlg.setMode(FileDialog.LOAD);
                fdlg.setTitle("Загрузить файл");
                fdlg.setVisible(true);
                map.clear();
                listModel.clear();

                FileReader reader = null;
                try {
                    reader = new FileReader(fdlg.getDirectory() + fdlg.getFile());
                    BufferedReader bReader = new BufferedReader(reader);

                    String infoString = null;

                    while ((infoString = bReader.readLine()) != null) {
                        String[] info = infoString.split(" ");

                        Students chel = new Students();
                        chel.secondName = info[0];
                        chel.age = Integer.parseInt(info[1]);
                        chel.address = info[2];

                        map.put(chel.secondName, chel);
                        listModel.addElement(chel.secondName);
                    }
                    reader.close();
                    bReader.close();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });

        JButton saveButton = new JButton("Сохранить файл");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fdlg.setMode(FileDialog.SAVE);
                fdlg.setTitle("Сохранить файл");
                fdlg.setVisible(true);

                try {
                    FileWriter writer = new FileWriter(fdlg.getDirectory() + fdlg.getFile());
                    BufferedWriter bWriter = new BufferedWriter(writer);

                    for (int i = 0; i < listModel.getSize(); i++) {
                        Students chel = map.get(listModel.getElementAt(i));
                        bWriter.write("" + chel.secondName + " " + Integer.toString(chel.age) + " " + chel.address);
                        bWriter.newLine();
                    }
                    bWriter.close();
                    writer.close();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        slButtons.add(loadButton);
        slButtons.add(Box.createHorizontalGlue());
        slButtons.add(saveButton);

        buttons.add(addButton);
        buttons.add(Box.createHorizontalGlue());
        buttons.add(deleteButton);
        buttons.add(Box.createHorizontalGlue());
        buttons.add(clearButton);

        textField.add(buttons);
        textField.add(Box.createVerticalStrut(20));

        splitPane.setLeftComponent(scroll);
        splitPane.setRightComponent(studentInfo);
        splitPane.setResizeWeight(0.25);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (map.get(list.getSelectedValue()) != null) {
                    Students student = map.get(list.getSelectedValue().toString());
                    studentName.setText("Имя : " + student.secondName);
                    studentAge.setText("Возраст : " + Integer.toString(student.age));
                    studentAddress.setText("Адрес : " + student.address);
                }
            }
        });

        frame.add(textField, BorderLayout.NORTH);
        frame.add(splitPane, BorderLayout.CENTER);
        frame.add(slButtons, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
