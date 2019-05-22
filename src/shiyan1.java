import java.util.*;
	class Student{         
		String name;//学生姓名
		String num;//学生学号
		Student(){}
		Student(String name,String num){
			this.name=name;
			this.num=num;
		}
		void printInfo(){
			System.out.println("姓名:"+name);
			System.out.print("学号:"+num+"\t");
		}
	}  //学生类
	class Course {   
		String Coursename;//课程名字
		String number;//课程编号
		Course(){}
		Course(String Coursename,String number){
			this.Coursename=Coursename;
			this.number=number;
		}
		void printInfo(){
			System.out.print("课程名字:"+Coursename+"\t");
			System.out.println("课程编号:"+number);
		}
	}  //课程类
	class Grade  {    
		String num;//学生学号
		String number;//课程编号
		int grade;//成绩
		Grade(){}
		Grade(String num,String number,int grade){
			this.num=num;
			this.number=number;
			this.grade=grade;
		}
		void printInfo(){
			System.out.println("学号:"+num);
			System.out.println("课程编号:"+number);
			System.out.println("成绩:"+grade);
		}
	}  //成绩类
public class shiyan1 {
		public static void main (String[] args) {
			//1--实例化几个学生对象并在泛型集合对象中保存学生的信息
			Student s1= new Student("郑东红","S001");
			Student s2= new Student("陈明丽","S002");
			Student s3= new Student("黄文杰","S003");
			ArrayList<Student> stu=new ArrayList<Student>();//建立学生列表并添加学生数据
			stu.add(s1);
			stu.add(s2);
			stu.add(s3);
			//2--实例化几个课程对象并在泛型集合对象中保存课程的信息
			Course c1=new Course("嵌入式编程原理","C001");
			Course c2=new Course("计算机专业英语","C002");
			Course c3=new Course("微机接口与技术","C003");
			ArrayList<Course> cou=new ArrayList<Course>();//建立课程列表并添加课程数据
			cou.add(c1);
			cou.add(c2);
			cou.add(c3);
			//3--实例化几个成绩对象并在泛型集合对象中保存成绩的信息
			Grade g1=new Grade("S001","C001",76);
			Grade g2=new Grade("S001","C002",90);
			Grade g3=new Grade("S001","C003",67);
			Grade g4=new Grade("S002","C001",82);
			Grade g5=new Grade("S002","C002",73);
			Grade g6=new Grade("S002","C003",85);
			Grade g7=new Grade("S003","C001",92);
			Grade g8=new Grade("S003","C002",81);
			Grade g9=new Grade("S003","C003",83);
			ArrayList<Grade> gra=new ArrayList<Grade>();//添加成绩列表并添加成绩数据
			gra.add(g1);
			gra.add(g2);
			gra.add(g3);
			gra.add(g4);
			gra.add(g5);
			gra.add(g6);
			gra.add(g7);
			gra.add(g8);
			gra.add(g9);
			//4--根据成绩泛型集合中的学号和课程编号查询学生集合和课程集
			  //合得到学生姓名和课程名称
			System.out.println("学号\t\t"+" 姓名\t\t     "+"课程编号\t     "+"课程名陈\t       "+"成绩");
			for(Grade g: gra){
				for(Student s:stu){
					if(g.num.equals(s.num)){
						//若找到了，则输出学号和姓名
						System.out.print (g.num+"\t\t"+s.name+"\t\t");
						break;
					}
			}
				for(Course c:cou){
					if(g.number.equals(c.number)){
						//若找到了，则输出课程名字和成绩
						System.out.println(g.number+"\t\t"+c.Coursename+"\t\t"+g.grade);
						break;
					}
				}
			}
			//5---输出每个学生各科的成绩
			System.out.println("\n=====================================================================\n");//分界线
			//6--统计每课参加考试的人数和总分
			int[] count=new int[cou.size()];  //保存各科参考人数
			int[] sums=new int[cou.size()];  //保存各科成绩总分
			//统计学生人数和总分
			for(int i=0;i<cou.size();i++){
				for(int j=0;j<gra.size();j++){
					if(cou.get(i).number.equals(gra.get(j).number)){
						count[i]++; //参考人数+1
						//累计求和
						sums[i]=sums[i]+gra.get(j).grade; 
					}
				}
			}
			//7--计算并保存每门课程的平均分
			TreeMap<String,Integer> total=new TreeMap<String,Integer>();			//计算平均分			
			for(int i=0;i<cou.size();i++){
				if(count[i]>0){
					//计算平均分
					sums[i]=sums[i]/count[i]; 
					//保存到集合中
					total.put(cou.get(i).number,sums[i]);
				}
			}
			//8--打印各科平均分
			System.out.println("课程编号\t\t     "+"课程名字\t\t    "+"平均分");
			int i=0;
			for(Course c:cou){
				System.out.println(c.number+"\t\t"+c.Coursename+"\t\t"+sums[i]);
				++i;
			}
		}
		}
