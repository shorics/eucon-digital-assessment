package model;

import wtf.shorics.annotation.NoArg

@NoArg
data class User(
    val id: Int,
    val email: String,
)