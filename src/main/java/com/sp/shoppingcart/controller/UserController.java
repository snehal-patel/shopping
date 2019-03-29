package com.sp.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.shoppingcart.entity.User;
import com.sp.shoppingcart.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userService ; 
	
	@GetMapping("users")
	public List<User> findAll()
	{
		return userService.findAll();
	}
	
	
	
	@PostMapping("user")
	public User addUser(@RequestBody User user)
	{
		return userService.save(user);
	}

	
	
	@Autowired private EntityLinks links;

	 @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity <?> AllProducts(@PageableDefault(size=20) Pageable pageable) {
	  Page < User > products = userService.findAll(pageable);
//	  PagedResources < User > pr = assembler.toResource(products, linkTo(UserController.class).slash("/products").withSelfRel());
//	  HttpHeaders responseHeaders = new HttpHeaders();
//	  responseHeaders.add("Link", createLinkHeader(pr));
	  return new ResponseEntity < > (products, HttpStatus.OK);
	 }

//	 private String createLinkHeader(PagedResources < User > pr) {
//	  final StringBuilder linkHeader = new StringBuilder();
//	  linkHeader.append(buildLinkHeader(pr.getLinks("first").get(0).getHref(), "first"));
//	  linkHeader.append(", ");
//	  linkHeader.append(buildLinkHeader(pr.getLinks("next").get(0).getHref(), "next"));
//	  return linkHeader.toString();
//	 }
//
//	 public static String buildLinkHeader(final String uri, final String rel) {
//	  return "<" + uri + ">; rel=\"" + rel + "\"";
//	 }
}
