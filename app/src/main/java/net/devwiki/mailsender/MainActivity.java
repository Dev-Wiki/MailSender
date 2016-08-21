package net.devwiki.mailsender;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.send_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEMail();
            }
        });
    }

    private void sendEMail() {
        MailManager.getInstance().sendMail("title", "content");
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "fade.amr";
        MailManager.getInstance().sendMailWithFile("title", "content", path);
    }
}
