package com.nurkhaliq.submission;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String animeName = getIntent().getStringExtra("animeName");
        String animeRemarks = getIntent().getStringExtra("animeRemarks");
        String animePhoto = getIntent().getStringExtra("animePhoto");
        String animeGenre = getIntent().getStringExtra("animeGenre");
        String animeAiring = getIntent().getStringExtra("animeAiring");
        String animeEpisodes = getIntent().getStringExtra("animeEpisodes");
        String animeSynopsis = getIntent().getStringExtra("animeSynopsis");

        TextView anmName = findViewById(R.id.tv_item_name);
        TextView anmRemarks = findViewById(R.id.tv_item_remarks);
        TextView anmGenre = findViewById(R.id.tv_item_genre);
        TextView anmAiring = findViewById(R.id.tv_item_airing);
        TextView anmEpisodes = findViewById(R.id.tv_item_episode);
        TextView anmSynopsis = findViewById(R.id.tv_item_sinopsis);
        ImageView anmPhoto = findViewById(R.id.img_item_photo);

        Glide.with(this)
                .load(animePhoto)
                .apply(new RequestOptions().override(550,700))
                .into(anmPhoto);
        anmName.setText(animeName);
        anmRemarks.setText(animeRemarks);
        anmGenre.setText(animeGenre);
        anmAiring.setText(animeAiring);
        anmEpisodes.setText(animeEpisodes);
        anmSynopsis.setText(animeSynopsis);
        anmSynopsis.setMovementMethod(new ScrollingMovementMethod());


    }
}
