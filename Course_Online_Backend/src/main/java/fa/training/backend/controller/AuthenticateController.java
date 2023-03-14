package fa.training.backend.controller;

import fa.training.backend.helpers.JwtProvider;
import fa.training.backend.model.LoginRequestModel;
import fa.training.backend.model.LoginResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@Slf4j
public class AuthenticateController {
	@Autowired
	AuthenticationManager authenticationManager;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "welcomePage";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		model.addAttribute("userInfo", loginedUser.getUsername());

//		return "adminPage";
		return  loginedUser.getUsername();
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponseModel loginPage(@Valid @RequestBody LoginRequestModel loginRequestModel) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequestModel.getEmail(),
						loginRequestModel.getPassword()
				)
		);
		log.error(authentication.toString());
		log.error(loginRequestModel.toString());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String accessToken = JwtProvider.generateAccessToken((fa.training.backend.entities.User) authentication.getPrincipal());
		String refreshToken = JwtProvider.generateRefreshToken((fa.training.backend.entities.User) authentication.getPrincipal());
		return new LoginResponseModel(accessToken, refreshToken);
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/user-info/{id}", method = RequestMethod.GET)
	public String userInfo(@PathVariable(value = "id") int userId) {



//		return "userInfoPage";
		return "userName: " ;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			loginedUser.getUsername();

			model.addAttribute("userInfo");

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);

		}

		return "403Page";
	}
}
