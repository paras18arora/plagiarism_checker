#include<iostream.h>

void main()
{

int i,j,k=0,m,n,*a;
cin>>n;
cin>>m;
*a=new int[n][m];





for(i=0;i<n;i++)
{
for(j=0;j<m;j++)
{
k+=(m*n)-1;
if(j+2<m)
{
if(i+1<n || i-1>=0)
{
k--;
}

}
if(j-2>=0)
{
if(i+1<n || i-1>=0)
{
k--;
}
}
if(i+2<n)
{
if(j+1<m || j-1>=0)
{
k--;
}

}
if(i-2>=0)
{
if(j+1<m || j-1>=0)
{
k--;
}
}

}
}

cout<<k;}