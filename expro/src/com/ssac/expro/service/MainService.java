package com.ssac.expro.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ssac.expro.BaseActivity;
import com.ssac.expro.R;
import com.ssac.expro.bean.Task;
import com.ssac.expro.bean.TaskType;
import com.ssac.expro.util.ErrorLog;
import com.ssac.expro.util.GenericUtil;
import com.ssac.expro.util.LogUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class MainService extends Service implements Runnable {

	private String TAG = LogUtil.makeLogTag(MainService.this.getClass());
	private ErrorLog mLog = null;
	public static boolean isrun = false;
	private static Queue<Task> allTask = new LinkedList<Task>();
	private static ArrayList<BaseActivity> allActivity = new ArrayList<BaseActivity>();

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		isrun = true;
		try {
			mLog = new ErrorLog();
			Log.i(TAG, "Opened log at " + mLog.getPath());
		} catch (IOException e) {
			Log.e(TAG, "Failed to open log", e);
		}
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void onDestroy() {

		try {
			if (mLog != null)
				mLog.close();
		} catch (IOException e) {
		}

		isrun = false;

		super.onDestroy();

		allTask = null;
		allActivity = null;
	}

	@Override
	public void run() {
		while (isrun) {
			Task task = null;
			if (!allTask.isEmpty()) {
				task = allTask.poll();
				if (null != task) {
					try {
						doTask(task);
					} catch (Exception e) {
						LogUtil.log(mLog, e);
						e.printStackTrace();
//						CRMApplication.throwTips("获取数据异常,请稍后尝试!");
					}
				}
			}
			// try {
			// Thread.sleep(1000);
			// } catch (Exception e) {
			// }
		}
	}

	public static void addActivity(BaseActivity wa) {
		allActivity.add(wa);
	}

	public static void removeActivity(BaseActivity wa) {

		allActivity.remove(wa);
	}

	public static BaseActivity getActivityByName(String aname) {
		for (BaseActivity wa : allActivity) {
			if (wa.getClass().getName().indexOf(aname) >= 0) {
				return wa;
			}
		}
		return null;
	}

	private Handler hand = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case TaskType.GET_REMIND: {
				break;
			}
			case TaskType.TODAY_DUE_CUSTOMER:// 今日到访客户
			case TaskType.PROTECT_DUE_CUSTOMER:// 保护到期客户
			case TaskType.PENDING_DISTRIBUTE_CUTOMER:// 待分配客户
				if (MainService.getActivityByName("ClientList") != null)
					MainService.getActivityByName("ClientList")
							.refresh(msg.obj);
				break;
			}
		}
	};

	public static void newTask(Task ts, Context context) {
		allTask.add(ts);
		// c = context;
	}

	private void doTask(Task ts) throws Exception {
		Message message = hand.obtainMessage();
		message.what = ts.getTaskID();
		// 获取参数
		HashMap<String, Object> hashParam = (HashMap<String, Object>) ts
				.getTaskParam();

		switch (ts.getTaskID()) {

		case TaskType.GET_REMIND:
			break;
		}
		allTask.remove(ts);
		hand.sendMessage(message);
	}

	public static void alertNetError(final Context context) {
		AlertDialog.Builder ab = new AlertDialog.Builder(context);
		ab.setTitle("网络异常");
		ab.setMessage("网络连接异常，请设置网络或退出程序");
		ab.setPositiveButton("设置网络", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				context.startActivity(new Intent(
						android.provider.Settings.ACTION_WIRELESS_SETTINGS));
				dialog.cancel();
			}
		});
		ab.setNegativeButton("退出程序", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent it = new Intent(context, MainService.class);
				context.stopService(it);
				android.os.Process.killProcess(android.os.Process.myPid());
			}
		});
		ab.create().show();
	}

	/**
	 * 关闭管理器里面的所有 activity
	 * 
	 * @param con
	 */
	public static void exitApp(Context con) {

		for (Activity ac : allActivity) {
			ac.finish();
		}

		allTask = null;
		allActivity = null;

		Intent it = new Intent("com.cnsaas.fycrm.service.MainService");
		con.stopService(it);
		// // 先清楚缓存
		GenericUtil.clearnCache();
		android.os.Process.killProcess(android.os.Process.myPid());
	}

	/**
	 * 程序退出
	 * 
	 * @param con
	 */
	public static void promptExit(final Context con) {
		LayoutInflater li = LayoutInflater.from(con);
		View exitV = li.inflate(R.layout.exitdialog, null);
		AlertDialog.Builder ab = new AlertDialog.Builder(con);
		ab.setView(exitV);
		ab.setPositiveButton(R.string.confirm, new OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
//				// 记录本次退出的tag
//				String favorite_page = con.getClass().getName();
//				CRMApplication.pushPreferenceData("favorite_page",
//						favorite_page);

				// 把缓存的数据都释放掉 节省资源

				exitApp(con);
			}
		});

		ab.setNegativeButton(R.string.cancel, null);
		ab.show();
	}
}
