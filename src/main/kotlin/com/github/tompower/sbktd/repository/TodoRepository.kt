package com.github.tompower.sbktd.repository

import com.github.tompower.sbktd.entity.Todo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : CrudRepository<Todo, Long>
