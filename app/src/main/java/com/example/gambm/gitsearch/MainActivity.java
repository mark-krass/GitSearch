package com.example.gambm.gitsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {



    @BindView(R.id.tvRepos)
    protected TextView repos;

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
            final Call<List<Contributor>> call = gitHubService.repoContributors("square", "retrofit");
            call.enqueue(new Callback<List<Contributor>>() {
                @Override
                public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                    repos.setText(response.body().toString());
                }

                @Override
                public void onFailure(Call<List<Contributor>> call, Throwable t) {
                    repos.setText("Something went wrong: " + t.getMessage());
                }
            });
        }
    }
}
