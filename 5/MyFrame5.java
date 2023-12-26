import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFrame5 {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        JFrame frame = new JFrame("Lab5");// создаем окно с заголовком FrameDemo
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new GridLayout(2, 4));

        ArrayList<JLabel> labelArray = new ArrayList<JLabel>();

        for (int i = 0; i <= 6; i++) {
            JLabel label = new JLabel("Метка " + i);
            panelLabel.add(label);
            labelArray.add(label);
        }

        Component strut = Box.createVerticalStrut(30);
        panelLabel.add(strut);
        frame.add(panelLabel, BorderLayout.NORTH);

        JSlider slider = new JSlider();
        slider.setOrientation(JSlider.VERTICAL);
        slider.setValue(slider.getMaximum());
        frame.add(slider, BorderLayout.WEST);

        Box panelText = new Box(BoxLayout.Y_AXIS);

        ArrayList<JTextField> textFieldsArr = new ArrayList<JTextField>();

        for (int i = 1; i <= 8; i++) {
            JTextField field = new JTextField("Текстовое поле " + i);
            textFieldsArr.add(field);
            panelText.add(field);
            Component strut1 = Box.createVerticalStrut(5);
            panelText.add(strut1);
        }

        frame.add(panelText, BorderLayout.EAST);

        JTree tree = new JTree();
        frame.add(tree, BorderLayout.CENTER);

        JPanel panelSome = new JPanel();
        panelSome.setLayout(new FlowLayout());

        JCheckBox checkBox = new JCheckBox("Выбор " + 1);
        JRadioButton radioButton = new JRadioButton("Выбор " + 2);
        JButton button = new JButton("Кнопка");
        JTextField textField = new JTextField("Текстовое поле");

        panelSome.add(checkBox);
        panelSome.add(radioButton);
        panelSome.add(button);
        panelSome.add(textField);

        Component strut2 = Box.createVerticalStrut(30);
        panelSome.add(strut2);
        frame.add(panelSome, BorderLayout.SOUTH);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (slider.getValue() == 0) {
                    frame.dispose();
                }
            }
        });

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox.isSelected()) {
                    for (int i = 0; i < 8; i++) {
                        textFieldsArr.get(i).setText(Integer.toString(i + 1));
                    }
                } else {
                    for (int i = 0; i < 8; i++) {
                        textFieldsArr.get(i).setText("Текстовое поле " + Integer.toString(i + 1));
                    }
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Hello");
            }
        });

        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setResizable(false);
        frame.setVisible(true);
    }

}