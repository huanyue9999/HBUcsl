#include <iostream>
#include <string.h>
#include <fstream>
#include <algorithm>
using namespace std;

int sizer;
typedef struct 
{
	int data;
	int t;
	int first;
}Node;

typedef struct 
{
	string name;		//地点名称 
	int a[101];   //地点数组 

}Position;

void initdata(Position *P)	//从文件读入学校各地点间的信息
{
	ifstream f1("a.in");
	int i=1,j;
	
	f1>>sizer;
	for(i=1;i<=sizer;i++)
	f1>>P[i].name;
	

	
	for(i=1;i<=sizer;i++)
	{
		for(j=1;j<=sizer;j++)
		{
			f1>>P[i].a[j];
		}
	}
}
void savedata(Position *P)	//保存信息
{
	string b;
	int i,j;
	ofstream fout("a.in");
	fout<<sizer<<endl;
	for(i=1;i<=sizer;i++)
	{
		if(i==0)
		fout<<endl;
		
		fout<<P[i].name<<' ';
	}
	fout<<endl;
	for(i=1;i<=sizer;i++)
	{
		for(j=1;j<=sizer;j++)
		{
			fout<<P[i].a[j]<<' ';
			
		}
		fout<<endl; 
	}
	fout.close();
}

//下面建立主菜单界面
int Menu()
{
 int command;
 cout<<"————————————————————————————————————————"<<endl;
 cout<<"————————————————————————————————————————"<<endl;
 cout<<"||                                                                          ||"<<endl;
 cout<<"||                                                                           ||"<<endl;
 cout<<"||              .............................................               ||"<<endl;
 cout<<"||             ...............................................               ||"<<endl;
 cout<<"||                                                                          ||"<<endl;
 cout<<"||           ..       欢迎使用河北大学七一路校区校园导航系统    ..         ||"<<endl;
 cout<<"||                                                                          ||"<<endl;
 cout<<"||             ...............................................               ||"<<endl;
 cout<<"||              .............................................               ||"<<endl;
 cout<<"||                                                                           ||"<<endl;
 cout<<"||             请选择您登录系统的身份:（提示：初始账号密码均为0）           ||"<<endl;
 cout<<"||                                                                           ||"<<endl;
 cout<<"||                           0 退 出 系统                                   ||"<<endl;
 cout<<"||                                                                           ||"<<endl;
 cout<<"||                           1 管 理 员 系统                                ||"<<endl;
 cout<<"||                                                                           ||"<<endl;
 cout<<"||                           2 普 通 游 客 系统                             ||"<<endl;
 cout<<"||                                                                           ||"<<endl;
 cout<<"————————————————————————————————————————"<<endl;
 cout<<"————————————————————————————————————————"<<endl;
 cout<<"请选择你要进行的操作..."<<endl;
 while(cin>>command,command<0||command>2)
 {
  cout<<"   输入错误！！！"<<endl;
  cout<<"   请重新输入：";  
 }
 return command;
}



int display_1()//管理员界面
{
    int command;
   cout<<"————————————————————————————————————————"<<endl;
   cout<<"————————————————————————————————————————"<<endl;
   cout<<"||                                                                           ||"<<endl;
   cout<<"||                                                                           ||"<<endl;
   cout<<"||              .............................................               ||"<<endl;
   cout<<"||             ...............................................               ||"<<endl;
   cout<<"||                                                                          ||"<<endl;
   cout<<"||             ..           欢迎使用校园导航系统          ..                 ||"<<endl;
   cout<<"||                                                                          ||"<<endl;
   cout<<"||             ...............................................               ||"<<endl;
   cout<<"||              .............................................               ||"<<endl;
   cout<<"||                                                                           ||"<<endl;
   cout<<"||                   管理员系统说明：本系统可实现如下功能:                  ||"<<endl;
   cout<<"||                          0 返  回  主 菜 单                               ||"<<endl;
   cout<<"||                          1 搜索位置相关信息                             ||"<<endl;
   cout<<"||                          2 录  入  路 径 (已初始化、可按a.txt文件录入)    ||"<<endl;
   cout<<"||                          3 添  加  路 径                                 ||"<<endl;
   cout<<"||                          4 删  除  路 径                                  ||"<<endl;
   cout<<"||                          5 修  改  路 径                                 ||"<<endl;
   cout<<"||                          6 显  示  路 径                                  ||"<<endl;
   cout<<"||                          7 查 询 两 点 间 最 短 路径                     ||"<<endl;
   cout<<"||                                                                           ||"<<endl;
   cout<<"————————————————————————————————————————"<<endl;
   cout<<"————————————————————————————————————————"<<endl;
   cout<<"请选择您要进行的操作..."<<endl;
   while(cin>>command,command<0||command>7)
 	{
 		cout<<"   输入错误！！！"<<endl;
 		cout<<"   请重新输入：";
 	}
 	return command;
}

