package com.silveira.developer.crudkotlinjwt.controllers

import com.silveira.developer.crudkotlinjwt.models.User
import com.silveira.developer.crudkotlinjwt.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@CrossOrigin(origins = arrayOf("*"), maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")
class AuthController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun signup(@RequestBody user: User): ResponseEntity<User> {
        val userCreated = userService.create(user)
        return ResponseEntity.created(URI("")).body(userCreated)
    }
}