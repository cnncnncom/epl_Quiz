package org.example.premierleaguequiz.model.repository;

import com.google.ai.generativelanguage.v1beta.Content;
import com.google.ai.generativelanguage.v1beta.GenerateContentRequest;
import com.google.ai.generativelanguage.v1beta.GenerativeServiceClient;
import com.google.ai.generativelanguage.v1beta.Part;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class TeamRepository {
    private final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    private final GenerativeServiceClient client;

    public TeamRepository() throws IOException {
        String apiKey = dotenv.get("GEMINI_API_KEY");
        client = GenerativeServiceClient.create(
                GenerativeServiceClient.defaultCredentialsBuilder()
                        .setApiKey(apiKey)
                        .build()
        );
    }

    public Team getTeamInfo(String teamName) throws Exception {
        Content content = Content.newBuilder()
                .addParts(Part.newBuilder().setText(
                        "List the 5 most important current players for the EPL team " + teamName +
                                ". Provide their names in a comma-separated list."
                ))
                .build();

        GenerateContentRequest request = GenerateContentRequest.newBuilder()
                .setModel("gemini-pro")
                .addContents(content)
                .build();

        var response = client.generateContent(request);
        String playersText = response.getCandidates(0).getContent().getParts(0).getText();

        // Split the players and trim whitespace
        String[] players = playersText.split(",\\s*");

        return new Team(teamName, players);
    }
}