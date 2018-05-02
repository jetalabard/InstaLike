package fr.talabard.instalike.SplashScreen;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import fr.talabard.instalike.MainPage.MainActivity;
import fr.talabard.instalike.R;

public class SplashScreen extends Activity implements LoadingTask.LoadingTaskFinishedListener {

	private static ProgressBar mProgress;
	private Animation myAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		ImageView imageLauncher= (ImageView) findViewById(R.id.imageLauncher);
		LoadImageFromAssetFolder.execute(this, imageLauncher, "logoInstaLike.JPG");
		if(savedInstanceState==null || getIntent().getBooleanExtra("EXIT", false) == true){
			myAnimation = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
			
			mProgress = (ProgressBar) findViewById(R.id.progressBar);
			mProgress.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(SplashScreen.this, "Chargement...", Toast.LENGTH_LONG).show();
				}
			});
			imageLauncher.startAnimation(myAnimation);
			new TestAvailability(this,mProgress,this).execute();
		}
		else{
			if(mProgress != null && mProgress.isShown()){
				mProgress.setVisibility(View.VISIBLE);
			}
		}
	}

	@Override
	public void onTaskFinished() {
		completeSplash();
	}

	private void completeSplash(){
			startApp();
			finish(); 
	}

	private void startApp() {
		Intent i = new Intent(SplashScreen.this, MainActivity.class);
		startActivity(i);
		overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
	}



}