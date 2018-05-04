package sanchez.samuel.coagronorte.develop.servidores;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class RegistreServer extends Activity {

    @BindView(R.id.choose_camara)
    CircleImageView newPhoto;

    File photo = null;
    String URL_IMAGE = "";
    private String photoPathTemp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_server);
        ButterKnife.bind(this);
        choseFromCamera(newPhoto);
    }



    public void choseFromCamera(CircleImageView circleImageView){
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getApplication().getPackageManager()) != null)
                {
                    photo = null;
                    try
                    {
                        photo = createTemporaryFile();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    if(photo != null)
                    {
                        Uri photoUri = FileProvider.getUriForFile(getApplicationContext(),"sanchez.samuel.coagronorte.develop.servidores",photo);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                        startActivityForResult(intent,1);
                    }
                }
            }
        });

    }

    private File createTemporaryFile()
            throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HH-mm-ss").format(new Date());
        String imagefileName =  timeStamp+"pruebas";
        File storageDir = getApplication().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File photo = File.createTempFile(imagefileName,".jpg",storageDir);
        photoPathTemp = "file:" +photo.getAbsolutePath();
        return  photo;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            Picasso.get().load(photo.getAbsoluteFile()).into(newPhoto);
        }
    }


}
