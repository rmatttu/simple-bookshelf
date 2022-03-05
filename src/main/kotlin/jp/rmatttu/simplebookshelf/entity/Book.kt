package jp.rmatttu.simplebookshelf.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Book() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    var title: String = ""

    constructor(id: Int, title: String):this() {
        this.id = id
        this.title = title
    }
}
