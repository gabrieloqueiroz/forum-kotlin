package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(
    var courses : List<Course>
) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Development"
        )
        courses = Arrays.asList(course)
    }

    fun searchCourseById(id : Long) : Course {
        return courses.first {
            it.id == id
        }
    }

}
