package ea.project.finalProject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ea.project.finalProject.model.User;
import ea.project.finalProject.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/login")
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());
		return mav;
	}

	@PostMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") User login) {
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		if (null != user) {
			mav = new ModelAndView("home");
			mav.addObject("firstname", user.getFirstname());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

	@GetMapping(value = "/register")
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("registration");
		mav.addObject("user", new User());
		return mav;
	}

	@PostMapping(value = "/register")
	public String register(@ModelAttribute(value = "user") User user, BindingResult result) {
		/*
		 * user.setUsername(StringUtils.trimWhitespace(user.getUsername()));
		 * user.setPassword(StringUtils.trimWhitespace(user.getPassword()));
		 * user.setFirstname(StringUtils.trimWhitespace(user.getFirstname()));
		 * user.setLastname(StringUtils.trimWhitespace(user.getLastname()));
		 * user.setDob((user.getDob()));
		 * user.setSex(StringUtils.trimWhitespace(user.getSex()));
		 * user.getAddress().setEmail(StringUtils.trimWhitespace(user.getAddress
		 * ().getEmail()));
		 */

		if (result.hasErrors()) {
			return "registration";
		}
		userService.addUser(user);

		return "registration";
	}

	@GetMapping(value = "/user/{userId}")
	public String getUser(@PathVariable int userId, Model model) {
		model.addAttribute("currentUser", userService.getUser(userId));
		return "userDetail";

	}

	@GetMapping(value = "/users")
	public String getAllUsers(Model model) {
		model.addAttribute("allUsers", userService.getAllUsers());
		return "registration";
	}

	@GetMapping(value = "/check_email")
	public @ResponseBody String checkEmail(@RequestParam("email") String email) {
		return userService.emailExists(email) ? "false" : "true";
	}

	@GetMapping(value = "/check_username")
	public @ResponseBody String checkUsername(@RequestParam("username") String username) {
		return userService.usernameExists(username) ? "false" : "true";
	}

	@PostMapping(value = "/change_email")
	public String changeEmail(@ModelAttribute(value = "user") User user, BindingResult result,
			@RequestParam("currentPassword") String currentPassword, RedirectAttributes redirectAttributes,
			ModelMap model) {
		model.addAttribute("isEmailForm", true);

		user.getAddress().setEmail(StringUtils.trimWhitespace(user.getAddress().getEmail()));

		if (!result.hasErrors()) {
			try {
				userService.changeEmail(user.getAddress().getEmail(), currentPassword);
			} catch (Exception e) {
				result.rejectValue("password", "NotMatchCurrent");
			}
		}

		if (result.hasErrors()) {
			return "settings";
		}
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("isEmailForm", true);

		return "redirect:/settings";
	}

	@PostMapping(value = "/edit_profile")
	public String editProfile(@ModelAttribute(value = "user") User user, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			// User currentUser = userService.currentUser();
			return "editprofile";
		}
		userService.changeProfileInfo(user);
		redirectAttributes.addFlashAttribute("success", true);

		return "redirect:/edit_profile";
	}

}
