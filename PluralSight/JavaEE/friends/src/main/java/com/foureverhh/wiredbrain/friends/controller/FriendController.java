package com.foureverhh.wiredbrain.friends.controller;

import com.foureverhh.wiredbrain.friends.domain.Friend;
import com.foureverhh.wiredbrain.friends.service.FriendService;
import com.foureverhh.wiredbrain.friends.utils.ErrorMessage;
import com.foureverhh.wiredbrain.friends.utils.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class FriendController {
    private FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @PostMapping("/friend")
    public Friend create(@Valid @RequestBody Friend friend){
        return friendService.save(friend);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e){
       List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
       List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream()
               .map(field->new FieldErrorMessage(field.getField(),field.getDefaultMessage()))
               .collect(Collectors.toList());
        System.out.println("I am here");
       return fieldErrorMessages;
    }
/*
    //Demo with ValidationException
    @PostMapping("friend")
    public Friend create(@RequestBody Friend friend) throws ValidationException {
        if(friend.getId() == 0 && friend.getFirstName() != null && friend.getFirstName() != null)
            return friendService.save(friend);
        else
            throw new ValidationException("Friend cannot be created");
    }*/
/*
    //Paste this on ControllerExceptionHandler class under controller
    //Demo with ValidationException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ErrorMessage exceptionHandler(ValidationException e){
        return new ErrorMessage("400",e.getMessage());
    }*/

    /*
    //Demo with ValidationException
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> exceptionHandler(ValidationException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }*/


    @GetMapping("friend")
    public List<Friend> read(){
        return friendService.findAll();//.isEmpty() ?list: friendService.findAll();
    }

    @PutMapping("friend")
    public ResponseEntity<Friend> update(@RequestBody Friend friend){
        if(friendService.findById(friend.getId()).isPresent())
            return new ResponseEntity<>(friendService.save(friend), HttpStatus.OK);
        else
            return new ResponseEntity<>(friend,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("friend/{id}")
    public void delete(@PathVariable int id){
        friendService.deleteById(id);
    }

    @GetMapping("/friend/search")
    public Iterable<Friend> findByFirstNameAndLastName(@RequestParam(value = "first",required = false) String firstName,
                                                   @RequestParam(value = "last",required = false) String lastName){
        if(firstName != null && lastName != null){
            return friendService.findByFirstNameAndLastName(firstName,lastName);
        }else if(firstName != null){
            return friendService.findByFistName(firstName);
        }else if(lastName != null){
            return friendService.findByLastName(lastName);
        }else {
            return friendService.findAll();
        }
    }

    @GetMapping("/friend/{id}")
    public Friend findById(@PathVariable int id) {
        return friendService.findById(id).get();
    }
}
