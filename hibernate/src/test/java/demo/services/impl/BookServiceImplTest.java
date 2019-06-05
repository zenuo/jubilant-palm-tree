package demo.services.impl;

import demo.Application;
import demo.models.Book;
import demo.services.IBookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 说明
 *
 * @author zenuo
 * @date 2019/06/05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BookServiceImplTest {

    @Autowired
    private IBookService bookService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        final List<Book> books = bookService.list();

        Assert.assertEquals(books.size(), 3);
    }

}