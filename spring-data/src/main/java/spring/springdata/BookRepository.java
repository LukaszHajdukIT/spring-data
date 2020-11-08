package spring.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByTitle(String title);


    List<Book> findBookByCoverTypeAndEditionDateGreaterThanAndPageCountLessThan(String coverType, LocalDate editionDate, int pageCount);

    @Query("select b from Book b where b.coverType = :coverType and b.editionDate > :editionDate and b.pageCount < :pageCount")
    List<Book> searchByCoverType(@Param("coverType") String coverType,
                                 @Param("editionDate") LocalDate editionDate,
                                 @Param("pageCount") int pageCount);
}
