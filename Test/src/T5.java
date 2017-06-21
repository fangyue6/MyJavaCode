import java.util.ArrayList;
import java.util.List;


public class T5 {

	public static void main(String[] args) {
		Member m1 =new Member("张三","JAVA工程师",9000);
		Member m2 =new Member("李四","C++工程师",8000);
		Member m3 =new Member("王五","大数据开发工程师",10000);
		List<Member> li =new ArrayList<Member>();
		li.add(m1);
		li.add(m2);
		li.add(m3);
		int temp=0;
		int maxIndex=0;
		for(int i=0;i<li.size();i++){
			if(li.get(i).getSalary()>=temp){
				temp=li.get(i).getSalary();
				maxIndex=i;
			}
		}
		System.out.println(li.get(maxIndex).getJob());

	}

}
