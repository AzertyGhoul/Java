import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class JMyPanel extends JPanel { // наш класс является наследником класса JPanel
    // создаем перечисление используемых параметров
    public static enum Figure {
        LINE, OVAL, RECT, ROUNDRECT, CLEAR, SECONDNAME
    };

    private Figure vibor = Figure.CLEAR; // объявляем переменную типа созданного перечисления
    // и присваиваем ей значение CLEAR

    public JMyPanel() {
    } // конструктор нашего класса

    public void ris(String s) {// метод, вызов которого приводит к перерисовке панели
        // параметр s принимает значение во время вызова данного метода (см.
        // MyGraph.java)
        vibor = Figure.valueOf(s); // устанавливаем, что нужно нарисовать
        repaint(); // перерисовываем нашу панель, т.е. вызываем метод paintComponent
    }

    public void paintComponent(Graphics gr) { // переопределяемый метод с параметром типа Graphics
        super.paintComponent(gr); // вызов такого же метода родительского класса
        // и передача ему параметра типа Graphics
        Graphics2D g = (Graphics2D) gr; // преобразование параметра к типу Graphics2D
        BasicStroke pen;
        // задание параметров для сглаживания графики (антиалиасинг)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (vibor) {
            case LINE:
                // определяем перо толщиной 20 точек, с закругленными концами линий и
                // закругленными стыками линий
                pen = new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                g.setStroke(pen);// делаем текущим пером созданное нами
                g.setColor(Color.blue);// задаем цвет пера
                g.drawLine(20, 20, 100, 100);
                break;
            case OVAL:
                // задаем массив, определяющий вид линии
                // элементы массива с четными индексами задают длину штриха в пикселах, элементы
                // с нечетными
                // индексами — длину промежутка; массив перебирается циклически;
                float[] dash = { 10, 30 };
                // определяем перо толщиной 10 точек, с квадратными концами линий, закругленными
                // стыками линий,
                // расстоянием в 10 точек, с которого начинает действовать закругление, массив,
                // определяющий вид
                // линии, и с какого элемента массива начинать узор
                pen = new BasicStroke(10, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dash, 0);
                g.setStroke(pen);
                g.setColor(Color.red);
                // устанавливаем стиль заливки, в качестве параметра задаем градиент от красного
                // к зеленому,
                // 30, 30 – начальная точка первого цвета, 50, 50 – начальная точка второго
                // цвета, true –
                // цикличность градиента
                g.setPaint(new GradientPaint(30, 30, Color.red, 50, 50, Color.green, true));
                // g.fill – создание объекта с заливкой, в качестве параметра задается объект из
                // пакета Graphics2D,
                // в нашем случае – эллипс
                g.fill(new Ellipse2D.Double(20, 20, 100, 100));
                break;

            case RECT:
                float[] dash2 = { 20, 20 };
                pen = new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1, dash2, 0);
                g.setStroke(pen);
                g.setColor(Color.magenta);
                g.drawRect(20, 20, 100, 100);
                break;
            case ROUNDRECT:
                float[] dash3 = { 20, 20, 2, 20, 2, 20 };
                pen = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 1, dash3, 0);
                g.setStroke(pen);
                g.setColor(Color.yellow);
                g.drawRoundRect(20, 20, 100, 100, 60, 60);
                break;

            case SECONDNAME:
                float[] dash4 = { 10, 20, 20, 10, 20, 10 };
                pen = new BasicStroke(10, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1, dash4, 1);
                g.setStroke(pen);
                g.setColor(new Color(0xFF0000));
                g.setPaint(new GradientPaint(35, 20, new Color(0xFF00FF), 40, 30, new Color(0xF0F111), true));

                // Н
                g.drawLine(20, 20, 20, 100);
                g.drawLine(20, 60, 80, 60);
                g.drawLine(80, 20, 80, 100);

                // Е
                pen = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
                g.setStroke(pen);
                g.setColor(new Color(0x00191F));
                g.setPaint(new GradientPaint(20, 30, new Color(0xF125F3), 22, 13, new Color(0xF0191F), true));

                g.drawLine(100, 20, 100, 100);
                g.drawLine(100, 20, 160, 20);
                g.drawLine(100, 100, 160, 100);
                g.drawLine(100, 60, 160, 60);

                // К
                pen = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 1, dash4, 3);
                g.setStroke(pen);
                g.setColor(new Color(0x00191F));
                g.setPaint(new GradientPaint(30, 30, new Color(0xF0F0F0), 50, 30, new Color(0x123456), true));

                g.drawLine(180, 20, 180, 100);
                g.drawLine(181, 60, 240, 20);
                g.drawLine(181, 60, 240, 100);

                // Р
                pen = new BasicStroke(10, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER);
                g.setStroke(pen);
                g.setPaint(new GradientPaint(10, 10, new Color(0x654321), 15, 20, new Color(0x123456), true));
                g.drawLine(260, 20, 260, 100);
                g.drawArc(235, 20, 60, 45, 90, -180);

                // А
                pen = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
                g.setStroke(pen);
                g.setPaint(new GradientPaint(35, 30, new Color(0x1F451F), 40, 32, new Color(0x1F2191), true));
                g.drawLine(345, 20, 315, 100);
                g.drawLine(345, 20, 375, 100);
                g.drawLine(330, 70, 360, 70);

                // С
                pen = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                g.setStroke(pen);
                g.setPaint(new GradientPaint(20, 30, new Color(0x1BAFE2), 30, 30, new Color(0xF0A0F0), true));
                g.drawArc(395, 20, 80, 80, 270, -180);

                // О
                pen = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash4, 2);
                g.setStroke(pen);
                g.setPaint(new GradientPaint(5, 15, new Color(0x012345), 15, 30, new Color(0xFAFAFA), true));
                g.drawArc(455, 20, 60, 80, 0, 360);

                // В
                pen = new BasicStroke(10, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER);
                g.setStroke(pen);
                g.setPaint(new GradientPaint(20, 25, new Color(0x872332), 20, 35, new Color(0xFABCDE), true));
                g.drawLine(535, 20, 535, 100);
                g.drawArc(500, 20, 80, 40, 90, -180);
                g.drawArc(500, 60, 80, 40, 90, -180);

                break;
            case CLEAR:
                g.clearRect(0, 0, getSize().width, getSize().height);
                break;
        }
    }

}
