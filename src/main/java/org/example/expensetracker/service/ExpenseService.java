package org.example.expensetracker.service;

import org.example.expensetracker.model.Expense;
import org.example.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public void saveExpense(Expense expense){
        expenseRepository.save(expense);
    }

    public Expense getExpenseById(Long id){
        return expenseRepository.findById(id).orElse(null);
    }

    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }
}
