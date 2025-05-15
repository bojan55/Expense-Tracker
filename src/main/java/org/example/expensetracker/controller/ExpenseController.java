package org.example.expensetracker.controller;

import org.example.expensetracker.model.Expense;
import org.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Expense> expenses = expenseService.getAllExpense();
        BigDecimal totalAmount = expenses.stream().map(Expense :: getAmount).reduce(BigDecimal.ZERO, BigDecimal :: add);
        model.addAttribute("expenses", expenses);
        model.addAttribute("totalAmount", totalAmount);
        return "index";
    }
}
