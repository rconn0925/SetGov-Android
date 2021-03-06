package com.setgov.android.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.setgov.android.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Ross on 6/16/2017.
 */

public class EventViewHolder  extends RecyclerView.ViewHolder {
    @InjectView(R.id.eventImage)
    public ImageView eventImage;
    @InjectView(R.id.eventName)
    public TextView eventName;
    @InjectView(R.id.eventDateTime)
    public TextView eventDateTime;
    @InjectView(R.id.eventNumberGoing)
    public TextView eventNumberGoing;
    @InjectView(R.id.eventTag)
    public TextView eventTag;
    @InjectView(R.id.eventAttendees)
    public RecyclerView eventAttendees;
    @InjectView(R.id.eventImageBackground)
    public RelativeLayout eventImageBackground;

    public EventViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this,itemView);
    }
}
