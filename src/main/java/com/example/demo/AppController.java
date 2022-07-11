package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class AppController {
	@Autowired
	private ContactRepository crepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PaymentRepository prepo;
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    @GetMapping("/register")
    public String showSignupForm(Model model)
    {
    	model.addAttribute("user",new User());
    	
    	return "regis";
    }
    
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        userRepo.save(user);
         
        return "register_success";
    }
    
    
    
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
         
        return "users";
    }
    
    @GetMapping("/contacts")
    public String listContacts(Model model) {
        List<ContactDtls> listContacts = crepo.findAll();
        model.addAttribute("listContacts", listContacts);
         
        return "contacts";
    }
    @GetMapping("/contacts/delete/{id}")
    public String deletecontactrecord(@PathVariable("id") int id)
    {
    	crepo.deleteById( id);
    	
    	return "redirect:/contacts";
    }
    
    @GetMapping("/home")
    public String home(Model model)
    {
    	model.addAttribute("contact",new ContactDtls());
    	return "home";
    }
    
    @GetMapping("/profile")
    public String profile()
    {
    	return "profile";
    }
    
    @GetMapping("/users/delete/{id}")
    public String deleteemployeerecord(@PathVariable("id") int id)
    {
    	userRepo.deleteById((long) id);
    	
    	return "redirect:/users";
    }
    @GetMapping("/pay")
    public String payment(Model model,@ModelAttribute Calculator calculator,BindingResult result,Model model1)
    {
    	model1.addAttribute("calculator",calculator);
    	model.addAttribute("Payment",new Payment());
    	return "payment";
    }
    
    @PostMapping("/paysuccess")
    public String sucess(@ModelAttribute Payment pay)
    {
    	prepo.save(pay);
    	return "success";
    }
    @Controller
    public class CalculatorController {
    	@GetMapping("/cal")
    	public String GetForm(Model model)
    	{
    		model.addAttribute("calculator",new Calculator());
    		return "calculator";
    	}
    	@PostMapping("/result")
    	public String PostForm(@ModelAttribute Calculator calculator,BindingResult result,Model model)
    	{
    		model.addAttribute("calculator",calculator);
    		return "result";
    	}
    }
    
	
	@PostMapping("/regis")
	public String regsiter(@ModelAttribute ContactDtls con)
	{
		crepo.save(con);
		return "redirect:/home";
	}
	@GetMapping("/admin")
	public String admin()
	{
		return "admin";
	}
}
