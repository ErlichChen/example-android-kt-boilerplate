package com.example.kt.boilerplate.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity (
    @PrimaryKey
    var id: String = "000001",
    @ColumnInfo(name = "user_name")
    var username: String
) {

}