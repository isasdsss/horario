package br.com.horario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.horario.entity.CursosEntity;
import br.com.horario.service.CursosService;


@Controller
public class CursosController {
	
	@Autowired
	private CursosService cursosService;
	
	
	@GetMapping("/cursos") //nome que eu quiser colocar
	public String docente(ModelMap model)
	{
		model.addAttribute("cursos", cursosService.findAll());
		return "cursos"; //caminho real do arquivo
	}
	
	@PostMapping("/salvar_cursos")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("cursosEntity") CursosEntity cursosEntity,
			RedirectAttributes atributes) throws Exception 
	{
		
			ModelAndView mv = new ModelAndView("redirect:/cursos");
			atributes.addFlashAttribute("mensagem", cursosService.save(cursosEntity));
			return mv;
		
	}
	@GetMapping("/alterar_cursos/{idCursos}")
	public ModelAndView update(ModelMap model,@PathVariable("idCursos") Long idCursos) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_cursos");
		model.addAttribute("idCursos", idCursos);
		model.addAttribute("cursos", cursosService.getOneByIdCursos(idCursos));
		
		return mv;
	}
	
	@PostMapping("/alterar_cursos")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("cursosEntity") CursosEntity cursosEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/cursos");
		atributes.addFlashAttribute("mensagem", cursosService.save(cursosEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_cursos/{idCursos}")
	public ModelAndView delete(ModelMap model,@PathVariable("idCursos") Long idCursos,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/cursos");
		model.addAttribute("mensagem",cursosService.deleteById(idCursos));
		model.addAttribute("cursos",cursosService.findAll());
		
		return mv;
		
		
	}

}

