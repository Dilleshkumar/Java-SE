import java.io.*;
import java.net.*;
public class DateServer
{ 
 public static void main(String args[])
{
 ServerSocket myServer;
 try
 {
 myServer=new ServerSocket(3000);
  while(true)
  {
   Socket clientrqst= myServer.accept();
   PrintWriter sc=new PrintWriter(clientrqst.getOutputStream(),true);
   sc.println("Enter the date(dd/mm/yyyy)");
   BufferedReader rc=new BufferedReader(new InputStreamReader(clientrqst.getInputStream()));
   String date=rc.readLine();
   String s[]=date.split("/",3);
   int mm,yyyy,dd;
   dd=Integer.parseInt(s[0]);
   mm=Integer.parseInt(s[1]);
   yyyy=Integer.parseInt(s[2]);
   
   int flag;
    if((mm>=1) && (mm<=12))
    {
     if((dd>=1 && dd<=31) && (mm==1 || mm==3 || mm==5 ||mm==7 || mm==8 || mm==10 || mm==12))
     flag=1;
     else if ((dd>=1 && dd<=30) && (mm==4 || mm==6 || mm==9 || mm==11))
     flag=1;
     else if((dd>=1 && dd<=28) && (mm==2))
     flag=1;
     else if ((dd>=1 && dd<=29) && (mm==2) && ((yyyy%4==0) && (yyyy % 100 != 0)|| (yyyy % 400 == 0)))
     flag=1;
     else 
     flag=0;
     }
    else
      flag=0;
    
   if(flag==1)
   {String p="Date is valid";
   sc.println(p);
   }
   if(flag==0)
   {String p="Date is Invalid";
   sc.println(p);
   }
   clientrqst.close();
   myServer.close(); 
 }}
  catch(Exception e)
  {
   System.out.println(e);
}}
}

