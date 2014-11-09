import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class MathFunctions extends PApplet {

public void setup()
{
	println(lcosAngleSSS(1,0.5f,Math.sqrt(3)/2));
	println(lcosSideSAS(0.5f,90,Math.sqrt(3)/2));
	println(lcosSideASS(90,0.5f,1));
	println(lsinSideAAS(90,30,1));
}
public double lcosAngleSSS(double a, double b, double c) //using Law of Cosine to find missing angle A
{
	return Math.toDegrees(Math.acos((Math.pow(a,2)-Math.pow(b,2)-Math.pow(c,2))/(-2.0f*b*c)));
}
public double lcosSideSAS(double a, double C, double b) //using Law of Cosine to find missing side C
{
	return Math.sqrt((Math.pow(a,2)+Math.pow(b,2))-(2*a*b*Math.cos(Math.toRadians(C))));
}
public double [] lcosSideASS(double A, double a, double b) //using Law of Cosine to find missing side c
{
	if(A==90)
	{
		if(a>b) 
		{
			double[]roots={Math.sqrt(Math.pow(a,2)-Math.pow(b,2))};
			return roots;
		}
		else 
		{
			double[]roots={Math.sqrt(Math.pow(b,2)-Math.pow(a,2))};
			return roots;
		}
	}
	else
	{
		double[]roots={((2*b*Math.cos(Math.toRadians(A)))+Math.sqrt(Math.pow(2*b*Math.cos(Math.toRadians(A)),2)-(4*(Math.pow(b,2)-Math.pow(a,2)))))/2,((2*b*Math.cos(Math.toRadians(A)))-Math.sqrt(Math.pow(2*b*Math.cos(Math.toRadians(A)),2)-(4*(Math.pow(b,2)-Math.pow(a,2)))))/2};
		return roots;
	}
}
public double[] lsinSideAAS(double A, double B, double a) //using Law of Sine to find missing side b and c
{
	double[] answers={Math.sin(Math.toRadians(B))*a/Math.sin(Math.toRadians(A)), Math.sin(Math.toRadians(180-B-A))*a/Math.sin(Math.toRadians(A))};
	return answers;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MathFunctions" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
