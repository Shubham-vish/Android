package com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByProducts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.EcomerceCategory;

import java.util.List;

public class ProductsPostAdapter extends RecyclerView.Adapter<ProductsPostAdapter.ViewHolder>{
    Context context;
    List<EcomerceCategory> categoryList;

    public ProductsPostAdapter(Context context, List<EcomerceCategory> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.post_scroll_view, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        EcomerceCategory item=categoryList.get(i);
        viewHolder.categoryText.setText(item.getName());
        //viewHolder.imageView.setImageDrawable(item.getImage());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void addItems(List<EcomerceCategory> lst) {
        categoryList.addAll(lst);

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView categoryText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.categoryImage);
            categoryText=itemView.findViewById(R.id.categoryName);
        }
    }
}
