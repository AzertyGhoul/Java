import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class App {

    public static DataBase myDB;
    public static JFrame frame;
    public static JScrollPane scrollPane;
    public static JScrollPane scrollPaneTemp;

    public static void main(String[] args) {

        String curPath = System.getProperty("user.dir"); // переменная для пути к папке проекта
        System.out.println("Working Directory = " + curPath);

        myDB = new DataBase(curPath);
        myDB.CreateTables();

        String[] buttonName = { "Company", "Employee", "Projects", "Task" };
        String[] tableName = { "Company", "Employee", "Projects", "Task" };

        HashMap<String, String> mapForTables = new HashMap<>();
        for (int i = 0; i < buttonName.length; i++) {
            mapForTables.put(buttonName[i], tableName[i]);
        }

        scrollPane = new JScrollPane();
        scrollPaneTemp = new JScrollPane();

        frame = new JFrame("Lab_8");
        frame.add(setMenu(buttonName, mapForTables), BorderLayout.NORTH);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
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
    }

    private static Component setMenu(String[] buttonName, HashMap<String, String> mapForTables) {
        Box mainMenu = new Box(BoxLayout.X_AXIS);

        for (int i = 0; i < buttonName.length; i++) {
            JButton curButton = new JButton(buttonName[i]);
            curButton.add(Box.createHorizontalGlue());
            curButton.add(Box.createVerticalStrut(20));

            curButton.addActionListener(e -> {
                JTable currentTable = myDB.getTable(mapForTables.get(e.getActionCommand()));
                if (mapForTables.get(e.getActionCommand()) == "Company"
                        || mapForTables.get(e.getActionCommand()) == "Projects") {
                    JFrame frameTemp = new JFrame(mapForTables.get(e.getActionCommand()));
                    frameTemp.remove(scrollPaneTemp);
                    scrollPaneTemp = new JScrollPane(currentTable);

                    frameTemp.add(scrollPaneTemp, BorderLayout.CENTER);
                    frameTemp.getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                    frameTemp.setSize(800, 600);
                    frameTemp.setMinimumSize(frameTemp.getSize());
                    frameTemp.setVisible(true);
                    frameTemp.pack();
                    frameTemp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frameTemp.setLocationRelativeTo(null);

                } else {
                    frame.remove(scrollPane);
                    scrollPane = new JScrollPane(currentTable);
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.pack();
                }
            });
            mainMenu.add(curButton);
        }
        return mainMenu;
    }
}