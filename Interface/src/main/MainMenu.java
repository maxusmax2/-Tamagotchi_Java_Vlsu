
package main;
import javax.swing.*;
import java.awt.*;

/** The class implements the main menu window of the game */
public class MainMenu extends JFrame {

    /** application window width in pixels*/
    final int WIDTH = 400;
    /** application window height in pixels*/
    final int HEIGHT = 560;
    /** the x-coordinate of the location of the window on the screen*/
    final int X = (Toolkit.getDefaultToolkit().getScreenSize().width - WIDTH) / 2;
    /** the y-coordinate of the location of the window on the screen*/
    final int Y = (Toolkit.getDefaultToolkit().getScreenSize().height - HEIGHT) / 2;

    /** This is label - window name */
    private JLabel labelNameWindow = new JLabel("menu");

    /** Button to start a new game*/
    public JButton buttonNewGame = new JButton("NEW GAME");
    /** Button to continue the game */
    public JButton buttonContinue = new JButton("CONTINUE");
    /** Button to save the game */
    public JButton buttonSave = new JButton("SAVE");

    /** The panel that contains the menu */
    JPanel panelMenu = new JPanel(new GridLayout(5, 1, 50, 20));

    /**
     * The constructor of this class implements the label and 3 buttons in the window
     */
    public MainMenu () {
        super("Tamagochi");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(X,Y,WIDTH,HEIGHT);
        this.setResizable(false);

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
