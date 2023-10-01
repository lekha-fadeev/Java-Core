package pro.sky.JavaCoredemo2.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.JavaCoredemo2.entity.Question;
import pro.sky.JavaCoredemo2.services.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return service.getQuestions(amount);
    }
}