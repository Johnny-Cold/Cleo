package sparkles.princess.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparkles.princess.model.entity.cleo.Cleo;
import sparkles.princess.repository.CleoStateRepository;
import sparkles.princess.service.CleoDialogueService;
import sparkles.princess.service.CleoService;

@Service
@Transactional
public class CleoServiceImpl implements CleoService {
    private Cleo cleo;
    private CleoDialogueService dialogueService;
    private CleoStateRepository stateRepository;

    @Autowired
    public CleoServiceImpl(CleoDialogueService dialogueService, CleoStateRepository stateRepository) {
        this.dialogueService = dialogueService;
        this.stateRepository = stateRepository;
    }

    public Cleo getCleo(){
        return cleo;
    }


}
