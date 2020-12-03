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

public class DetailFootball extends AppCompatActivity {
    Realm realm;
    RealmHelper realmHelper;
    ModelMovieRealm movieModel;


    Bundle extras;
    String team;
    String deskripsi;
    String badge;
    String id;

    TextView tvteam;
    ImageView ivbadge;
    TextView tvdesc;
    Button btnbookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_football);
        extras = getIntent().getExtras();
        tvteam = (TextView)findViewById(R.id.tvteam);
        tvdesc = (TextView)findViewById(R.id.txtdeskripsi);
        ivbadge = (ImageView) findViewById(R.id.ivbadge);
        btnbookmark = (Button) findViewById(R.id.btnbookmark);

        if (extras != null) {
            team = extras.getString("team");
            id = extras.getString("id");
            deskripsi = extras.getString("description");
            badge = extras.getString("badge");
            tvteam.setText(team);
            tvdesc.setText(deskripsi);
            Glide.with(DetailFootball.this)
                    .load(badge)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivbadge);
            // and get whatever type user account id is
        }

        //Set up Realm
        Realm.init(DetailFootball.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);


        btnbookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieModel = new ModelMovieRealm();
                movieModel.setstrDescriptionEN(deskripsi);
                movieModel.setstrTeam(team);
                movieModel.setstrTeamBadge(badge);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(movieModel);

            }
        });
    }
}