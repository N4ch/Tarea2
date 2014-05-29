import javax.swing.*;

import java.awt.Container;

public class PhysicsLab {
   public static void main(String[] args) {
      PhysicsLab_GUI lab_gui = new PhysicsLab_GUI();
      lab_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      lab_gui.setVisible(true);
   }
}

class PhysicsLab_GUI extends JFrame {
   public PhysicsLab_GUI() {
      setTitle("My Small and Nice Physics Laboratory");
      setSize(MyWorldView.WIDTH+20, MyWorldView.HEIGHT+150);  // height+50 to account for menu height
      MyWorld world = new MyWorld();
      MyWorldView  worldView = new MyWorldView(world);
      world.setView(worldView);
      add(worldView);
      LabMenuListener menuListener = new LabMenuListener(world);
      JMenuBar menuBar = createLabMenuBar(menuListener);
      setJMenuBar(menuBar);     
      
      

   
   }   
   

    public JMenuBar createLabMenuBar(LabMenuListener menu_l) {//NUEVO DESDE ETAPA 2
      
    	JMenuBar mb = new JMenuBar();
           
      
      JMenu menu = new JMenu ("Configuration");
      mb.add(menu);
      menu.addActionListener(menu_l);

      
      JMenu subMenu = new JMenu("Insert");
      subMenu.addActionListener(menu_l);
      menu.add(subMenu);
      
      JMenuItem menuItem;
      
      menuItem =new JMenuItem("Ball");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      
      menuItem = new JMenuItem("Spring");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      
      menuItem = new JMenuItem("FixedHook");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      
      menuItem = new JMenuItem("My Scenario");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      
      //termina menu configuration//
      
      menu = new JMenu("MyWorld");
      menu.addActionListener(menu_l);
      mb.add(menu);
      
      subMenu = new JMenu("Simulator");
      menuItem.addActionListener(menu_l);
      menu.add(subMenu);
      
      menuItem = new JMenuItem("Start");
      menuItem.addActionListener(menu_l);
      menu.add(menuItem);
      
      menuItem = new JMenuItem("Stop");
      menuItem.addActionListener(menu_l);
      menu.add(menuItem);
      
      
      
      menuItem = new JMenuItem("Set Delta time");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      
      menuItem = new JMenuItem("View Refresh time");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      
      menuItem = new JMenuItem("View Delta Time");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      
      
      
      return mb;          
   }
   

}

