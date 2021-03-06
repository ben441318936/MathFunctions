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

//Trig Cheat Engine
public void setup()
{
	/*examples for v1.0
	println("Set 1");
	println(lcosAngleSSS(1,0.5,Math.sqrt(3)/2));
	printlcosAngleSSS(1,0.5,Math.sqrt(3)/2);
	println("Set 2");
	println(lcosSideSAS(0.5,90,Math.sqrt(3)/2));
	printlcosSideSAS(0.5,90,Math.sqrt(3)/2);
	println("Set 3");
	println(lcosSideASS(90,0.5,1));
	printlcosSideASS(90,0.5,1);
	println("Set 4");
	println(lsinSideAAS(90,60,1));
	printlsinSideAAS(90,60,1);
	println("Set 5");
	println(lsinSideASA(30,1,60));
	printlsinSideASA(30,1,60);
	*/

	/*
	v2.0 Grand Unification of Functions
	Enter the code in this format: LCosNLSin("type (SSS, SAS, etc)", side a, side b, side c, angle A, angle B, angle C); 
	Only enter givens applicable to the particular type. For example, if using ASS, do not give more than two sides and more than one angle. 
	Set up your triangle correctly and choose the arguments accordingly.
	Enter 0 for unknown values.
	*/
	//tests
	println("test 1");  println(" ");   /* change this part only >>*/  LCosNLSin("SSS",1,Math.sqrt(3)/2,0.5f,0,0,0);   /*<< change this part only*/   println(" "); 
	println("test 2");  println(" ");   /* change this part only >>*/  LCosNLSin("SAS",1,Math.sqrt(3)/2,0,0,0,30);    /*<< change this part only*/   println(" ");
	println("test 3");  println(" ");   /* change this part only >>*/  LCosNLSin("ASS",1,0,0.5f,0,0,30);               /*<< change this part only*/   println(" ");
	println("test 4");  println(" ");   /* change this part only >>*/  LCosNLSin("ASS",1,0,0.5f,90,0,0);               /*<< change this part only*/   println(" ");
	println("test 5");  println(" ");   /* change this part only >>*/  LCosNLSin("ASS",0,Math.sqrt(3)/2,0.5f,0,0,30);  /*<< change this part only*/   println(" ");
	println("test 6");  println(" ");   /* change this part only >>*/  LCosNLSin("ASS",0,Math.sqrt(3)/2,0.5f,0,60,0);  /*<< change this part only*/   println(" ");
	println("test 7");  println(" ");   /* change this part only >>*/  LCosNLSin("ASS",1,Math.sqrt(3)/2,0,90,0,0);    /*<< change this part only*/   println(" ");
	println("test 8");  println(" ");   /* change this part only >>*/  LCosNLSin("ASS",1,Math.sqrt(3)/2,0,0,60,0);    /*<< change this part only*/   println(" ");
	println("test 9");  println(" ");   /* change this part only >>*/  LCosNLSin("AAS",1,0,0,90,0,30);                /*<< change this part only*/   println(" ");
	println("test 10"); println(" ");   /* change this part only >>*/  LCosNLSin("AAS",1,0,0,90,60,0);                /*<< change this part only*/   println(" ");
	println("test 11"); println(" ");   /* change this part only >>*/  LCosNLSin("AAS",0,Math.sqrt(3)/2,0,90,60,0);   /*<< change this part only*/   println(" ");
	println("test 12"); println(" ");   /* change this part only >>*/  LCosNLSin("AAS",0,Math.sqrt(3)/2,0,0,60,30);   /*<< change this part only*/   println(" ");
	println("test 13"); println(" ");   /* change this part only >>*/  LCosNLSin("AAS",0,0,0.5f,90,0,30);              /*<< change this part only*/   println(" ");
	println("test 14"); println(" ");   /* change this part only >>*/  LCosNLSin("AAS",0,0,0.5f,0,60,30);              /*<< change this part only*/   println(" ");
	println("test 15"); println(" ");   /* change this part only >>*/  LCosNLSin("ASA",1,0,0,0,60,30);                /*<< change this part only*/   println(" ");
	println("test 16"); println(" ");   /* change this part only >>*/  LCosNLSin("ASA",0,Math.sqrt(3)/2,0,90,0,30);   /*<< change this part only*/   println(" ");
	println("test 17"); println(" ");   /* change this part only >>*/  LCosNLSin("ASA",0,0,0.5f,90,60,0);              /*<< change this part only*/   println(" ");
}

