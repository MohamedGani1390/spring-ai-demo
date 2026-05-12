package ai.chatbot.ai_chatbot.service;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptions;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class StabilityAiImageService {

    @Qualifier("stabilityAiImageModel")
    @Autowired
    private ImageModel stabiltyAiImageModel;


    public byte[] generateImageWithStabilityAi(String prompt) {
        StabilityAiImageOptions openAiImageOptions = StabilityAiImageOptions.builder()
                .model( "stable-diffusion-xl-1024-v1-0")
                .N(1)
                .height(1024)
                .width(1024)
                .responseFormat("b64_json")
                .build();
        return generateImage(stabiltyAiImageModel, openAiImageOptions, prompt);
    }
    public byte[] generateImage(ImageModel imageModel, ImageOptions imageOptions, String prompt) {
        ImageResponse imageResponse = imageModel.call(new ImagePrompt(prompt, imageOptions));
        String b64Json = imageResponse.getResult().getOutput().getB64Json();
        return Base64.getDecoder().decode(b64Json);

    }
}
