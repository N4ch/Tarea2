interface SpringAttachable {
  void attachSpring(Spring s);
  void detachSpring(Spring s);
  double getPosition();
  boolean contains(double x, double y) ;
  void dragTo(double x);


}