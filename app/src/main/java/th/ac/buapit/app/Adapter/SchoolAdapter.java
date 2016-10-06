package th.ac.buapit.app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import th.ac.buapit.app.Model.SchoolItem;
import th.ac.buapit.app.R;


public class SchoolAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<SchoolItem> data = Collections.emptyList();
    SchoolItem current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public SchoolAdapter(Context context, List<SchoolItem> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.card_row_school, parent,false);
        MyHolder holder= new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        SchoolItem current = data.get(position);
        myHolder.Tx1.setText(current.getSchool_name());
        myHolder.Tx2.setText(current.getSchool_history());
        myHolder.Tx3.setText(current.getSchool_id_code());
        //myHolder.TxTel.setText(current.personTel);

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView Tx1;
        TextView Tx2;
        TextView Tx3;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            Tx1 = (TextView) itemView.findViewById(R.id.tv_school_name);
            Tx2 = (TextView) itemView.findViewById(R.id.tv_school_history);
            Tx3 = (TextView) itemView.findViewById(R.id.tv_school_under);
            //TxTel = (TextView) itemView.findViewById(R.id.textPrice);
        }

    }


}