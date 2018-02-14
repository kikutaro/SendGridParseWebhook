package xyz.kikutaro.sendgrid.parse;

import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParseApplication {

	@GetMapping("/ping")
	public String parse() {
		return "pong parse";
	}

	@PostMapping("/parse")
	public void parse(@RequestParam Map<String, String> allParams) {
		System.out.println("--------- ここから ---------");
		System.out.println(LocalDateTime.now());
		allParams.entrySet().stream()
			.map(e -> e.getKey() + ":" + e.getValue())
			.forEach(System.out::println);
		System.out.println("--------- ここまで ---------");
	}

	public static void main(String[] args) {
		SpringApplication.run(ParseApplication.class, args);
	}
}
