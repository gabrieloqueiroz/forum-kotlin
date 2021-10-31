package br.com.alura.forum.service

import br.com.alura.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
data class UserService(
    var users : List<User>
) {

    init {
        val user = User(
            id = 1,
            name = "Gabriel Queiroz",
            email = "gabriel@email.com"
        )
        users = Arrays.asList(user)
    }

    fun searchUserById(id: Long): User {
        return users.first {
            it.id == id
        }
    }
}
