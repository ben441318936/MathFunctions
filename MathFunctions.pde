void setup()
{
	/*examples
	println(lcosAngleSSS(1,0.5,Math.sqrt(3)/2));
	printlcosAngleSSS(1,0.5,Math.sqrt(3)/2);
	println(lcosSideSAS(0.5,90,Math.sqrt(3)/2));
	printlcosSideSAS(0.5,90,Math.sqrt(3)/2);
	println(lcosSideASS(30,1,0.5));
	printlcosSideASS(30,1,0.5);
	println(lsinSideAAS(90,60,1));
	printlsinSideAAS(99,60,1);
	println(lsinSideASA(30,1,60));
	printlsinSideASA(30,1,60);
	*/
}
//trigonometry
double lcosAngleSSS(double a, double b, double c) //using Law of Cosine to find missing angle A
{
	double d=Math.toDegrees(Math.acos((Math.pow(a,2)-Math.pow(b,2)-Math.pow(c,2))/(-2.0*b*c)));
	return d;
}
void printlcosAngleSSS(double a, double b, double c)
{
	double d=lcosAngleSSS(a,b,c);
	println(String.format("%.3f",d)); 
}
double lcosSideSAS(double a, double C, double b) //using Law of Cosine to find missing side C
{
	double d=Math.sqrt((Math.pow(a,2)+Math.pow(b,2))-(2*a*b*Math.cos(Math.toRadians(C))));
	return d;
}
void printlcosSideSAS(double a, double C, double b)
{
	double d=lcosSideSAS(a,C,b);
	println(String.format("%.3f",d));
}
double [] lcosSideASS(double A, double b, double a) //using Law of Cosine to find missing side c
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
void printlcosSideASS(double A, double b, double a)
{
	double[] d=lcosSideASS(A,b,a);
	for(int i=0;i<d.length;i++)
	{
		println(String.format("%.3f",d[i]));
	}
}
double[] lsinSideAAS(double A, double B, double a) //using Law of Sine to find missing side b and c
{
	double[] answers={Math.sin(Math.toRadians(B))*a/Math.sin(Math.toRadians(A)), Math.sin(Math.toRadians(180-B-A))*a/Math.sin(Math.toRadians(A))};
	return answers;
}
void printlsinSideAAS(double A, double B, double a)
{
	double[] d=lsinSideAAS(A,B,a);
	for(int i=0;i<d.length;i++)
	{
		println(String.format("%.3f",d[i]));
	}
}
double[] lsinSideASA(double A, double b, double C) //using Law of Sine to find missing side a and c
{
	double[] answers={Math.sin(Math.toRadians(A))*b/Math.sin(Math.toRadians(180-C-A)),Math.sin(Math.toRadians(C))*b/Math.sin(Math.toRadians(180-C-A))};
	return answers;
}
void printlsinSideASA(double A, double b, double C)
{
	double[] d=lsinSideASA(A,b,C);
	for(int i=0;i<d.length;i++)
	{
		println(String.format("%.3f",d[i]));
	}
}