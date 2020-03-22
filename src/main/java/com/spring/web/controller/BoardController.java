package com.spring.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.domain.Board;
import com.spring.web.domain.BoardRepository;

@Controller
public class BoardController {
    
    @Autowired
    BoardRepository boardRepository;
    
    @RequestMapping(value="/boardListView", method={RequestMethod.POST,RequestMethod.GET})
    public String boardIndex(Model model){
        
    	List<Board> listBoard = boardRepository.findAll();
        model.addAttribute("listBoard" ,listBoard);
        
        return "boardListView";
    }
    
    @RequestMapping(value="/boardWriteView", method={RequestMethod.POST,RequestMethod.GET})
    public String boardWriteView(){
       
        return "boardWriteView";
    }
    
    @RequestMapping(value="/boardWriteAction", method={RequestMethod.POST,RequestMethod.GET})
    public String boardWriteAction(HttpServletRequest req){
        
    	Board board= new Board();
    	board.setSubject (req.getParameter("subject"));
    	board.setWname(req.getParameter("wname"));
    	board.setContent(req.getParameter("content"));
    	board.setPasswd("123");
    	board.setReadcnt(0);
    	boardRepository.save(board);
        
        return "redirect:/boardListView";
    }
    
    @RequestMapping(value="/boardReadView", method={RequestMethod.POST})
    public String boardReadView(Model model,HttpServletRequest req){
       
    	Board board = boardRepository.getOne(Integer.parseInt(req.getParameter("bbsno")));
        model.addAttribute("boardEnty" ,board);
        
        return "boardReadView";
    }
}
