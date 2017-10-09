package com.example.gambm.gitsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

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
            final Call<ReposInfo> call = gitHubService.repoContributors(etsearch.getText().toString());
            call.enqueue(new Callback<ReposInfo>() {
                @Override
                public void onResponse(Call<ReposInfo> call, Response<ReposInfo> response) {
                    lvsimple.setAdapter(new BoxAdapter(MainActivity.this, response.body().getList()));
                }

                @Override
                public void onFailure(Call<ReposInfo> call, Throwable t) {
                    Log.d("mylogs", String.valueOf(t));
                }
            });
        }
    }
}
