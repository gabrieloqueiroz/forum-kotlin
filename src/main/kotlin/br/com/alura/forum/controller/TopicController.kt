package br.com.alura.forum.controller

import br.com.alura.forum.service.TopicService
import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.model.Topic
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(
    private val service : TopicService
) {

    @GetMapping
    fun list () : List<TopicView>{
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchId(@PathVariable id : Long ) : TopicView{
        return service.searchId(id)
    }

    @PostMapping
    fun createTopic(@RequestBody @Valid dto : TopicForm) {
        service.createTopics(dto)
    }

}