int display_2()//普通用户界面
{
 int command;
   cout<<"————————————————————————————————————————"<<endl;
   cout<<"————————————————————————————————————————"<<endl;
   cout<<"||                                                                           ||"<<endl;
   cout<<"||              .............................................               ||"<<endl;
   cout<<"||             ...............................................               ||"<<endl;
   cout<<"||                                                                          ||"<<endl;
   cout<<"||             ..           欢迎使用校园导航系统          ..                 ||"<<endl;
   cout<<"||                                                                          ||"<<endl;
   cout<<"||             ...............................................               ||"<<endl;
   cout<<"||              .............................................               ||"<<endl;
   cout<<"||                                                                           ||"<<endl;
   cout<<"||                 普通用户系统说明：您可以实现如下功能:                    ||"<<endl;
   cout<<"||                                                                           ||"<<endl;
   cout<<"||                           0 返 回 主 菜单                               ||"<<endl;
   cout<<"||                                                                           ||"<<endl;
   cout<<"||                           1 搜索位置相关信息                             ||"<<endl;
   cout<<"||                                                                           ||"<<endl;
   cout<<"||                           2 两 点 最 短 路径                            ||"<<endl;
   cout<<"||                                                                           ||"<<endl;
   cout<<"————————————————————————————————————————"<<endl;
   cout<<"————————————————————————————————————————"<<endl;
   cout<<"请选择您要进行的操作..."<<endl;
 	while(cin>>command,command<0||command>2)
 	{
 		cout<<"   输入错误！！！"<<endl;
 		cout<<"   请重新输入：";
	}
	return command;
}

