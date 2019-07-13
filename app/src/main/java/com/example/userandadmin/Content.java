package com.example.userandadmin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class Content extends Fragment {

    Context context;
    ImageView imageView;
    VideoView videoView;
    TextView titleView;
    TextView descriptionView;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        if(view != null) {

            imageView = view.findViewById(R.id.imageViewID);
            videoView = view.findViewById(R.id.videoViewID);
            titleView = view.findViewById(R.id.titleTextviewID);
            descriptionView = view.findViewById(R.id.descriptionTextViewId);

            imageView.setVisibility(View.GONE);
            videoView.setVisibility(View.GONE);

            if(EmployeeDashboard.list.get(ShowContent.contentID).getType() == 0)
            {
                imageView.setVisibility(View.VISIBLE);
                videoView.setVisibility(View.GONE);
                imageView.setImageResource(EmployeeDashboard.list.get(ShowContent.contentID).getThumbnail());
            }

            else if(EmployeeDashboard.list.get(ShowContent.contentID).getType() == 1)
            {
                imageView.setVisibility(View.GONE);
                videoView.setVisibility(View.VISIBLE);

                Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.vid1 );
                videoView.setVideoURI(uri);
                videoView.start();


            }

            else
            {
                imageView.setVisibility(View.GONE);
                videoView.setVisibility(View.GONE);
            }

            titleView.setText(EmployeeDashboard.list.get(ShowContent.contentID).getTitle());
            descriptionView.setText(EmployeeDashboard.list.get(ShowContent.contentID).getDescription());


        }
    }
}
