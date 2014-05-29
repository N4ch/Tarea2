
public class CreateConfiguration {//NUEVO DESDE ETAPA 2
	  
	   
	   static void makeConf(MyWorld world){
		   
		   	double mass = 1.0;      // 1 [kg] 
		    double radius = 0.1;    // 10 [cm] 
		    double position = 0.5;  // 1 [m] 
		    double speed = 0.5;     // 0.5 [m/s]
		    
		    Ball b0 = new Ball(mass, radius, position, speed);
		    Ball b1 = new Ball(mass, radius, 3, speed);
		    Ball b2 = new Ball(0.0001, radius, 2, speed);
		    
		    FixedHook h0= new FixedHook(0,0);
		    FixedHook h1= new FixedHook(0,3.8);
		    
		    Spring s0 = new Spring(1.0,0.5);
		    Spring s1 = new Spring(1.0,0.5);
		    
		    s0.attachAend(h0);
		    s0.attachBend(b0);
		    
		    s1.attachAend(h1);
		    s1.attachBend(b1);

		    world.addElement(b2);
		    
		    world.addElement(h0);		    
		    world.addElement(s0);
		    world.addElement(b0);
		    

		    world.addElement(h1);		    
		    world.addElement(s1);
		    world.addElement(b1);
		 }
	   
	   static void addBall (MyWorld world){
			double mass = 1.0;      // 1 [kg] 
		    double radius = 0.1;    // 10 [cm] 
		    double position = 0;  // 1 [m] 
		    double speed = 0.5;     // 0.5 [m/s]
		    
		    Ball b0 = new Ball (mass,radius,position,speed);

		    world.addElement(b0); 		  
	   }
	   
	   static void addSpring (MyWorld world){
		    
		    Spring s0 = new Spring(1.0,0.5);
		    world.addElement(s0); 	  
	   }
	   
	   static void addFixedHook (MyWorld world){
		    
		    FixedHook h0 = new FixedHook(1.0,0.5);
		    world.addElement(h0); 	  
	   }
	   

}
