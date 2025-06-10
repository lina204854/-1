@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
    
    public List<Book> search(String query) {
        return bookRepository.findByTitleContainingOrPublisherContainingOrStudentNameContaining(query, query, query);
    }
    
    public List<Book> filterByIssueDate(LocalDate from, LocalDate to) {
        return bookRepository.findByIssueDateBetween(from, to);
    }
}

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles())
        );
    }
}
