package ai.chatbot.ai_chatbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptions;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Base64;

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
