package com.example.userandadmin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class Comment extends Fragment {

    ListView commentListView;
    EditText userComment;
    ImageButton comment;

    ArrayList<String> commentList = new ArrayList<>();

    CustomAdapter3 adapter3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        if(view != null) {

            commentListView = view.findViewById(R.id.commentListViewId);
            userComment = view.findViewById(R.id.userComment);
            comment = view.findViewById(R.id.commentButton);

            adapter3 = new CustomAdapter3(view.getContext(), commentList);



        }
    }
}

