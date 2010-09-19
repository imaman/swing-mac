package com.blogspot.javadots.swingmac;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.*;
import org.simplericity.macify.eawt.*;

public class Main  {

   private JFrame f = new JFrame();
   private MyApplicationListener listener = new MyApplicationListener();

   public Main() {
      
      JMenuBar mb = new JMenuBar();
      f.setJMenuBar(mb);
      JMenu m = new JMenu("File");
      mb.add(m);

      addItem(m, "Open", KeyEvent.VK_O);
      addItem(m, "Save", KeyEvent.VK_S);
      addItem(m, "Save As", KeyEvent.VK_A);
      addItem(m, "Import", KeyEvent.VK_I);
      addItem(m, "Export", KeyEvent.VK_E);
      
      f.setTitle("Main");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize(400, 300);
      f.setVisible(true);
   }

   private void addItem(JMenu m, String name, int accelerator) {
      JMenuItem mi = new JMenuItem(name);
      mi.setAccelerator(KeyStroke.getKeyStroke(accelerator, 
         Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      m.add(mi);
   }

   // Must be public!!
   public class MyApplicationListener implements ApplicationListener {

      private void handle(ApplicationEvent event, String message) {
         JOptionPane.showMessageDialog(f, message);
         event.setHandled(true);
      }

      public void handleAbout(ApplicationEvent event) {
         handle(event, "aboutAction");
      }

      public void handleOpenApplication(ApplicationEvent event) {
         // Ok, we know our application started
         // Not much to do about that..
      }

      public void handleOpenFile(ApplicationEvent event) {
         handle(event, "openFileInEditor: " + event.getFilename());
      }

      public void handlePreferences(ApplicationEvent event) {
         handle(event, "preferencesAction");
      }

      public void handlePrintFile(ApplicationEvent event) {
         handle(event, "Sorry, printing not implemented");
      }

      public void handleQuit(ApplicationEvent event) {
         handle(event, "exitAction");
         System.exit(0);
      }

      public void handleReOpenApplication(ApplicationEvent event) {
         event.setHandled(true);
         f.setVisible(true);
      }
   }

   public ApplicationListener getApplicationListener() {
      return listener;
   }
}
