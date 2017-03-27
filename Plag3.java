import java.io.*;
public class Plag3
{
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



public static int min1(int x, int y, int z) 
{
	int a,b;
	a=Math.min(x, y);
	b=Math.min(a, z);
    return b;
}
 
public static int editDistDP(String str1, String str2, int m, int n)
{
    // Create a table to store results of subproblems
    int [][]dp=new int[m+1][n+1];
 
    // Fill d[][] in bottom up manner
    for (int i=0; i<=m; i++)
    {
        for (int j=0; j<=n; j++)
        {
            // If first string is empty, only option is to
            // isnert all characters of second string
            if (i==0)
                dp[i][j] = j;  // Min. operations = j
 
            // If second string is empty, only option is to
            // remove all characters of second string
            else if (j==0)
                dp[i][j] = i; // Min. operations = i
 
            // If last characters are same, ignore last char
            // and recur for remaining string
            else if (str1.charAt(i-1) == str2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1];
 
            // If last character are different, consider all
            // possibilities and find minimum
            else
                dp[i][j] = 1 + min1(dp[i][j-1],  // Insert
                                   dp[i-1][j],  // Remove
                                   dp[i-1][j-1]); // Replace
        }
    }
 
    return dp[m][n];
}
 
// Driver program
public static void main(String args[])
{
    	String  a[]=filechar("files//normal1.cpp");
		String  b[]=filechar("files//normal.cpp");
	    String t1="";
		String t2="";
		float z=0,maxi=0,pl3;
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

        z= editDistDP(t1, t2, t1.length(), t2.length());
		
		maxi=Math.max(t1.length(),t2.length());
		pl3=((float)t2.length()-z)/maxi;
        pl3=pl3*100;
        System.out.println("Plagiarism by string conversion is"+pl3);
   
}
}