package com.example.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText cmd_ET;
	private EditText bianma_ET;
	private TextView show_TV;
	private Button start_Bt;
	String result = null;
	String bianma = "utf8";
	String CMD = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cmd_ET = (EditText) findViewById(R.id.cmd);
		bianma_ET = (EditText) findViewById(R.id.bianma);
		show_TV = (TextView) findViewById(R.id.textView1);
		start_Bt = (Button) findViewById(R.id.start);
/*		if ("gbk".equals(bianma_ET.getText().toString())) {
			bianma = "gbk";
		}*/
		CMD = cmd_ET.getText().toString();

		start_Bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Toast.makeText(MainActivity.this,
				// cmd_ET.getText().toString(), 0).show();
				// show_TV.setText(
				// cmd_ET.getText().toString()+"\n"+bianma_ET.getText().toString());
				//resultCMD(cmd_ET.getText().toString(),bianma);
				do_exec(cmd_ET.getText().toString());//ls /mnt/sdcard
			}
		});

	}

	public String resultCMD(String str_CMD, String str_bianma) {
		String result = "";
		try {
			Process pro = Runtime.getRuntime().exec(str_CMD);
			String line = null;
			BufferedReader buf = new BufferedReader(new InputStreamReader(
					pro.getInputStream(), str_bianma));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
				show_TV.append(line);
				result += line;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			result = "出现错误：\n输入的命令为：" + str_CMD + "\n输入的编码为：" + str_bianma
					+ "\n" + ex.getMessage();
		}
		return result;

	}
	 String do_exec(String cmd) {  
	        String s = "\n";  
	        try {  
	        	if(cmd.contains("ping")){
	        		Toast.makeText(MainActivity.this, cmd.substring(5), 0).show();
	        		cmd="ping -c 1 -w 1 "+cmd.substring(5);
	        	}
	            Process p = Runtime.getRuntime().exec(cmd);  
	            BufferedReader in = new BufferedReader(  
	                                new InputStreamReader(p.getInputStream()));  
	            String line = null;  
	            while ((line = in.readLine()) != null) {  
	                s += line + "\n";                 
	            }  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        show_TV.setText(s);  
	        return cmd;       
	    }  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
