package com.bawazir.utslaptopgaming;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LaptopListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Laptop> laptopList;

    public LaptopListAdapter(Context context, int layout, ArrayList<Laptop> laptopList) {
        this.context = context;
        this.layout = layout;
        this.laptopList = laptopList;
    }

    @Override
    public int getCount() {
        return laptopList.size();
    }

    @Override
    public Object getItem(int position) {
        return laptopList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtPrice = (TextView) row.findViewById(R.id.txtPrice);
            holder.imageView = (ImageView) row.findViewById(R.id.imgTiens);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Laptop laptop = laptopList.get(position);

        holder.txtName.setText(laptop.getName());
        holder.txtPrice.setText(laptop.getPrice());

        byte[] tiensImage = laptop.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(tiensImage, 0, tiensImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
