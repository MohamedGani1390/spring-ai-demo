package ai.chatbot.ai_chatbot.controller;

import ai.chatbot.ai_chatbot.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AiController {
    private final AiService aiService;
    @GetMapping
    public String getAiResponse(@RequestParam  String userInput) {
        return aiService.getAiResponse(userInput);
    }
}
