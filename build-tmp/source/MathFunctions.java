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
	//examples
	println("Set 1");
	println(lcosAngleSSS(1,0.5f,Math.sqrt(3)/2));
	printlcosAngleSSS(1,0.5f,Math.sqrt(3)/2);
	printlcosAngleSSS(41,428.510f,400);
	println("Set 2");
	println(lcosSideSAS(0.5f,90,Math.sqrt(3)/2));
	printlcosSideSAS(0.5f,90,Math.sqrt(3)/2);
	printlcosSideSAS(206.457f,25,336.906f);
	println("Set 3");
	println(lcosSideASS(90,0.5f,1));
	printlcosSideASS(90,0.5f,1);
	println("Set 4");
	println(lsinSideAAS(90,60,1));
	printlsinSideAAS(90,60,1);
	println("Set 5");
	println(lsinSideASA(30,1,60));
	printlsinSideASA(30,1,60);
	printlsinSideASA(66,150,90);
}
//trigonometry
public double lcosAngleSSS(double a, double b, double c) //using Law of Cosine to find missing angle A
{
	double d=Math.toDegrees(Math.acos((Math.pow(a,2)-Math.pow(b,2)-Math.pow(c,2))/(-2.0f*b*c)));
	return d;
}
public void printlcosAngleSSS(double a, double b, double c)
{
	double d=lcosAngleSSS(a,b,c);
	println(String.format("%.3f",d)); 
}
public double lcosSideSAS(double a, double C, double b) //using Law of Cosine to find missing side C
{
	double d=Math.sqrt((Math.pow(a,2)+Math.pow(b,2))-(2*a*b*Math.cos(Math.toRadians(C))));
	return d;
}
public void printlcosSideSAS(double a, double C, double b)
{
	double d=lcosSideSAS(a,C,b);
	println(String.format("%.3f",d));
}
public double [] lcosSideASS(double A, double b, double a) //using Law of Cosine to find missing side c
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
public void printlcosSideASS(double A, double b, double a)
{
	double[] d=lcosSideASS(A,b,a);
	for(int i=0;i<d.length;i++)
	{
		println(String.format("%.3f",d[i]));
	}
}
public double[] lsinSideAAS(double A, double B, double a) //using Law of Sine to find missing side b and c
{
	double[] answers={Math.sin(Math.toRadians(B))*a/Math.sin(Math.toRadians(A)), Math.sin(Math.toRadians(180-B-A))*a/Math.sin(Math.toRadians(A))};
	return answers;
}
public void printlsinSideAAS(double A, double B, double a)
{
	double[] d=lsinSideAAS(A,B,a);
	for(int i=0;i<d.length;i++)
	{
		println(String.format("%.3f",d[i]));
	}
}
public double[] lsinSideASA(double A, double b, double C) //using Law of Sine to find missing side a and c
{
	double[] answers={Math.sin(Math.toRadians(A))*b/Math.sin(Math.toRadians(180-C-A)),Math.sin(Math.toRadians(C))*b/Math.sin(Math.toRadians(180-C-A))};
	return answers;
}
public void printlsinSideASA(double A, double b, double C)
{
	double[] d=lsinSideASA(A,b,C);
	for(int i=0;i<d.length;i++)
	{
		println(String.format("%.3f",d[i]));
	}
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
