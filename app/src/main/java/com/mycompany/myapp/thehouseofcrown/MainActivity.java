package com.mycompany.myapp.thehouseofcrown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TheGridAdapter.OnGridClickedListener{
    TheGridAdapter CardAdapter;
    int resourceId;
    static int whichy;
    ArrayList<Integer> playerx = new ArrayList<>();
    ArrayList<Integer> newxarray = new ArrayList<>();
    ArrayList<Integer> playero = new ArrayList<>();
    ArrayList<Integer> newoarray = new ArrayList<>();
//    Integer[] seta = {1,2,3};
//    Integer[] setb = {1,4,7};
//    Integer[] setc = {1,5,9};
//    Integer[] setd = {2,5,8};
//    Integer[] sete = {4,5,6};
//    Integer[] setf = {3,5,7};
//    Integer[] setg = {3,6,9};
//    Integer[] seth = {7,8,9};
         ArrayList<Integer> seta = new ArrayList<>();
    ArrayList<Integer> setb= new ArrayList<>();
    ArrayList<Integer> setc = new ArrayList<>();
    ArrayList<Integer> setd = new ArrayList<>();
    ArrayList<Integer> sete = new ArrayList<>();
    ArrayList<Integer> setf = new ArrayList<>();
    ArrayList<Integer> setg = new ArrayList<>();
    ArrayList<Integer> seth = new ArrayList<>();
//        seyb, setc, setd, sete, setf, setg, seth,seti, setj ,setk,setl;

    List<Tiles> persons = new ArrayList<>();
    static int watchere;
    GridView cardsgrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resourceId = R.layout.card;
        watchere = 0;
       seta.add(0); seta.add(1); seta.add(2);
        setb.add(0); setb.add(3); setb.add(6);
        setc.add(0); setc.add(4); setc.add(8);
        setd.add(3); setd.add(4); setd.add(5);
        sete.add(6); sete.add(7); sete.add(8);
        setf.add(1); setf.add(4); setf.add(7);
        setg.add(2); setg.add(5); setg.add(8);
        seth.add(2); seth.add(4); seth.add(6);
        Tiles j = new Tiles("topa",false,0);
        Tiles m = new Tiles("top",false,0);
        Tiles r = new Tiles("top",false,0);
        Tiles l = new Tiles("middlea",false,0);
        Tiles n = new Tiles("middle",false,0);
        Tiles s = new Tiles("middle",false,0);
        Tiles o = new Tiles("bottoma",false,0);
        Tiles p = new Tiles("bottom",false,0);
        Tiles t = new Tiles("bottom",false,0);
        whichy = 1;

        persons.add(j); persons.add(m);
        persons.add(r); persons.add(l);
        persons.add(n); persons.add(s);
        persons.add(o); persons.add(p);
        persons.add(t);
        cardsgrid = (GridView)findViewById(R.id.cardsgrid);
        CardAdapter= new TheGridAdapter(this,resourceId,persons);
        CardAdapter.notifyDataSetChanged();
        CardAdapter.setOnItemClickedListener(this);
//        toolbarng = (Toolbar)v.findViewById(R.id.toolbarng);
//        toolbarng.setLogoDescription("the engineers");
//        toolbarng.setTitle("eee engineers");
        cardsgrid.setAdapter(CardAdapter);
    }

    @Override
    public void OnGridClicked(int position) {
    if(persons.get(position).isShowcontent()) {
        Toast.makeText(getApplicationContext(), "you already played on this tile", Toast.LENGTH_LONG).show();

    }
        else {
        persons.get(position).setWhich(whichy);
        workitall(position,whichy);
        if(whichy ==1){

            whichy =2;
        }
        else {
            if (whichy == 2) {

                whichy = 1;
            }
        }
        persons.get(position).setShowcontent(true);
        CardAdapter.notifyDataSetChanged();
    }
    }

    public void workitall(int position, int whichhye ){
        if(whichhye==1){
            playerx.add(position);
            if(playerx.size()>=3){
               if(innerwork(playerx,newxarray,watchere)==1){
                Toast.makeText(this,"player x has won!",Toast.LENGTH_LONG ).show();

               }
            }
        }
        else {
            playero.add(position);
            if(playero.size()>=3){
              if(innerwork(playero,newoarray,watchere)==1)
              {
                  Toast.makeText(this,"player o has won!",Toast.LENGTH_LONG ).show();
              }
            }
        }
    }
    public int innerwork(ArrayList<Integer> a, ArrayList<Integer> b, int watcher){
        if(watcher ==0) {
            for (int i = 0; i < a.size(); i++) {
                if(watcher ==0) {
                    for (int m = i + 1; m+1 < a.size(); m++) {
                        b.clear();
                        b.add(a.get(i));
                        b.add(a.get(m));
                        b.add(a.get(m+1));

                        Collections.sort(b, new Comparator<Integer>() {
                            @Override
                            public int compare(Integer t0, Integer t1) {
                                return (int) (t0 - t1);
                            }

                        });
                      if ( processor(b,watcher)==1){
                          b.clear();
                          return 1;

                      }
                    }
                }
            }
        }
        b.clear();
            return 0;
    }
    public int processor(ArrayList <Integer> b, int watcher) {
        if (watcher == 0) {
            if (watcher == 0) {
//                Toast.makeText(this,b.toString(),Toast.LENGTH_LONG).show();
//                Toast.makeText(this,seta.toString(),Toast.LENGTH_LONG).show();
                if (b.equals(seta) || b.equals(setb) || b.equals(setc) || b.equals(setd)) {
                    watcher = 1;
                    return 1;

                } else {
                    if (b.equals(sete) || b.equals(setf) || b.equals(setg) || b.equals(seth)) {
                        watcher = 1;
                        return 1;

                    } else {
                        return 0;
                    }
                }

            }

        }
            return 0;
        }

}
