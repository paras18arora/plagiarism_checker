#include<iostream.h>
#include<conio.h>
#include"heap.cpp"

void main()
{

clrscr();
int n;
cout<<"Enter no. of elements in array";
cin>>n;
int *a=new int[n];
for(int i=0;i<n;i++)
{
cin>>a[i];
}
for(i=1;i<n;i++)
{
insertminheap(a,i,a[i]);
}
for(i=0;i<n;i++)
{
cout<<a[i]<<"  ";
}
cout<<endl;
for(i=0;i<n-2;i++)
{
deleteminheap(a,n-i);
}
for(i=0;i<n;i++)
{
cout<<a[i]<<"  ";
}
getch();
}