import java.awt.*;
import java.awt.geom.*;

public class FixedHookView {
   private final double width=0.1;  // fixed point width
   private Color color = Color.GREEN;
   private Rectangle2D.Double shape = new Rectangle2D.Double() ;
   private FixedHook hook;

   public FixedHookView (FixedHook h){
	      hook=h;
	   }
	   public boolean contains (double x, double y){
		  
	   return shape.contains(x,y);
	   }
	   public void setSelected (){
	      color = Color.RED;
	   }
	   public void setReleased() {
	      color = Color.BLUE;
	   }
	   void updateView(Graphics2D g) {
	      shape.setFrame(hook.getPosition()-width, -width, 2*width, 2*width);

	      g.setColor(color);
	      g.fill(shape);
	
	     	            
	   }
	   
	   
	   
	 
}
	