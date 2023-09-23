package pro.sky.JavaCoredemo2.controller;

import pro.sky.JavaCoredemo2.entity.Question;
import pro.sky.JavaCoredemo2.services.MathQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final MathQuestionService service;

    public MathQuestionController(MathQuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> all() {
        return service.getAll();
    }
}