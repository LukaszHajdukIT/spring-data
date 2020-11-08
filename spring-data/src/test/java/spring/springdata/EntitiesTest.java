package spring.springdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
        // kazdy przypadek testowy bedzie otwierał i zamykał transakcję. jeden test nie wpływa na działanie drugiego testu
class EntitiesTest {

    @Autowired
    CarRepository carRepository;

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void init() {
        carRepository.save(new Car("Audi", "A4", "diesel", 120, 5, "red"));
        carRepository.save(new Car("Mercedes", "300", "diesel", 120, 3, "blue"));
        carRepository.save(new Car("Fiat", "Tipo", "benzine", 90, 5, "black"));
        carRepository.save(new Car("Audi", "A7", "benzine", 120, 3, "blue"));

        bookRepository.save(new Book("ISBN1", "title1", 2, LocalDate.of(1990, 12, 30), "paper", 250));
        bookRepository.save(new Book("ISBN2", "title2", 1, LocalDate.of(2020, 7, 13), "paper", 100));
        bookRepository.save(new Book("ISBN3", "title3", 3, LocalDate.of(2019, 4, 10), "hard", 300));
        bookRepository.save(new Book("ISBN4", "title4", 2, LocalDate.of(1990, 6, 4), "hard", 150));
    }

    //testy powinny być zależne od siebie
    @Test
    public void returnsFindAllCars() {
        // When
        List<Car> all = carRepository.findAll();
        // Then
        assertThat(all.size()).isEqualTo(4);
    }

    @Test
    public void returnsBookPerTitle() {
        // When
        List<Book> booksPerTitle = bookRepository.findBookByTitle("title1");
        // Then
        assertThat(booksPerTitle.size()).isEqualTo(1);
        assertThat(booksPerTitle.get(0).getCoverType()).isEqualTo("paper");
    }

    @Test
    public void returnsCarIsNotAudi() {
        // When
        List<Car> carIsNotAudi = carRepository.findCarByEngineType("diesel", 100,"Audi");
        // Then
        assertThat(carIsNotAudi.size()).isEqualTo(1);
    }

    @Test
    public void returnsBooksWithCoverPaper() {
        // When
        List<Book> booksWithCoverPaper = bookRepository.searchByCoverType(
                "paper", LocalDate.of(2000, 1, 1), 300
        );
        // Then
        assertThat(booksWithCoverPaper.size()).isEqualTo(1);
    }
}