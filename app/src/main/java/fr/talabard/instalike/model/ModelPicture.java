package fr.talabard.instalike.model;

import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import fr.talabard.instalike.business.ILPicture;
import fr.talabard.instalike.business.PictureToshow;
import retrofit2.Call;


public class ModelPicture {

    public List<ILPicture> getNews() {
        Call<List<ILPicture>> call = AccessWebService.getClient().getNews();
        try {
            return call.execute().body();
        } catch (Exception e) {
            Log.d("debug", "DEBUG Exception gets : " + e.toString());
            return new ArrayList<>();

        }
    }

    public List<PictureToshow> changeILPictureToPictureToShow(List<ILPicture> pictures) {
        List<PictureToshow> listToShow = new ArrayList<>();
        try {
            for(ILPicture pic : pictures){
                java.net.URL url = new URL(pic.getUrl());
                listToShow.add(new PictureToshow(BitmapFactory.decodeStream(url.openConnection().getInputStream()),
                        pic.getTitle(),pic.getDescription(),pic.getId()));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return listToShow;
    }

    public ILPicture getDetail(Long id){
        Call<ILPicture> call = AccessWebService.getClient().getDetailsOfPicture(id);
        try {
            return call.execute().body();
        } catch (Exception e) {
            Log.d("debug", "DEBUG Exception gets : " + e.toString());
            return null;
        }
    }
}