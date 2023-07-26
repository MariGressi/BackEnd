package com.BackEnd;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class URLConnectionService {
    public String getPageContent(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        String pageContent = document.text();

        // Obter todas as legendas das imagens e adicionar ao conteúdo da página
        Elements imageCaptions = document.select("div.thumbinner div.thumbcaption");
        for (var caption : imageCaptions) {
            pageContent += " " + caption.text();
        }

        return pageContent;
    }
}
