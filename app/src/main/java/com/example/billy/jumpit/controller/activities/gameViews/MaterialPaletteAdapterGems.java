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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.model.ClassGems;

import java.util.ArrayList;
import java.util.List;

public class MaterialPaletteAdapterGems extends RecyclerView.Adapter<MaterialPaletteAdapterGems.PaletteViewHolder> {
    private List<ClassGems> data;
    RecyclerView list;
    Context context;
    RelativeLayout fondo;
    ArrayList <Integer> imagenes = new ArrayList();
    Button btnskin;
    ArrayList <String> euros = new ArrayList();

    public MaterialPaletteAdapterGems(@NonNull List<ClassGems> data, Context context) {
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
        imagenes.add(R.drawable.monedabuy1);imagenes.add(R.drawable.monedabuy2);imagenes.add(R.drawable.monedabuy3);
        imagenes.add(R.drawable.monedabuy4);
        euros.add("0,5 €");euros.add("0,75 €");euros.add("1 €");euros.add("1,5 €");
        holder.getTextView().setText(euros.get(position));
        ClassGems color = data.get(position);
        holder.getImagebutton();
        holder.getImagen();
        holder.getImagen().setImageResource(imagenes.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PaletteViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private Button imagebutton;
        private TextView textView;

        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            imagen = (ImageView) elementskin.findViewById(R.id.photoGemasBuy);
            imagebutton = (Button) elementskin.findViewById(R.id.buttonGems);
            textView = (TextView) elementskin.findViewById(R.id.eurosBuy);

            imagebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("pep", ".........................................");

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    builder.setMessage("Quieres confirmar la compra?")
                            .setTitle("Compra1:");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK button
                        }
                    });
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


        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
        public ImageView getImagen() {
            return imagen;
        }

        public Button getImagebutton() {
            return imagebutton;
        }

    }

}