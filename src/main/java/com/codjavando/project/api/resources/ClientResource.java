package com.codjavando.project.api.resources;

import com.codjavando.project.api.model.Client;
import com.codjavando.project.api.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientResource {

    private final ClientService clientService;

    @GetMapping
    public ModelAndView getView() {
        ModelAndView mv = new ModelAndView("confirmationForm");
        return mv;
    }

    @PostMapping
    public String save(@Valid Client client, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("message", "Make sure the required fields are filled in.");
            return "redirect:/confirmationForm";
        }
        clientService.save(client);
        return "redirect:/confirmation";
    }

}
