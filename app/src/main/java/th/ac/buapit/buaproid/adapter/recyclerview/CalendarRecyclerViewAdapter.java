package th.ac.buapit.buaproid.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import th.ac.buapit.buaproid.model.CalendarModel;
import th.ac.buapit.buaproid.R;


public class CalendarRecyclerViewAdapter extends RecyclerView.Adapter<CalendarRecyclerViewAdapter.VersionViewHolder> {

    Context context;
    OnItemClickListener clickListener;
    private List<CalendarModel> itemList;

    public CalendarRecyclerViewAdapter(Context context, List<CalendarModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public CalendarRecyclerViewAdapter(List<CalendarModel> mListNewsModel) {
    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_calendar, viewGroup, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final VersionViewHolder versionViewHolder, final int position) {
        versionViewHolder.mTitle.setText(itemList.get(position).getCalendarTitle());
        versionViewHolder.mStart.setText(itemList.get(position).getCalendarStart());
        versionViewHolder.mEnd.setText(itemList.get(position).getCalendarEnd());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public void clear() {
        itemList.clear();
        notifyDataSetChanged();
    }

    class VersionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitle, mStart, mEnd;

        public VersionViewHolder(View itemView) {
            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.tv_event_title);
            mStart = (TextView) itemView.findViewById(R.id.tv_event_start);
            mEnd = (TextView) itemView.findViewById(R.id.tv_event_end);

//            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
//            clickListener.onItemClick(v, position);
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

