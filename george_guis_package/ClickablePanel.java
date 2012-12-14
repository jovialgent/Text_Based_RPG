/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package george_guis_package;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 *
 *@author George Petersen

 */
public class ClickablePanel extends JPanel{

    JPanel face;
    String file_name;

    public ClickablePanel(String file) {
        /*
         * Runs the initializing methods that produce the JFrame you can edit
         * these in the method section title "init"
         */
        file_name = file;
        init();
    }

    /**
     * This init method creates and adds a new clickable frame to this JFrame.
     */
    private void init() {
        /*
         * Both makes and adds an icon panel (a panel with a picture) that will
         * be able to be clickable.
         */
        this.makeIconPanel(file_name);
    }

    /**
     * This method will return a JPanel with a .png file that will be able to 
     * click
     * @return 
     */
    private JPanel makeIconPanel(String file) {
         
        /*
         * This makes a new image panel that will hold the image that will be
         * clickable
         */
        JPanel imagePanel = new JPanel();
        /*
         * This is an icon. An icon holds an image and will hold the image we
         * want to click. What I want you to do is make your own pick that
         * will resemble the clickable areas of the Punch in the Face game and
         * then make sure they are clickable. The best way to do it is by 
         * copying the dimensions of the PNG value attached and just move the
         * squares.
         */
        Icon icon = new ImageIcon(file);
        /*
         * Now, an icon needs to be placed inside a label to be put on the 
         * panel. It is weird I know, but that is how it has to be.
         */
        JLabel jlabel = new JLabel(icon);
        /*
         * Here is where you add a mouselistener. A mouselistener allows the 
         * mouse to interact with the component that has a mouse listener 
         * attached.
         */
        imagePanel.addMouseListener(new ThisMouseListener());
        /*
         * This will add the picture to the image panel.
         */
        imagePanel.add(jlabel);
        /*
         * This returns the JPanel thus when this method is called it will
         * produce a JPanel so think of this as a special kind of JPanel.
         */
        return imagePanel;

    }

    /**
     * This private class makes a mouselistener that will produce the ability
     * to click on a various frame.
     */
    private class ThisMouseListener implements MouseListener {
        
        @Override
        public void mouseClicked(MouseEvent me) {
            /*
             * These two variables will call and get the value of where the
             * mouse clicked. Remember the upper left hand corner is (0,0) and 
             * down is positive.
             */
            int x = me.getX();
            int y = me.getY();
            

            /*
             * Remember it will be easier for you to group your booleans
             * here than to put your long lines of code in the if's. What
             * these booleans are used to make a box where the area within
             * is clickable. I put in to check the accuracy by setting up
             * a console display that does it this way:
             * 
             * [Area Pressed]: ([X Value], [Y Value])
             */
            boolean one = x >= 5 && x <= 165 && y >= 6 && y <= 78;
            boolean two = x >= 694 && x <= 853 && y >= 5 && y <= 75;
            boolean three = x >= 170 && x <= 330 && y >= 248 && y <= 321;
            boolean four = x >= 531 && x <= 692 && y >= 248 && y <= 321;
            boolean five = x >= 5 && x <= 166 && y >= 539 && y <= 604;
            boolean six = x >= 693 && x <= 850 && y >= 538 && y <= 602;
            
            
            if (one) {
                System.out.println("1: (" + x + "," + y + ")");           
            }
            
            if (two) {
                System.out.println("2: (" + x + "," + y + ")");
            }

            if (three) {
                System.out.println("3: (" + x + "," + y + ")");
            }

            if (four) {
                System.out.println("4: (" + x + "," + y + ")");
            }

            if (five) {
                System.out.println("5: (" + x + "," + y + ")");
            }

            if (six) {
                System.out.println("6: (" + x + "," + y + ")");
            }


        }

        /*
         * Play around with these. I am not a 100% sure what these do so if
         * you find something cool with these, then go for it. :D 
         */
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
