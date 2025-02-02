package capitulos.strings;

import java.util.Objects;

public class Integration {

    public static class Video {
        String id;
        String title;
        Integer duration;

        public Video(String id, String title, Integer duration) {
            this.id = "\"" + id + "\"";
            this.title = "\"" + title + "\"";
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "\t{\n\t\t\"id\": " + id + ", \n\t\t\"title\": " + title + ", \n\t\t\"duration\": " + duration +"\n\t}";
        }
    }

    public String csvToJson(String[] videos) {
        StringBuilder result = new StringBuilder("[");

        if (Objects.nonNull(videos) && videos.length > 0) {
            result.append("\n");
            String[] videoSplit = videos[0].split(",");
            result.append(new Video(videoSplit[0],
                videoSplit[1].substring(6, videoSplit[1].indexOf(".")), Integer.valueOf(videoSplit[2])));
            if (videos.length > 1) {
                for (int i = 1; i < videos.length; i++) {
                    result.append(",\n");
                    videoSplit = videos[i].split(",");
                    result.append(new Video(videoSplit[0],
                        videoSplit[1].substring(6, videoSplit[1].indexOf(".")), Integer.valueOf(videoSplit[2])));
                }
            }
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        String[] videos = {
                "4668c219-296d-40de-a073-99b85026e977,01-01 Visão geral do capítulo.mp4,222",
                "81be4133-f81a-443a-96f3-0c30d7460ab8,01-02 Algoritmos e Lógica de Programação.mp4,396",
                "b82f4f7b-f8f1-43e2-974d-3821e6a59e45,01-03 Estruturas de dados é sobre o quê.mp4,567",
                "ccde5219-f2df-4a11-b981-e0cdfa3c6224,01-04 Precisa saber OO antes de ED.mp4,215",
                "e77cf174-9547-4d7f-8372-ef23f193938f,01-05 Esse curso também é para outras linguagens.mp4,219",
                "254ef676-7bc5-478d-8250-0ce2616c9731,01-06 Vamos falar sobre objetos e funções.mp4,94",
                "e030627b-a8e0-4bde-bda8-edc78503fc2c,02-01 Visão geral do capítulo.mp4,389",
                "c4be1d39-6c97-4721-afd5-3b63ca0abf0a,02-02 Aviso sobre os exercícios.mp4,107",
                "6364ff0f-bc34-4166-8b35-2f0d9cf1b062,02-03 Literais e expressões em Javascript PARTE 1.mp4,545",
                "e7245f74-0135-4af0-9b79-bf4927438cfc,02-04 Literais e expressões em Javascript PARTE 2.mp4,567",
                "a7fc8b41-ce2f-4751-a6a7-39d4db32fbe0,02-05 Imutabilidade de strings em Javascript.mp4,310",
                "a8071e3d-97fe-4cc8-b377-2a69f50844a6,02-06 Funções de string em Javascript PARTE 1.mp4,748",
                "b8624056-07ad-4caa-8deb-1db75e04a8f6,02-07 Funções de string em Javascript PARTE 2.mp4,797",
                "215a5a6a-4171-4f98-b803-4d02811da5ae,02-08 Funções de string em Javascript PARTE 3.mp4,374",
                "32029cca-af8a-4b20-971a-08ccf350d2f4,02-09 Expressões regulares.mp4,486"
        };
        Integration integration = new Integration();
        System.out.println(integration.csvToJson(videos));
    }
}
