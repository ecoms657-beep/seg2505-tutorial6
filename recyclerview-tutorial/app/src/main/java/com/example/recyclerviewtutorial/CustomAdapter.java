package com.example.recyclerviewtutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final String[] localDataSet;

    // Garde la référence au TextView d'une ligne
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    // Reçoit le tableau de données à afficher
    public CustomAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Crée une nouvelle ligne (appelé par le gestionnaire de mise en page)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        return new ViewHolder(view);
    }

    // Remplit une ligne avec les données (appelé par le gestionnaire de mise en page)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(localDataSet[position]);
    }

    // Nombre d'éléments de la liste
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}