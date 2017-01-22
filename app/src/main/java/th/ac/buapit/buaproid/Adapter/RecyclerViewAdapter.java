package th.ac.buapit.buaproid.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import th.ac.buapit.buaproid.Holder.RecyclerViewHolders;
import th.ac.buapit.buaproid.Model.TestModel;
import th.ac.buapit.buaproid.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders>{

    private List<TestModel> itemList;
    private Context context;
    public RecyclerViewAdapter(Context context, List<TestModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_home, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.m_title.setText(itemList.get(position).getNewsTitle());
        holder.m_content.setText(itemList.get(position).getNewsContent());
    }
    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}

