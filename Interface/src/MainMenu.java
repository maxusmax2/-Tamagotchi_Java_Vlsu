import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame{

    private JLabel labelNameWindow = new JLabel("menu");

    private JButton buttonNewGame = new JButton("NEW GAME");
    private JButton buttonContinue = new JButton("CONTINUE");
    private JButton buttonSave = new JButton("SAVE");

    JPanel panelMenu = new JPanel(new GridLayout(5, 1, 50, 20));

    public MainMenu () {
        super("Tamagochi");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,100,400,560);

        Container containerMenu = this.getContentPane();
        containerMenu.setLayout(new BorderLayout(40,80));
        containerMenu.setBackground(new Color(248,252,116));;


        JPanel panelMenu = new JPanel(new GridLayout(7,1,0,10));
        containerMenu.add(panelMenu, BorderLayout.CENTER);
        panelMenu.setBackground(new Color(248,252,116));


        JPanel panelWest = new JPanel();
        containerMenu.add(panelWest, BorderLayout.WEST);
        panelWest.setBackground(new Color(248,252,116));

        JPanel panelEast = new JPanel();
        containerMenu.add(panelEast, BorderLayout.EAST);
        panelEast.setBackground(new Color(248,252,116));

        JPanel panelNorth = new JPanel();
        containerMenu.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setBackground(new Color(248,252,116));

        JPanel panelSouth = new JPanel();
        containerMenu.add(panelSouth, BorderLayout.SOUTH);
        panelSouth.setBackground(new Color(248,252,116));


        panelMenu.add(labelNameWindow);
        labelNameWindow.setFont(new Font( "", Font.PLAIN, 25));

        panelMenu.add(buttonNewGame);
        buttonNewGame.setHorizontalAlignment(SwingConstants.LEFT);
        buttonNewGame.setForeground(Color.white);
        buttonNewGame.setFont(new Font( "", Font.PLAIN, 25));
        buttonNewGame.setBackground(new Color(237, 52, 192));

        panelMenu.add(buttonContinue);
        buttonContinue.setHorizontalAlignment(SwingConstants.LEFT);
        buttonContinue.setForeground(Color.white);
        buttonContinue.setFont(new Font( "", Font.PLAIN, 25));
        buttonContinue.setBackground(new Color(237, 52, 192));

        panelMenu.add(buttonSave);
        buttonSave.setHorizontalAlignment(SwingConstants.LEFT);
        buttonSave.setForeground(Color.white);
        buttonSave.setFont(new Font( "", Font.PLAIN, 25));
        buttonSave.setBackground(new Color(237, 52, 192));

    }
}
