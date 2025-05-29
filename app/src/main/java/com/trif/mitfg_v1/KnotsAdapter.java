package com.trif.mitfg_v1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class KnotsAdapter extends RecyclerView.Adapter<KnotsAdapter.KnotViewHolder> {

    private List<KnotItem> knots;
    private OnKnotClickListener listener;

    public interface OnKnotClickListener {
        void onKnotClick(KnotItem knot);
    }

    public KnotsAdapter(List<KnotItem> knots, OnKnotClickListener listener) {
        this.knots = knots;
        this.listener = listener;
    }

    @NonNull
    @Override
    public KnotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_knot, parent, false);
        return new KnotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KnotViewHolder holder, int position) {
        KnotItem knot = knots.get(position);
        holder.bind(knot, listener);
    }

    @Override
    public int getItemCount() {
        return knots.size();
    }

    static class KnotViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgKnotIcon;
        private TextView txtKnotName;
        private TextView txtKnotDescription;

        public KnotViewHolder(@NonNull View itemView) {
            super(itemView);
            imgKnotIcon = itemView.findViewById(R.id.imgKnotIcon);
            txtKnotName = itemView.findViewById(R.id.txtKnotName);
            txtKnotDescription = itemView.findViewById(R.id.txtKnotDescription);
        }

        public void bind(KnotItem knot, OnKnotClickListener listener) {
            txtKnotName.setText(knot.getName());
            txtKnotDescription.setText(knot.getDescription());

            int iconResId = itemView.getContext().getResources()
                    .getIdentifier(knot.getIconName(), "drawable", itemView.getContext().getPackageName());

            if (iconResId != 0) {
                imgKnotIcon.setImageResource(iconResId);
            } else {
                imgKnotIcon.setImageResource(R.drawable.ic_knot_default);
            }

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onKnotClick(knot);
                }
            });
        }
    }
}
