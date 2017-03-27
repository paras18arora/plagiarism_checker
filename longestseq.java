mport java.io.*;
public class Plag
{
	public static int r=0;
	public static int rn=0;
	public static String[] filechar1(String args)
	{
		 String a[]=new String[1000];
       int i=0;
       
        
       File file = new File(args);
    if (!file.exists()) 
    {
      System.out.println(args + " does not exist.");
      return null;
    }
    if (!(file.isFile() && file.canRead())) 
    {
      System.out.println(file.getName() + " cannot be read from.");
      return null;
    }
    try {
      FileInputStream fis = new FileInputStream(file);
      char current;
      String temp="";
      while (fis.available() > 0) 
      {
        current = (char) fis.read();
        if(current!=' ' && current!=10 && current!=13)
        {
            temp=temp+current;
        }
        else
        if(current==' ' || current==10 && current==13)
        {
             a[i]=temp;
             i++;
             temp="";
        }
        
      }
     
      
    } catch (IOException e)
        {
            e.printStackTrace();
        }
        return a;
   
	}

	
	public static String[] filechar(String args)
	{
		 String a[]=new String[1000];
       int i=0;
       
        
       File file = new File(args);
    if (!file.exists()) 
    {
      System.out.println(args + " does not exist.");
      return null;
    }
    if (!(file.isFile() && file.canRead())) 
    {
      System.out.println(file.getName() + " cannot be read from.");
      return null;
    }
    try {
      FileInputStream fis = new FileInputStream(file);
      char current;
      String temp="";
      while (fis.available() > 0) 
      {
        current = (char) fis.read();
        if(current!=' ' && current!=10 && current!=13)
        {
            temp=temp+current;
        }
        else
        if(current==' ' || current==10 && current==13)
        {
             a[i]=temp;
             i++;
             temp="";
        }
        
      }
     
      
    } catch (IOException e)
        {
            e.printStackTrace();
        }
        return a;
   
	}
	
	
	
	
	public static int longseq(string p1,string p2)
	{
	
	
	
	
	
	
	
	
	
	}]
	
	
	
	
	
	
	
	
	
	
		public static void main(String args[])
	{
		float pl=0;
		String  a[]=filechar("files//normal1.cpp");
		String  b[]=filechar("files//normal.cpp");
	    String t1="";
		String t2="";
		int i,j,t;
		 for(i=0;i<a.length;i++)
        {
        String temp=a[i];
        if(temp!=null)
        {
        
        t1=t1+a[i];
        
        }
        }
		 for(i=0;i<b.length;i++)
        {
        String temp=b[i];
        if(temp!=null)
        {
        
        t2=t2+b[i];
        
        }
		
		
		longseq(t1,t2);
		
        }
	 