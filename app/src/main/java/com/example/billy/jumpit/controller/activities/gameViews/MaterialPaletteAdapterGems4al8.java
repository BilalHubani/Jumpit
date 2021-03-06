package com.example.billy.jumpit.controller.activities.gameViews;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.model.ClassGems;

import java.util.ArrayList;
import java.util.List;

public class MaterialPaletteAdapterGems4al8 extends RecyclerView.Adapter<MaterialPaletteAdapterGems4al8.PaletteViewHolder> {
    private List<ClassGems> data;
    RecyclerView list;
    Context context;
    RelativeLayout fondo;
    ArrayList <Integer> imagenes = new ArrayList();
    ArrayList <String> euros = new ArrayList();
    Button btnskin;

    public MaterialPaletteAdapterGems4al8(@NonNull List<ClassGems> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public PaletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementgems, parent, false);
        return new PaletteViewHolder(row);
    }

    @Override
    public void onBindViewHolder(PaletteViewHolder holder, int position) {
        imagenes.add(R.drawable.monedabuy5);imagenes.add(R.drawable.monedabuy6);
        imagenes.add(R.drawable.monedabuy7);imagenes.add(R.drawable.monedabuy8);
        euros.add("2 €");euros.add("3 €");euros.add("4 €");euros.add("5 €");
        holder.getTextView().setText(euros.get(position));
        ClassGems color = data.get(position);
        holder.getImagen();
        holder.getImagen().setImageResource(imagenes.get(position));
        holder.getImagebutton();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PaletteViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private Button imagebutton;
        private TextView textView;

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }


        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            imagen = (ImageView) elementskin.findViewById(R.id.photoGemasBuy);
            imagebutton = (Button) elementskin.findViewById(R.id.buttonGems);
            textView = (TextView) elementskin.findViewById(R.id.eurosBuy);
            //probando

            imagebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("pep", ".........................................");

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    if(textView.getText().equals("2 €")){
                        builder.setMessage("Quieres confirmar la compra de 400 gemas?")
                                .setTitle("Compra1:");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                            }
                        });
                    }if(textView.getText().equals("3 €")){
                        builder.setMessage("Quieres confirmar la compra de 600 gemas?")
                                .setTitle("Compra1:");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                            }
                        });
                    }if(textView.getText().equals("4 €")){
                        builder.setMessage("Quieres confirmar la compra de 800 gemas?")
                                .setTitle("Compra1:");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                            }
                        });
                    }if(textView.getText().equals("5 €")){
                        builder.setMessage("Quieres confirmar la compra de 1000 gemas?")
                                .setTitle("Compra1:");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                            }
                        });
                    }
                    builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
            });
        }

        public ImageView getImagen() {
            return imagen;
        }

        public Button getImagebutton() {
            return imagebutton;
        }

    }

}