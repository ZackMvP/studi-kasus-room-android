package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
/**
 * DAO (Data Access Object) Merupakan sebuah kelas yang dibuat dengan fungsi mengakses database.
 * DAO yang dibuat merupakan suatu interface dengan nama ItemDao
 * Menginisialisasi DAO harus menggunakan annotation @DAO
 * Memasukkan data menggunakan annotation @Insert, Mengupdate data dengan @Update, Menghapus data
 * menggunakan @Delete, dan mendapatkan data dengan @Query.
 *
 * Parameter onConflict pada @Insert digunakan sebagai metode penaganan apabila terjadi masalah
 * seperti penambahann data secara bersamaan.
 * Parameter dari @Query merupakan suatu command SQLite3.
 *
 * Return value dari tiap function adalam entity  itu sendiri. Namun, pada @Query, digunakan
 * Flow untuk mendapatkan data secara pararel di thread berbeda tanpa membuat function suspend
 **/

//Inisasi DAO
@Dao
interface ItemDao {
    //Menambahkan data
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    //Memperbarui data
    @Update
    suspend fun update(item: Item)

    //Menghapus data
    @Delete
    suspend fun delete(item: Item)

    //Mendapatkan item berdasarkan idnya
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    //Mendapatkan seluruh item secara menaik
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}