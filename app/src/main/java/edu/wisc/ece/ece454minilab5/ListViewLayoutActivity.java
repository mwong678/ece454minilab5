/*
Matthew Wong
ECE 454 Minilab 5
 */


package edu.wisc.ece.ece454minilab5;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewLayoutActivity extends ListActivity {

    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> FOLKS = new ArrayList<String>(Arrays.asList("studentA", "studentB", "studentC", "studentD"));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define a new adapter
        mAdapter = new ArrayAdapter<String>(this,
                R.layout.activity_list_view_layout, FOLKS);

        // Assign the adapter to ListView
        setListAdapter(mAdapter);

        // Define the listener interface
        OnItemClickListener mListener = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String elementText = (String) parent.getItemAtPosition(position); // convert to string
                FOLKS.remove(position);
                mAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), elementText +  " is removed from the list!", Toast.LENGTH_SHORT).show();
                Log.d("","");
            }
        };

        // Get the ListView and wired the listener
        ListView listView = getListView();
        listView.setOnItemClickListener(mListener);

        //test change comment

    }
}