package com.metacube.metaparking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.metaparking.dto.*;
import com.metacube.metaparking.service.ParkingServiceImpl;


@Controller
public class MetaParkingController {
	@Autowired
	ParkingServiceImpl  parkingserviceObj;
	@GetMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("employeeCommand", new EmployeeLogin());
		System.out.println("come inside add student details");
		return "home";
	}
	
	@PostMapping("/home")
	public String loginAuth(@ModelAttribute("employeeCommand") @Validated  EmployeeLogin  employee , BindingResult errorResult , Model model) {
		
		if(errorResult.hasErrors()) {
			return "home";
		} else {
			System.out.println(employee.getPassword());
			boolean result = parkingserviceObj.authenticatedUser(employee.getEmail() , employee.getPassword());
			if(result) {
				
				return "redirect:/Profile";
			} else {
				ObjectError oe = new ObjectError("authenticatedFailed", "Wrong id and password");
				errorResult.addError(oe);
				return "home";
			}
		}
	
	}
	
	@GetMapping("/Register")
	public String registerPage(Model model) {
		model.addAttribute("employeeRegister", new EmployeeRegister());
		System.out.println("come inside EmployeeRegister details");
		
		return "register";
	}
	@PostMapping("/Register")
	public String userRegisterAuthentication(@ModelAttribute("employeeRegister") @Validated  EmployeeRegister  employee , BindingResult errorResult , Model model) {
		
		if(errorResult.hasErrors()) {
			return "register";
		} else {
			System.out.println(employee.getPassword());
			boolean result = parkingserviceObj.checkDuplicateEmail(employee.getEmail());
			if(result) {
				return "redirect:/Vehicleform";
			} else {
				ObjectError oe = new ObjectError("authenticatedFailed", "Email id Already used");
				errorResult.addError(oe);
				return "register";
			}
		}
	
	}
	
	
	@GetMapping("/Vehicleform")
	public String vehicleRegister(Model model) {
		model.addAttribute("url",1);
		return "VehicleRegister";
	}
	
	@GetMapping("/FriendList")
	public String getFriendList(Model model) {
		model.addAttribute("url", 2);
		return "userfriendlist";
	}
	
	@GetMapping("/Profile")
	public String getUserProfile(Model model) {
		model.addAttribute("url", 3);
		return "profile";
	}
	
	@GetMapping("/GatePass")
	public String takeGatePass(Model model) {
		model.addAttribute("url", 4);
		return "gatePass";
	}
	
	
}
