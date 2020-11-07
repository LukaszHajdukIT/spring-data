package spring.springdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String title;
    private int edition;
    private LocalDate editionDate;
    private String coverType;
    private int pageCount;

    public Book() {
    }

    public Book(String isbn, String title, int edition, LocalDate editionDate, String coverType, int pageCount) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.editionDate = editionDate;
        this.coverType = coverType;
        this.pageCount = pageCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public LocalDate getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(LocalDate editionDate) {
        this.editionDate = editionDate;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", edition=" + edition +
                ", editionDate=" + editionDate +
                ", coverType='" + coverType + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
}
