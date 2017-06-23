package login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    UserRepository userRepository;
   String name = null;
   ServletSession servObj;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toGet(HttpServletRequest request, Model model) {
        String uName= new User().getuName();
        request.getSession().setAttribute("nameSession", uName);
        model.addAttribute(new User());
        return "login";
    }

    @RequestMapping(value = "/display", method = RequestMethod.POST)
    public String toSend(@ModelAttribute User user, Model model) {
         name = user.getuName();
      //   session.setAttribute("nameSession", name);
        Iterable<User> values = userRepository.findByUName(name);
        System.out.println(values + "fdghj");
        model.addAttribute("values", values);

        return "display";
    }
}
