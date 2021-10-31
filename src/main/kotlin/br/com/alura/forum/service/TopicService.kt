package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
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

    fun update(form: UpdateTopicForm) {
        val topic = topics.first {
            it.id == form.id
        }
        topics = topics.minus(topic).plus(Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            creationDate = topic.creationDate
        ))
    }

    fun delete(id: Long) {
        val topic = topics.first {
            it.id == id
        }
        topics = topics.minus(topic)
    }
}
