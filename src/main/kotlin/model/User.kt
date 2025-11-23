package wtf.shorics.model

import wtf.shorics.annotation.NoArg
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "users")
@NoArg
data class User(
    @Id
    val id: Long?,

    @Column(nullable = false)
    val email: String?,
)