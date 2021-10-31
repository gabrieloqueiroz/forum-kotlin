package br.com.alura.forum.controller

import br.com.alura.forum.service.TopicService
import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.model.Topic
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder
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
    fun createTopic(@RequestBody @Valid form : TopicForm, uriBuilder : UriComponentsBuilder) : ResponseEntity <TopicView> {
        val topicView = service.createTopics(form)
        val uri = uriBuilder.path("/topic/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping()
    fun updateTopic(@RequestBody @Valid form : UpdateTopicForm) : ResponseEntity<TopicView>{
        val updatedTopic = service.update(form)
        return ResponseEntity.ok(updatedTopic)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id : Long){
        service.delete(id)
    }
}
