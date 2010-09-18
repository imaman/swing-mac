package com.blogspot.javadots.swingmac;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import org.simplericity.macify.eawt.Application;
import org.simplericity.macify.eawt.ApplicationEvent;
import org.simplericity.macify.eawt.ApplicationListener;

public class Main implements ApplicationListener {

   Application application;
   private JFrame f;


   public Main() {
      f = new JFrame();
      f.setTitle("This is Main");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JMenuBar mb = new JMenuBar();
      JMenu m = new JMenu("File");
      mb.add(m);

      JMenuItem mi = new JMenuItem("Open");
      mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit
         .getDefaultToolkit().getMenuShortcutKeyMask()));
      m.add(mi);

      mi = new JMenuItem("Save");
      mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit
         .getDefaultToolkit().getMenuShortcutKeyMask()));
      m.add(mi);

      mi = new JMenuItem("Close");
      mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit
         .getDefaultToolkit().getMenuShortcutKeyMask()));
      m.add(mi);

      mi = new JMenuItem("Import");
      mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Toolkit
         .getDefaultToolkit().getMenuShortcutKeyMask()));
      m.add(mi);

      mi = new JMenuItem("Export");
      mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Toolkit
         .getDefaultToolkit().getMenuShortcutKeyMask()));
      m.add(mi);

      f.setJMenuBar(mb);

      f.setSize(400, 300);
      f.setVisible(true);
   }

   private void message(Object... arr) {
      JOptionPane.showMessageDialog(f, Arrays.toString(arr));            
   }
   
   public void handleAbout(ApplicationEvent event) {
      message("aboutAction");
      event.setHandled(true);
   }

   public void handleOpenApplication(ApplicationEvent event) {
      // Ok, we know our application started
      // Not much to do about that..
   }

   public void handleOpenFile(ApplicationEvent event) {
      message("openFileInEditor", new File(event.getFilename()));
   }

   public void handlePreferences(ApplicationEvent event) {
      message("preferencesAction");
   }

   public void handlePrintFile(ApplicationEvent event) {
      message("Sorry, printing not implemented");
   }

   public void handleQuit(ApplicationEvent event) {
      message("exitAction");
      System.exit(0);
   }

   public void handleReOpenApplication(ApplicationEvent event) {
      f.setVisible(true);
   }
}
