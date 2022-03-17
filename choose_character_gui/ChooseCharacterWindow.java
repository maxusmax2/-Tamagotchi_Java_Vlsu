import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.*;

public class ChooseCharacterWindow  extends  JFrame{


    private JButton chooseCharacterOne = new JButton("CH. 1");
    private JButton chooseCharacterTwo = new JButton("CH. 2");

    private JLabel chooseCharacterLabel = new JLabel("CHOOSE A CHARACTER");
    private JLabel newGameLabel = new JLabel("NEW GAME");

    private Image characterOneImage = new ImageIcon("../Images/Веселый 2 копия.jpg").getImage();

    private Image characterTwoImage = new ImageIcon("../Images/Веселый копия.jpg").getImage();

    public ChooseCharacterWindow()
    {
        super("Tamagochi");

        this.getContentPane().setBackground(Color.YELLOW);
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container containerMain = this.getContentPane();
        containerMain.setLayout(new GridLayout(2,1,3,3));

        JPanel panelImage1 = new JPanel();
//        panelImage1.add(characterOneImage);

        JPanel panelImage2 = new JPanel();



        containerMain.add(newGameLabel);

        containerMain.add(chooseCharacterLabel);



    }
}
