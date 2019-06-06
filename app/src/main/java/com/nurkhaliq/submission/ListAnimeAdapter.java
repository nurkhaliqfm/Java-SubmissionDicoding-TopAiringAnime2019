package com.nurkhaliq.submission;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class ListAnimeAdapter extends RecyclerView.Adapter<ListAnimeAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Anime> listanime;

    ListAnimeAdapter(Context context) {

        this.context = context;
    }

    private ArrayList<Anime> getListanime() {

        return listanime;
    }

    void setListanime(ArrayList<Anime> listanime) {

        this.listanime = listanime;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_anime, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder categoryViewHolder, final int position) {
        categoryViewHolder.animeName.setText(getListanime().get(position).getName());
        categoryViewHolder.animeRemarks.setText(getListanime().get(position).getRemarks());
        categoryViewHolder.animeDetail.setText(getListanime().get(position).getDetail());

        Glide.with(context)
                .load(getListanime().get(position).getPhoto())
                .apply(new RequestOptions().override(550,700))
                .into(categoryViewHolder.imgPhoto);

        categoryViewHolder.animeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveDetail = new Intent(context, DetailActivity.class);
                moveDetail.putExtra("animeRemarks", getListanime().get(position).getRemarks());
                moveDetail.putExtra("animeName", getListanime().get(position).getName());
                moveDetail.putExtra("animePhoto", getListanime().get(position).getPhoto());
                moveDetail.putExtra("animeGenre", getListanime().get(position).getGenre());
                moveDetail.putExtra("animeAiring", getListanime().get(position).getAiring());
                moveDetail.putExtra("animeEpisodes", getListanime().get(position).getEpisodes());
                moveDetail.putExtra("animeSynopsis", getListanime().get(position).getSynopsis());


                context.startActivities(new Intent[]{moveDetail});
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListanime().size();
    }


    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView animeName;
        TextView animeRemarks;
        ImageView imgPhoto;
        TextView animeDetail;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            animeName = itemView.findViewById(R.id.tv_item_name);
            animeRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            animeDetail = itemView.findViewById(R.id.detail_button);
        }
    }
}
