package wtf.shorics.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import wtf.shorics.annotation.NoArg

@Entity(name = "roles")
@Table(uniqueConstraints=[
    UniqueConstraint(columnNames = ["user_id", "permission"])
])
@NoArg
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User?,

    @Column(nullable = false)
    val permission: String?,
)