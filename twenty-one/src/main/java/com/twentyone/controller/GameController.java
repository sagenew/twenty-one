package com.twentyone.controller;

import com.twentyone.game.BlackJackGame;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("game")
@RequestMapping("/")
public class GameController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(Model model) {
        model.addAttribute("message", "Welcome to Blackjack! Click to start a new game");
        return "mainMenu";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String startNewGame(Model model) {
        model.addAttribute("game", new BlackJackGame());
        return "inProgress";
    }

    @RequestMapping(method = RequestMethod.POST, params = "hit")
    public String hit(Model model) {
        BlackJackGame game = (BlackJackGame) model.getAttribute("game");
        game.playerHit();
        if(game.playerBusted()){
            game.resolveDealerHand();
            return "endGame";
        } else {
            return "inProgress";
        }
    }

    @RequestMapping(method = RequestMethod.POST, params = "stand")
    public String stand(Model model) {
        BlackJackGame game = (BlackJackGame) model.getAttribute("game");
        game.resolveDealerHand();
        return "endGame";
    }
}