package br.edu.ifrn.siteifsol.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifrn.siteifsol.repository.NoticiaRepository;
import br.edu.ifrn.siteifsol.repository.Usuariorepository;
import br.edu.ifrn.siteifsol.repository.empreendimentorepository;

@Controller
public class ADMController {

	@Autowired
	Usuariorepository usuariorepository;

	@Autowired
	empreendimentorepository empreendimentoRepository;

	@Autowired
	NoticiaRepository noticiaRepository;

	@GetMapping("/adm")
	public String home(ModelMap modelo) {
		try {
			modelo.addAttribute("totUsuarios", usuariorepository.findAll().size());
			modelo.addAttribute("totEmpre", empreendimentoRepository.findAll().size());
			modelo.addAttribute("totNoticias", noticiaRepository.findAll().size());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "ADM";
	}

}
