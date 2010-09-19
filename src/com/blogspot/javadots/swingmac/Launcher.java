package com.blogspot.javadots.swingmac;

import javax.swing.*;
import org.simplericity.macify.eawt.*;

// Should be a dedicated class: prevent UI interactions that may take place 
// due to initialization of static fields/class loading

public class Launcher {

	private static void macSetup(String appName) {
      String os = System.getProperty("os.name").toLowerCase();
      boolean isMac = os.startsWith("mac os x");     

      if(!isMac)
         return;
      
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", 
		   appName);		
	}
	
	public static void main(String[] args) throws Exception {
	
	   // Must be before setLookAndFeel
		macSetup("swing-mac");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		SwingUtilities.invokeLater(new Runnable() {
      
         @Override
         public void run() {
            
            Application app = new DefaultApplication();

            Main main = new Main();            
            app.addApplicationListener(main.getApplicationListener());
            
            app.addPreferencesMenuItem();
            app.setEnabledPreferencesMenu(true);            
         }
      });
	}
}
