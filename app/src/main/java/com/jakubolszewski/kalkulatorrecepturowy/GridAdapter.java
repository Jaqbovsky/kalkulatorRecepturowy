package com.jakubolszewski.kalkulatorrecepturowy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridAdapter extends BaseAdapter {

    Context context;

    private final String [] values;


    public GridAdapter(Context context, String[] values, int[] images) {
        this.context = context;
        this.values = values;
        this.images = images;
    }

    private final int [] images;

    View view;
    LayoutInflater layoutInflater;




    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return images.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            view = new View(context);
            view = layoutInflater.inflate(R.layout.single_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView = (TextView) view.findViewById(R.id.textview);
            imageView.setImageResource(images[position]);
            textView.setText(values[position]);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, values[position], Toast.LENGTH_SHORT).show();

                    if (values[position].equals("Witamina A")){
                        Toast.makeText(context, values[position], Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, vitaminAActivity.class);
                        context.startActivity(intent);
                    }
                    if (values[position].equals("Witamina E")){
                        Toast.makeText(context, values[position], Toast.LENGTH_SHORT).show();
                    }
                    if (values[position].equals("Witamina A + D3")){
                        Toast.makeText(context, values[position], Toast.LENGTH_SHORT).show();
                    }
                    if (values[position].equals("Devicap")){
                        Toast.makeText(context, values[position], Toast.LENGTH_SHORT).show();
                    }
                    if (values[position].equals("Spirytus")){
                        Toast.makeText(context, values[position], Toast.LENGTH_SHORT).show();
                    }
                    if (values[position].equals("Olejki")){
                        Toast.makeText(context, values[position], Toast.LENGTH_SHORT).show();
                    }
                }
            });
            view.setBackgroundColor(Color.WHITE);
        }

        return view;
    }
}
