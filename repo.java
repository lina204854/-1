public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByPublisherContaining(String publisher);
    List<Book> findByStudentNameContaining(String studentName);
    List<Book> findByIssueDateBetween(LocalDate start, LocalDate end);
}

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
