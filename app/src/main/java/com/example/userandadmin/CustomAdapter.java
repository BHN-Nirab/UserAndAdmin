package com.example.userandadmin;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Model> list;
    ArrayList<Model> filtered;
    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = new ArrayList<>();
        this.list.addAll(list);
        filtered = new ArrayList<>();
        filtered.addAll(this.list);
    }

    @Override
    public int getCount() {
        return filtered.size();
    }

    @Override
    public Object getItem(int position) {
        return filtered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_demo, parent, false);
        }

        TextView title = convertView.findViewById(R.id.titleTextView);
        TextView description = convertView.findViewById(R.id.descriptionTextView);
        final TextView like = convertView.findViewById(R.id.likeTextView);
        final TextView dislike = convertView.findViewById(R.id.dislikeTextView);
        ImageView thumbnail = convertView.findViewById(R.id.thumbnailImageView);
        ImageView contentType = convertView.findViewById(R.id.contentType);
        ImageView likeImageView = convertView.findViewById(R.id.likeImageview);
        ImageView dislikeImageview = convertView.findViewById(R.id.dislikeImageview);

        likeImageView.setImageResource(R.drawable.ic_thumb_up_black_24dp);
        dislikeImageview.setImageResource(R.drawable.ic_thumb_down_black_24dp);

        title.setText(filtered.get(position).getTitle());
        description.setText(filtered.get(position).getDescription());
        like.setText(String.valueOf(filtered.get(position).getLike()));
        dislike.setText(String.valueOf(filtered.get(position).getDislike()));
        thumbnail.setImageResource(filtered.get(position).getThumbnail());

        if(filtered.get(position).getType() == 0)
            contentType.setImageResource(R.drawable.ic_image_black_24dp);

        else if(filtered.get(position).getType() == 1)
            contentType.setImageResource(R.drawable.ic_ondemand_video_black_24dp);

        else
            contentType.setImageResource(R.drawable.ic_short_text_black_24dp);

        likeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentLike = list.get(position).getLike();
                currentLike = currentLike+1;
                list.get(position).setLike(currentLike);
                like.setText(String.valueOf(list.get(position).getLike()));

            }
        });

        dislikeImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentDisLike = list.get(position).getDislike();
                currentDisLike = currentDisLike+1;
                list.get(position).setDislike(currentDisLike);
                dislike.setText(String.valueOf(filtered.get(position).getDislike()));

            }
        });

        return convertView;
    }

    public void filter(String charSeq)
    {
        charSeq = charSeq.toLowerCase();
        filtered.clear();
        if(charSeq.length() == 0)
        {
            filtered.addAll(list);
        }

        else
        {
            for(Model m : list)
            {
                if(m.getTitle().toLowerCase().contains(charSeq) || m.getDescription().toLowerCase().contains(charSeq))
                    filtered.add(m);

            }
        }

        notifyDataSetChanged();
    }
}
