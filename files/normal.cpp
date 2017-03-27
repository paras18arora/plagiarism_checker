#include<iostream.h>
#include<conio.h>

class treenode
{

public:
int info;
int height;

class treenode *left,*right;

treenode()
{
info=-1;
left=NULL;
right=NULL;
height=0;
}

};
int max(int a,int b)
{
if(a>b)
return a;
else
return b;
}
int height(treenode *root)
{
if(root==NULL)
return -1;
else
return root->height;
}
treenode *LL(treenode *x)
{
treenode *w=x->left;
x->left=w->right;
w->right=x;
x->height=max(height(x->left),height(x->right))+1;
w->height=max(height(w->left),height(w->right))+1;

return w;
}
treenode *RR(treenode *w)
{
treenode *x=w->right;
w->right=x->left;
x->left=w;
w->height=max(height(w->left),height(w->right))+1;
x->height=max(height(x->left),height(x->right))+1;

return x;
}
treenode *LR(treenode *z)
{
z->left=RR(z->left);
return LL(z);
}
treenode *RL(treenode *z)
{
z->right=LL(z->right);
return RR(z);
}

treenode *balance(treenode *root1)
{
treenode *temp=root1;
int bf=0,bf1=0;
bf=height(root1->left)-height(root1->right);
if(bf>1)
{
bf1=height(root1->left->left)-height(root1->left->right);
if(bf1>1)
temp=LL(root1);
else
temp=LR(root1);
}
else if(bf<-1)
{
bf1=height(root1->right->left)-height(root1->right->right);
if(bf1>1)
temp=RL(root1);
else
temp=RR(root1);
}

return temp;}
treenode *insert(treenode *root1,int info)
{
if(root1==NULL)
{
root1=new treenode();
root1->info=info;

//cout<<root1->left->info;
}
else
{
if(info<root1->info)
{
//root1->left=NULL;
root1->left=insert(root1->left,info);
root1=balance(root1);
}
else
//root1->right=NULL;
{root1->right=insert(root1->right,info);
root1=balance(root1);
}
if(root1->right->height>root1->left->height && root1->right!=NULL)
root1->height=root1->right->height+1;
else
if(root1->left!=NULL)
root1->height=root1->left->height+1;
}
return root1;}

void displayinorder(treenode *root1)
{
if(root1->left!=NULL)
{displayinorder(root1->left);
}
cout<<root1->info;
if(root1->right!=NULL)
{displayinorder(root1->right);
}
}
void main()
{
clrscr();
treenode *root2=new treenode();
int n,b;
cin>>n;
for(int i=0;i<n;i++)
{
cin>>b;
if(i==0)
root2->info=b;
else
{root2=insert(root2,b);
}
}
displayinorder(root2);
/*int c;
//cout<<"ENter No.";
//cin>>c;
//a->inordersuccessor(root2,c);
a->displayinorder(root2);
cout<<endl;
a->displaypostorder(root2);
*/


getch();
}