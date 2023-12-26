import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class MyFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab4");// создаем окно с заголовком FrameDemo
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        setNorth(frame);
        setWest(frame);
        setEast(frame);
        setCenter(frame);
        setSouth(frame);

        frame.setVisible(true);
        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setResizable(false);
    }

    public static void setNorth(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 4));

        ArrayList<JLabel> labelArray = new ArrayList<JLabel>();

        for (int i = 0; i <= 6; i++) {
            JLabel label = new JLabel("Метка " + i);
            panel.add(label);
            labelArray.add(label);
        }

        Component strut = Box.createVerticalStrut(30);
        panel.add(strut);
        frame.add(panel, BorderLayout.NORTH);
    }

    public static void setWest(JFrame frame) {
        JSlider slider = new JSlider();
        slider.setOrientation(JSlider.VERTICAL);
        frame.add(slider, BorderLayout.WEST);
    }

    public static void setEast(JFrame frame) {
        Box panel = new Box(BoxLayout.Y_AXIS);

        ArrayList<JTextField> textFieldsArr = new ArrayList<JTextField>();

        for (int i = 1; i <= 8; i++) {
            JTextField field = new JTextField("Текстовое поле " + i);
            textFieldsArr.add(field);
            panel.add(field);
            Component strut = Box.createVerticalStrut(5);
            panel.add(strut);
        }
        frame.add(panel, BorderLayout.EAST);
    }

    public static void setCenter(JFrame frame) {
        JTree tree = new JTree();
        frame.add(tree);
    }

    public static void setSouth(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JCheckBox("Выбор" + 1));
        panel.add(new JRadioButton("Выбор" + 2));
        panel.add(new JButton("Кнопка"));
        panel.add(new JTextField("Текстовое поле"));

        Component strut = Box.createVerticalStrut(30);
        panel.add(strut);

        frame.add(panel, BorderLayout.SOUTH);
    }
}