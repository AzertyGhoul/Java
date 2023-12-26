import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGraph extends JFrame implements ActionListener {
    private JMyPanel myPanel = new JMyPanel();// объявляем и создаем нашу панель для рисования

    public static void main(String[] args) {
        new MyGraph("Окно с графикой");// создаем окно
    }

    public MyGraph(String s) { // конструктор с параметром для заголовка окна
        super(s);// вызываем конструктор суперкласса и передаем ему параметр
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Рисование фигур");
        JMenu menu1 = new JMenu("Рисование фамилии");

        JMenuItem Line = new JMenuItem("LINE");
        JMenuItem Round = new JMenuItem("OVAL");
        JMenuItem Rect = new JMenuItem("RECT");
        JMenuItem RoundRect = new JMenuItem("ROUNDRECT");
        JMenuItem Clear = new JMenuItem("CLEAR");
        JMenuItem Clear1 = new JMenuItem("CLEAR");
        JMenuItem SecondName = new JMenuItem("SECONDNAME");

        Line.addActionListener(this);
        Round.addActionListener(this);
        Rect.addActionListener(this);
        RoundRect.addActionListener(this);
        Clear.addActionListener(this);

        SecondName.addActionListener(this);
        Clear1.addActionListener(this);

        menu1.add(SecondName);
        menu1.add(Clear1);

        menu.add(Line);
        menu.add(Round);
        menu.add(Rect);
        menu.add(RoundRect);
        menu.add(Clear);

        menuBar.add(menu);
        menuBar.add(menu1);

        add(menuBar, BorderLayout.NORTH);

        // хотя в нашем случае это не важно, т.к. мы используем пружины
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(myPanel, BorderLayout.CENTER);
        Dimension size = getSize();// записываем в переменную size текущий размер окна
        size.setSize(size.width + 630, size.height + 300);// устанавливаем новый размер окна, увеличивая
        // текущий по высоте на 200
        setMinimumSize(size);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) { // при нажатии на одну из кнопок
        myPanel.ris(e.getActionCommand());// вызываем метод ris нашей панели (см. JMyPanel.java)
    } // и передаем в качестве параметра название нажатой кнопки
      // (e.getActionCommand())

}
