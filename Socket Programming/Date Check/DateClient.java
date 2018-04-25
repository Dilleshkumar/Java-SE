import java.io.*; 

import java.net.*;

public class DateClient
{
public static void main(String args[])
{
	try
 {
 Socket myClient= new Socket("127.0.0.1",3000);
 BufferedReader rs= new BufferedReader(new InputStreamReader(myClient.getInputStream()));
 String str=rs.readLine();
 System.out.println(str);
 BufferedReader scan=new BufferedReader(new InputStreamReader(System.in));
 str=scan.readLine();
 //System.out.println(str);
 PrintWriter out=new PrintWriter(myClient.getOutputStream(),true);
 out.println(str);
BufferedReader inp1= new BufferedReader(new InputStreamReader(myClient.getInputStream()));
str=inp1.readLine();
System.out.println(str);
 
 }
 catch(Exception e)
{
 System.out.println(e);
}
 }
 
}

