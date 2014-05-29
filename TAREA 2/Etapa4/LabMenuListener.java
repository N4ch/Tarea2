import java.awt.event.*; 

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LabMenuListener  implements ActionListener {
   private MyWorld  world;
   private MyWorldView view;
   
   public LabMenuListener (MyWorld  w ){
      this.world = w;
      
      
   }
   
   
   public void actionPerformed(ActionEvent e) {
      JMenuItem menuItem = (JMenuItem)(e.getSource());
      String text = menuItem.getText();
      
      // Actions associated to main menu options
      if (text.equals("My Scenario")) {  // here you define Etapa2's configuration
    	  CreateConfiguration.makeConf(world);  	//metodo static de la clase createConfiguration();
    	 
    	  //NUEVO DESDE ETAPA 2        
      }
      
      if (text.equals("Ball")) {
    	  CreateConfiguration.addBall(world);
    	  
      }
      if (text.equals("FixedHook")) {
    	  CreateConfiguration.addFixedHook(world);
      }
      if (text.equals("Spring")) {
    	  CreateConfiguration.addSpring(world);

      }

      // Actions associated to MyWorld submenu
      if (text.equals("Start")) {
         world.start();        
      }
      
      if (text.equals("Stop")){
         world.stop();
         
      }//NUEVO DESDE ETAPA 2
      
      
      
      if (text.equals("Set Delta time")) {
         String data = JOptionPane.showInputDialog("Ingrese el delta  t [s]");
         world.setDelta_t(Double.parseDouble(data));
      }
      if (text.equals("View Refresh time")) {
         double refreshTime;
         refreshTime=world.getRefreshPeriod();
         JOptionPane.showMessageDialog( null, "El Refresh Time es = " +refreshTime + "[s]");//NUEVO DESDE ETAPA 2
      }
      
      if (text.equals("View Delta Time")) {
            double Delta;
             Delta=world.getDelta();
             JOptionPane.showMessageDialog( null, "El DeltaTime es = "+Delta+"[s]"); //NUEVO DESDE ETAPA 2
      }
   }
}