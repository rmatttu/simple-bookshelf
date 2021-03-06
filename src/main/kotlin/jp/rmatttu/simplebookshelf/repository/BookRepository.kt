package jp.rmatttu.simplebookshelf.repository

import jp.rmatttu.simplebookshelf.entity.Book
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Int> {
    fun findAllByOrderById(): List<Book>
    fun findAllByOrderByIdDesc(): List<Book>
    fun findByTitleContainingIgnoreCase(searchTitle: String, pageable: Pageable): List<Book>
    fun countByTitleContainingIgnoreCase(searchTitle: String): Int
}
