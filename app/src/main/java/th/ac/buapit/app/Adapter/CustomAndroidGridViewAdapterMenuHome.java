package th.ac.buapit.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import th.ac.buapit.app.R;

public class CustomAndroidGridViewAdapterMenuHome extends BaseAdapter {
    private Context mContext;
    private final String[] menuHome;
    private final int[] menuHomeimageId;

    public CustomAndroidGridViewAdapterMenuHome(Context c,String[] menuHome,int[] menuHomeimageId ) {
        mContext = c;
        this.menuHomeimageId = menuHomeimageId;
        this.menuHome = menuHome;
    }

    @Override
    public int getCount() {
        return menuHome.length;
    }

    @Override
    public Object getItem(int p) {
        return null;
    }

    @Override
    public long getItemId(int p) {
        return 0;
    }

    @Override
    public View getView(int p, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.gridview_home, null);
            TextView textView = (TextView) grid.findViewById(R.id.gridview_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.gridview_image);
            textView.setText(menuHome[p]);
            imageView.setImageResource(menuHomeimageId[p]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}