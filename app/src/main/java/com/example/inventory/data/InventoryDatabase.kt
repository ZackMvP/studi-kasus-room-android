package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Pembuatan kelas abstract InventoryDatabase
 * Digunakan sebagai tempat penyimpanan data utama, hanya dapat diakses melalui DAO
 * Database berisikan satu entitas yaitu Item
 * Dalam kelas abstract, dibuat suatu function itemDao dengan return type ItemDAO
 *
 * terdapat object singleton agar hanya satu database yang akan digunakan dan dibuat guna menghindari
 * memory leak
 * fungsi getDatabse digunakan untuk mendapatkan database dengan membuat objek database.
 */
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    //Pembuatan fungsi return ItemDao
    abstract fun itemDao(): ItemDao

    companion object {
        //Tidak masuk cache, hanya disimpan di memori utama (RAM). Sehingga bisa dibaca semua thread
        @Volatile
        //Instansiasi singleton
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            // Mengecek apakah object instance null apa tidak, jika ya dibuatkan objek database baru
            // Synchronized digunakan untuk menghindari race condition
            return Instance ?: synchronized(this) {
                //Pembuatan database dengan nama item_database
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    // Build database
                    .build()
                    // Mengatur Instance (Global) menjadi Instance (Lokal)
                    .also { Instance = it }
            }
        }
    }
}