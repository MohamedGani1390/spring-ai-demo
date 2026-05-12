package ai.chatbot.ai_chatbot.controller;

import ai.chatbot.ai_chatbot.service.AiService;
import ai.chatbot.ai_chatbot.service.StabilityAiImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    @Autowired
    private  AiService aiService;
    @Autowired
    private  StabilityAiImageService stabilityAiImageService;

    @GetMapping
    public String getAiResponse(@RequestParam  String userInput) {
        return aiService.getAiResponse(userInput);
    }

    @GetMapping("/generate-image")
    public ResponseEntity<?> generateImage(@RequestParam String prompt) {
        System.out.println("Received prompt: " + prompt);
        byte[] imageBytes = stabilityAiImageService.generateImageWithStabilityAi(prompt);
        return ResponseEntity.ok()
                .header("Content-Type", "image/png")
                .body(imageBytes);
    }
}
