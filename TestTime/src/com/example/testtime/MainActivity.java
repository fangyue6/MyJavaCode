package com.example.testtime;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView t;
	String time = null;
	private final Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:// 1
				time=(String) msg.obj;
				t.setText(time);
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t = (TextView) findViewById(R.id.time);
		WorkerThread w=new WorkerThread();
		w.start();

	}

	public void net() {
		Thread a = new Thread() {
			public void run() {
				time = MyUtil.getNetTime("http://www.baidu.com") + "-";
			}
		};
		a.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class WorkerThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			String internet_time = MyUtil.getNetTime("http://www.baidu.com");
			Message msg = mHandler.obtainMessage();
			msg.what = 1;
			msg.obj = internet_time;
			mHandler.sendMessage(msg);
		}
	}

}
