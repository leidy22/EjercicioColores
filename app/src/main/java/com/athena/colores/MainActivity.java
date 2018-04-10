package com.athena.colores;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements SeekBar.OnSeekBarChangeListener{

    //Atributos se colocan antes del método onCreate

/*    private String name = "carlosgibarra";

    private float numero =0.2f;

    private TextView textViewName;

    private Button buttonAccept;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_index,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_item_menu_1:
                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
                //seekBarAlpha.setProgress(0);
                return true;
            case R.id.id_item_menu_2:
                //seekBarAlpha.setProgress(128);
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_index,menu);



    }*/


    SeekBar seekBarRojo, seekBarAzul, seekBarVerde, seekBarAlpha;
    View viewBackground;
    TextView txtAlpha,txtAzul,txtRojo,txtVerde;
    int seekR,seekA,seekV,seekAl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarRojo = (SeekBar)  findViewById(R.id.id_seek_rojo);
        seekBarVerde = (SeekBar)  findViewById(R.id.id_seek_verde);
        seekBarAzul = (SeekBar)  findViewById(R.id.id_seek_azul);
        seekBarAlpha = (SeekBar)  findViewById(R.id.id_seek_alpha);
        viewBackground = (FrameLayout) findViewById(R.id.id_v_background);

        txtAlpha = (TextView) findViewById(R.id.txt_alpha);
        txtAzul = (TextView) findViewById(R.id.txt_azul);
        txtRojo = (TextView) findViewById(R.id.txt_rojo);
        txtVerde = (TextView) findViewById(R.id.txt_verde);


        seekBarAlpha.setOnSeekBarChangeListener(this);
        seekBarAzul.setOnSeekBarChangeListener(this);
        seekBarRojo.setOnSeekBarChangeListener(this);
        seekBarVerde.setOnSeekBarChangeListener(this);

        /*textViewName = (TextView) findViewById(R.id.textViewName);
        buttonAccept = (Button) findViewById(R.id.it_btn_open);


        buttonAccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textViewName.setText("Carlos Ibarra");
                Toast.makeText(MainActivity.this, "Hola Mundo", Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(textViewName);*/


    }

    public void updateBackground(){
        seekAl = seekBarAlpha.getProgress();
        seekR = seekBarRojo.getProgress();
        seekV = seekBarVerde.getProgress();
        seekA = seekBarAzul.getProgress();

        txtAlpha.setText(String.valueOf(seekAl));
        txtAzul.setText(String.valueOf(seekA));
        txtRojo.setText(String.valueOf(seekR));
        txtVerde.setText(String.valueOf(seekV));

        System.out.println(seekAl);
        int color = Color.argb(seekAl,seekR,seekV,seekA);

        viewBackground.setBackgroundColor(color);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        updateBackground();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
