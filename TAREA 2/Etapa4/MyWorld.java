import java.util.*;
import java.io.*;

import javax.swing.Timer;

import java.awt.event.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MyWorld.
 */
public class MyWorld implements ActionListener {
   
   /** The out. */
   private PrintStream out;
   
   /** The elements. */
   private ArrayList<PhysicsElement> elements;  // array to hold everything in my world.
   
   /** The view. */
   private MyWorldView view;   // NEW
   
   /** The passing time. */
   private Timer passingTime;   // NEW
   
   /** The time simulation. */
   private double t;        // simulation time
   
   /** The delta_t. */
   private double delta_t;        // in seconds
   
   /** The refresh period. */
   private double refreshPeriod;  // in seconds
   
   /**
    * Instantiates a new my world.
    */
   public MyWorld(){
      this(System.out);  // delta_t= 0.1[ms] and refreshPeriod=200 [ms]
   }
   
   /**
    * Instantiates a new my world.
    *
    * @param output the output
    */
   public MyWorld(PrintStream output){
      out = output;
      t = 0;
      refreshPeriod = 0.006;      // 60 [ms]
      delta_t = 0.00001;          // 0.01 [ms]
      elements = new ArrayList<PhysicsElement>();
      view = null;
      passingTime = new Timer((int)(refreshPeriod*1000), this);    
   }

   /**
    * Gets the refresh period.
    *
    * @return the refresh period
    */
   public double getRefreshPeriod() {  //NUEVO DESDE ETAPA 2
	   double refresh=this.refreshPeriod;
	     return refresh;
	   }
   
   /**
    * Gets the delta.
    *
    * @return the delta
    */
   public double getDelta() {			//NUEVO DESDE ETAPA 2
	   double refresh=this.delta_t;
	     return refresh;
	   }
   
   /**
    * Adds the element.
    *
    * @param e the e
    */
   public void addElement(PhysicsElement e) {
      elements.add(e);
      view.repaintView();
   }
   
   /**
    * Sets the view.
    *
    * @param view the new view
    */
   public void setView(MyWorldView view) {
      this.view = view;
   }
   
   /**
    * Sets the delta_t.
    *
    * @param delta the new delta_t
    */
   public void setDelta_t(double delta) {
      delta_t = delta;
   }
   
   /**
    * Sets the refresh period.
    *
    * @param rp the new refresh period
    */
   public void setRefreshPeriod (double rp) {
      refreshPeriod = rp;
      passingTime.setDelay((int)(refreshPeriod*1000)); // convert from [s] to [ms]
   }
   
   
   /**
    * Start.
    */
   public void start() {
      if(passingTime.isRunning()) return;
      passingTime.start();      
   }
   
   /**
    * Stop.
    */
   public void stop(){
	   if(passingTime.isRunning()) {
	      passingTime.stop();
	      
	   }
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   /**
    * Start the simulation
    */
   public void actionPerformed (ActionEvent event) {  // like simulate method of Assignment 1, 
      double nextStop=t+refreshPeriod;                // the arguments are attributes here.
      for (; t<nextStop; t+=delta_t){
         for (PhysicsElement e: elements)
            if (e instanceof Simulateable) {
               Simulateable s = (Simulateable) e;
               s.computeNextState(delta_t,this); // compute each element next state based on current global state
            }
         for (PhysicsElement e: elements)  // for each element update its state. 
            if (e instanceof Simulateable) {
               Simulateable s = (Simulateable) e;
               s.updateState();            // update its state
//               printState(t);
//               printStateDescription();
            }
         repaintView();        
      }    
     
   }
   
   /**
    * Repaint view.
    */
   public void repaintView(){
      view.repaintView();
   }

   /**
    * Find colliding ball.
    *
    * @param me the me
    * @return the ball
    */
   public Ball findCollidingBall(Ball me) {
      for (PhysicsElement e: elements)
         if ( e instanceof Ball) {
            Ball b = (Ball) e;
            if ((b!=me) && b.collide(me)) return b;
         }
      return null;
   }
 
   /**
    * Gets the physics elements.
    *
    * @return the physics elements
    */
   public ArrayList<PhysicsElement> getPhysicsElements(){
      return elements;
   }
   
   /**
    * Find.
    *
    * @param x the x
    * @param y the y
    * @return the physics element
    */
   public PhysicsElement find(double x, double y) {
      for (PhysicsElement e: elements)
            if (e.contains(x,y)) return e;
      return null;
   }
   
   
   /**
    * Prints the state description.
    */
   public void printStateDescription(){
	     String s = "Time\t\t";
	     for (PhysicsElement e:elements)
	       s+=e.getDescription() + "\t\t";
	     out.println(s);
	   }

	   //ENTREGA POSICIÓN DE LAS BOLAS EN FUNCIÓN DEL TIEMPO - OK!!
	   /**
   	 * Prints the state.
   	 *
   	 * @param t the t
   	 */
   	public void printState(double t){
		 String s = t+"\t\t";
		 for (PhysicsElement e:elements)
			 s+=e.getState() + "\t\t"; 
		 out.println(s);
	   }
	   
	   /**
   	 * Find attachable element.
   	 *
   	 * @param x the x
   	 * @param y the y
   	 * @return the spring attachable
   	 */
   	public SpringAttachable findAttachableElement(double x ,double y) {
		      for (PhysicsElement e :elements)
		         if (e instanceof SpringAttachable) {
		            SpringAttachable sp =(SpringAttachable) e;
		            if (sp.contains(x,y)) return sp;
		         }
		      return null;
		   }
	   
} 