package pooa20171.iff.br.academiaapp4.model;

/**
 * Created by Marcos on 23/07/2017.
 */

import java.util.ArrayList;
import java.util.List;

import pooa20171.iff.br.academiaapp4.R;

public class MyData {
    //  LISTA DE NOMES QUE VÃO APARECER NO RECYCLERVIEW
    //  SERÁ O MEU ARRAY QUE ESTÁ VINDO DA API
    private static final String[] titles = {
            "Supinu Reto",
            "Supino Inclinado",
            "Crussifixo",
            "CrossOver",
            "Remada Unilateral",
            "Title 6"
    };

    private static final String[] subTitles = {
            "Deite sobre um banco horizontal e mantenha os glúteos em contato com o banco.\n" +
                    "Segure a barra de forma que as mãos fiquem com a palma voltada para a direção dos seus pés e com uma distância maior que a largura dos ombros.",

            "Deite sobre um banco inclinado (aproximadamente 45 graus) e mantenha os glúteos em contato com o banco.\n" +
                    "Segure a barra de forma que as mãos fiquem com a palma voltada para a direção dos seus pés e com uma distância maior que a largura dos ombros.",

            "Deite-se em um banco horizontal. Segure os halteres com os braços estendidos e os cotovelos levemente flexionados.",

            "Para esse exercício, você utilizará as pegadas de uma mão.\n" +
                    "\n" +
                    "Selecione o peso desejado e ajuste as polias para uma posição que fique um pouco mais alto que seus ombros. Mantenha-se no centro da máquina, dê um passo a frente e mantenha um pé a frente do outro.\n" +
                    "\n" +
                    "As palmas das mãos devem permanecer voltadas para frente.\n" +
                    "\n" +
                    "Deixe as costas retas e o tronco levemente inclinado para frente.",

            "Segure um halter em uma das mãos e ajoelhe-se no banco com o joelho oposto. Incline-se para a frente e mantenha as costas paralelas ao chão, apoiando o peso do corpo sobre sua mão livre.\n" +
                    "\n" +
                    "Mantenha o cotovelo do braço que segura o peso levemente flexionado.",

            "Description 6"
    };

    private static final int[] icon = {
            R.drawable.ic_airport_shuttle_black_24dp
    };

    //  REPRESENTA OS RECURSOS DE IMAGEM
    private static final int[] icons = {
            android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_call,
            android.R.drawable.ic_menu_mylocation,
            android.R.drawable.ic_menu_mylocation,
            android.R.drawable.ic_menu_mylocation,
            android.R.drawable.ic_menu_mylocation
    };


    /**
     * Este seria meu método que retorna minha Lista de Data pegando pelo requesterId
     * @return List<Data>
     */
    public static List<ListItem> getListData(){
        List<ListItem> data = new ArrayList<>();

        //  ADICIONA NO RECYCLERVIEW TODAS AS NOSSAS LISTAS
        for(int i = 0; i < titles.length; i++){
            ListItem item = new ListItem();
            item.setTitle(titles[i]);
            item.setSubTitle(subTitles[i]);
            item.setImageResId(icons[i]);
            data.add(item);
        }
        return data;
    }
}
