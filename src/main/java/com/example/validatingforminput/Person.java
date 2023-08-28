package com.example.validatingforminput;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class Person {

	@NotNull
	@Length(min = 2, max = 20,  message = "the entered value [${validatedValue}] is invalid; there should be at least {min} symbols, but not more than {max}")
	private String name;

	// IDEA-293379: navigation/completion for annotation parameters in message string
	// IDEA-160468: SpEL is not supported
	@NotNull
	@Min(value=18, message = "Person must be at least {value} year${value >= 18 ? 's' : ''} old")
	@Max(value = 120, message = "{age.max.message}")
	private Integer age;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return "Name: " + this.name + ", Age: " + this.age ;
	}
}