import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Game_window extends JFrame{

    BufferedImage bufferedImage = ImageIO.read(new File("CH1_funny.jpg"));
    Image image = bufferedImage.getScaledInstance(280, 280, Image.SCALE_DEFAULT);
    ImageIcon icon1 = new ImageIcon(image);

    JLabel label_img = new JLabel(icon1);
    JLabel label_name_character =new JLabel("Hachapuric");
    JLabel label_days_of_life =new JLabel("day:");

    JProgressBar progressBar_feed = new JProgressBar();
    JProgressBar progressBar_play = new JProgressBar();
    JProgressBar progressBar_sleep = new JProgressBar();
    JProgressBar progressBar_clean = new JProgressBar();

    JButton button_feed = new JButton("feed");
    JButton button_play = new JButton("play");
    JButton button_sleep = new JButton("sleep");
    JButton button_clean = new JButton("clean");
    JButton button_menu = new JButton("menu");


    JPanel panel_img =new JPanel(new GridLayout(1,1));

    JPanel panel_name_label =new JPanel(new FlowLayout());

    JPanel panel_feed =new JPanel(new FlowLayout());
    JPanel panel_play =new JPanel(new FlowLayout());
    JPanel panel_sleep =new JPanel(new FlowLayout());
    JPanel panel_clean =new JPanel(new FlowLayout());

    JPanel panel_footer =new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel panel_characteristics =new JPanel(new GridLayout(5,1));

    public Game_window() throws IOException {
        super("Tamagochi");
        this.setBounds(100,100,400,560);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container_1 =this.getContentPane();
        container_1.setLayout(new BorderLayout());

        panel_img.setBackground(new Color(248, 252, 116));
        panel_name_label.setBackground(new Color(248, 252, 116));
        panel_feed.setBackground(new Color(248, 252, 116));
        panel_play.setBackground(new Color(248, 252, 116));
        panel_clean.setBackground(new Color(248, 252, 116));
        panel_sleep.setBackground(new Color(248, 252, 116));
        panel_characteristics.setBackground(new Color(248, 252, 116));
        panel_footer.setBackground(new Color(248, 252, 116));

        button_feed.setPreferredSize(new Dimension(73,25));
        button_feed.setBackground(new Color(203,147,24));
        button_feed.setForeground(new Color(255,255,255));
        button_feed.setFont(new Font("Arial", Font.PLAIN, 16));

        button_play.setPreferredSize(new Dimension(73,25));
        button_play.setBackground(new Color(203,147,24));
        button_play.setForeground(new Color(255,255,255));
        button_play.setFont(new Font("Arial", Font.PLAIN, 16));

        button_sleep.setPreferredSize(new Dimension(73,25));
        button_sleep.setBackground(new Color(203,147,24));
        button_sleep.setForeground(new Color(255,255,255));
        button_sleep.setFont(new Font("Arial", Font.PLAIN, 16));

        button_clean.setPreferredSize(new Dimension(73,25));
        button_clean.setBackground(new Color(203,147,24));
        button_clean.setForeground(new Color(255,255,255));
        button_clean.setFont(new Font("Arial", Font.PLAIN, 16));

        button_menu.setPreferredSize(new Dimension(73,25));
        button_menu.setBackground(new Color(237,52,192));
        button_menu.setForeground(new Color(255,255,255));
        button_menu.setFont(new Font("Arial", Font.PLAIN, 16));

        progressBar_feed.setMinimum(0);
        progressBar_feed.setMaximum(100);
        progressBar_feed.setValue(70);
        progressBar_feed.setForeground(new Color(74, 255, 244));
        progressBar_feed.setPreferredSize(new Dimension(250,25));

        progressBar_play.setMinimum(0);
        progressBar_play.setMaximum(100);
        progressBar_play.setValue(70);
        progressBar_play.setForeground(new Color(75, 255, 156));
        progressBar_play.setPreferredSize(new Dimension(250,25));

        progressBar_sleep.setMinimum(0);
        progressBar_sleep.setMaximum(100);
        progressBar_sleep.setValue(70);
        progressBar_sleep.setForeground(new Color(176, 255, 75));
        progressBar_sleep.setPreferredSize(new Dimension(250,25));

        progressBar_clean.setMinimum(0);
        progressBar_clean.setMaximum(100);
        progressBar_clean.setValue(70);
        progressBar_clean.setForeground(new Color(75, 202, 255));
        progressBar_clean.setPreferredSize(new Dimension(250,25));


        label_days_of_life.setFont(new Font("Arial", Font.PLAIN, 16));

        label_name_character.setFont(new Font("Arial", Font.PLAIN, 25));

        container_1.add(label_name_character);
        container_1.add(panel_img, BorderLayout.NORTH);
        container_1.add(panel_characteristics, BorderLayout.CENTER);
        container_1.add(panel_footer,BorderLayout.SOUTH);


        panel_name_label.add(label_name_character);

        panel_feed.add(progressBar_feed);
        panel_feed.add(button_feed);

        panel_play.add(progressBar_play);
        panel_play.add(button_play);

        panel_sleep.add(progressBar_sleep);
        panel_sleep.add(button_sleep);

        panel_clean.add(progressBar_clean);
        panel_clean.add(button_clean);

        panel_footer.add(button_menu);
        panel_footer.add(label_days_of_life);

        panel_img.add(label_img);

        panel_characteristics.add(panel_name_label);
        panel_characteristics.add(panel_feed);
        panel_characteristics.add(panel_play);
        panel_characteristics.add(panel_sleep);
        panel_characteristics.add(panel_clean);

    }
}


