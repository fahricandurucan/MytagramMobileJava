package com.example.mytagrammobilejava;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    List<Post> postList;
    LayoutInflater layoutInflater;


    public PostAdapter(Activity activity,List<Post> postList) {
        this.postList = postList;
        layoutInflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int i) {
        return postList.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView;
        rowView = layoutInflater.inflate(R.layout.row,null);
        EditText txtMessage = rowView.findViewById(R.id.editTextTextPersonName);
        TextView txtLoc = rowView.findViewById(R.id.textLocation);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        Post post = postList.get(i);
        txtMessage.setText(post.getMessage());
        if(post.getLocation() != null){
            txtLoc.setText(post.getLocation().getAltitude() + " " + post.getLocation().getLongitude());
        }

        imageView.setImageBitmap(post.getImage());


        return rowView;
    }
}
