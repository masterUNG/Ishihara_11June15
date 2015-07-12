package appewtc.masterung.ishihara;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ShowScoreActivity extends AppCompatActivity {

    //Explicit
    TextView showScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        //Bind Widget
        bindWidget();

        //Show Score
        showScore();

    }   // onCreate

    public void clickExit(View view) {

        //Show Alert Dialog
        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.danger);
        objBuilder.setTitle("Confirm Exit");
        objBuilder.setMessage("Are you sure ? Do you want to exit ?");
        objBuilder.setCancelable(false);
        objBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                dialogInterface.dismiss();
            }
        });
        objBuilder.show();
    }

    public void clickPlay(View view) {

        //Full
//        Intent objIntent = new Intent(ShowScoreActivity.this, MainActivity.class);
//        startActivity(objIntent);
//        finish();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }



    private void showScore() {

        //Receive Value from Intent
        int intMyScore = getIntent().getExtras().getInt("Score");
        showScoreTextView.setText(Integer.toString(intMyScore) + "/10" );

    }

    private void bindWidget() {
        showScoreTextView = (TextView) findViewById(R.id.txtShowScore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_score, menu);
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
}   // Main Class
