package pack.controller;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MyModel {
	private String name;
	private String skills[];
}
