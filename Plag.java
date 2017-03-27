import java.io.*;
import java.util.Arrays;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Plag implements ActionListener 
{
	public static int r=0;
	public static int rn=0;
	public static String file1="";
	public static String file2="";
	JLabel l1,l2;
    JTextField t1,t2;
	
    JButton b,b1,b2;    
    JFrame f;
	public Plag()
	{    r=0;
		 f=new JFrame("Plagiarism detection");
        l1=new JLabel("enter first file");
        l2=new JLabel("enter second file");
       
        t1=new JTextField(100);
        t2=new JTextField(100);
		 b=new JButton("check");
		 b1=new JButton("browse");
		 b2=new JButton("browse");


        b.addActionListener(this);
		
		b1.addActionListener(this);
		
		b2.addActionListener(this);
		
        f.setSize(600,450);
        f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane();
		l1.setBounds(10,50,100,30);
        l2.setBounds(10,100,100,30);
		 t1.setBounds(150,50,200,30);
        t2.setBounds(150,100,200,30);
		b1.setBounds(400,50,100,30);
		b2.setBounds(400,100,100,30);
         b.setBounds(50,200,100,30);
		 
		f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(t2);
        f.add(b);
		f.add(b1);
		f.add(b2);
		f.setVisible(true);
	}
	   
	     public void actionPerformed (ActionEvent e)
		{
			if((JButton)e.getSource()==b)
			{
			String s1="";
			String s2="";
			s1=t1.getText();
			s2=t2.getText();
			file1=s1;
			file2=s2;
			compute();
			}
			if((JButton)e.getSource()==b2)
			{
			JFileChooser JF=new JFileChooser();
			JF.showOpenDialog(f);
			t2.setText(JF.getSelectedFile().getAbsolutePath());
			}
			if((JButton)e.getSource()==b1)
			{
			JFileChooser JF=new JFileChooser();
			JF.showOpenDialog(f);
			t1.setText(JF.getSelectedFile().getAbsolutePath());
			}
		}
		public static void compute()
		{
                float avg=0;
		float pl=0;
		float p2=0;
		int min,seqlen;
		String  a[]=filechar(Plag.file1);
		String  b[]=filechar(Plag.file2);
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
		
		
		/*char[] chars = t1.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        t1=sorted;
		
		
		chars = t2.toCharArray();
        Arrays.sort(chars);
        sorted = new String(chars);
        t2=sorted;*/

	   i=0;
	   j=0;
   /*  while(i+10<t1.length())
     {
     
          String  subst1=t1.substring(i,i+10);*/
            while(j+3<t2.length())
            {
            String subst2=t2.substring(j,j+3);
            Plag.search(subst2,t1,101);
            j=j+3;
            }
            i=i+10;
			
    // }
	int x=Math.max(t2.length(),t1.length())/3;
	int rr=0;
	rr=r;
	 pl=((float)rr/x);
	 pl=pl*100;
	 System.out.println(r);
	 System.out.println(rn);
	  System.out.println(t1);
	 System.out.println(t2);
	 
	 JOptionPane.showMessageDialog(null,"Plagiarism by rabin karp is "+pl+"%");
	 
	 String  c[]=filechar1(Plag.file1);
		String  d[]=filechar1(Plag.file2);
	    String t3="";
		String t4="";
	
		 for(i=0;i<c.length;i++)
        {
        String temp=c[i];
        if(temp!=null)
        {
        
        t3=t3+c[i];
        
        }
        }
		 for(i=0;i<d.length;i++)
        {
        String temp=d[i];
        if(temp!=null)
        {
        
        t4=t4+d[i];
        
        }
        }
		
		
		char[] chars = t3.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        t3=sorted;
		chars = t4.toCharArray();
        Arrays.sort(chars);
        sorted = new String(chars);
        t4=sorted;
		
	  seqlen=subseq(t3,t4);
        min=Math.max(t3.length(),t4.length());

         p2=(float)(seqlen+1)/min;
         p2=p2*100;

      System.out.println("longest subsequence length  "+seqlen);
	  System.out.println("longest subsequence length  "+min);
     JOptionPane.showMessageDialog(null,"Plagiarism by longest common subsequence is "+p2+"%");
      System.out.println();
	 
	 String  e[]=filechar3(Plag.file1);
		String  f[]=filechar3(Plag.file2);
	    String t5="";
		String t6="";
		float z=0,maxi=0,pl3;
	
		 for(i=0;i<e.length;i++)
        {
        String temp=e[i];
        if(temp!=null)
        {

        t5=t5+e[i];

        }
        }
		 for(i=0;i<f.length;i++)
        {
        String temp=f[i];
        if(temp!=null)
        {

        t6=t6+f[i];

        }
        }
		
		
      /*   chars = t5.toCharArray();
        Arrays.sort(chars);
        sorted = new String(chars);
        t5=sorted;
		
		chars = t6.toCharArray();
        Arrays.sort(chars);
        sorted = new String(chars);
        t6=sorted;
		*/
		
        z= editDistDP(t5, t6, t5.length(), t6.length());
		
		maxi=Math.max(t5.length(),t6.length());
		pl3=((float)maxi-z)/maxi;
        pl3=pl3*100;

      JOptionPane.showMessageDialog(null,"Plagiarism by string conversion is "+pl3+"%");


        avg=(pl+p2+pl3)/3;

        JOptionPane.showMessageDialog(null,"Average Plagiarism is "+pl3+"%");
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
        if(current==' ' || current==10 || current==13)
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
	public static String[] filechar3(String args)
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


static void search(String pat, String txt, int q)
{
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int p = 0; 
    int t = 0; 
    int h = 1;
    int d = 256;

    for (i = 0; i < M-1; i++)
        h = (h*d)%q;


    for (i = 0; i < M; i++)
    {
        p = (d*p + pat.charAt(i))%q;
        t = (d*t + txt.charAt(i))%q;
    }


    for (i = 0; i <= N - M; i++)
    {


        if ( p == t )
        {
            rn++;
            for (j = 0; j < M; j++)
            {
                if (txt.charAt(i+j) != pat.charAt(j))
                    break;
            }


            if (j == M)
			{
				r++;
				break;
			}
        }


        if ( i < N-M )
        {
            t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;


            if (t < 0)
            t = (t + q);
        }
	
    }
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
    
    int [][]dp=new int[m+1][n+1];
 
   
    for (int i=0; i<=m; i++)
    {
        for (int j=0; j<=n; j++)
        {
           
           
            if (i==0)
                dp[i][j] = j;  // Min. operations = j
 
          

            else if (j==0)
                dp[i][j] = i; // Min. operations = i
 
           
         
            else if (str1.charAt(i-1) == str2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1];
 
           

            else
                dp[i][j] = 1 + min1(dp[i][j-1],  // Insert
                                   dp[i-1][j],  // Remove
                                   dp[i-1][j-1]); // Replace
        }
    }
 
    return dp[m][n];
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
	    Plag ob=new Plag();
		/*float pl=0;
		float p2=0;
		int min,seqlen;
		String  a[]=filechar(Plag.file1);
		String  b[]=filechar(Plag.file2);
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
		
		
		char[] chars = t1.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        t1=sorted;
		
		
		chars = t2.toCharArray();
        Arrays.sort(chars);
        sorted = new String(chars);
        t2=sorted;

	   i=0;
	   j=0;
     while(i+10<t1.length())
     {
     
          String  subst1=t1.substring(i,i+10);
            while(j+3<t2.length())
            {
            String subst2=t2.substring(j,j+3);
            Plag.search(subst2,subst1,101);
            j=j+3;
            }
            i=i+10;
     }
	 pl=((float)Plag.r/Plag.rn);
	 pl=pl*100;
	 System.out.println(r);
	 System.out.println(rn);
	  System.out.println(t1);
	 System.out.println(t2);
	 
	 JOptionPane.showMessageDialog(null,"Plagiarism by NOrmalization is "+pl+"%");
	 
	 String  c[]=filechar1(Plag.file1);
		String  d[]=filechar1(Plag.file2);
	    String t3="";
		String t4="";
	
		 for(i=0;i<a.length;i++)
        {
        String temp=a[i];
        if(temp!=null)
        {
        
        t3=t3+a[i];
        
        }
        }
		 for(i=0;i<b.length;i++)
        {
        String temp=b[i];
        if(temp!=null)
        {
        
        t4=t4+b[i];
        
        }
        }
		
		
		chars = t3.toCharArray();
        Arrays.sort(chars);
        sorted = new String(chars);
        t3=sorted;
		chars = t4.toCharArray();
        Arrays.sort(chars);
        sorted = new String(chars);
        t4=sorted;
		
	  seqlen=subseq(t3,t4);
        min=Math.min(t3.length(),t4.length());

         p2=(float)seqlen/min;
         p2=p2*100;

      System.out.println("longest subsequence length  "+seqlen);
     JOptionPane.showMessageDialog(null,"Plagiarism by NOrmalization is "+p2+"%");
      System.out.println();
	 
	 String  e[]=filechar3(Plag.file1);
		String  f[]=filechar3(Plag.file2);
	    String t5="";
		String t6="";
		float z=0,maxi=0,pl3;
	
		 for(i=0;i<a.length;i++)
        {
        String temp=a[i];
        if(temp!=null)
        {

        t5=t5+a[i];

        }
        }
		 for(i=0;i<b.length;i++)
        {
        String temp=b[i];
        if(temp!=null)
        {

        t6=t6+b[i];

        }
        }
		
		
         chars = t5.toCharArray();
        Arrays.sort(chars);
        sorted = new String(chars);
        t5=sorted;
		
		chars = t6.toCharArray();
        Arrays.sort(chars);
        sorted = new String(chars);
        t6=sorted;
		
		
        z= editDistDP(t5, t6, t5.length(), t6.length());
		
		maxi=Math.max(t5.length(),t6.length());
		pl3=((float)maxi-z)/maxi;
        pl3=pl3*100;
      JOptionPane.showMessageDialog(null,"Plagiarism by NOrmalization is "+pl3+"%");*/
   
	}
	
	

	
	
	
	
	
}
