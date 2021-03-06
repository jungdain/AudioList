package rlathfdl463.kr.hs.emirim.audiolist;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button butPlay, butStop;
    TextView textMusic;
    ProgressBar progress;
    String[] music={"moves_like_jagger", "sunday morning", "This love"};
    int[] musicReadIds={R.raw.move_like_jagger, R.raw.sunday_morning, R.raw.this};
    int selectedMusiId;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list_music);
        butPlay = (Button) findViewById(R.id.but_play);
        butStop = (Button) findViewById(R.id.but_stop);
        textMusic = (TextView) findViewById(R.id.text_music);
        progress = (ProgressBar) findViewById(R.id.progress_music);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.id.layout.simple_list_single_choice, music);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setItemChecked(0, true);
        selectedMusiId=musicReadIds[0];
        mediaPlayer=MediaPlayer.create(this, selectedMusiId);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedMusiId=musicReadIds[i];
            }
        });

        butPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        butStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}
