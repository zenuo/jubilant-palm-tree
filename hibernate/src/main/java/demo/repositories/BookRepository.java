package demo.repositories;

import demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 书籍仓库
 *
 * @author zenuo
 * @date 2019/06/05
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
