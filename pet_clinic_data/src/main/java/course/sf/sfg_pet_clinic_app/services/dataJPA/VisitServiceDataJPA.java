package course.sf.sfg_pet_clinic_app.services.dataJPA;

import course.sf.sfg_pet_clinic_app.model.Visit;
import course.sf.sfg_pet_clinic_app.repositories.VisitRepository;
import course.sf.sfg_pet_clinic_app.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dataJpa")
public class VisitServiceDataJPA extends AbstractServiceDataJPA<Visit, VisitRepository> implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceDataJPA(VisitRepository visitRepository) {
        super(visitRepository);
        this.visitRepository = visitRepository;
    }
}
