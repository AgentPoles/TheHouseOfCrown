package com.mycompany.myapp.thehouseofcrown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 5/27/2018.
 */
public class TheGridAdapter extends ArrayAdapter<Tiles> {
        int resource;
        TextView personname, personauthority;
        ImageView xoro;
        int posi;
        OnGridClickedListener Listener;
        public TheGridAdapter(Context context, int resourece, List<Tiles> persons){
            super(context,resourece,persons);
            this.resource =resourece;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            RelativeLayout gridViewe;
            LinearLayout persontotal;
            Tiles person = getItem(position);
            posi = position;
            if(convertView == null){
                gridViewe = new RelativeLayout(getContext());
                String Inflator = Context.LAYOUT_INFLATER_SERVICE;
                LayoutInflater li;
                li = (LayoutInflater)getContext().getSystemService(Inflator);
                li.inflate(resource,gridViewe,true);
            }
            else{
                gridViewe = (RelativeLayout) convertView;
            }
            persontotal = (LinearLayout) gridViewe.findViewById(R.id.persontotal);
            xoro = (ImageView)gridViewe.findViewById(R.id.xoro);
            if(person.getPositione().equals("topa")){
                persontotal.setPadding(0,0,0,0);
            }
            if(person.getPositione().equals("top")){
                persontotal.setPadding(1,0,0,0);
            }
            if(person.getPositione().equals("middlea")){
                persontotal.setPadding(0,1,0,0);
            }
            if(person.getPositione().equals("middle")){
                persontotal.setPadding(1,1,0,0);
            }
            if(person.getPositione().equals("bottoma")){
                persontotal.setPadding(0,1,0,0);

            }
            if(person.getPositione().equals("bottom")){
                persontotal.setPadding(1,1,0,0);
            }
            if(person.isShowcontent()) {
                if (person.getWhich() == 0) {

                } else {
                    if (person.getWhich() == 1) {
                        xoro.setImageResource(R.drawable.ic_close_black_24dp);
                    } else {
                        xoro.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp);
                    }
                    xoro.setVisibility(View.VISIBLE);
                }
            }
            persontotal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Listener.OnGridClicked(position);
                }
            });
            return gridViewe;
        }

        public interface OnGridClickedListener{
            public void OnGridClicked(int position);
        }
        public void setOnItemClickedListener (OnGridClickedListener listener){
            this.Listener = listener;
        }
}
