package org.example.gestionpatient.web;

import lombok.AllArgsConstructor;
import org.example.gestionpatient.entities.Patient;
import org.example.gestionpatient.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor  //injection via constructor
public class PatientController
{
    private PatientRepository patientRepository;

    @GetMapping("/index") // quand on tape /index la vue patients.html sera retournée
    public String index(Model model,
                        @RequestParam(name="page",defaultValue="0")int page ,
                        @RequestParam(name="size",defaultValue="5")int  size,
                        @RequestParam(name="keyword",defaultValue="") String kw
    )
    {
        Page<Patient> pagePatients=patientRepository.findByNomContains(kw,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);//tableau de dimensions nbre de pages
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id , String keyword, int page)
    {
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword"+keyword;
    }


}
