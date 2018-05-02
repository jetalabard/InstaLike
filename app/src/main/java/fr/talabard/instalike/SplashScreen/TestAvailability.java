package fr.talabard.instalike.SplashScreen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import fr.talabard.instalike.Dialog;

public class TestAvailability extends AsyncTask<String, String, String> {
	
	
	private Activity activity;
	private ProgressBar progressBar;
	private LoadingTask.LoadingTaskFinishedListener listener;
	private AlertDialog alertDialog;

	public TestAvailability(Activity act, ProgressBar mProgress, LoadingTask.LoadingTaskFinishedListener listener) {
		this.activity =act;
		this.progressBar = mProgress;
		this.listener = listener;
	}

	@Override
	protected String doInBackground(String... params) {
		showMessageIfNoConnectionElseLoadApplication();
		return "";
	}
	

	private void showMessageIfNoConnectionElseLoadApplication() {
		TestConnection test = new TestConnection(activity);
			if(test.isNetworkAvailable()){
				this.progressBar.setVisibility(View.VISIBLE);
				new LoadingTask(progressBar,activity,listener).execute();
			}
			else {
				activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						showDialogConnection();
					}
				});
			}

	}
	
	private void showDialogConnection() {
		Dialog d = new Dialog(activity, "Problème Connexion", "Connectez vous et rééssayez.", false);
		alertDialog  = d.setPositiveButton("Rééssayer", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				showMessageIfNoConnectionElseLoadApplication();
			}
		}).setNegativeButton("Annuler", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				alertDialog.dismiss();
				activity.finish();
			}
		}).create();
		alertDialog.show();
	}

}
