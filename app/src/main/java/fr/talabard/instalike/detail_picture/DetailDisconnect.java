package fr.talabard.instalike.detail_picture;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import fr.talabard.instalike.R;
import fr.talabard.instalike.Tags;
import fr.talabard.instalike.business.ILPicture;
import fr.talabard.instalike.model.ModelPicture;

/**
 * Created by jerem on 01/04/2017.
 */

public class DetailDisconnect {


    private Bitmap image;

    public void createView(DetailActivity detailActivity) {
        detailActivity.setContentView(R.layout.detail_picture);
        String title = detailActivity.getIntent().getStringExtra(Tags.TITLE);
        Long id = detailActivity.getIntent().getLongExtra(Tags.ID_PICTURE,0);
        Toolbar toolbar = (Toolbar) detailActivity.findViewById(R.id.toolbar);
        detailActivity.setSupportActionBar(toolbar);
        detailActivity. getSupportActionBar().setTitle(title);
        byte[] byteArray = detailActivity.getIntent().getByteArrayExtra(Tags.BITMAP);
        image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        ImageView imageView = (ImageView) detailActivity.findViewById(R.id.image);
        imageView.setImageBitmap(image);
       // new PictureDetailTask(detailActivity).execute(id);
    }

    private class PictureDetailTask extends AsyncTask<Long,Void,ILPicture> {
        private ProgressDialog dialog;
        private  DetailActivity activity;
        public PictureDetailTask(DetailActivity activity){
            this.activity = activity;
            dialog = new ProgressDialog(activity);
        }

        protected void onPreExecute() {
            this.dialog.setMessage("Chargement...");
            this.dialog.show();
        }

        @Override
        protected ILPicture doInBackground(Long...params) {
            Long id = params[0];
            ModelPicture model = new ModelPicture();
            return model.getDetail(id);
        }

        @Override
        protected void onPostExecute(ILPicture picture) {
            super.onPostExecute(picture);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            showPictures(picture);
        }
        private void showPictures(ILPicture picture){
            TextView title = (TextView) this.activity.findViewById(R.id.title);
            TextView description = (TextView) this.activity.findViewById(R.id.description);
            TextView date = (TextView) this.activity.findViewById(R.id.date);
            ImageView imageView = (ImageView) this.activity.findViewById(R.id.image);
            imageView.setImageBitmap(image);
            title.setText(picture.getTitle());
            description.setText(picture.getDescription());
            date.setText(picture.getPublicationDate().toString());

        }
    }


}