//v2.0
public void LCosNLSin(String type, double a, double b, double c, double A, double B, double C)
{
	double sidea, sideb, sidec, angleA, angleB, angleC, area;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	if(type.equals("SSS"))
	{
		sidea=a; sideb=b; sidec=c;
		angleA=Math.toDegrees(Math.acos((Math.pow(sidea,2)-Math.pow(sideb,2)-Math.pow(sidec,2))/(-2.0f*sideb*sidec)));
		angleB=Math.toDegrees(Math.acos((Math.pow(sideb,2)-Math.pow(sidea,2)-Math.pow(sidec,2))/(-2.0f*sidea*sidec)));
		angleC=Math.toDegrees(Math.acos((Math.pow(sidec,2)-Math.pow(sidea,2)-Math.pow(sideb,2))/(-2.0f*sideb*sidea)));
		area=sidec*sidea*Math.sin(Math.toRadians(angleB))/2;
		println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
		println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
		println("area: "+String.format("%.3f",area));
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	if(type.equals("SAS"))
	{
		if(a==0)
		{
			sideb=b; sidec=c; angleA=A;
			sidea=Math.sqrt((Math.pow(sidec,2)+Math.pow(sideb,2))-(2*sidec*sideb*Math.cos(Math.toRadians(angleA))));
			angleC=Math.toDegrees(Math.acos((Math.pow(sidec,2)-Math.pow(sideb,2)-Math.pow(sidea,2))/(-2.0f*sideb*sidea)));
			angleB=Math.toDegrees(Math.acos((Math.pow(sideb,2)-Math.pow(sidea,2)-Math.pow(sidec,2))/(-2.0f*sidea*sidec)));
			area=sidec*sidea*Math.sin(Math.toRadians(angleB))/2;
			println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
			println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
			println("area: "+String.format("%.3f",area));
		}
		if(b==0)
		{
			sidea=a; sidec=c; angleB=B;
			sideb=Math.sqrt((Math.pow(sidec,2)+Math.pow(sidea,2))-(2*sidec*sidea*Math.cos(Math.toRadians(angleB))));
			angleC=Math.toDegrees(Math.acos((Math.pow(sidec,2)-Math.pow(sideb,2)-Math.pow(sidea,2))/(-2.0f*sideb*sidea)));
			angleA=Math.toDegrees(Math.acos((Math.pow(sidea,2)-Math.pow(sideb,2)-Math.pow(sidec,2))/(-2.0f*sideb*sidec)));
			area=sidec*sidea*Math.sin(Math.toRadians(angleB))/2;
			println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
			println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
			println("area: "+String.format("%.3f",area));
		}
		if(c==0)
		{
			sidea=a; sideb=b; angleC=C;
			sidec=Math.sqrt((Math.pow(sidea,2)+Math.pow(sideb,2))-(2*sideb*sidea*Math.cos(Math.toRadians(angleC))));
			angleB=Math.toDegrees(Math.acos((Math.pow(sideb,2)-Math.pow(sidec,2)-Math.pow(sidea,2))/(-2.0f*sidec*sidea)));
			angleA=Math.toDegrees(Math.acos((Math.pow(sidea,2)-Math.pow(sideb,2)-Math.pow(sidec,2))/(-2.0f*sideb*sidec)));
			area=sidec*sidea*Math.sin(Math.toRadians(angleB))/2;
			println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
			println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
			println("area: "+String.format("%.3f",area));		
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	if(type.equals("ASS") || type.equals("SSA"))
	{
		double area1, area2;
		if(a==0)
		{
			sideb=b; sidec=c;
			double sidea1, sidea2, angleA1, angleA2, angleB1, angleB2, angleC1, angleC2;
			if(B==0)
			{
				angleC=C;
				sidea1=((2*sideb*Math.cos(Math.toRadians(angleC)))+Math.sqrt(Math.pow(2*sideb*Math.cos(Math.toRadians(angleC)),2)-(4*(Math.pow(sideb,2)-Math.pow(sidec,2)))))/2;
				angleB1=Math.toDegrees(Math.acos((Math.pow(sideb,2)-Math.pow(sidea1,2)-Math.pow(sidec,2))/(-2.0f*sidea1*sidec)));
				angleA1=Math.toDegrees(Math.acos((Math.pow(sidea1,2)-Math.pow(sidec,2)-Math.pow(sideb,2))/(-2.0f*sideb*sidec)));
				sidea2=((2*sideb*Math.cos(Math.toRadians(angleC)))-Math.sqrt(Math.pow(2*sideb*Math.cos(Math.toRadians(angleC)),2)-(4*(Math.pow(sideb,2)-Math.pow(sidec,2)))))/2;
				angleB2=Math.toDegrees(Math.acos((Math.pow(sideb,2)-Math.pow(sidea2,2)-Math.pow(sidec,2))/(-2.0f*sidea2*sidec)));
				angleA2=Math.toDegrees(Math.acos((Math.pow(sidea2,2)-Math.pow(sidec,2)-Math.pow(sideb,2))/(-2.0f*sideb*sidec)));
				area1=sidea1*sidec*Math.sin(Math.toRadians(angleB1))/2;
				area2=sidea2*sidec*Math.sin(Math.toRadians(angleB2))/2;
				println("Set 1");
				println("side a: "+String.format("%.3f",sidea1));   println("side b: "+String.format("%.3f",sideb));    println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA1)); println("angle B: "+String.format("%.3f",angleB1)); println("angle C: "+String.format("%.3f",angleC)); 
				println("area: "+String.format("%.3f",area1));
				println("Set 2");
				println("side a: "+String.format("%.3f",sidea2));   println("side b: "+String.format("%.3f",sideb));    println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA2)); println("angle B: "+String.format("%.3f",angleB2)); println("angle C: "+String.format("%.3f",angleC));
				println("area: "+String.format("%.3f",area2));
			}
			if(C==0)
			{
				angleB=B;
				sidea1=((2*sidec*Math.cos(Math.toRadians(angleB)))+Math.sqrt(Math.pow(2*sidec*Math.cos(Math.toRadians(angleB)),2)-(4*(Math.pow(sidec,2)-Math.pow(sideb,2)))))/2;
				angleC1=Math.toDegrees(Math.acos((Math.pow(sidec,2)-Math.pow(sidea1,2)-Math.pow(sideb,2))/(-2.0f*sidea1*sideb)));
				angleA1=Math.toDegrees(Math.acos((Math.pow(sidea1,2)-Math.pow(sidec,2)-Math.pow(sideb,2))/(-2.0f*sideb*sidec)));
				sidea2=((2*sidec*Math.cos(Math.toRadians(angleB)))-Math.sqrt(Math.pow(2*sidec*Math.cos(Math.toRadians(angleB)),2)-(4*(Math.pow(sidec,2)-Math.pow(sideb,2)))))/2;
				angleC2=Math.toDegrees(Math.acos((Math.pow(sidec,2)-Math.pow(sidea2,2)-Math.pow(sideb,2))/(-2.0f*sidea2*sideb)));
				angleA2=Math.toDegrees(Math.acos((Math.pow(sidea2,2)-Math.pow(sidec,2)-Math.pow(sideb,2))/(-2.0f*sideb*sidec)));
				area1=sidea1*sideb*Math.sin(Math.toRadians(angleC1))/2;
				area2=sidea2*sideb*Math.sin(Math.toRadians(angleC2))/2;
				println("Set 1");
				println("side a: "+String.format("%.3f",sidea1));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA1)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC1));
				println("area: "+String.format("%.3f",area1));
				println("Set 2");
				println("side a: "+String.format("%.3f",sidea2));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA2)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC1));
				println("area: "+String.format("%.3f",area2));
			}
		}
		if(b==0)
		{
			sidea=a; sidec=c;
			double sideb1, sideb2, angleB1, angleB2, angleA1, angleA2, angleC1, angleC2;
			if(A==0)
			{
				angleC=C;
				sideb1=((2*sidea*Math.cos(Math.toRadians(angleC)))+Math.sqrt(Math.pow(2*sidea*Math.cos(Math.toRadians(angleC)),2)-(4*(Math.pow(sidea,2)-Math.pow(sidec,2)))))/2;
				angleA1=Math.toDegrees(Math.acos((Math.pow(sidea,2)-Math.pow(sideb1,2)-Math.pow(sidec,2))/(-2.0f*sideb1*sidec)));
				angleB1=Math.toDegrees(Math.acos((Math.pow(sideb1,2)-Math.pow(sidea,2)-Math.pow(sidec,2))/(-2.0f*sidec*sidea)));
				sideb2=((2*sidea*Math.cos(Math.toRadians(angleC)))-Math.sqrt(Math.pow(2*sidea*Math.cos(Math.toRadians(angleC)),2)-(4*(Math.pow(sidea,2)-Math.pow(sidec,2)))))/2;
				angleA2=Math.toDegrees(Math.acos((Math.pow(sidea,2)-Math.pow(sideb2,2)-Math.pow(sidec,2))/(-2.0f*sideb2*sidec)));
				angleB2=Math.toDegrees(Math.acos((Math.pow(sideb2,2)-Math.pow(sidea,2)-Math.pow(sidec,2))/(-2.0f*sidec*sidea)));
				area1=sideb1*sidec*Math.sin(Math.toRadians(angleA1))/2;
				area2=sideb2*sidec*Math.sin(Math.toRadians(angleA2))/2;
				println("Set 1");
				println("side a: "+String.format("%.3f",sidea));    println("side b: "+String.format("%.3f",sideb1));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA1)); println("angle B: "+String.format("%.3f",angleB1)); println("angle C: "+String.format("%.3f",angleC));
				println("area: "+String.format("%.3f",area1));
				println("Set 2");
				println("side a: "+String.format("%.3f",sidea));    println("side b: "+String.format("%.3f",sideb2));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA2)); println("angle B: "+String.format("%.3f",angleB2)); println("angle C: "+String.format("%.3f",angleC));
				println("area: "+String.format("%.3f",area2));
			}
			if(C==0)
			{
				angleA=A;
				sideb1=((2*sidec*Math.cos(Math.toRadians(angleA)))+Math.sqrt(Math.pow(2*sidec*Math.cos(Math.toRadians(angleA)),2)-(4*(Math.pow(sidec,2)-Math.pow(sidea,2)))))/2;
				angleC1=Math.toDegrees(Math.acos((Math.pow(sidec,2)-Math.pow(sideb1,2)-Math.pow(sidea,2))/(-2.0f*sideb1*sidea)));
				angleB1=Math.toDegrees(Math.acos((Math.pow(sideb1,2)-Math.pow(sidea,2)-Math.pow(sidec,2))/(-2.0f*sidec*sidea)));
				sideb2=((2*sidec*Math.cos(Math.toRadians(angleA)))-Math.sqrt(Math.pow(2*sidec*Math.cos(Math.toRadians(angleA)),2)-(4*(Math.pow(sidec,2)-Math.pow(sidea,2)))))/2;
				angleC2=Math.toDegrees(Math.acos((Math.pow(sidec,2)-Math.pow(sideb2,2)-Math.pow(sidea,2))/(-2.0f*sideb2*sidea)));
				angleB2=Math.toDegrees(Math.acos((Math.pow(sideb2,2)-Math.pow(sidea,2)-Math.pow(sidec,2))/(-2.0f*sidec*sidea)));
				area1=sideb1*sidea*Math.sin(Math.toRadians(angleC1))/2;
				area2=sideb2*sidea*Math.sin(Math.toRadians(angleC2))/2;
				println("Set 1");
				println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb1));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB2)); println("angle C: "+String.format("%.3f",angleC1));
				println("area: "+String.format("%.3f",area1)); 
				println("Set 2");
				println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb2));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB2)); println("angle C: "+String.format("%.3f",angleC2));
				println("area: "+String.format("%.3f",area2));
			}
		}
		if(c==0)
		{
			sideb=b; sidea=a;
			double sidec1, sidec2, angleB1, angleB2, angleC1, angleC2, angleA1, angleA2;
			if(B==0)
			{
				angleA=A;
				sidec1=((2*sideb*Math.cos(Math.toRadians(angleA)))+Math.sqrt(Math.pow(2*sideb*Math.cos(Math.toRadians(angleA)),2)-(4*(Math.pow(sideb,2)-Math.pow(sidea,2)))))/2;
				angleB1=Math.toDegrees(Math.acos((Math.pow(sideb,2)-Math.pow(sidea,2)-Math.pow(sidec1,2))/(-2.0f*sidea*sidec1)));
				angleC1=Math.toDegrees(Math.acos((Math.pow(sidec1,2)-Math.pow(sidea,2)-Math.pow(sideb,2))/(-2.0f*sideb*sidea)));
				sidec2=((2*sideb*Math.cos(Math.toRadians(angleA)))-Math.sqrt(Math.pow(2*sideb*Math.cos(Math.toRadians(angleA)),2)-(4*(Math.pow(sideb,2)-Math.pow(sidea,2)))))/2;
				angleB2=Math.toDegrees(Math.acos((Math.pow(sideb,2)-Math.pow(sidea,2)-Math.pow(sidec2,2))/(-2.0f*sidea*sidec2)));
				angleC2=Math.toDegrees(Math.acos((Math.pow(sidec2,2)-Math.pow(sidea,2)-Math.pow(sideb,2))/(-2.0f*sideb*sidea)));
				area1=sidec1*sidea*Math.sin(Math.toRadians(angleB1))/2;
				area2=sidec2*sidea*Math.sin(Math.toRadians(angleB2))/2;
				println("Set 1");
				println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));	   println("side c: "+String.format("%.3f",sidec1));
				println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB1)); println("angle C: "+String.format("%.3f",angleC1));
				println("area: "+String.format("%.3f",area1));
				println("Set 2");
				println("side a: "+String.format("%.3f",sidea));    println("side b: "+String.format("%.3f",sideb));	println("side c: "+String.format("%.3f",sidec2));
				println("angle A: "+String.format("%.3f",angleA));  println("angle B: "+String.format("%.3f",angleB2)); println("angle C: "+String.format("%.3f",angleC2));
				println("area: "+String.format("%.3f",area2));
			}
			if(A==0)
			{
				angleB=B;
				sidec1=((2*sidea*Math.cos(Math.toRadians(angleB)))+Math.sqrt(Math.pow(2*sidea*Math.cos(Math.toRadians(angleB)),2)-(4*(Math.pow(sidea,2)-Math.pow(sideb,2)))))/2;
				angleA1=Math.toDegrees(Math.acos((Math.pow(sidea,2)-Math.pow(sideb,2)-Math.pow(sidec1,2))/(-2.0f*sideb*sidec1)));
				angleC1=Math.toDegrees(Math.acos((Math.pow(sidec1,2)-Math.pow(sidea,2)-Math.pow(sideb,2))/(-2.0f*sideb*sidea)));
				sidec2=((2*sidea*Math.cos(Math.toRadians(angleB)))-Math.sqrt(Math.pow(2*sidea*Math.cos(Math.toRadians(angleB)),2)-(4*(Math.pow(sidea,2)-Math.pow(sideb,2)))))/2;
				angleA2=Math.toDegrees(Math.acos((Math.pow(sidea,2)-Math.pow(sideb,2)-Math.pow(sidec2,2))/(-2.0f*sideb*sidec2)));
				angleC2=Math.toDegrees(Math.acos((Math.pow(sidec2,2)-Math.pow(sidea,2)-Math.pow(sideb,2))/(-2.0f*sideb*sidea)));
				area1=sidec1*sideb*Math.sin(Math.toRadians(angleA1))/2;
				area2=sidec2*sideb*Math.sin(Math.toRadians(angleA2))/2;
				println("Set 1");
				println("side a: "+String.format("%.3f",sidea));    println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec1));
				println("angle A: "+String.format("%.3f",angleA1)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC1));
				println("area: "+String.format("%.3f",area1));
				println("Set 2");
				println("side a: "+String.format("%.3f",sidea));    println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec2));
				println("angle A: "+String.format("%.3f",angleA2)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC2));
				println("area: "+String.format("%.3f",area2));
			}
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	if(type.equals("AAS")||type.equals("SAA"))
	{
		if(A==0)
		{
			angleB=B; angleC=C; angleA=180-angleB-angleC;
			if(c==0)
			{
				sideb=b;
				sidec=Math.sin(Math.toRadians(angleC))*sideb/Math.sin(Math.toRadians(angleB));
				sidea=Math.sin(Math.toRadians(angleA))*sideb/Math.sin(Math.toRadians(angleB));
				double s=(sidea+sideb+sidec)/2;
				area=Math.sqrt((s)*(s-sidea)*(s-sideb)*(s-sidec));
				println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
				println("area: "+String.format("%.3f",area));
			}
			if(b==0)
			{
				sidec=c;
				sideb=Math.sin(Math.toRadians(angleB))*sidec/Math.sin(Math.toRadians(angleC));
				sidea=Math.sin(Math.toRadians(angleA))*sidec/Math.sin(Math.toRadians(angleC));
				double s=(sidea+sideb+sidec)/2;
				area=Math.sqrt((s)*(s-sidea)*(s-sideb)*(s-sidec));
				println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
				println("area: "+String.format("%.3f",area));
			}
		}
		if(B==0)
		{
			angleA=A; angleC=C; angleB=180-angleA-angleC;
			if(c==0)
			{
				sidea=a;
				sidec=Math.sin(Math.toRadians(angleC))*sidea/Math.sin(Math.toRadians(angleA));
				sideb=Math.sin(Math.toRadians(angleB))*sidea/Math.sin(Math.toRadians(angleA));
				double s=(sidea+sideb+sidec)/2;
				area=Math.sqrt((s)*(s-sidea)*(s-sideb)*(s-sidec));
				println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
				println("area: "+String.format("%.3f",area));
			}
			if(a==0)
			{
				sidec=c;
				sidea=Math.sin(Math.toRadians(angleA))*sidec/Math.sin(Math.toRadians(angleC));
				sideb=Math.sin(Math.toRadians(angleB))*sidec/Math.sin(Math.toRadians(angleC));
				double s=(sidea+sideb+sidec)/2;
				area=Math.sqrt((s)*(s-sidea)*(s-sideb)*(s-sidec));
				println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
				println("area: "+String.format("%.3f",area));
			}
		}
		if(C==0)
		{
			angleA=A; angleB=B; angleC=180-angleA-angleB;
			if(b==0)
			{
				sidea=a;
				sideb=Math.sin(Math.toRadians(angleB))*sidea/Math.sin(Math.toRadians(angleA));
				sidec=Math.sin(Math.toRadians(angleC))*sidea/Math.sin(Math.toRadians(angleA));
				double s=(sidea+sideb+sidec)/2;
				area=Math.sqrt((s)*(s-sidea)*(s-sideb)*(s-sidec));
				println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
				println("area: "+String.format("%.3f",area));
			}
			if(a==0)
			{
				sideb=b;
				sidea=Math.sin(Math.toRadians(angleA))*sideb/Math.sin(Math.toRadians(angleB));
				sidec=Math.sin(Math.toRadians(angleC))*sideb/Math.sin(Math.toRadians(angleB));
				double s=(sidea+sideb+sidec)/2;
				area=Math.sqrt((s)*(s-sidea)*(s-sideb)*(s-sidec));
				println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
				println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
				println("area: "+String.format("%.3f",area));
			}
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	if(type.equals("ASA"))
	{
		if(a!=0)
		{
			sidea=a; angleB=B; angleC=C; angleA=180-angleB-angleC;
			sideb=Math.sin(Math.toRadians(angleB))*sidea/Math.sin(Math.toRadians(angleA));
			sidec=Math.sin(Math.toRadians(angleC))*sidea/Math.sin(Math.toRadians(angleA));
			double s=(sidea+sideb+sidec)/2;
			area=Math.sqrt((s)*(s-sidea)*(s-sideb)*(s-sidec));
			println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
			println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
			println("area: "+String.format("%.3f",area));
		}
		if(b!=0)
		{
			sideb=b; angleA=A; angleC=C; angleB=180-angleA-angleC; 
			sidea=Math.sin(Math.toRadians(angleA))*sideb/Math.sin(Math.toRadians(angleB));
			sidec=Math.sin(Math.toRadians(angleC))*sideb/Math.sin(Math.toRadians(angleB));
			double s=(sidea+sideb+sidec)/2;
			area=Math.sqrt((s)*(s-sidea)*(s-sideb)*(s-sidec));
			println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
			println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
			println("area: "+String.format("%.3f",area));
		}
		if(c!=0)
		{
			sidec=c; angleA=A; angleB=B; angleC=180-angleA-angleB;
			sidea=Math.sin(Math.toRadians(angleA))*sidec/Math.sin(Math.toRadians(angleC));
			sideb=Math.sin(Math.toRadians(angleB))*sidec/Math.sin(Math.toRadians(angleC));
			double s=(sidea+sideb+sidec)/2;
			area=Math.sqrt((s)*(s-sidea)*(s-sideb)*(s-sidec));
			println("side a: "+String.format("%.3f",sidea));   println("side b: "+String.format("%.3f",sideb));   println("side c: "+String.format("%.3f",sidec));
			println("angle A: "+String.format("%.3f",angleA)); println("angle B: "+String.format("%.3f",angleB)); println("angle C: "+String.format("%.3f",angleC));
			println("area: "+String.format("%.3f",area));
		}

	}
}

//v1.0
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
