import java.awt.*;
import java.awt.geom.*;

// TODO: Auto-generated Javadoc
/**
 * The Class BallView.
 */
public class BallView {
   
   /** The color of a ball. */
   private Color color = Color.BLUE;
   
   /** The shape of a ball. */
   private Ellipse2D.Double shape = new Ellipse2D.Double();
      
   /** Reference to a ball. */
   private Ball ball;
   
   /**
    * Instantiates a new ball view.
    *
    * @param b the b
    */
   public BallView (Ball b){
      ball=b;
   }
   
   /**
    * Contains.
    *
    * @param x the x
    * @param y the y
    * @return true, if successful
    */
   public boolean contains (double x, double y){
	  
   return shape.contains(x,y);
   }
   
   /**
    * Sets the selected.
    */
   public void setSelected (){
      color = Color.RED;
   }
   
   /**
    * Sets the released.
    */
   public void setReleased() {
      color = Color.BLUE;
   }
   
   /**
    * Update view of Ball.
    
    * @param g the g
    */
  public  void updateView(Graphics2D g) {
      double radius = ball.getRadius();
      shape.setFrame(ball.getPosition()-radius, -radius, 2*radius, 2*radius);
      g.setColor(color);
      g.fill(shape);
  
   }
}