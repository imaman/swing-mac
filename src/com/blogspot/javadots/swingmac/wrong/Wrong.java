package com.blogspot.javadots.swingmac.wrong;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Wrong  {

   private JFrame f;
 
   public Wrong() {
      f = new JFrame();
      f.setTitle("Main");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JMenuBar mb = new JMenuBar();
      JMenu m = new JMenu("File");
      mb.add(m);

      JMenuItem mi = new JMenuItem("Open");
      mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
      m.add(mi);

      mi = new JMenuItem("Save");
      mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
      m.add(mi);

      mi = new JMenuItem("Save As");
      mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
      m.add(mi);

      mi = new JMenuItem("Import");
      mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
      m.add(mi);

      mi = new JMenuItem("Export");
      mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
      m.add(mi);

      f.setJMenuBar(mb);

      f.setSize(400, 300);
      f.setVisible(true);
   }

   
      
   
   public static void main(String[] args) throws Exception {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      
      SwingUtilities.invokeLater(new Runnable() {
      
         @Override
         public void run() {
            new Wrong();            
         }
      });
   }
   
}
