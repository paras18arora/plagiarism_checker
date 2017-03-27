import java.io.*;
public class Plag1
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

  public static int subseq(String x,String y)
  {   int count=0;
      int m = x.length();
      int n= y.length();
        int[][] opt = new int[m][n];
 for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++)
                {
                    if(i==0||j==0)
                    {
                        opt[i][j]=0;
                    }
				}
 }
         for (int i = 1; i<m; i++) {
            for (int j = 1; j<n; j++)
                {
                    
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i-1][j-1] + 1;
                else
                    opt[i][j] = Math.max(opt[i-1][j], opt[i][j-1]);
            }
        }

/*        int i=m; , j=n ; count=0;
        Sytem.out.println("printing the longest subsequence - ");
           System.out.println();
        while(i>0  && j >0)
            {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i--;
                j--;
                count++;
            }
            else if (opt[i-1][j] >= opt[i][j-1])
                        i--;

              else
                       j--;
        }
*/



        return opt[m-1][n-1];
      




}



	public static void main(String args[])
	{
		float p2=0;
		int min,seqlen;
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
        }

        seqlen=subseq(t1,t2);
        min=Math.min(t1.length(),t2.length());

         p2=(float)seqlen/min;
         p2=p2*100;

      System.out.println("longest subsequence length  "+seqlen);
      System.out.println("PLAGIARISM DETECTED BY THIS ALGO  "+p2);
      System.out.println();


	}
}