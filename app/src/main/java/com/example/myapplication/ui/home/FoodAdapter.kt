package com.example.myapplication.ui.home

import com.example.myapplication.R
import com.example.myapplication.base.component.recyclerview.RecyclerAdapter
import com.example.myapplication.base.component.recyclerview.ViewHolder
import com.example.myapplication.data.model.FoodItem
import com.example.myapplication.databinding.ItemFoodBinding

class FoodAdapter : RecyclerAdapter<ItemFoodBinding, FoodItem>() {

    inner class FoodViewHolder(val binding: ItemFoodBinding) : ViewHolder<FoodItem>(binding) {

        override val onPressed: ((position: Int) -> Unit)?
            get() = {}
        override val bind: (item: FoodItem) -> Unit
            get() = {
                binding.item = it
            }

    }

    override val layoutRes: Int
        get() = R.layout.item_food

    override fun setHolder(binding: ItemFoodBinding): ViewHolder<FoodItem> = FoodViewHolder(binding)


}