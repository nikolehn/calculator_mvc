package edu.uned.web.nikole.controllers;

import edu.uned.web.nikole.models.Calculator;
import java.lang.reflect.Method;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {

    @RequestMapping("/")
    public String calculator(Model model) {
        return "calculator";
    }

    @RequestMapping("/ops/{op}")
    public String op0(Model model, @PathVariable String op) {

        try {
            Method meth = Calculator.class.getMethod(op);
            Double result = (Double) meth.invoke(null);
            model.addAttribute("result", result);
        } catch (Exception ex) {
            model.addAttribute("result", "ERROR");
        }

        return "operation";
    }

    @RequestMapping("/ops/{op}/{op1}/")
    public String op1(Model model, @PathVariable String op, @PathVariable String op1) {

        try {
            Double op1d = Double.valueOf(op1);
            Method meth = Calculator.class.getMethod(op, Double.class);
            Double result = (Double) meth.invoke(null, op1d);
            model.addAttribute("result", result);
        } catch (Exception ex) {
            model.addAttribute("result", "ERROR");
        }

        return "operation";
    }

    @RequestMapping("/ops/{op}/{op1}/{op2}/")
    public String op2(Model model, @PathVariable String op, @PathVariable String op1, @PathVariable String op2) {

        try {
            Double op1d = Double.valueOf(op1);
            Double op2d = Double.valueOf(op2);
            Method meth = Calculator.class.getMethod(op, Double.class, Double.class);
            Double result = (Double) meth.invoke(null, op1d, op2d);
            model.addAttribute("result", result);
        } catch (Exception ex) {
            model.addAttribute("result", "ERROR");
        }

        return "operation";
    }
}
