package practice;

public class GenericMethodPractice 	
{
public static void main(String[] args) //caller
{
//Hardcode 
//int a = 10;
//int b = 30;
//int c = a+b;
//System.out.println(c);

adde(30,40);
adde(60,90);
int div = adde(50, 5);
System.out.println(div+20-10);

//Generic/Reusable method
}
public static int adde(int a, int b) 	
{
int c = a/b;
return c;
}
}
