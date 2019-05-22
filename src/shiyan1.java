import java.util.*;
	class Student{         
		String name;//ѧ������
		String num;//ѧ��ѧ��
		Student(){}
		Student(String name,String num){
			this.name=name;
			this.num=num;
		}
		void printInfo(){
			System.out.println("����:"+name);
			System.out.print("ѧ��:"+num+"\t");
		}
	}  //ѧ����
	class Course {   
		String Coursename;//�γ�����
		String number;//�γ̱��
		Course(){}
		Course(String Coursename,String number){
			this.Coursename=Coursename;
			this.number=number;
		}
		void printInfo(){
			System.out.print("�γ�����:"+Coursename+"\t");
			System.out.println("�γ̱��:"+number);
		}
	}  //�γ���
	class Grade  {    
		String num;//ѧ��ѧ��
		String number;//�γ̱��
		int grade;//�ɼ�
		Grade(){}
		Grade(String num,String number,int grade){
			this.num=num;
			this.number=number;
			this.grade=grade;
		}
		void printInfo(){
			System.out.println("ѧ��:"+num);
			System.out.println("�γ̱��:"+number);
			System.out.println("�ɼ�:"+grade);
		}
	}  //�ɼ���
public class shiyan1 {
		public static void main (String[] args) {
			//1--ʵ��������ѧ�������ڷ��ͼ��϶����б���ѧ������Ϣ
			Student s1= new Student("֣����","S001");
			Student s2= new Student("������","S002");
			Student s3= new Student("���Ľ�","S003");
			ArrayList<Student> stu=new ArrayList<Student>();//����ѧ���б����ѧ������
			stu.add(s1);
			stu.add(s2);
			stu.add(s3);
			//2--ʵ���������γ̶����ڷ��ͼ��϶����б���γ̵���Ϣ
			Course c1=new Course("Ƕ��ʽ���ԭ��","C001");
			Course c2=new Course("�����רҵӢ��","C002");
			Course c3=new Course("΢���ӿ��뼼��","C003");
			ArrayList<Course> cou=new ArrayList<Course>();//�����γ��б���ӿγ�����
			cou.add(c1);
			cou.add(c2);
			cou.add(c3);
			//3--ʵ���������ɼ������ڷ��ͼ��϶����б���ɼ�����Ϣ
			Grade g1=new Grade("S001","C001",76);
			Grade g2=new Grade("S001","C002",90);
			Grade g3=new Grade("S001","C003",67);
			Grade g4=new Grade("S002","C001",82);
			Grade g5=new Grade("S002","C002",73);
			Grade g6=new Grade("S002","C003",85);
			Grade g7=new Grade("S003","C001",92);
			Grade g8=new Grade("S003","C002",81);
			Grade g9=new Grade("S003","C003",83);
			ArrayList<Grade> gra=new ArrayList<Grade>();//��ӳɼ��б���ӳɼ�����
			gra.add(g1);
			gra.add(g2);
			gra.add(g3);
			gra.add(g4);
			gra.add(g5);
			gra.add(g6);
			gra.add(g7);
			gra.add(g8);
			gra.add(g9);
			//4--���ݳɼ����ͼ����е�ѧ�źͿγ̱�Ų�ѯѧ�����ϺͿγ̼�
			  //�ϵõ�ѧ�������Ϳγ�����
			System.out.println("ѧ��\t\t"+" ����\t\t     "+"�γ̱��\t     "+"�γ�����\t       "+"�ɼ�");
			for(Grade g: gra){
				for(Student s:stu){
					if(g.num.equals(s.num)){
						//���ҵ��ˣ������ѧ�ź�����
						System.out.print (g.num+"\t\t"+s.name+"\t\t");
						break;
					}
			}
				for(Course c:cou){
					if(g.number.equals(c.number)){
						//���ҵ��ˣ�������γ����ֺͳɼ�
						System.out.println(g.number+"\t\t"+c.Coursename+"\t\t"+g.grade);
						break;
					}
				}
			}
			//5---���ÿ��ѧ�����Ƶĳɼ�
			System.out.println("\n=====================================================================\n");//�ֽ���
			//6--ͳ��ÿ�βμӿ��Ե��������ܷ�
			int[] count=new int[cou.size()];  //������Ʋο�����
			int[] sums=new int[cou.size()];  //������Ƴɼ��ܷ�
			//ͳ��ѧ���������ܷ�
			for(int i=0;i<cou.size();i++){
				for(int j=0;j<gra.size();j++){
					if(cou.get(i).number.equals(gra.get(j).number)){
						count[i]++; //�ο�����+1
						//�ۼ����
						sums[i]=sums[i]+gra.get(j).grade; 
					}
				}
			}
			//7--���㲢����ÿ�ſγ̵�ƽ����
			TreeMap<String,Integer> total=new TreeMap<String,Integer>();			//����ƽ����			
			for(int i=0;i<cou.size();i++){
				if(count[i]>0){
					//����ƽ����
					sums[i]=sums[i]/count[i]; 
					//���浽������
					total.put(cou.get(i).number,sums[i]);
				}
			}
			//8--��ӡ����ƽ����
			System.out.println("�γ̱��\t\t     "+"�γ�����\t\t    "+"ƽ����");
			int i=0;
			for(Course c:cou){
				System.out.println(c.number+"\t\t"+c.Coursename+"\t\t"+sums[i]);
				++i;
			}
		}
		}
