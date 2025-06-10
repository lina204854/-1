@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String publisher;
    
    @Column(name = "issue_date")
    private LocalDate issueDate;
    
    @Column(name = "student_name")
    private String studentName;
    
    @Column(name = "return_date")
    private LocalDate returnDate;
    
    // Геттеры и сеттеры
}

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String password;
    private boolean active;
    private String roles;
    
    // Геттеры и сеттеры
}
