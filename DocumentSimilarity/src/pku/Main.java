package pku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Main extends javax.swing.JFrame {
	private static final String LINE_SEPATER = System
			.getProperty("line.separator");
	private JButton jButton1;
	private JLabel jLabel5;
	private JFileChooser jFileChooser2;
	private JFileChooser jFileChooser1;
	private JButton jButton3;
	private JButton jButton2;
	private JLabel jLabel4;
	private JTextField jTextField2;
	private JTextField jTextField1;

	private JDialog dialog;

	private StringBuffer sb1 = new StringBuffer();
	private StringBuffer sb2 = new StringBuffer();

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main inst = new Main();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Main() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setLayout(null);
				jButton1.setText("\u6bd4\u8f83");
				jButton1.setBounds(143, 73, 73, 24);
				jButton1.setBackground(new java.awt.Color(204, 158, 216));
				jButton1.addKeyListener(new KeyAdapter() {
				});
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						showMessage();
					}
				});
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(0, 7, 331, 24);
				jTextField1.setBackground(new java.awt.Color(243, 231, 182));
				jTextField1.setLocale(new java.util.Locale("zh", "TW"));
				jTextField1.setText("\u9009\u62e9\u4e00\u4e2a\u6587\u672c\u6587\u4ef6");
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBackground(new java.awt.Color(243, 231, 182));
				jTextField2.setLocale(new java.util.Locale("zh", "TW"));
				jTextField2.setBounds(0, 37, 331, 24);
				jTextField2.setText("\u9009\u62e9\u53e6\u4e00\u4e2a\u6587\u672c\u6587\u4ef6");
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setBounds(70, 144, 209, 111);
				jLabel4.setForeground(new java.awt.Color(0, 255, 0));
				jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 28));
				jLabel4.setText("0.00");
				jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u6587\u672c\u76f8\u4f3c\u5ea6");
				jLabel5.setBounds(143, 128, 92, 47);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("\u9009\u62e9\u4e00\u4e2a\u6587\u672c");
				jButton2.setBounds(323, 7, 147, 24);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						try {
							jButton2ActionPerformed(evt);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("\u9009\u62e9\u53e6\u4e00\u4e2a\u6587\u672c");
				jButton3.setBounds(325, 36, 145, 24);
				jButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						try {
							jButton3ActionPerformed(evt);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
			pack();
			this.setSize(480, 320);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 点击按钮事件
	private void jButton2ActionPerformed(ActionEvent evt) throws Exception {
		jFileChooser1 = new JFileChooser();
		int returnvalue = jFileChooser1.showOpenDialog(this);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"txt & doc document", "txt", "doc");
		jFileChooser1.setFileFilter(filter);

		if (returnvalue == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: "
					+ jFileChooser1.getSelectedFile().getName());
		}
		if (returnvalue == JFileChooser.CANCEL_OPTION) {
			return;
		}
		File file = jFileChooser1.getSelectedFile();

		BufferedReader bufr = new BufferedReader(new FileReader(file));
		String line = null;
		sb1.setLength(0);
		while ((line = bufr.readLine()) != null) {
			sb1.append(line);
			// jTextArea1.append(line + LINE_SEPATER);
		}
		System.out.println(sb1.toString());
		bufr.close();
		jTextField1.setText(file.getPath());
	}
	// 点击按钮事件
	private void jButton3ActionPerformed(ActionEvent evt) throws Exception {
		jFileChooser2 = new JFileChooser();
		int returnvalue = jFileChooser2.showOpenDialog(this);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"txt & doc document", "txt", "doc");
		jFileChooser2.setFileFilter(filter);
		
		if (returnvalue == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: "
					+ jFileChooser2.getSelectedFile().getName());
		}
		if (returnvalue == JFileChooser.CANCEL_OPTION) {
			return;
		}
		File file = jFileChooser2.getSelectedFile();
		
		BufferedReader bufr = new BufferedReader(new FileReader(file));
		String line = null;
		sb2.setLength(0);
		while ((line = bufr.readLine()) != null) {
			sb2.append(line);
			// jTextArea1.append(line + LINE_SEPATER);
		}
		System.out.println(sb2.toString());
		bufr.close();
		jTextField2.setText(file.getPath());
	}

	// 计算文本相似度
	private void showMessage() {
		double d=SimFeatureUtil.sim(sb1.toString(), sb2.toString());

		// double d=WordSimilarity.simWord(dir_str1, dir_str2);

		// System.out.println(dir_str1 +"  "+dir_str2+" "+d);
		// System.out.println(WordSimilarity.simWord(dir_str1, dir_str2));

		// if(d)
		 jLabel4.setText(d+"");

	}

	private JFileChooser getJFileChooser1() {
		if (jFileChooser1 == null) {
			jFileChooser1 = new JFileChooser();
		}
		return jFileChooser1;
	}

	private JFileChooser getJFileChooser2() {
		if (jFileChooser2 == null) {
			jFileChooser2 = new JFileChooser();
		}
		return jFileChooser2;
	}
}
