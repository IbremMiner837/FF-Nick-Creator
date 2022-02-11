package com.infinitybyte.nickcreator.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infinitybyte.nickcreator.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Model> listRecyclerItem;
    private final Context context;

    public Adapter(Context context, List<Model> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView system, festive_regular;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            system = (TextView) itemView.findViewById(R.id.nickname_list);
            festive_regular = (TextView) itemView.findViewById(R.id.nickname_list);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.nickname_list, viewGroup, false);

        return new ItemViewHolder((layoutView));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        Model itemInfo = (Model) listRecyclerItem.get(i);

        itemViewHolder.festive_regular.setText(itemInfo.getNickname());
        itemViewHolder.festive_regular.setTypeface(context.getResources().getFont(R.font.festive_regular));
    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