void look_up_the_map(Position *P)       //////浏览平面图
{
	int i,j;
	initdata(P);
	if(sizer==0)
	{
		cout<<endl;
		cout<<" 暂时还没有录入信息，请按回车键返回！"<<endl;
		getchar();
		getchar();
	
	}
	
	else
	{
		cout<<"当前河北大学七一路校区录入地点数量："<<sizer<<" 个"<<endl;
	
		cout<<endl;
		cout<<"地点简介：" <<endl;

		for(int i=1;i<=sizer;i++) 
		{
			cout<<i<<"："<<P[i].name<<endl;
		}
		
				int com;
				int i;
				string s1; 
		cout<<"请选择您要查看位置信息的序号："<<endl; 
		cin>>i;
		s1 = P[i].name;
		cout<<endl<<endl; 
		if(!s1.compare("体检中心")) 
		cout<<"      *****体检中心为河北大学学校师生提供健康检查"<<endl;
		else if(!s1.compare("操场"))
		cout<<"      *****操场是全校师生体育锻炼的主要场所"<<endl;
		
		else if(!s1.compare("邯郸音乐厅"))
		cout<<"         *****邯郸音乐厅是我校大型活动的场所"<<endl;
    	else if(!s1.compare("网计学院"))
    	cout<<"          *****网络空间安全与计算机学院"<<endl;
    	else if(!s1.compare("信息学部"))
    	cout<<"       *****信息学部为学生提供大量实践机会"<<endl;
        else if(!s1.compare("图书馆"))
        cout<<"            *****图书馆内有的大量丰富的藏书"<<endl;
        else if(!s1.compare("花园景观"))
        cout<<"           *****花园景观为生活区一大特色"<<endl;
        else if(!s1.compare("校门南口"))
        cout<<"             *****河北大学七一路校区校门南口"<<endl;
        else if(!s1.compare("校门北口"))
        cout<<"              *****河北大学七一路校区校门北口"<<endl;
        else if(!s1.compare("校门东口"))
        cout<<"               *****河北大学七一路校区校门东口"<<endl;
        else if(!s1.compare("餐厅"))
        cout<<"     *****餐厅每天为学生提供优质的饭菜"<<endl;
        else if(!s1.compare("银杏景观"))
        cout<<"     *****秋天的银杏景观非常漂亮"<<endl;

        else
        cout<<"暂未更新相关信息"<<endl;
        
		if(i>0&&i<=sizer)
		{
			cout<<endl<<endl;
		
			cout<<"与"<<P[i].name<<"直接相邻的有：" ;
			for(j=1;j<=sizer;j++)
			{
				if(P[i].a[j]!=0) 
				cout<<P[j].name<<' ';
				
			}
			cout<<endl<<endl;
		}
		
	}
	cout<<" 返 回 上 级 菜 单 请 按 回 车 键：";
    getchar();getchar();
}
void fill_the_data(Position *P)        /////////重新录入路径
{
	int k,i,j;
	cout<<"请输入该次录入地点的数量：";
	cin>>k;
	
	sizer = k;
	for(i=1;i<=k;i++)
	{
		cout<<" 请录入第"<<i<<"个地点名：";
		cin>>P[i].name;
		cout<<endl;
		 
	}
	cout<<"请以邻接矩阵的形式输入地点两两之间的距离，第i行第j列代表i地点与j地点之间的距离:"<<endl;
	for(i=1;i<=k;i++)
	{
		for(j=1;j<=k;j++)
		{
			cin>>P[i].a[j];
		}
	}
	savedata(P);
	cout<<"        录 入 成 功！！！"<<endl;
 	cout<<" 返 回 上 级 菜 单 请 按 回 车 键：";
	getchar();getchar();
}


void add_the_data(Position *P)         ////////添加函数
{
	int i;
	initdata(P);
	if(sizer == 0)
	{
		cout<<endl;
		cout<<" 暂时还没有录入信息，请按回车键返回！"<<endl;
		getchar();getchar();
	}
	else
	{
		cout<<"请输入你需要增加的地点名：";
		cin>>P[sizer+1].name;
		cout<<"请按顺序输入该地点与其他地点之间的距离"<<endl; 
		
		for(i= 1;i<=sizer;i++)
		{
			cout<<"请输入该点到"<<P[i].name<<"的距离：";
			cin>>P[sizer+1].a[i];
			P[i].a[sizer+1] = P[sizer+1].a[i];
		}
		sizer++;
		P[i].a[sizer] = 0;
		savedata(P);
		cout<<"        添 加 成 功！！！"<<endl;
	}
	cout<<" 返 回 上 级 菜 单 请 按 回 车 键：" ;
	getchar();
	getchar();
}
void delete_the_data(Position *P)   ////////////删除函数
{
	string name;
	int i,j,k;
	initdata(P);
	if(sizer==0)
	{
		cout<<endl;
		cout<<" 暂时还没有录入信息，请按回车键返回！"<<endl;
		getchar();
		getchar();
	
	}
	else
	{
		cout<<"请输入你要删除的地点名字：";
		cin>>name;
		for(i=1;i<=sizer;i++)
		{
			if(P[i].name == name)
			break;
		}
		if(i>sizer)
		cout<<"    输 入 错 误，该 学 校 地 图 信 息 中 没 有 该 地 点！";
		
		else
		{
			for(j=i;j<sizer;j++)
			{
				P[j] = P[j+1];
				
			}
			sizer--;
			for(k=1;k<=sizer;k++)
			{
				for(j=i;j<=sizer;j++)
				{
					P[k].a[j] = P[k].a[j+1];
				}
				
				
			}
			savedata(P);
			
			cout<<"        删 除 成 功！！！"<<endl;
		}
	}
	cout<<" 返 回 上 级 菜 单 请 按 回 车 键：";
	getchar();getchar();
}

