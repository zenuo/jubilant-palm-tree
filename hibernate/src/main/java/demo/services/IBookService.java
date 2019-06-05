package demo.services;

import demo.models.Book;

import java.util.List;

/**
 * 书籍服务
 *
 * @author zenuo
 * @date 2019/06/05
 */
public interface IBookService {
    List<Book> list();
}
