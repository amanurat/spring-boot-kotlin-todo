package com.github.tompower.sbktd.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/")
class IndexController {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun index(): String {
        return "redirect:/todos"
    }
}