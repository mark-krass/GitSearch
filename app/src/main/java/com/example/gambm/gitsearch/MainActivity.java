package com.example.gambm.gitsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lvSimple)
    protected ListView lvsimple;

    @BindView(R.id.etSearch)
    protected EditText etsearch;

    private final String LOG_TAG = "mylogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);
    }


    @OnClick(R.id.btnSearch)
    protected void onClick() {
        {
            GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
            final Call<List<ReposInfo>> call = gitHubService.repoContributors(etsearch.getText().toString());
            call.enqueue(new Callback<List<ReposInfo>>() {
                @Override
                public void onResponse(Call<List<ReposInfo>> call, Response<List<ReposInfo>> response) {
                    lvsimple.setAdapter(new BoxAdapter(MainActivity.this, response.body()));
                }

                @Override
                public void onFailure(Call<List<ReposInfo>> call, Throwable t) {
                    Log.d(LOG_TAG, String.valueOf(t));
                }
            });
        }
    }
}
