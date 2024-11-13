/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity berisikan data yang ada dalam database. Kurang lebih fungsinya sama dengan tabel
 * Menginisasi Entity diperlukan anotasi @Entity dengan parameter tableName.
 * Dalam kasus ini, digunakan nama items.
 * Sama seperti data class, isi dari entity merupakan variabel.
 * Karena database bersifat RDBMS. Untuk mengatur primary key, digunakan anotasi @PrimaryKey pada
 * variabel yang diinginkan. Dengan auto increment menggunakna parameter autoGenerate = true.
 *
 * Pada kasus ini, ada 4 variabel yaitu id sebagai primary key yang memiliki data type int yang
 * dimulai dar 0.
 * Name dengan data type String
 * Price dengan data type double
 * Quantity dengan data type int.
 */

@Entity(tableName = "items")
class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)
