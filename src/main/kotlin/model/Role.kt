package wtf.shorics.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import model.User
import wtf.shorics.annotation.NoArg

@Entity(name = "roles")
@NoArg
data class Role(
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    val id: Long?,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User?,

    @Column
    val permission: String?,
)