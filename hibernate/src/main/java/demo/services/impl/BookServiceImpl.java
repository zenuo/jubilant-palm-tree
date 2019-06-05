package demo.services.impl;

import demo.models.Book;
import demo.repositories.BookRepository;
import demo.services.IBookService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 书籍服务实现
 *
 * @author zenuo
 * @date 2019/06/05
 */
@Service
@RequiredArgsConstructor
final class BookServiceImpl implements IBookService {

    @NonNull
    private final BookRepository bookRepository;

    @Override
    public List<Book> list() {
        return bookRepository.findAll();
    }
}
