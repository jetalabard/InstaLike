package fr.talabard.instalike.MainPage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import fr.talabard.instalike.LoginActivity;
import fr.talabard.instalike.R;
import fr.talabard.instalike.business.ILPicture;
import fr.talabard.instalike.business.PictureToshow;
import fr.talabard.instalike.model.ModelPicture;
import fr.talabard.instalike.model.PictureAdapter;

/**
 * Created by jerem on 01/04/2017.
 */

public class ViewMainPageDisconnect {

    private RecyclerView recyclerView;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MainActivity activity;

    public void createView(final MainActivity activity){
        this.activity = activity;
        activity.setContentView(R.layout.activity_default);
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) activity.findViewById(R.id.connect);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, LoginActivity.class);
                activity.startActivity(i);
                activity.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

            }
        });
        fab.setVisibility(FloatingActionButton.VISIBLE);


        recyclerView = (RecyclerView)activity.findViewById(R.id.imagegallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(activity.getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);


        new ListPictureTask(this.activity).execute();
        mSwipeRefreshLayout = (SwipeRefreshLayout) activity.findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
    }

    private void refreshContent(){
        new ListPictureTask(this.activity).execute();
        mSwipeRefreshLayout.setRefreshing(false);
    }


    private void showPictures(List<PictureToshow> pictures){
        if(pictures !=null || !pictures.isEmpty()) {

            PictureAdapter adapter = new PictureAdapter(pictures,this.activity);
            recyclerView.setAdapter(adapter);
        }
    }

    class ListPictureTask extends AsyncTask<String,Void,List<PictureToshow>> {

        private ProgressDialog dialog;
        public ListPictureTask(MainActivity activity){
            dialog = new ProgressDialog(activity);
        }

        protected void onPreExecute() {
            this.dialog.setMessage("Chargement...");
            this.dialog.show();
        }

        @Override
        protected List<PictureToshow> doInBackground(String...params) {
            ModelPicture model = new ModelPicture();
            List<ILPicture> picturesList = model.getNews();
            return model.changeILPictureToPictureToShow(picturesList);
        }

        @Override
        protected void onPostExecute(List<PictureToshow> pictures) {
            super.onPostExecute(pictures);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            showPictures(pictures);
        }
    }
}
