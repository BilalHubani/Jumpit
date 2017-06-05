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
import android.widget.TextView;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.controller.managers.SkinCallback;
import com.example.billy.jumpit.controller.managers.SkinManager;
import com.example.billy.jumpit.controller.services.SkinService;
import com.example.billy.jumpit.model.*;
import com.example.billy.jumpit.model.Skin;

import java.util.ArrayList;
import java.util.List;

public class MaterialPaletteAdapter extends RecyclerView.Adapter<MaterialPaletteAdapter.PaletteViewHolder> {
    private List<ClassSkin> data;
    public List<Skin> skins;
    RecyclerView list;
    SkinManager skinManager;
    SkinCallback skinCallback;
    Context context;
    ArrayList <Integer> imagenes = new ArrayList();
    ArrayList <String> ids = new ArrayList();
    Button btnskin;
    int i = 0;

    public MaterialPaletteAdapter(@NonNull List<ClassSkin> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public PaletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementskin, parent, false);
        return new PaletteViewHolder(row);
    }

    @Override
    public void onBindViewHolder(PaletteViewHolder holder, int position) {

        skins = new ArrayList<>();

        //SkinManager.getInstance().getAllSkins(skinCallback);


        Log.e("------->>>>>", "");

        ClassSkin color = data.get(position);
        holder.getTitleTextView().setText(color.getNombre());
        holder.getImageskin().setImageResource(color.getFoto());
        holder.getBtnskin();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PaletteViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private ImageView imageskin;
        private Button btnGoldPowerUp;
        private Button btnDonatorPowerUp;

        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            titleTextView = (TextView) elementskin.findViewById(R.id.nameskin);
            imageskin = (ImageView) elementskin.findViewById(R.id.photoskin);
            btnGoldPowerUp = (Button) elementskin.findViewById(R.id.buttonGoldShop);
            btnDonatorPowerUp = (Button) elementskin.findViewById(R.id.buttonDonatorShop);

            btnGoldPowerUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    builder.setMessage("Quieres confirmar la compra?")
                            .setTitle("Compra gold:");
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
            btnDonatorPowerUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("pep", ".........................................");

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    builder.setMessage("Quieres confirmar la compra?")
                            .setTitle("Compra donator:");
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

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public ImageView getImageskin() {
            return imageskin;
        }

        public Button getBtnskin() {
            return btnskin;
        }

    }

    public void pepe(){
        btnskin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



}