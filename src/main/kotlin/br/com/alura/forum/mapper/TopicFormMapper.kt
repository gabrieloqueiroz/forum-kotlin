package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.model.Topic
import br.com.alura.forum.service.CourseService
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val authorService: UserService,
) : Mapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.searchCourseById(t.idCourse),
            author = authorService.searchUserById(t.idUser)
        )
    }
}