void change_the_data(Position *P)           //////修改函数
{
	string name;
	int i,j,command;
	initdata(P);
	if(sizer==0)
	{
		cout<<endl;
		cout<<" 暂时还没有录入信息，请按回车键返回！"<<endl;
		getchar();
		getchar();
	
	}
	
	else
	{
				cout<<"     1.修改某点到其他各点间距离"<<endl<<endl;
		cout<<"     2.修改地点名"<<endl<<endl;
		cout<<"请选择您要修改的对象的序号："; 
		cin>>command;
		 

		
		while(command<1||command>2)
		{
			cout<<"输入错误！！！"<<endl;
			cout<<"请重新输入：";
			cin>>command;
		}
		
		if(command==1)
		{
			cout<<"请输入您要修改路径的地点名字：";
			cin>>name;
			
			cout<<endl;
			
			for(i=1;i<=sizer;i++)
			{
				if(P[i].name==name)
				break;
			}
			if(i>sizer)
			cout<<"    输 入 错 误，该 学 校 地 图 信 息 中 没 有 该 地 点！";
			
			else
			{
				cout<<"请重新输入该点到其他点之间的距离：";
				
				for(j=1;j<=sizer;j++)
				{
					cout<<name<<"到"<<P[j].name<<"的新距离：";
					cin>>P[i].a[j];
					P[j].a[i] = P[i].a[j];
				}
				savedata(P);
				cout<<"        修 改 成 功！！！"<<endl;
			}
		}
		else
		{
	 		cout<<"请输入你要修改的地点名：";
			cin>>name;
				
			cout<<endl;
			for(i=1;i<=sizer;i++)
			{
				if(P[i].name==name)
				break;
			
			}
			if(i>sizer)
			cout<<"    输 入 错 误，该 学 校 地 图 信 息 中 没 有 该 地 点！";
					
			else
			{
				cout<<"请重新输入该地点名字：";
				cin>>P[i].name;
				savedata(P);
				cout<<"        修 改 成 功！！！"<<endl;
			}
		}
	}
	
	cout<<" 返 回 上 级 菜 单 请 按 回 车 键：";
 	getchar();
	getchar();
}
void print_the_data(Position *P)           ///////显示校园各地点信息
{
	int i,j;
	initdata(P);
	if(sizer==0)
	{
		cout<<endl;
		cout<<" 暂时还没有录入信息，请按回车键返回！"<<endl;
		getchar();
		getchar();
	
	}
	
	else
	{
		cout<<"已录入地点数量："<<sizer<<" 个"<<endl;
		cout<<"所有地点名如下：";
		
		for(i=1;i<=sizer;i++)
		{
			if(i==0)
			cout<<endl;
			
			cout<<P[i].name<<' ';
		}
		cout<<endl;
		for(i=1;i<=sizer;i++)
		{
			for(j=1;j<=sizer;j++)
			{
				cout<<P[i].a[j]<<' ';
				
			}
			cout<<endl;
		}
	}
	cout<<" 返 回 上 级 菜 单 请 按 回 车 键：";
    getchar();getchar();
}

void f(int n,int i,Position *P,Node *c)      ////递归输出最佳路径
{
	if(i==n)
	{
		cout<<P[i].name<<" ";
		return ;
		
	}
	
	f(n,c[i].first,P,c);
	cout<<P[i].name<<" ";
}

