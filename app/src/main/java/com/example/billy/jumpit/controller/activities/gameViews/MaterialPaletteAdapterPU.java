package com.example.billy.jumpit.controller.activities.gameViews;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
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
import android.widget.Toast;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.controller.managers.PowerUpCallback;
import com.example.billy.jumpit.controller.managers.PowerUpManager;
import com.example.billy.jumpit.controller.managers.UserPowerUpCallback;
import com.example.billy.jumpit.controller.managers.UserPowerUpManager;
import com.example.billy.jumpit.model.ClassPowerUp;
import com.example.billy.jumpit.model.PowerUp;
import com.example.billy.jumpit.model.UserPowerUp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lolrol1 on 14/5/17.
 */

public class MaterialPaletteAdapterPU extends RecyclerView.Adapter<MaterialPaletteAdapterPU.PaletteViewHolder> implements UserPowerUpCallback{
    private List<PowerUp> data;
    public List<PowerUp> powerUps = new ArrayList<>();
    RecyclerView list;
    PowerUpManager powerUpManager;
    Context context;
    ArrayList<String> descripcion = new ArrayList();
    Button btnskin;

    public MaterialPaletteAdapterPU(@NonNull List<PowerUp> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public MaterialPaletteAdapterPU.PaletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementpowerup, parent, false);
        return new PaletteViewHolder(row);
    }

    @Override
    public void onBindViewHolder(final MaterialPaletteAdapterPU.PaletteViewHolder holder, int position) {

        descripcion.add("Con estas zapatillas puedes saltar más alto");
        descripcion.add("Con estas monstruosas zapas puedes correr más");
        descripcion.add("Conseguir x2 la puntuación ahora es más fácil");

        final PowerUp powerup = data.get(position);

        holder.getTitleTextView().setText(powerup.getName());

        switch (powerup.getSplashArt()) {
            case "zapatasrojasvoladoras":
                holder.getImageskin().setImageResource(R.drawable.zapatasrojasvoladoras);
                break;
            case "zapatasrojasboost":
                holder.getImageskin().setImageResource(R.drawable.zapatasrojasboost);
                break;
            case "doublescoregold":
                holder.getImageskin().setImageResource(R.drawable.doublescoregold);
                break;
            default:
                break;
        }
        holder.getTextPowerUp().setText(descripcion.get(position));
        holder.getGoldText().setText(powerup.getPriceGame().toString());
        holder.getDonatorText().setText(powerup.getPricePremium().toString());

        holder.btnGoldPowerUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("pep", ".........................................");

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                if(holder.titleTextView.getText().equals("Voladoras")){
                    builder.setMessage("Quieres confirmar la compra con monedas de oro?")
                            .setTitle("Comprar PowerUp de volar:");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            UserPowerUpManager.getInstance().buyPowerUpByPriceGame(MaterialPaletteAdapterPU.this, powerup, 1);
                        }
                    });
                }
                if(holder.titleTextView.getText().equals("Rapidisimas")){
                    builder.setMessage("Quieres confirmar la compra con monedas de oro?")
                            .setTitle("Comprar PowerUp de ir rapidisimo:");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            UserPowerUpManager.getInstance().buyPowerUpByPriceGame(MaterialPaletteAdapterPU.this, powerup, 1);
                        }
                    });
                }
                if(holder.titleTextView.getText().equals("Doble Puntuacion")){
                    builder.setMessage("Quieres confirmar la compra con monedas de oro?")
                            .setTitle("Comprar PowerUp de doble puntuacion:");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            UserPowerUpManager.getInstance().buyPowerUpByPriceGame(MaterialPaletteAdapterPU.this, powerup, 1);
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

        holder.btnDonatorPowerUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("pep", ".........................................");

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                if(holder.titleTextView.getText().equals("Voladoras")){
                    builder.setMessage("Quieres confirmar la compra con monedas Donator?")
                            .setTitle("Comprar PowerUp de volar:");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            UserPowerUpManager.getInstance().buyPowerUpByPricePremium(MaterialPaletteAdapterPU.this, powerup, 1);
                        }
                    });
                }
                if(holder.titleTextView.getText().equals("Rapidisimas")){
                    builder.setMessage("Quieres confirmar la compra con monedas Donator?")
                            .setTitle("Comprar PowerUp de ir rapidisimo:");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            UserPowerUpManager.getInstance().buyPowerUpByPricePremium(MaterialPaletteAdapterPU.this, powerup, 1);
                        }
                    });
                }

                if(holder.titleTextView.getText().equals("Doble Puntuacion")){
                    builder.setMessage("Quieres confirmar la compra con monedas Donator?")
                            .setTitle("Comprar PowerUp de doble puntuacion:");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            UserPowerUpManager.getInstance().buyPowerUpByPricePremium(MaterialPaletteAdapterPU.this, powerup, 1);
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

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onSuccess(List<UserPowerUp> userPowerUpsList) {

    }

    @Override
    public void onSucces() {
        Toast.makeText(context,"ARTICULO ADQUIRIDO", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSucces(UserPowerUp userPowerUp) {

    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(context,"NO TIENES SUFICIENTES CREDITOS", Toast.LENGTH_SHORT).show();
    }


    class PaletteViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private ImageView imagePowerUp;
        private TextView textPowerUp, goldText, donatorText;
        private Button btnGoldPowerUp;
        private Button btnDonatorPowerUp;


        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            titleTextView = (TextView) elementskin.findViewById(R.id.namepowerup);
            imagePowerUp = (ImageView) elementskin.findViewById(R.id.photopowerup);
            textPowerUp = (TextView) elementskin.findViewById(R.id.textDescripcio);
            goldText = (TextView) elementskin.findViewById(R.id.dineroGoldShop);
            donatorText = (TextView) elementskin.findViewById(R.id.dineroDonatorShop);
            btnGoldPowerUp = (Button) elementskin.findViewById(R.id.buttonGoldShop);
            btnDonatorPowerUp = (Button) elementskin.findViewById(R.id.buttonDonatorShop);

            /*btnGoldPowerUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("pep", ".........................................");

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    if(titleTextView.getText().equals("Voladoras")){
                        builder.setMessage("Quieres confirmar la compra con monedas de oro?")
                                .setTitle("Comprar PowerUp de volar:");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                            }
                        });
                    }
                    if(titleTextView.getText().equals("Rapidisimas")){
                        builder.setMessage("Quieres confirmar la compra con monedas de oro?")
                                .setTitle("Comprar PowerUp de ir rapidisimo:");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                            }
                        });
                    }
                    if(titleTextView.getText().equals("Doble Puntuacion")){
                        builder.setMessage("Quieres confirmar la compra con monedas de oro?")
                                .setTitle("Comprar PowerUp de doble puntuacion:");
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

            btnDonatorPowerUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("pep", ".........................................");

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    if(titleTextView.getText().equals("Voladoras")){
                        builder.setMessage("Quieres confirmar la compra con monedas Donator?")
                                .setTitle("Comprar PowerUp de volar:");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                            }
                        });
                    }
                    if(titleTextView.getText().equals("Rapidisimas")){
                        builder.setMessage("Quieres confirmar la compra con monedas Donator?")
                                .setTitle("Comprar PowerUp de ir rapidisimo:");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                            }
                        });
                    }

                    if(titleTextView.getText().equals("Doble Puntuacion")){
                        builder.setMessage("Quieres confirmar la compra con monedas Donator?")
                                .setTitle("Comprar PowerUp de doble puntuacion:");
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
            });*/
        }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public ImageView getImageskin() {
            return imagePowerUp;
        }

        public TextView getTextPowerUp() {
            return textPowerUp;
        }

        public Button getBtnGoldPowerUp() {
            return btnGoldPowerUp;
        }

        public void setBtnGoldPowerUp(Button btnGoldPowerUp) {
            this.btnGoldPowerUp = btnGoldPowerUp;
        }

        public Button getBtnDonatorPowerUp() {
            return btnDonatorPowerUp;
        }

        public void setBtnDonatorPowerUp(Button btnDonatorPowerUp) {
            this.btnDonatorPowerUp = btnDonatorPowerUp;
        }

        public void setTitleTextView(TextView titleTextView) {
            this.titleTextView = titleTextView;
        }

        public ImageView getImagePowerUp() {
            return imagePowerUp;
        }

        public void setImagePowerUp(ImageView imagePowerUp) {
            this.imagePowerUp = imagePowerUp;
        }

        public void setTextPowerUp(TextView textPowerUp) {
            this.textPowerUp = textPowerUp;
        }

        public TextView getGoldText() {
            return goldText;
        }

        public void setGoldText(TextView goldText) {
            this.goldText = goldText;
        }

        public TextView getDonatorText() {
            return donatorText;
        }

        public void setDonatorText(TextView donatorText) {
            this.donatorText = donatorText;
        }
    }


}
