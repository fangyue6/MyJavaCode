import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.regex.*;

import javax.swing.JOptionPane;

public class Detaction {
	
	public static void main(String[] args) {
    	 new FileWindows();
    	 
	}
}

@SuppressWarnings("serial")
class FileWindows extends Frame implements ActionListener {

	float similarity;
    String SFname = "";
    String TFname = "";
	FileDialog file_open;
	DirPanel dirPanel;
	MainPanel mainPanel;
	Button taButton;

	FileWindows(){
		super("文档检测系统");
		setLocation(300, 50);
		setSize(600,700);
		dirPanel = new DirPanel();
		mainPanel = new MainPanel();
		taButton = new Button("开始检测");
		
		taButton.addActionListener(this);
		dirPanel.SFbutton.addActionListener(this);
		dirPanel.TFbutton.addActionListener(this);
		add(dirPanel,BorderLayout.NORTH);
		add(mainPanel,BorderLayout.CENTER);
		add(taButton,BorderLayout.SOUTH);
		setResizable(false);
		setBackground(Color.GRAY);
		setVisible(true);
		validate();
		
		addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		file_open = new FileDialog(this,"打开文件对话框",FileDialog.LOAD);
		file_open.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
				file_open.setVisible(false);
			}
		});
		
	}

public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==dirPanel.SFbutton){
		file_open.setVisible(true);
		SFname = file_open.getDirectory()+file_open.getFile();
		dirPanel.SFdir.setText(SFname);

}
	else if(e.getSource()==dirPanel.TFbutton){
		file_open.setVisible(true);
		TFname = file_open.getDirectory();
		dirPanel.TFdir.setText(file_open.getDirectory());
	}
	else if(e.getSource()==taButton){
		try{
			File sf = new File(dirPanel.SFdir.getText());
			File tf = new File(dirPanel.TFdir.getText());
			File[] tFiles = tf.listFiles();
		
			mainPanel.ta1.setText("");
			mainPanel.ta2.setText("");
			mainPanel.ta3.setText("");
		
		File temp;
		for(int i=0;i<tFiles.length;i++){
			parse(sf,tFiles[i]);

		}
		for(int i=0;i<tFiles.length-1;i++){
			for(int j=i+1;j<tFiles.length;j++){
				if(parse(sf,tFiles[i])<parse(sf, tFiles[j])){
					temp = tFiles[i];
					tFiles[i] = tFiles[j];
					tFiles[j] = temp;
				}
			}
		}
		
		
		for(int i=0;i<tFiles.length;i++){
			if(parse(sf,tFiles[i])>=80&&parse(sf,tFiles[i])<=100){
				mainPanel.ta1.append("\n"+"检测原文档 与 "+tFiles[i].getName()+" 的相似度："+parse(sf,tFiles[i])+"%");
			}else if(parse(sf,tFiles[i])>=50&&parse(sf,tFiles[i])<80){
				mainPanel.ta2.append("\n"+"检测原文档 与 "+tFiles[i].getName()+" 的相似度："+parse(sf,tFiles[i])+"%");
			}else{
				mainPanel.ta3.append("\n"+"检测原文档 与 "+tFiles[i].getName()+" 的相似度："+parse(sf,tFiles[i])+"%");
				}
	}	
		}catch(NullPointerException e1){
//			ta.append("请选择文档");
			JOptionPane.showMessageDialog(this, "请选择文档","提示对话框",JOptionPane.ERROR_MESSAGE);
//			e1.printStackTrace();
		}
	
	}
}



public float parse(File sf,File tf) {
	int TRUE = 0;
	BufferedReader br = null;
	String[] sSplit = null;
	String[] tSplit = null;
	String s ="";
	String sStr = "";
	String tStr = "";
	Pattern p = null ;
	List<Pattern> Patterns = new ArrayList<Pattern>();
	
	try {
		br = new BufferedReader(new FileReader(sf));
		while((s = br.readLine())!=null){
			s = s.trim();
			sStr =sStr + s;
		}
		
		sSplit= sStr.split("[。？！.?!]");
		for(int i=0;i<sSplit.length;i++){
//			System.out.println(sSplit[i]);
			p = Pattern.compile(sSplit[i]);
			Patterns.add(p);
		}
		
			
			br = new BufferedReader(new FileReader(tf));
			while((s = br.readLine())!=null){
				s = s.trim();
				tStr =tStr + s;
			}
			
			tSplit= tStr.split("[。？！.?!]");
			for(int j=0;j<Patterns.size();j++)
			for(int i=0;i<tSplit.length;i++){
				
				p = Patterns.get(j);
				Matcher m = p.matcher(tSplit[i]);
//				System.out.println(m.matches());
				if(m.matches()){
					TRUE++;
					/*System.out.println("");
					System.out.println("相同语句：");
					System.out.println(sSplit[i]);*/
				}
		}
		similarity = (float)TRUE/(float)(tSplit.length+sSplit.length-TRUE);
		similarity = similarity*100;   
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}finally{
		if(br!=null){
			try {
				br.close();
				br = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
	return similarity;
	
}

}

@SuppressWarnings("serial")
class DirPanel extends Panel {

	TextField TFdir,SFdir;
	Button TFbutton,SFbutton;
	DirPanel() {
		
		SFdir = new TextField("请选择文档",20);
		SFbutton = new Button("browse");
		TFdir = new TextField("请选择文件夹",20);
		TFbutton = new Button("browse");
		add(SFdir);
		add(SFbutton);
		add(TFdir);
		add(TFbutton);
		
	}

	
}

@SuppressWarnings("serial")
class MainPanel extends Panel {
	TextArea ta1,ta2,ta3;
	Label la1,la2,la3;
	MainPanel() {
	Font font=new Font("宋体",Font.BOLD,16); 
	ta1 = new TextArea();
	ta2 = new TextArea();
	ta3 = new TextArea();
	la1 = new Label("-----------------------------就是抄袭-----------------------------");
	la2 = new Label("-----------------------------疑似抄袭-----------------------------");
	la3 = new Label("-----------------------------不是抄袭-----------------------------");
	
	ta1.setBackground(Color.darkGray);
	ta2.setBackground(Color.darkGray);
	ta3.setBackground(Color.darkGray);
	ta1.setForeground(Color.red);
	ta2.setForeground(Color.orange);
	ta3.setForeground(Color.white);
	la1.setFont(font);
	la2.setFont(font);
	la3.setFont(font);
	setBackground(Color.lightGray);

	setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
	add(la1);
	add(ta1);
	add(la2);
	add(ta2);
	add(la3);
	add(ta3);
	add(new Label("-----------------------------肆棟贰贰零柒-----------------------------"));
	}
}