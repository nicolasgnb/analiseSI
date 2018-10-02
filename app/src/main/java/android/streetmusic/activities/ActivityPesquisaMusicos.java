package android.streetmusic.activities;

import android.streetmusic.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import java.util.Arrays;

public class ActivityPesquisaMusicos extends AppCompatActivity {

    ListView buscar_musico;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_musicos);

        buscar_musico = findViewById(R.id.buscar_musico);

        ArrayList<String> arrayMusicos = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.lista_nomes_teste)));

        adapter = new ArrayAdapter<>(
                ActivityPesquisaMusicos.this,
                android.R.layout.simple_list_item_1,
                arrayMusicos

        );

        buscar_musico.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_busca, menu);
        MenuItem nome_musico = menu.findItem(R.id.menu_buscar);
        SearchView searchView = (SearchView) nome_musico.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}
