package com.blogspot.javadots.swingmac;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.simplericity.macify.eawt.Application;
import org.simplericity.macify.eawt.DefaultApplication;

public class Launcher {

	private static void macSetup() {
      String os = System.getProperty("os.name").toLowerCase();
      boolean isMac = os.startsWith("mac os x");     

      if(!isMac)
         return;
      
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "swing-mac");		
	}
	
	public static void main(String[] args) throws Exception {
		macSetup();
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		SwingUtilities.invokeLater(new Runnable() {
      
         @Override
         public void run() {
            
            Application app = new DefaultApplication();

            Main main = new Main();
            
            app.addApplicationListener(main);
            app.addPreferencesMenuItem();
            app.setEnabledPreferencesMenu(true);            
         }
      });
	}
}
