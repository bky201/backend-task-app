package com.example.backendtaskapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.sql.DriverManager.println

@SpringBootApplication
class BackendTaskAppApplication

fun main(args: Array<String>) {
	runApplication<BackendTaskAppApplication>(*args)
	kotlin.io.println("Hello!")
}
