package com.github.tompower.sbktd.controller

import com.github.tompower.sbktd.entity.Todo
import com.github.tompower.sbktd.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("/todos")
class TodoController @Autowired constructor(val todoService: TodoService) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun list(model: Model): String {
        model.addAttribute("todos", todoService.findAll())
        return "todos"
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun add(todo: Todo, redirectAttributes: RedirectAttributes): String {
        todoService.create(todo)
        redirectAttributes.addFlashAttribute("success", "${todo.name} created")
        return "redirect:/todos"
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.DELETE))
    fun complete(@PathVariable id: Long, redirectAttributes: RedirectAttributes): String {
        val todo = todoService.findOne(id)
        todoService.delete(todo)
        redirectAttributes.addFlashAttribute("success", "${todo.name} deleted")
        return "redirect:/todos"
    }
}
