package com.template.TemplateProject;

import com.template.TemplateProject.model.User;
import com.template.TemplateProject.service.ATMService;
import com.template.TemplateProject.service.BeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateProjectApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TemplateProjectApplication.class, args);

		ATMService atmService = BeanFactory.getAtmService();
		atmService.initialize();

		User user = User.builder().userId(10).cardNumber("1234").pin("6789").balance(1000).build();
		BeanFactory.getRepository().addUser(user);

		atmService.cardEnter("1234");
		atmService.numberClicked(4);

		atmService.numberClicked(6);
		atmService.numberClicked(7);
		atmService.numberClicked(8);
		atmService.numberClicked(9);

		atmService.enterClicked();
	}

}
