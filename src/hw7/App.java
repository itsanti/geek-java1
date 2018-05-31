package hw7;

import javax.swing.*;
import java.awt.*;

/**
 * HW 7 Classes
 *
 * @author Aleksandr Kurov
 * @version dated Май 31, 2018
 * @link https://github.com/itsanti
 */
class App extends JFrame {

    static final int CAT_SIZE = 5;

    Plate plate;
    Cat[] cats = new Cat[CAT_SIZE];

    public App() {

        initApp();

        setTitle("Hungry Cats");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0, 0, 480, 640);
        setLocationRelativeTo(null);
        setResizable(false);
        setFont(new Font("Courier New",Font.BOLD,14));

        setLayout(new BorderLayout());

        JButton addFood = new JButton("add food");
        JButton feedCats = new JButton("feed cats");
        JButton reset = new JButton("reset");

        JPanel btns = new JPanel();
        btns.setLayout(new GridLayout(1,3));
        btns.add(addFood);
        btns.add(feedCats);
        btns.add(reset);

        add(btns, BorderLayout.SOUTH);

        addFood.addActionListener(e -> {
            plate.increaseFood(50);
            repaint();
        });

        feedCats.addActionListener(e -> {
            for(Cat cat : cats) {
                cat.eat(plate);
            }
            repaint();
        });

        reset.addActionListener(e -> {
            initApp();
            repaint();
        });

        setVisible(true);

    }

    public void initApp() {
        plate = new Plate(getRng(50, 440));

        for (int i = 0; i < CAT_SIZE; i++) {
            cats[i] = new Cat(getRng(30, 150));
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        plate.paint(g);

        g.drawString("Cats:", 20, 130);
        for (int i = 0; i < CAT_SIZE; i++) {
            cats[i].paint(g, i + 1);
        }
    }

    private int getRng(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}

class Cat {
    private int appetite;
    private boolean isFull = false;

    Cat(int appetite) {
        this.appetite = appetite;
    }

    void eat(Plate plate) {
        if (!isFull) {
            isFull = plate.dereaseFood(appetite);
        }
    }

    public void paint(Graphics g, int vgap) {
        vgap = 80 * vgap + 60;
        g.setColor(new Color(0xFF, 0x93, 0x38));
        g.drawRect(20,vgap, appetite,50);
        g.fillRect(20,vgap, isFull ? appetite : 0,50);
        g.setColor(Color.BLACK);
        g.drawString(isFull ? "" : String.valueOf(appetite), 30, vgap + 30);
    }
}

class Plate {
    private final int volume = 440;
    private int food;

    Plate(int food) {
        this.food = food;
    }

    boolean dereaseFood(int food) {
        if (this.food >= food) {
            this.food -= food;
            return true;
        }
        return false;
    }

    void increaseFood(int food) {
        this.food += (this.food + food <= volume) ? food : volume - this.food;
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0xF4, 0x8A, 0x8A));
        g.drawRect(20,50,volume,50);
        g.fillRect(20,50, food,50);
        g.setColor(Color.BLACK);
        g.drawString("Plate volume:", 20, 45);
        g.drawString(getVolume(), 30, 80);
    }

    private String getVolume() {
        return food + " / " + volume;
    }
}