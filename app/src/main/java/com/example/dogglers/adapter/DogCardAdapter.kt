/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog

class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    private val dogs: List<Dog> = DataSource.dogs

    class DogCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dogPicture: ImageView = view.findViewById(R.id.dog_picture)
        val dogName: TextView = view.findViewById(R.id.dogs_name)
        val dogAge: TextView = view.findViewById(R.id.dogs_age)
        val dogHobby: TextView = view.findViewById(R.id.dogs_hobby)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val layoutType = when (layout) {
            Layout.GRID -> R.layout.grid_list_item
            else -> R.layout.vertical_horizontal_list_item
        }
        return DogCardViewHolder(LayoutInflater.from(parent.context)
            .inflate(layoutType, parent, false))
    }

    override fun getItemCount(): Int = dogs.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val dog = dogs[position]
        holder.dogPicture.setImageResource(dog.imageResourceId)
        holder.dogName.text = dog.name
        holder.dogAge.text = dog.age
        holder.dogHobby.text = dog.hobbies

        val resources = context?.resources
        resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
