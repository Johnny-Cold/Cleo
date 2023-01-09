package sparkles.princess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparkles.princess.model.entity.cleo.CleoState;
import sparkles.princess.repository.CleoStateRepository;
import sparkles.princess.service.CleoService;

@RestController
@RequestMapping("cleo")
public class CleoController {
    private final CleoService service;
    private final CleoStateRepository cleoStateRepository;

    private CleoState cleoState;

    private boolean hasStarted = false;

    @Autowired
    public CleoController(CleoService service, CleoStateRepository cleoStateRepository) {
        this.service = service;
        this.cleoStateRepository = cleoStateRepository;
    }

    public void start() {
        cleoState = cleoStateRepository.getLastState();

        if (cleoState == null) {
            cleoState = new CleoState();
        }

        hasStarted = true;
    }

    public void stop() {
        if (cleoState != null) {
            cleoStateRepository.save(cleoState);
            hasStarted = false;
        }
    }
}
