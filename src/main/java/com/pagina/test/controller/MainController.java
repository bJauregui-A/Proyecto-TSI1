package com.pagina.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pagina.test.model.Curso;
import com.pagina.test.model.CursoRepository;
import com.pagina.test.model.UserRepository;
import com.pagina.test.model.Usuario;


@Controller // This means that this class is a Controller
@RequestMapping(path="") // This means URL's start with /demo (after Application path)
public class MainController {

  @Autowired // This means to get the bean called userRepository
  private UserRepository userRepository;

  @Autowired
  private CursoRepository cursoRepository;

  @PostMapping(path="/addUser") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String nombre
      , @RequestParam String password_hash, @RequestParam String rut, @RequestParam String tipo) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Usuario n = new Usuario();
    n.setNombre(nombre);
    n.setPassword_hash(password_hash);
    n.setRut(rut);
    n.setTipo(rut);
    userRepository.save(n);
    return "Saved";

  
  }

  @PostMapping(path="/addCurso") // Map ONLY POST Requests
  public @ResponseBody String addNewCurso (@RequestParam String nombre
      , @RequestParam String descripcion, @RequestParam String linkPago,@RequestParam String dirigidoa,@RequestParam int horas,@RequestParam String modalidad, @RequestParam int precio) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Curso n = new Curso();
    n.setNombre(nombre);
    n.setDescripcion(descripcion);
    n.setLinkPago(linkPago);
    n.setPrecio(precio);
    n.setDirigidoa(dirigidoa);
    n.setHoras(horas);
    n.setModalidad(modalidad);
    
    cursoRepository.save(n);

    return "Saved";

  }

  @GetMapping(path="/allUsers")
  public @ResponseBody Iterable<Usuario> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }

    @GetMapping(path="/allCursos")
  public @ResponseBody Iterable<Curso> getAllCursos() {
    // This returns a JSON or XML with the users
    return cursoRepository.findAll();
  }

  @GetMapping(path="/index")
  public String index() {
        return "index"; // nombre de la plantilla index.html
    }

  @GetMapping(path="/us")
  public String aboutUs(){
    return "us";
  }
  @GetMapping(path="/images")
    public String images() {
        return "images"; // nombre de la plantilla images.html
    }

  @GetMapping(path="/cursos")
  public String verCursos(Model model) {
      model.addAttribute("cursos", cursoRepository.findAll());
      return "cursos"; // Se mostrará cursos.html
  }
    @GetMapping(path="/editCursos")
  public String verCursos2(Model model) {
      model.addAttribute("cursos", cursoRepository.findAll());
      return "editCursos"; // Se mostrará cursos.html
  }
  @GetMapping(path="/cuentas")
  public String verCuentas(Model model) {
      model.addAttribute("usuarios", userRepository.findAll());
      return "cuentas"; // Se mostrará cursos.html
  }

  @GetMapping(path="/cuenta")
  public String getCuenta() {
      return "cuenta";
  }
  
  @GetMapping(path="/contacto")
  public String getContacto() {
      return "contacto";
  }
  


}
