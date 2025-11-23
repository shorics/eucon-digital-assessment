package wtf.shorics.model

import wtf.shorics.annotation.NoArg

@NoArg
data class Role(
    val userId: Int,
    val permission: String,
)
