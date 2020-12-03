package com.example.realm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailFavourite extends AppCompatActivity {

    Realm realm;
    RealmHelper realmHelper;
    ModelMovieRealm movieModel;


    Bundle extras;
    String title;
    String date;
    String deskripsi;
    String path;
    String id;

    TextView tvteam;
    ImageView ivbadge;
    TextView txtdeskripsi;
    Button btnbookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_favourite);
        extras = getIntent().getExtras();
        tvteam = (TextView)findViewById(R.id.tvteam);
        txtdeskripsi = (TextView)findViewById(R.id.txtdeskripsi);
        ivbadge = (ImageView) findViewById(R.id.ivbadge);
        btnbookmark = (Button) findViewById(R.id.btnbookmark);

        if (extras != null) {
            title = extras.getString("judul");
            id = extras.getString("id");
            date = extras.getString("date");
            deskripsi = extras.getString("deskripsi");
            path = extras.getString("path");
            tvteam.setText(title);
            txtdeskripsi.setText(deskripsi);
            Glide.with(DetailFavourite.this)
                    .load(path)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivbadge);
            // and get whatever type user account id is
        }

        //Set up Realm
        Realm.init(DetailFavourite.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);


        btnbookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieModel = new ModelMovieRealm();
                movieModel.setstrDescriptionEN(deskripsi);
                movieModel.setstrTeam(title);
                movieModel.setstrTeamBadge(path);
                movieModel.setintFormedYear(date);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(movieModel);

            }
        });
    }
}