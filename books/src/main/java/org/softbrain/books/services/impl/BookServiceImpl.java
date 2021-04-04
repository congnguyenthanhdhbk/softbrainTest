package org.softbrain.books.services.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.softbrain.books.converter.BookConverter;
import org.softbrain.books.dtos.AppResponse;
import org.softbrain.books.dtos.BookDto;
import org.softbrain.books.enums.AppMessageEnum;
import org.softbrain.books.models.Book;
import org.softbrain.books.repositories.BookRepository;
import org.softbrain.books.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    // Inject a repository to manipulate directly book table via JPA
    private BookRepository bookRepository;
    private BookConverter bookConverter;

    /**
     * Applying DI by using constructor type
     * @param bookRepository
     * @param bookConverter
     */
    public BookServiceImpl(BookRepository bookRepository,
                           BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
    }

    /**
     * @see {@link BookService#addBook(BookDto)}
     * @param book BookDto
     * @return
     */
    @Override
    public AppResponse<Book> addBook(final BookDto book) {
        final Book convertedBook = this.bookConverter.convertToBook(book);
        final Book savedBook = this.bookRepository.save(convertedBook);
        return new AppResponse<Book>(
                AppMessageEnum.SAVED_BOOK_SUCCESS.getCode(),
                AppMessageEnum.SAVED_BOOK_SUCCESS.getMessage(),
                savedBook);
    }

    /**
     * @see {@link BookService#findAllBook(Integer, Integer)}
     * @param pageNumber Integer
     * @param pageSize Integer
     * @return Page of list book
     */
    @Override
    public AppResponse<Page<Book>> findAllBook(final Integer pageNumber, final Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Book> books = this.bookRepository.findAll(pageable);
        return new AppResponse<>(
                AppMessageEnum.FIND_BOOK_BY_ID_SUCCEED.getCode(),
                AppMessageEnum.FIND_ALL_BOOK_SUCCESS.getMessage(),
                books);
    }

    /**
     * @see {@link BookService#findBookById(Integer)}
     * @param bookId Integer
     * @return
     */
    @Override
    public AppResponse<Book> findBookById(Integer bookId) {
        return new AppResponse<>(
                AppMessageEnum.FIND_BOOK_BY_ID_SUCCEED.getCode(),
                AppMessageEnum.FIND_BOOK_BY_ID_SUCCEED.getMessage(),
                this.bookRepository.findById(bookId).get()
        );
    }

    @Override
    public AppResponse<Boolean> updateBook(Integer bookId, BookDto updatedBookDto) {
        final Book foundBook = this.bookRepository.findById(bookId).get();
        final Book convertedBook = this.bookConverter.convertToBook(updatedBookDto);

        // Check isbn before updating
        if (StringUtils.isNotEmpty(updatedBookDto.getIsbn())) {
            foundBook.setIsbn(convertedBook.getIsbn());
        }
        // Check title before updating
        if (StringUtils.isNotEmpty(updatedBookDto.getTitle())) {
            foundBook.setTitle(convertedBook.getTitle());
        }

        if (StringUtils.isNotEmpty(convertedBook.getPublisher())) {
            foundBook.setPublisher(convertedBook.getPublisher());
        }
        final Book updatedBook = this.bookRepository.save(foundBook);

        if (ObjectUtils.isNotEmpty(updatedBook)) {
            return new AppResponse<Boolean>(
                    AppMessageEnum.UPDATED_BOOK_SUCCESS.getCode(),
                    AppMessageEnum.UPDATED_BOOK_SUCCESS.getMessage(), true);
        }
        return new AppResponse<Boolean>(
                AppMessageEnum.UPDATED_BOOK_SUCCESS.getCode(),
                AppMessageEnum.UPDATED_BOOK_SUCCESS.getMessage(), false);
    }
}
