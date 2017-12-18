package com.happykart.android.ui.main;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.happykart.android.R;
import com.happykart.android.databinding.ItemCategoryBinding;
import com.happykart.android.model.Category;
import com.happykart.android.util.ActivityRouter;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemViewHolder> {

    private ActivityRouter router;
    private final ObservableList<Category> dataList;

    public CategoryAdapter(ActivityRouter router, ObservableList<Category> dataList) {
        this.router=router;
        this.dataList = dataList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_category, parent, false);
        return new ItemViewHolder(binding, new CategoryItemViewModel());
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class ItemViewHolder extends RecyclerView.ViewHolder {

        private final CategoryItemViewModel viewModel;
        private final ItemCategoryBinding binding;

        public ItemViewHolder(ItemCategoryBinding binding, CategoryItemViewModel viewModel) {
            super(binding.getRoot());
            this.viewModel = viewModel;
            this.binding = binding;
        }

        public void bind(Category category) {
            viewModel.setCategory(category);
            binding.setVm(viewModel);
            binding.executePendingBindings();

            binding.btnCategory.setOnClickListener(v -> {
                if(getAdapterPosition()==RecyclerView.NO_POSITION)return;
                Category cat=dataList.get(getAdapterPosition());
                router.startProductListActivity(cat.getName());
            });
        }
    }

}
