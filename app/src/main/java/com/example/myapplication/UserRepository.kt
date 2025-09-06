package com.example.myapplication

object UserRepository {

    private val users = mutableMapOf<String, String>()

    fun addUser(email: String, password: String): Boolean {
        if (users.containsKey(email)) {
            return false
        }
        users[email] = password
        return true
    }

    fun findUser(email: String, password: String): User? {
        return if (users.containsKey(email) && users[email] == password) {
            User(email)
        } else {
            null
        }
    }

    fun getAllUsers(): List<User> {
        return users.keys.map { User(it) }
    }
}