package com.example.android.recyclerviewcodeinflowpractise;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Ogbono", "This is how ogbono is made.\nThis is how ogbono is made.\nThis is how ogbono is made. ", R.drawable.ic_brightness));
        recipeList.add(new Recipe("Egusi", "This is how Egusi is made.\nThis is how Egusi is made.\nThis is how Egusi is made. ", R.drawable.ic_android));
        recipeList.add(new Recipe("okro", "This is how okro is made.\nThis is how okro is made.\nThis is how okro is made. ", R.drawable.ic_ac_unit));

        mRecyclerView = findViewById(R.id.recycler_view);
        //  mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecipeAdapter(recipeList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                recipeList.remove(position);
                mAdapter.notifyItemRemoved(position);
            }
        }).attachToRecyclerView(mRecyclerView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipeList.add(new Recipe("Stew", "This is how to make stew", R.drawable.ic_brightness));
                recipeList.add(new Recipe("Stew", "This is how to make stew", R.drawable.ic_brightness));
                recipeList.add(new Recipe("Stew", "This is how to make stew", R.drawable.ic_brightness));
                recipeList.add(new Recipe("Stew", "This is how to make stew", R.drawable.ic_brightness));
                mAdapter.notifyDataSetChanged();
                mRecyclerView.smoothScrollToPosition(recipeList.size() - 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
