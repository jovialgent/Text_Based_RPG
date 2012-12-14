/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package george_guis_package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author George
 */
public class PhoneGui extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new PhoneGui();
    }
    JFrame test;
    JPanel home_pane;
    JPanel phone_call;
    JPanel test_panel;
    JPanel[] apps;
    int current;
    
    public PhoneGui() {
        super("Phone GUI");
        initialize();
        pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void initialize() {
        settings();
        test = this.makeTestFrame();
        home_pane = this.makeHomePane();
        apps[0] = home_pane;
        apps[1] = this.textPanel();
        current = 0;
        
        this.add(apps[current]);
    }

    /**
     * Makes a test frame to interact with the Phone GUI
     * @return a JFrame to test
     */
    private JFrame makeTestFrame() {
        JFrame temp = new JFrame("Test");
        test_panel = new JPanel();
        temp.setPreferredSize(new Dimension(600, 480));
        temp.pack();
        temp.setVisible(true);
        temp.addMouseListener(new ThisMouseListener());
        temp.add(test_panel);
        return temp;
    }

    /**
     * Sets the preferences for the JFrame
     */
    private void settings() {
        this.setPreferredSize(new Dimension(300, 500));
        
        apps = new JPanel[2];
        
        
    }

    /**
     * Creates this Home Pane where all these menu options will be built
     * and access in terms on a clickable image icon panel
     * @return a Home JPanel
     */
    private JPanel makeHomePane() {
        JPanel temp = new JPanel();
        Icon a = new ImageIcon("Temp_App_skin.png");
        JLabel b = new JLabel(a);
        b.setPreferredSize(new Dimension(300, 520));
        temp.setLayout(new GridLayout(1, 1));
        temp.add(b);
        temp.setBackground(Color.WHITE);
        temp.addMouseListener(new ThisMouseListener());
        return temp;
    }
    
    private void doApp(int selection) {
        switch (selection) {
            case 0:
                this.setPanel(selection+1);
                break;
            case 1:
                test_panel.setBackground(Color.yellow);
                break;
        }
        
    }
    
    private JPanel textPanel(){
        JPanel temp = new JPanel();
        final JTextField[] text = new JTextField[3];
        JLabel[] labels = {new JLabel("Red"), new JLabel("Green"),
            new JLabel("Blue")
        };
        
        for(int i = 0; i < text.length; i++){
            text[i] = new JTextField("0", 5);
            temp.add(labels[i]);
            temp.add(text[i]);
            
        }
        JButton x = new JButton("Home");
        x.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                test_panel.setBackground(new Color(
                        new Integer(text[0].getText()),
                        new Integer(text[1].getText()),
                        new Integer(text[2].getText())));
                setPanel(0);
            }
            
        });
        temp.add(x);
        
        return temp;
    }
    
    private void setPanel(int index){
        this.remove(apps[current]);
        current = index;
        this.add(apps[current]);
        this.repaint();
        this.setSize(new Dimension(300,500));
        
    }
    
    
    private class ThisMouseListener implements MouseListener {
        
        @Override
        public void mouseClicked(MouseEvent me) {
            /*
             * These two variables will call and get the value of where the
             * mouse clicked. Remember the upper left hand corner is (0,0) and 
             * down is positive.
             */
            int x = me.getX(); // X - Coordinate of the mouse
            int y = me.getY(); // Y - Coordinate of the mouse

            /*
             * This next part will create the boolean that will figure out
             * which section of this icon picture is clicked. What will happen
             * is we will set this size of each icon which will indicate this 
             * app button. 
             * 
             * Next we tell how many column and rows we want. However, since
             * we have out of bound exception the columns and rows have to be
             * number of rows and columns - 1.
             * 
             * After that, add one to both the columns and the rows then 
             * multiplu them to determine the number of apps thus the number
             * of sections this clickable icon will have.
             * 
             * Lastly, we will use a while loop to populate the positions which
             * are true and false thus which one is selected.
             *  
             */
            int width = 100;
            int length = 130;
            int columns = 2;
            int rows = 3;
            int num_of_apps = (columns + 1) * (rows + 1);
            boolean[] positions = new boolean[num_of_apps];
            int index = 0;
            int column_count = 0;
            int row_count = 0;

            /*
             * Special note: the formula to figure out the box is:
             * 
             * x_start = (width * column#)
             * x_end = (width * column#) + width
             * y_start = (length * row#) 
             * y_end = (length * row#) + length
             * 
             * 
             */
            while (row_count <= rows) {
                while (column_count <= columns) {
                    boolean temp =
                            x > (width * column_count)
                            && x < ((width * column_count) + width)
                            && y > (length * row_count)
                            && y < (length + (length * row_count));
                    positions[index] = temp;
                    index += 1;
                    column_count += 1;
                }
                column_count = 0;
                row_count += 1;
                
            }

            /*
             * This will now find which ever position is true and do something
             * for that position
             */
            for (int i = 0; i < positions.length; i++) {
                if (positions[i]) {
                    doApp(i);
                    break;
                }
            }
            
        }
        
        @Override
        public void mousePressed(MouseEvent me) {
        }
        
        @Override
        public void mouseReleased(MouseEvent me) {
        }
        
        @Override
        public void mouseEntered(MouseEvent me) {
        }
        
        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
}
