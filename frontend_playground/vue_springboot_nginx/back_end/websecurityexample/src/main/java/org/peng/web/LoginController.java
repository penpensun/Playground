package org.peng.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Security;
import java.util.Map;

@RestController
public class LoginController {

    /*@RequestMapping(value = "rest/login", method = RequestMethod.POST)
    public ResponseMessage loginRest(@RequestParam(value = "username", required=true) String username,
                            @RequestParam(value = "password", required=true) String password, Model model) throws Exception {
        System.out.println("rest/login POST");
        return login(username, password, model);
    }*/

    @RequestMapping(value = "/rest/login", method = RequestMethod.POST)
    public ResponseMessage login(@RequestParam(value = "username", required=true) String username,
                        @RequestParam(value = "password", required=true) String password, Model model) throws Exception {
        System.out.println("login POST endpoint.");
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true); // set remember me to true.
        try{
            user.login(token);
            return new ResponseMessage(true, "Login successful", null);
        } catch(UnknownAccountException e) {
            model.addAttribute("message", "account does not exist");
        } catch(IncorrectCredentialsException e){
            model.addAttribute("message","wrong password");
        }
        return new ResponseMessage(false, "Login unsuccessful", null);

    }

    @RequestMapping(value="/rest/login_status",method = RequestMethod.GET)
    public ResponseMessage isLogin() throws Exception {
        System.out.println("is Login function GET endpoint.");
        Subject user = SecurityUtils.getSubject();
        return new ResponseMessage(user.isAuthenticated(), "Current login status", null);
    }
}
