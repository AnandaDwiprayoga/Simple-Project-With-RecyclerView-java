package com.example.dicodingtugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dicodingtugasakhir.models.DesignerModels;

public class DetailDesigner extends AppCompatActivity {

    public static final String KEY_DESIGNER = "key _designer";
    private DesignerModels designerModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_designer);

         ImageView photo, photoBelakang;
         TextView textViewNama, textViewDesc, textViewAddress, textViewEmail, textViewNumber;

        photo = findViewById(R.id.iv_profil);
        photoBelakang = findViewById(R.id.iv_backImg);
        textViewNama = findViewById(R.id.tv_namaDesigner);
        textViewDesc = findViewById(R.id.tv_descDesigner);
        textViewAddress = findViewById(R.id.tv_address);
        textViewEmail = findViewById(R.id.tv_email);
        textViewNumber = findViewById(R.id.tv_phone);

        designerModels = getIntent().getParcelableExtra(KEY_DESIGNER);

        if(designerModels != null) {
            photo.setImageResource(designerModels.getPhoto());
            photoBelakang.setImageResource(designerModels.getPhotoBelakang());
            textViewNama.setText(designerModels.getNama());
            textViewDesc.setText(designerModels.getDesc());
            textViewAddress.setText(designerModels.getAlamat());
            textViewEmail.setText(designerModels.getEmail());
            textViewNumber.setText(designerModels.getNomer());
        }

        Button buttonSaveContact = findViewById(R.id.buttonContact);
        Button buttonEmail = findViewById(R.id.buttonEmail);

        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(designerModels!= null) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + designerModels.getEmail()));
                    if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
                }
            }
        });

        buttonSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (designerModels != null) {
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.NAME, designerModels.getNama());
                    intent.putExtra(ContactsContract.Intents.Insert.EMAIL, designerModels.getEmail());
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE, designerModels.getNomer());
                    if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
                }
            }
        });
    }
}
