package MyProject.db;

import java.util.Optional;

public interface db <A,B > {
    boolean add(A a, B b);
    Optional<A> getOneByEmail(String username, String password);

}
