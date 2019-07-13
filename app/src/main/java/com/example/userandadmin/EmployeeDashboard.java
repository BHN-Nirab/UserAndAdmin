package com.example.userandadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Random;

public class EmployeeDashboard extends AppCompatActivity {

    ListView contentListView;
    SearchView contentSearchview;
    public static String employeeId;



    public static String title[] = new String[]{"Billal", "Hosain", "Nirab", "Ahasanul", "Islam", "Talukdar", "Sadman", "Sakib"};
    public static String description[] = new String[]{"This is billal...", "This is hosain...", "This is nirab...", "This is ahasan...", "This is islam...", "This is talukdar...", "This is sadman...", "This is sakib..."};
    public static int images[] = new int[]{R.drawable.billal, R.drawable.hosain, R.drawable.nirab, R.drawable.ahasanul, R.drawable.islam, R.drawable.talukdar, R.drawable.sadman, R.drawable.sakib};

    public static ArrayList<Model> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dashboard);

        contentListView = findViewById(R.id.contentListView);
        contentSearchview = findViewById(R.id.contentSearchView);

        Bundle bundle = getIntent().getExtras();
        employeeId = bundle.getString("employeeID");

        initializeModelList();

        final CustomAdapter adapter = new CustomAdapter(EmployeeDashboard.this, list);
        contentListView.setAdapter(adapter);

        contentSearchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty())
                {
                    adapter.filter("");
                    contentListView.clearTextFilter();
                }

                else
                    adapter.filter(newText);

                return true;
            }
        });

        contentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EmployeeDashboard.this, ShowContent.class);
                intent.putExtra("contentID", position);
                startActivity(intent);
            }
        });



    }

    public void initializeModelList()
    {
        for(int i=0; i<title.length; i++)
        {
            Model model = new Model(title[i], description[i], generateRandomIntIntRange(0, 30), generateRandomIntIntRange(0,30), generateRandomIntIntRange(0,2), images[i]);
            list.add(model);
        }
    }


    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
