import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

public class App {

    public static DataBase myDB;
    public static JFrame frame;
    public static JScrollPane scrollPane;
    public static JScrollPane scrollPaneTemp;
    public static FileDialog fdlg;
    public static String curTableName = "";

    public static void main(String[] args) {

        String curPath = System.getProperty("user.dir"); // переменная для пути к папке проекта
        System.out.println("Working Directory = " + curPath);

        myDB = new DataBase(curPath);
        myDB.CreateTables();

        String[] buttonName = { "Company", "Employee", "Projects", "Task" };
        String[] tableName = { "Company", "Employee", "Projects", "Task" };
        String[] tableNameRus = { "Инфо о компании", "Инфо о работнике", "Инфо проектах", "Инфо о задачах" };

        HashMap<String, String> mapForTablesRus = new HashMap<>();
        HashMap<String, String> mapForTables = new HashMap<>();
        for (int i = 0; i < buttonName.length; i++) {
            mapForTables.put(buttonName[i], tableName[i]);
            mapForTablesRus.put(buttonName[i], tableNameRus[i]);
        }

        scrollPane = new JScrollPane();
        scrollPaneTemp = new JScrollPane();

        frame = new JFrame("Lab_8");
        frame.add(setMenu(buttonName, mapForTables, mapForTablesRus), BorderLayout.NORTH);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(setBotom(""), BorderLayout.SOUTH);
        frame.setSize(800, 600);
        frame.setMinimumSize(frame.getSize());
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                myDB.closeConnetion();
                e.getWindow().dispose();
            }
        });

        fdlg = new FileDialog(frame, "");
        fdlg.setMode(FileDialog.SAVE);
    }

    private static Component setMenu(String[] buttonName, HashMap<String, String> mapForTables,
            HashMap<String, String> mapForTablesRus) {
        Box mainMenu = new Box(BoxLayout.X_AXIS);

        for (int i = 0; i < buttonName.length; i++) {
            JButton curButton = new JButton(buttonName[i]);
            curButton.add(Box.createHorizontalGlue());
            curButton.add(Box.createVerticalStrut(20));

            curButton.addActionListener(e -> {
                JTable currentTable = myDB.getTable(mapForTables.get(e.getActionCommand()));
                curTableName = mapForTables.get(e.getActionCommand());
                if (mapForTables.get(e.getActionCommand()) == "Company"
                        || mapForTables.get(e.getActionCommand()) == "Projects") {
                    JFrame frameTemp = new JFrame(mapForTables.get(e.getActionCommand()));
                    frameTemp.remove(scrollPaneTemp);
                    scrollPaneTemp = new JScrollPane(currentTable);

                    frameTemp.add(scrollPaneTemp, BorderLayout.CENTER);
                    frameTemp.getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                    frameTemp.setSize(800, 600);
                    frameTemp.add(setBotom("temp"), BorderLayout.SOUTH);
                    frameTemp.setMinimumSize(frameTemp.getSize());
                    frameTemp.setVisible(true);
                    frameTemp.pack();
                    frameTemp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frameTemp.setLocationRelativeTo(null);

                    // для активации нижних кнопок (они по умолчанию не активны)
                    // получаем компоновку окна
                    BorderLayout layout = (BorderLayout) frameTemp.getContentPane().getLayout();
                    // получаем компоновку окна и берем нижнюю область с новыми кнопками
                    Box southBox = (Box) layout.getLayoutComponent(BorderLayout.SOUTH);
                    // в цикле проходим по всем объектам и активируем их
                    for (int j = 0; j < southBox.getComponentCount(); j++) {
                        southBox.getComponent(j).setEnabled(true);
                    }

                } else {
                    frame.remove(scrollPane);
                    scrollPane = new JScrollPane(currentTable);
                    BorderLayout layout = (BorderLayout) frame.getContentPane().getLayout();
                    // получаем компоновку окна и берем нижнюю область с новыми кнопками
                    Box southBox = (Box) layout.getLayoutComponent(BorderLayout.SOUTH);
                    // в цикле проходим по всем объектам и активируем их
                    for (int j = 0; j < southBox.getComponentCount(); j++) {
                        southBox.getComponent(j).setEnabled(true);
                    }
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.pack();
                }
            });
            mainMenu.add(curButton);
        }
        return mainMenu;
    }

    private static File getFile(String caption, String ext) {
        fdlg.setTitle(caption);
        fdlg.setFile("*." + ext);
        fdlg.setVisible(true);

        String fileName = fdlg.getDirectory() + fdlg.getFile();
        if (!fileName.contains("." + ext)) {
            fileName = fileName.concat("." + ext);
        }

        File file = new File(fileName);
        return file;
    }

    private static String[] getTableHeader(JScrollPane pane) {
        JViewport viewport = (JViewport) pane.getComponent(0);
        JTable tempTable = (JTable) viewport.getComponent(0);
        TableModel tableModel = tempTable.getModel();
        int colCount = tableModel.getColumnCount();
        String[] columnNames = new String[colCount];

        for (int i = 0; i < colCount; i++) {
            columnNames[i] = tableModel.getColumnName(i);
        }
        return columnNames;
    }

    private static String[][] getTableData(JScrollPane pane) {
        JViewport viewPort = (JViewport) pane.getComponent(0); // получаем внутреннюю область панели
        JTable tempTable = (JTable) viewPort.getComponent(0); // из нее получаем таблицу (объект с номером 0)
        TableModel tableModel = tempTable.getModel(); // у таблицы берем модель (в ней находятся данные)
        int colCount = tableModel.getColumnCount(); // узнаем кол-во полей (столбцов)
        int rowCount = tableModel.getRowCount(); // узнаем кол-во записей (содержимое таблицы)
        String[][] data = new String[rowCount][colCount]; // создаем двумерный массив такого размера
        for (int i = 0; i < rowCount; i++) { // во вложенных циклах
            for (int j = 0; j < colCount; j++) { // проходим по записям таблицы
                data[i][j] = (String) tableModel.getValueAt(i, j); // и записываем их в массив
            }
        }
        for (int i = 0; i < data.length; i++) { // вывод массива для проверки
            System.out.println(Arrays.asList(data[i]));
        }
        return data; // возвращаем массив
    }

    private static Component setBotom(String temp) {
        Box bottom = new Box(BoxLayout.X_AXIS);
        JButton toWord = new JButton("toWord");

        if (temp == "temp") {
            toWord.addActionListener(e -> {
                String[] columnNames = getTableHeader(scrollPaneTemp);
                String[][] data = getTableData(scrollPaneTemp);

                File file = getFile("Save to Word file", "docx");
                if (!file.getName().contains("nullnull")) {
                    ToOffice.toWordDocx(columnNames, data, file, curTableName);
                }
            });

            toWord.setEnabled(false);
            bottom.add(toWord);
            bottom.add(Box.createHorizontalGlue());

            JButton toExcel = new JButton("toExcel");
            toExcel.addActionListener(e -> {
                String[] columnNames = getTableHeader(scrollPaneTemp);
                String[][] data = getTableData(scrollPaneTemp);
                File file = getFile("Save to Excel file", "xls");
                if (!file.getName().contains("nullnull")) {
                    ToOffice.toExcel(columnNames, data, file, curTableName);
                }
            });

            toExcel.setEnabled(false);
            bottom.add(toExcel);
            return bottom;
        } else {
            toWord.addActionListener(e -> {
                String[] columnNames = getTableHeader(scrollPane);
                String[][] data = getTableData(scrollPane);

                File file = getFile("Save to Word file", "docx");
                if (!file.getName().contains("nullnull")) {
                    ToOffice.toWordDocx(columnNames, data, file, curTableName);
                }
            });

            toWord.setEnabled(false);
            bottom.add(toWord);
            bottom.add(Box.createHorizontalGlue());

            JButton toExcel = new JButton("toExcel");
            toExcel.addActionListener(e -> {
                String[] columnNames = getTableHeader(scrollPane);
                String[][] data = getTableData(scrollPane);
                File file = getFile("Save to Excel file", "xls");
                if (!file.getName().contains("nullnull")) {
                    ToOffice.toExcel(columnNames, data, file, curTableName);
                }
            });

            toExcel.setEnabled(false);
            bottom.add(toExcel);
            return bottom;
        }

    }
}