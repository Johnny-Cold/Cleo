package sparkles.princess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparkles.princess.service.CleoService;

@RestController
@RequestMapping("cleo")
public class CleoController {
    private final CleoService service;

    @Autowired
    public CleoController(CleoService service) {
        this.service = service;
    }


}