int fun(Node c[])                   //////寻找最小值
{
	int min=9999,i,k=-1;
	for(i=1;i<sizer;i++)
	{
		if(c[i].t==1&&c[i].data<min)
		{
			min=c[i].data;
			k=i;
		}
		
	}
	return k;
}
void compute_distance(Position *P)   ///////求最短路径
{
	initdata(P);
	string name1,name2;
	
	int i,j,n,max=9999,k;
	Node c[101];
	for(i=1;i<=sizer;i++)
	{
		c[i].data = max;
		c[i].t = 1;
		
	}
	
	cout<<"请输入你要查询的起始位置：";
	cin>>name1;
	cout<<"请输入你要查询的终点位置：";
	cin>>name2;
	
	for(i=1;i<=sizer;i++)
	{
		if(P[i].name == name1)
		{
			n=i;
			c[i].t=  0;
			c[i].first = n;
			break;
			
		}
	}
	
	if(i>sizer)
	cout<<"    输 入 错 误，该 学 校 地 图 信 息 中 没 有 该 地 点！";
	
	else
	{
		for(j=1;j<=sizer;j++)
		{
			if(P[i].a[j]!=0)
			{
				c[j].data = P[i].a[j];
				c[j].first = i;
			}
		}
		
		int pp=0;
		while(1)
		{
			k=fun(c);
			if(k==-1)
			break;
			
			c[k].t = 0;
			for(i=1;i<=sizer;i++)
			{
				if(P[k].a[i]!=0&&(P[k].a[i]+c[k].data<c[i].data))
				{
					c[i].data = P[k].a[i]+c[k].data;
					c[i].first = k;
				}
			}
		}
		
		for(i=1;i<=sizer;i++)
		{
			if(P[i].name == name2)
			{
				cout<<name1<<"到"<<name2<<"最短路径依次经过的地点为: ";
				f(n,i,P,c);
				
				cout<<endl;
				cout<<"路径距离位：";
				if(c[i].data == 9999)
				cout<<'0'<<endl;
				
				else
				cout<<c[i].data<<endl;
				break; 
			}
		}
		
	}
	cout<<" 返 回 上 级 菜 单 请 按 回 车 键：";
    getchar();getchar();
		
}
int main()
{
    int command,t1,t2;
    string zh,mm;
    Position *P=new Position[101];
   // system("color 2b");
    while(1)
    {
        command=Menu();
 		if(command==1)
  		{
  			 while(1)
  			{
   				cout<<"请输入账号："<<endl;cin>>zh;
 				cout<<"请输入密码："<<endl;cin>>mm;
    			if(zh=="0"&&mm=="0") break;
   				 else cout<<"账号或密码错误，请重新输入..."<<endl;
   			}
   		system("cls");
  		t1=0;
  		while(t1==0)
 		{
   			command=display_1();
   			switch(command)
 			{
  				case 0:t1=1;break;
    			case 1:look_up_the_map(P);system("cls");break;
  				case 2:fill_the_data(P);system("cls");break;
   				case 3:add_the_data(P);system("cls");break;
   				case 4:delete_the_data(P);system("cls");break;
   				case 5:change_the_data(P);system("cls");break;
    			case 6:print_the_data(P);system("cls");break;
    			case 7:compute_distance(P);system("cls");break;
  	 		}	
  		}
   
 		}
  		else if(command==2)
  		{
  			 while(1)
  			 {
   			 cout<<"请输入账号："<<endl;cin>>zh;
   			 cout<<"请输入密码："<<endl;cin>>mm;
    		if(zh=="0"&&mm=="0") break;
   			 else cout<<"账号或密码错误，请重新输入..."<<endl;
   			}
           system("cls");
   			t2=0;
   			
   			while(t2==0)
  			 {
  		 		command=display_2();
  			  	switch(command)
   				{
   				case 0:t2=1;break;
    			case 1:look_up_the_map(P);system("cls");break;
   				case 2:compute_distance(P);system("cls");break;
 				}
  			 }
   
  		}
  		
    else break;
	}
}









