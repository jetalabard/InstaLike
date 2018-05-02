package fr.talabard.instalike.SplashScreen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.widget.ProgressBar;

public class LoadingTask extends AsyncTask<String, Integer, Integer> {


	private final ProgressBar progressBar;
	private final LoadingTaskFinishedListener finishedListener;
	private Activity activity;
	private WakeLock mWakeLock;
	private OutputStream output;
	private InputStream input;
	private HttpURLConnection connection;

	public interface LoadingTaskFinishedListener {
		void onTaskFinished();
	}

	public LoadingTask(ProgressBar progressBar, Activity act,LoadingTaskFinishedListener finishedListener) {
		this.progressBar = progressBar;
		this.finishedListener = finishedListener;
		this.activity = act;
	}

	@Override
	protected Integer doInBackground(String... params) {
        downloadResources();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 1234;
	}


	/**
	 * s'execute avant la t�che asynchrone
	 */
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		//permet de continuer la tache asynchrone m�me en veille
		PowerManager pm = (PowerManager) activity.getSystemService(Context.POWER_SERVICE);
		mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
				getClass().getName());
		mWakeLock.acquire();
	}

	private void downloadResources() {
		int count = 10;
		for (int i = 0; i < count; i++) {

			int progress = (int) ((i / (float) count) * 100);
			publishProgress(progress);

		}
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		progressBar.setProgress(values[0]);
	}

	@Override
	protected void onPostExecute(Integer result) {
		super.onPostExecute(result);
		if(mWakeLock != null){
			mWakeLock.release();
		}
		finishedListener.onTaskFinished();
	}
}