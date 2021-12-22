package com.mycompany.myapp.thehouseofcrown;

/**
 * Created by Paul on 5/27/2018.
 */
public class Tiles {
    private String positione;
    private boolean showcontent;
    private int which;
    Tiles(){

    }
    Tiles(String positione, boolean showcontent, int which){
        this.positione = positione;
        this.showcontent = showcontent;
        this.which = which;
    }

    public String getPositione() {
        return positione;
    }

    public void setPositione(String positione) {
        this.positione = positione;
    }

    public void setShowcontent(boolean showcontent) {
        this.showcontent = showcontent;
    }

    public boolean isShowcontent() {
        return showcontent;
    }

    public int getWhich() {
        return which;
    }

    public void setWhich(int which) {
        this.which = which;
    }
}
