import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/***************************************************************
 * GUI for rolling dice
 * 
 * @author Scott Grissom 
 * @version Februrary 20, 2017
 ***************************************************************/
public class SillyGUI extends JFrame implements ActionListener{

    // FIX ME: define three dice
    private GVdie d1;
    private GVdie d2;
    private GVdie d3;
    private SillyDice game;

    /** buttons, labels and fields */
    private JButton rollButton;
    private JTextField guessField;
    private JLabel messageLabel;
    
/************************************************
Main - starts the GUI application
************************************************/    public static void main( String[ ] args ){
        SillyGUI gui = new SillyGUI( );
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);           
    }
    
/************************************************
SillyGUI constructor - creates GUI layout
************************************************/
    public SillyGUI( ){ 
        
        // insatantiate the game object
        game = new SillyDice();
        
        // set characteristics of the JFrame
        setTitle("Our Silly Dice Game");
        setSize(500,300);
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();
        
        // Create and place the roll button
        rollButton = new JButton("Roll");
        loc = new GridBagConstraints();
        loc.gridy = 3;
        loc.gridx = 0;
        add(rollButton, loc);
        
        // FIXED: register the Roll Button action listener
        d1.addActionListener(this);
        d2.addActionListener(this);
        d3.addActionListener(this);
        
        // create and place the message field
        messageLabel = new JLabel();
        messageLabel.setText(game.getMessage());
        
        loc = new GridBagConstraints();
        loc.gridy = 0;
        loc.gridx = 0;
        loc.gridwidth = 4;
        loc.insets = new Insets(20,20,20,20);
        add(messageLabel, loc);

        // create and place the Guess Label
        loc = new GridBagConstraints();
        loc.gridy = 2;
        loc.gridx = 2;
        add(new JLabel("Guess:"), loc);

        // create and place the Guess Field
        guessField = new JTextField(2);
        loc = new GridBagConstraints();
        loc.gridy = 3;
        loc.gridx = 2;
        add(guessField, loc);
        
        // FIX ME: create and place three dice in middle row
        d1 = game.getDie(1);//getDie(1)
        loc = new GridBagConstraints();
        loc.gridx = 0;
        loc.gridy = 1;
        loc.insets = new Insets(0,10,0,10);
        add(d1, loc); 
        
        
        d2= game.getDie(1);
         loc = new GridBagConstraints();
        loc.gridx = 1;
        loc.gridy = 1;
        loc.insets = new Insets(0,10,0,10);
        add(d1, loc); 
        
        d3= game.getDie(1);
         loc = new GridBagConstraints();
        loc.gridx = 2;
        loc.gridy = 1;
        loc.insets = new Insets(0,10,0,10);
        add(d1, loc);        
    }

/******************************************************
Respond to the user action 
******************************************************/
    public void actionPerformed(ActionEvent e){

            string s = guessField.getText();
            int g = Integer.parseInt(s);
            game.makeGuess(g);
            
         //   if (e.getSource() == 
       // FIX ME: check if roll button clicked 
            if(event.getSource() == d1){
                JOptionPane.showMessageDialog(null, "");
            }
       
            if(event.getSource() == d2){
                JOptionPane.showMessageDialog(null, "");
            }
           
            if(event.getSource() == d3){
                JOptionPane.showMessageDialog(null, "");
            }
       // FIX ME: update game message
     
    }
}
