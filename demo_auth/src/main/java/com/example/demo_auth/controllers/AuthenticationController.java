package com.example.demo_auth.controllers;

import com.example.demo_auth.models.Account;
import com.example.demo_auth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value="/api/sample", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController extends BaseController {

    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;

    /*@Autowired
    private SmtpMailSender smtpMailSender;*/

    @RequestMapping(method = GET)
    public Account sampleGet(){
        return this.accountService.findByUsername("papidakos");
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Account> sample(HttpServletResponse response){
        return new ResponseEntity<Account>(accountService.findByUsername("papidakos"), HttpStatus.CREATED);
    }

   /* @RequestMapping(value="/register", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> register(@RequestBody Account account, BindingResult errors) throws Exception{

        // Check if account is unique
        if(errors.hasErrors()){
            throw new InvalidRequestException("Username already exists", (Throwable) errors);
        }

        Account createdAccount = accountService.createNewAccount(account);
        return new ResponseEntity<Account>(createdAccount, HttpStatus.CREATED);
    }*/

    /*@RequestMapping(value="/forgot-password", method=RequestMethod.GET)
    public ResponseEntity<String> forgotPassword() throws MessagingException {
        String response = "{success: true}";
        smtpMailSender.send("cpapidas@gmail.com", "Password forgot", "Forgot password url");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }*/

}
