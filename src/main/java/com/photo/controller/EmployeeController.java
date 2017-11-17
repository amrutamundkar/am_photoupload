package com.photo.controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.photo.model.Employee;
import com.photo.service.EmployeeService;

@RestController
@RequestMapping(value = "/")
public class EmployeeController {

    private static String UPLOADED_FOLDER = "C://uploadedFiles//";
	
	@Autowired
	EmployeeService employeeService;
	Employee emp = new Employee();
	/*
	@GetMapping(value="/employees")
	public List<Employee> getEmployeeBycId( @PathVariable("cid") int cid) {
		return employeeService.getEmployeeBycId(cid);

	}	*/

	@GetMapping(value="/employees")
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();

	}	
	@GetMapping(value="/employees/{id}")
	public Employee getEmployeebyId( @PathVariable("id") int id) {
		return employeeService.getEmployeebyId(id);

	}

	@PostMapping(value="/employees")
	public Employee createEmplyoee(@RequestBody Employee user) {
		return employeeService.createemp(user);
		
	}
	
	@PostMapping(value=("/employees/upload"))
	public Employee createuploadEmplyoee(@RequestParam("file") MultipartFile file,@RequestParam("emp_name") String emp_name,
			RedirectAttributes redirectAttributes)
            {
		if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            
        }
        try {           
        	
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
           
            emp.setEmpName(emp_name);
            emp.setPhoto(bytes);         
                                    
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

		return employeeService.createemp(emp);
		
	}
	@GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

	@PutMapping(value="/employees/{id}")
	public List<Employee> updateEmploye(@RequestBody Employee user, @PathVariable("id") int id) {
		return employeeService.updateemp(user,id);		

	}

	@DeleteMapping(value="/employees/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id") int id) {
		return employeeService.deleteemp(id);
	}

}
