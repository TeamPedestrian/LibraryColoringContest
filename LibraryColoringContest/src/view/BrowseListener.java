package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * 
 * @author Yikalo  (class not used).
 *
 */
public class BrowseListener implements ActionListener {
     JButton button ;
        JLabel label;
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        final JFrame frame = new JFrame("Please Select Age for Difficulty");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(952, 500);
        frame.setLocationRelativeTo(null);
        //setupFrame(frame);
        frame.setVisible(true);
        
        
           JPanel center = new JPanel();
           JMenuBar menuBar = new JMenuBar();
          // setJMenuBar(menuBar);
           
           JMenu Menu = new JMenu("Design Selection");
           menuBar.add(Menu);
           frame.setJMenuBar(menuBar);
           
           
                JButton button = new JButton("0 - 5");
                //button.setBounds(300, 100, 100, 100);
                center.add(button);
                frame.add(center);
                
//                button.addActionListener(new ActionListner(){
                    //public void ActionPerformed(ActionEvent e){
                        
                        
                    //}
//                });
                    
                
                JButton button1 = new JButton("6 - 10");
                center.add(button1);
                frame.add(center);

                JButton button2 = new JButton("11 - 15");
                center.add(button2);
                frame.add(center);
                
                JButton button3 = new JButton("16 - above");
                center.add(button3);
                frame.add(center);
        
    
    
    
    }

    

}