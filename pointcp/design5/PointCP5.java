public abstract class PointCP5
{
  //Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
  protected char typeCoord;
  
  /**
   * Contains the current value of X or RHO depending on the type
   * of coordinates.
   */
  protected double xOrRho;
  
  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  protected double yOrTheta;
	
	
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
    if(typeCoord == 'C') 
      return xOrRho;
    else 
      return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
  }
  
  public double getY()
  {
    if(typeCoord == 'C') 
      return yOrTheta;
    else 
      return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
  }
  
  public double getRho()
  {
    if(typeCoord == 'P') 
      return xOrRho;
    else 
      return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
  }
  
  public double getTheta()
  {
    if(typeCoord == 'P')
      return yOrTheta;
    else 
      return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
  }
  
	
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar()
  {
    if(typeCoord != 'P')
    {
      //Calculate RHO and THETA
      double temp = getRho();
      yOrTheta = getTheta();
      xOrRho = temp;
      
      typeCoord = 'P';  //Change coord type identifier
    }
  }
	
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public void convertStorageToCartesian()
  {
    if(typeCoord != 'C')
    {
      //Calculate X and Y
      double temp = getX();
      yOrTheta = getY();
      xOrRho = temp;
   
      typeCoord = 'C';	//Change coord type identifier
    }
  }

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP5 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP5 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP5('C',
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as " + (typeCoord == 'C' 
       ? "Cartesian  (" + getX() + "," + getY() + ")"
       : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
  }
}
