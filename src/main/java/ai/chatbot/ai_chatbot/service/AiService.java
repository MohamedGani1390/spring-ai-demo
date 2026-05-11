package ai.chatbot.ai_chatbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiService {
    private final ChatModel chatModel;

    public String getAiResponse(String userInput) {
        // Here you would implement the logic to interact with the chatModel
        // For example, you could call a method on chatModel to get a response based on userInput
        // This is just a placeholder implementation
        return "This is a response from the AI model based on user input: " + chatModel.call(userInput);
    }
}
