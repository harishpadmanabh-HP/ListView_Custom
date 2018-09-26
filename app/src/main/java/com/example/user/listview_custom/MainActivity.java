package com.example.user.listview_custom;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lst;
    ImageView imgs;
    TextView txt;
    ArrayList<String> fine;
    TextView nums;
    //int []imageid;
    //int[] nm = {2134567890,9867543218,9745682124,8124568062,7012367850,8281476906,9764321678,"9876512345};
    int[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.d4, R.mipmap.d4, R.mipmap.d6, R.mipmap.d4, R.mipmap.ic_launcher_round, R.mipmap.d5, R.mipmap.d4};
    String[] nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = (ListView) findViewById(R.id.custlist);

        nm = new String[]{"9999999990", "1234567890", "2134567890", "9867543218", "9745682124", "8124568062", "7012367850", "8281476906", "9764321678", "9876512345"};

        fine = new ArrayList<String>();

        fine.add("A");
        fine.add("B");
        fine.add("C");
        fine.add("D");
        fine.add("E");
        fine.add("F");
        fine.add("G");
        fine.add("H");
        fine.add("I");
        fine.add("J");

        adapt adp = new adapt();
        lst.setAdapter(adp);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent cl = new Intent(Intent.ACTION_CALL);
                //cl.setData(Uri.parse("name: ",+lst[position]));
                cl.setData(Uri.parse("tel:  " + nm[position]));
                cl.putExtra("fine", fine);
                cl.putExtra("num", nm[position]);

                if (ActivityCompat.checkSelfPermission( MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(cl);

            }
        });
    }





    class adapt extends BaseAdapter {

        LayoutInflater inflate;


        @Override
        public int getCount() {

            return fine.size();
            //return nm.size();
        }

        @Override
        public Object getItem(int position) {

            return position;
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View cview, ViewGroup parent) {

            inflate = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cview= inflate.inflate(R.layout.link,null);
            txt=(TextView)cview.findViewById(R.id.custtxt);
            nums=(TextView)cview.findViewById(R.id.num);
            nums.setText(nm[position]);
            //nums.setText(nm.get(position));
            // nums.setText(nm(p));
            imgs=(ImageView)cview.findViewById(R.id.img);
            imgs.setImageResource(images[position]);
            txt.setText(fine.get(position));
            return cview;
        }
    }


}

