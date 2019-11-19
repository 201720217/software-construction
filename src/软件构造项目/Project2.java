package ���������Ŀ;

import java.util.Random;

public class Project2 {
	public static void main(String[] args) {
		short[] x = new short[50];  
		short[] y = new short[50];	 
		short[] ov = new short[50];                               //�½����������ʽ���Ŵ�������
		printHeader();                                            //��˵���������������
		generateEquations(x,y,ov);                                //�����ӷ��������ʽ����������x[i],y[i],ov[i]
		printExercise(x,y,ov);                                    //����Ҫ���ӡ�����ʽ
		printCalculations(x,y,ov);                                //������ʽ���������Ҫ���ӡ���
	}
	public static void printHeader() {
		System.out.println("-----------------------------------------");
		System.out.println("-���������50��100���ڵļӼ�����ʽ-");
		System.out.println("-ÿ�����г���ɵõ�һ��50�������ʽ�Ĵ�-");
		System.out.println("-----------------------------------------");
	}
	public static void generateEquations(short[] x,short[] y,short[] ov) {
		Random random=new Random();
		for(int i=0;i<50;i++) {
			ov[i]=(short)random.nextInt(2);
			if((ov[i])==1) {
				while(true){
					short index1=(short)random.nextInt(101);
					short index2=(short)random.nextInt(101);
					if(index1+index2<=100) {
						x[i]=index1;
						y[i]=index2;
						break;                                              //�涨��ʽ�ĺͲ��ܳ���һ��
					}	
				}
			
			}
			else {
				while(true){
					short index1=(short)random.nextInt(101);
					short index2=(short)random.nextInt(101);
					if(index1-index2>0) {
						x[i]=index1;
						y[i]=index2;
						break;                                             //�涨��ʽ�Ĳ��С����
					}	
				}	
			}
			for(int m=0;m<49;m++) {
				for(int n=m+1;n<50;n++) {
					if(x[m]==x[n]&&y[m]==y[n]&&ov[m]==ov[n]||ov[m]==1&&x[m]==y[n]&&y[m]==x[n]) {
						x[m]=(short)random.nextInt(101);
						y[m]=(short)random.nextInt(101);
						ov[m]=(short)random.nextInt(2);
						m=0;
						break;
					}
				}	
			}                                                                //�ж�������ʽ�Ƿ��ظ�
		}
	}                                 
   public static void printExercise(short[] x,short[] y,short[] ov) {
	for(int i=0;i<50;i++) {
		if(ov[i]==1) {
			System.out.print("("+(i+1)+")"+":  "+x[i]+'+'+y[i]+"="+"\t");
		}
		else {
			System.out.print("("+(i+1)+")"+":  "+x[i]+'-'+y[i]+"="+"\t");
		}
		if((i+1)%5==0)
			System.out.println();
	   }
   }                                                                       //�����ɵ���ʽ����һ����Ҫ���ӡ���
	
	
	
	
	public static void printCalculations(short[] x,short[] y,short[] ov) {
		System.out.println("-----------------------------------------");
		System.out.println("-��������ʽ�Ĳο���-");
		System.out.println("-----------------------------------------");
		for(int i=0;i<50;i++) {
			if(ov[i]==1) {
				int answer=x[i]+y[i];
				System.out.print("("+(i+1)+")"+":   "+answer+"\t");
				if((i+1)%5==0) {
					System.out.println();
				}		
			}
			else {
				int answer=x[i]-y[i];
				System.out.print("("+(i+1)+")"+":   "+answer+"\t");
				if((i+1)%5==0) {
					System.out.println();                                //����Ҫ���ӡ�����ʽ�Ĵ�
				}	
			}
		}
	}
}

