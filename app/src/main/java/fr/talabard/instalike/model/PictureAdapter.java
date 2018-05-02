package fr.talabard.instalike.model;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.List;
import fr.talabard.instalike.detail_picture.DetailActivity;
import fr.talabard.instalike.R;
import fr.talabard.instalike.Tags;
import fr.talabard.instalike.business.PictureToshow;

/**
 * Created by jerem on 31/03/2017.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    private List<PictureToshow> galleryList;
    private Activity activity;

    public PictureAdapter(List<PictureToshow> galleryList, Activity activity) {
        this.galleryList = galleryList;
        this.activity = activity;
    }

    @Override
    public PictureAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.title.setText(galleryList.get(i).getTitle());
        viewHolder.description.setText(galleryList.get(i).getDescription());
        viewHolder.img.setImageBitmap(galleryList.get(i).getImage());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                galleryList.get(i).getImage().compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Intent intent = new Intent(activity, DetailActivity.class);
                intent.putExtra(Tags.BITMAP, byteArray);
                intent.putExtra(Tags.ID_PICTURE,galleryList.get(i).getId());
                intent.putExtra(Tags.TITLE,galleryList.get(i).getTitle());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title;
        private TextView description;
        public ViewHolder(View view) {
            super(view);
            description = (TextView) view.findViewById(R.id.description);
            title = (TextView) view.findViewById(R.id.title);
            img = (ImageView) view.findViewById(R.id.img);
        }
    }
}