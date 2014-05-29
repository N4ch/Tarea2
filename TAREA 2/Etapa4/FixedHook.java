import java.util.*;
import java.awt.*;



public class FixedHook extends PhysicsElement implements SpringAttachable {

	   private static int id=0;  // Ball identification number
	   private final double mass; 
	   private double pos_t;     // current position at time t
	   private double pos_tPlusDelta;  // next position in delta time in future
	   private double speed_t;   // speed at time t
	   private double speed_tPlusDelta;   // speed in delta time in future
	   private FixedHookView view;
	   private Spring spring;

	   private FixedHook(){   // nobody can create a block without state
	     this(0,0);
	   }
	   
	   public FixedHook(double mass, double position){
		  super(id++);
  	      this.mass = mass;
		  pos_t = position;
		  view= new FixedHookView(this);
	       }
			
		
		public void attachSpring(Spring sp){
		       this.spring = sp;
		   }
		
		 public void detachSpring(Spring sa) {
		       //FALTA POR IMPLEMENTAR
		   }
		
		
		public String getDescription() {
			   id = getId();
			   String id_out = "Hook" +id;
			   return id_out;
		   }
		   
		public String getState(){
			   return (""+pos_t);
		   }
		   
		public void computeNextState(double delta_t, MyWorld aThis){
			pos_tPlusDelta=pos_t;
			speed_tPlusDelta=speed_t;	
		  }

		public void updateState(){
			pos_t=pos_tPlusDelta;
			speed_t=speed_tPlusDelta;
		  }
	   public double getMass() {
	      return mass;
	   }
	   
	   
	   public double getPosition() {
	      return pos_t;
	   }
	   
	   public double getSpeed() {
	      return speed_t;
	   }
	   
	   public void updateView (Graphics2D g) {   // NEW
	     view.updateView(g);  // update this Ball's view in Model-View-Controller design pattern     
	   }
	   
	   public boolean contains(double x, double y) {
	   return view.contains(x,y);
	   }
	   
	   public void setSelected(){
	      view.setSelected();
	   }
	   
	   public void setReleased(){
	      view.setReleased();
	   }
	   
	   public void dragTo(double x){
	      pos_t=x;
	   }   
	   
	}