package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic>,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    fun list(): List<TopicView> {
        return topics.map {
            topicViewMapper.map(it)
        }.toList()
    }

    fun searchId(id : Long): TopicView {
        val topic = topics.first {
            it.id == id
        }
        return topicViewMapper.map(topic)
    }

    fun createTopics(form: TopicForm) {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }
}
