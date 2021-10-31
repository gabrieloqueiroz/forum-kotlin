package br.com.alura.forum.model

import java.time.LocalDateTime

data class Answer(
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: User,
    val topico: Topic,
    val solucao: Boolean
) {

}
