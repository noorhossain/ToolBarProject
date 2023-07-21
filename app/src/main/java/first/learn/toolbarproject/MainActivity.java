package first.learn.toolbarproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    ImageView imgFontChange, imgSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

       // setTitle("First Home Page");

        setTitle(Html.fromHtml("<small>First Home Page</small>", Html.FROM_HTML_MODE_LEGACY));


        imgFontChange= (ImageView) findViewById(R.id.imgFontChange);
        imgSettings = (ImageView) findViewById(R.id.imgSettings);


        imgFontChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFontChage ();
            }
        });

        imgSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showFontColor();
            }
        });

    }

    MenuItem btnEmptyCirle, btnBook;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.settings_menu, menu );

        btnEmptyCirle = menu.findItem(R.id.btnEmptyCirle);
        btnBook = menu.findItem(R.id.btnBook);

        btnEmptyCirle.setVisible(false);
        btnBook.setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    boolean isHide = true;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();

        if(id==R.id.btnShowHide){
            if(isHide){
                btnEmptyCirle.setVisible(true);
                btnBook.setVisible(true);
                isHide = false;
            }else {
                btnEmptyCirle.setVisible(false);
                btnBook.setVisible(false);
                isHide = true;
            }
        }

        if(id==R.id.btnEmptyCirle){


            AlertDialog.Builder ad = new AlertDialog.Builder(mContext);
            ad.setTitle("Downloding...");
            ad.setMessage("Please Wait......");
            ad.setPositiveButton("Cancel Download", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog bd = ad.create();

            bd.show();




            new  Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                        bd.setTitle("Success");
                        bd.setMessage("Alhamdulillah, Download Completed.");
                }
            },2500);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bd.dismiss();
                    changeCircle ();
                }
            },5000);


        }


//        if(id==R.id.btnSettings){
//
//            showSettings ();
//        }


        if(id==R.id.btnFontChange){
            showFontChage ();
        }


        if(id==R.id.btnFontColor){
            showFontColor ();
        }

        if(id==R.id.btnFonSize){
            showFontSize ();
        }

        if(id==R.id.btnBook){
            Toast.makeText(this, "This is Book Opening Button", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }


    boolean isEmptyCircle = false ;

    void changeCircle (){

        isEmptyCircle = !isEmptyCircle;

        try {
            invalidateOptionsMenu();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if(isEmptyCircle){

            btnEmptyCirle.setIcon(R.drawable.tick_circle);
        }else {

            btnEmptyCirle.setIcon(R.drawable.empty_circle);
        }

        return super.onPrepareOptionsMenu(menu);
    }

    void showFontChage (){

        new AlertDialog.Builder(mContext).setTitle("Font Change").setMessage("Put Font Change widget here")
                .setPositiveButton("Ok", null).create().show();
    }

    void showFontColor(){

        new AlertDialog.Builder(mContext).setTitle("Font Color").setMessage("Put Font Change widget here")
                .setPositiveButton("Ok", null).create().show();
    }


    void showFontSize(){

        new AlertDialog.Builder(mContext).setTitle("Font Size").setMessage("Put Font Change widget here")
                .setPositiveButton("Ok", null).create().show();
    }
}