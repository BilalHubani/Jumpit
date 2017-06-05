package com.example.billy.jumpit.controller.activities.gameViews;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MaterialPaletteAdapter extends RecyclerView.Adapter<MaterialPaletteAdapter.PaletteViewHolder> implements SkinCallback{
    private List<Skin> data;
    public List<Skin> skins = new ArrayList<>();
    RecyclerView list;
    SkinManager skinManager;
    //SkinCallback skinCallback;
    Context context;
    ArrayList <Integer> imagenes = new ArrayList();
    ArrayList <String> ids = new ArrayList();
    Button btnskin;

    public MaterialPaletteAdapter(@NonNull List<Skin> data, Context context) {
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

        //String uri = "drawable/skinrosita";

        //int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());

        //Drawable image = context.getResources().getDrawable(imageResource);

        Skin skin = data.get(position);
        //int foto = Integer.parseInt(skin.getSplashArt());

        switch (skin.getSplashArt()) {
            case "skinrosita":
                holder.getImageskin().setImageResource(R.drawable.skinrosita);
                break;
            case "moco":
                holder.getImageskin().setImageResource(R.drawable.moco);
                break;
            case "blackdragon":
                holder.getImageskin().setImageResource(R.drawable.blackdragon);
                break;
            case "vikings":
                holder.getImageskin().setImageResource(R.drawable.vikingsshop);
                break;
            case "caballero":
                holder.getImageskin().setImageResource(R.drawable.caballeroshop);
                break;
            case "mago":
                holder.getImageskin().setImageResource(R.drawable.magoshop);
                break;
            case "azulete":
                holder.getImageskin().setImageResource(R.drawable.azuleteshop);
                break;
            default:
                break;
        }

        holder.getTitleTextView().setText(skin.getName());
        holder.getImageskin().setImageResource(R.drawable.skinrosita);
        holder.textGoldSkin.setText(skin.getPriceGame().toString());
        holder.textDonatorSkin.setText(skin.getPricePremium().toString());
        holder.getBtnskin();


    }

    @Override
    public void onSuccess(List<Skin> skinsList) {

    }

    @Override
    public void onSucces() {

    }

    @Override
    public void onSucces(Skin skin) {

    }

    @Override
    public void onFailure(Throwable t) {


    }


    class PaletteViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private ImageView imageskin;
        private Button btnGoldSkin;
        private Button btnDonatorSkin;
        private TextView textGoldSkin;
        private TextView textDonatorSkin;

        public PaletteViewHolder(final View elementskin) {
            super(elementskin);
            titleTextView = (TextView) elementskin.findViewById(R.id.nameskin);
            imageskin = (ImageView) elementskin.findViewById(R.id.photoskin);
            btnGoldSkin = (Button) elementskin.findViewById(R.id.buttonGoldShop);
            btnDonatorSkin = (Button) elementskin.findViewById(R.id.buttonDonatorShop);
            textGoldSkin = (TextView) elementskin.findViewById(R.id.dineroGoldShop);
            textDonatorSkin = (TextView) elementskin.findViewById(R.id.dineroDonatorShop);

            btnGoldSkin.setOnClickListener(new View.OnClickListener() {
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
            btnDonatorSkin.setOnClickListener(new View.OnClickListener() {
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

        public Button getBtnGoldSkin() {
            return btnGoldSkin;
        }
    }

        public Button getBtnDonatorSkin() {
            return btnDonatorSkin;
        }

        public TextView getTextGoldSkin() {
            return textGoldSkin;
        }

        public TextView getTextDonatorSkin() {
            return textDonatorSkin;
        }

        public void setTitleTextView(TextView titleTextView) {
            this.titleTextView = titleTextView;
        }

        public void setImageskin(ImageView imageskin) {
            this.imageskin = imageskin;
        }

        public void setBtnGoldSkin(Button btnGoldSkin) {
            this.btnGoldSkin = btnGoldSkin;
        }

        public void setBtnDonatorSkin(Button btnDonatorSkin) {
            this.btnDonatorSkin = btnDonatorSkin;
        }

        public void setTextGoldSkin(TextView textGoldSkin) {
            this.textGoldSkin = textGoldSkin;
        }

        public void setTextDonatorSkin(TextView textDonatorSkin) {
            this.textDonatorSkin = textDonatorSkin;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}