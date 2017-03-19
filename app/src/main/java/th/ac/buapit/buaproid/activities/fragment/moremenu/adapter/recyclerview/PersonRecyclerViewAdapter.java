package th.ac.buapit.buaproid.activities.fragment.moremenu.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.activities.fragment.moremenu.model.PersonModel;
import th.ac.buapit.buaproid.model.CalendarModel;


public class PersonRecyclerViewAdapter extends RecyclerView.Adapter<PersonRecyclerViewAdapter.VersionViewHolder> {

    Context context;
    OnItemClickListener clickListener;
    private List<PersonModel> itemList;

    public PersonRecyclerViewAdapter(Context context, List<PersonModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public PersonRecyclerViewAdapter(List<PersonModel> mListPersonModel) {
    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_people, viewGroup, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final VersionViewHolder versionViewHolder, final int position) {
        versionViewHolder.c_title.setText(itemList.get(position).getNamePerson());
        versionViewHolder.c_position.setText(itemList.get(position).getPositionPerson());
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
        TextView c_title, c_position;

        public VersionViewHolder(View itemView) {
            super(itemView);

            c_title = (TextView) itemView.findViewById(R.id.p_title);
            c_position = (TextView) itemView.findViewById(R.id.p_position);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            clickListener.onItemClick(v, position);
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

