package br.com.alura.forum.controller

import br.com.alura.forum.service.TopicService
import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
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
    fun createTopic(@RequestBody @Valid form : TopicForm) {
        service.createTopics(form)
    }

    @PutMapping()
    fun updateTopic(@RequestBody @Valid form : UpdateTopicForm){
        service.update(form)
    }

    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id : Long){
        service.delete(id)
    }


}
