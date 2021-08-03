package course.sf.sfg_pet_clinic_app.services.dataJPA;

import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractServiceDataJPA<T, R extends CrudRepository<T, Long>> {

    private final R repository;

    public AbstractServiceDataJPA(R repository) {
        this.repository = repository;
    }

    public Set<T> findAll() {
        Set<T> typeSet = new HashSet<>();
        repository.findAll().forEach(typeSet::add);
        return typeSet;
    }


    public T findById(Long aLong) {
        Optional<T> optionalType = repository.findById(aLong);
        if (!optionalType.isPresent()) {
            return null;
        }
        return optionalType.get();
    }


    public T save(T object) {
        return repository.save(object);
    }


    public void delete(T object) {
        repository.delete(object);
    }


    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
