package pooa20171.iff.br.academiaapp4.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import pooa20171.iff.br.academiaapp4.R;
import pooa20171.iff.br.academiaapp4.adapter.MyAdapter;
import pooa20171.iff.br.academiaapp4.model.ItemClickCallback;
import pooa20171.iff.br.academiaapp4.model.ListItem;
import pooa20171.iff.br.academiaapp4.model.MyData;

/**
 * Created by Marcos on 23/07/2017.
 */

public class ListActivity extends AppCompatActivity implements ItemClickCallback{
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_TITLE = "TITLE";
    private static final String EXTRA_SUBTITLE = "SUBTITLE";
    private RecyclerView rv_list;
    private MyAdapter adapter;
    private ArrayList listData;
    private ListItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listData = (ArrayList) MyData.getListData();

        //  RECUPERA O RecyclerView
        rv_list = (RecyclerView) findViewById(R.id.rv_list);

        //  DEFINE O TIPO DE LAYOUT DO RecyclerView
        //  Or GridLayoutManager or StaggeredGridLayoutManager
        rv_list.setLayoutManager(new LinearLayoutManager(this));

        //  MEU ADAPTER RECEBE A LISTA DE DADOS AQUI
        adapter = new MyAdapter(MyData.getListData(), this);
        adapter.setItemClickCallback(this);

        //  ADICIONA MEU ADAPTER
        rv_list.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int p) {
        Toast.makeText(this, "Click on item " + p, Toast.LENGTH_SHORT).show();

        //  Vou passar pra minha activity de listagem o que eu cliquei
        item = (ListItem) listData.get(p);
        Intent intent = new Intent(this, DetailActivity.class);
        Bundle extras = new Bundle();
        extras.putString(EXTRA_TITLE, item.getTitle());
        extras.putString(EXTRA_SUBTITLE, item.getSubTitle());
        intent.putExtra(BUNDLE_EXTRAS, extras);
        startActivity(intent);
    }

    @Override
    public void onSecondaryIconClick(int p) {
        Toast.makeText(this, "Click on secondary item " + p, Toast.LENGTH_SHORT).show();

        //  VOCÊ PODE CHAMAR ALGUM MÉTODO LÁ DO MyAdapter e executar alguma ação como excluir a ocorrência por exemplo
        ListItem item = (ListItem) listData.get(p);
        //update our data
        if (item.isFavourite()){
            item.setFavourite(false);
        } else {
            item.setFavourite(true);
        }
        adapter.notifyDataSetChanged();
    }

}
