/*Задание 3
Сохранить в программе множество из 50 ссылок в интернет на картинки.

Написать JavaFX приложение в котором есть одна кнопка - “Обновить”
И 25 картинок в одном окне в виде матрицы (5 на 5). Картинки беруться рандомно из массива ссылок.
После нажатия на кнопку “Обновить”, картинки должны быть еще раз рандомно взяты из множества ссылок, загружены и отображены в окне.
При этом нельзя хранить в программе сами картинки и рандомом выбирать из них. Каждый раз надо загружать их из интернета.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task3 extends Application {
    Random r = new Random();
    Pane root = new Pane();
    /*List<String> list = new ArrayList<>();
		list.add("https://angloved.ru/wp-content/uploads/2015/01/rusalochka.jpg");
		list.add("http://bm.img.com.ua/nxs/img/prikol/images/large/1/2/308321_879382.jpg");
		list.add(30);
		list.add(40);
		list.add(50);*/



    public static void main(String[] args) throws Exception {


        /*BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream("files/links.txt")));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            links.add(inputLine);
            System.out.println(inputLine);
        }
        in.close();*/

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        List<String> links = new ArrayList<>();
        links.add("http://bm.img.com.ua/nxs/img/prikol/images/large/1/2/308321_879382.jpg");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrfXzuhJigzPRG8JNqoa6R9Te5n_FwqASiX3cFMKnZCvTHeNgwWA");
        links.add("https://novomoskovsk-ua.info/wp-content/uploads/2015/12/sovetskie-multfilmy.jpg");
        links.add("http://bm.img.com.ua/nxs/img/prikol/images/large/1/2/308321_879382.jpg");
        links.add("https://telegraf.com.ua/files/2017/04/jpg10");
        links.add("https://telegraf.com.ua/files/2017/04/podborka-prikolnyx-kartinok-5-1.jpg");
        links.add("https://telegraf.com.ua/files/2017/04/podborka-prikolnyx-kartinok-4-4.jpg");
        links.add("https://telegraf.com.ua/files/2017/04/podborka-prikolnyx-kartinok-4-3.jpg");
        links.add("https://kittybloger.files.wordpress.com/2013/08/white-cats-are-beautiful-30-photos-15.jpg");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPIXZsAtoLvkhIlgBtkALd7pqRhcGJSwR-wx6_5gpEymqnD9ui");
        links.add("http://coolwallpaperz.info/user-content/uploads/wall/o/75/sailboat-flower-art-ii-purple-painting-cat-291208.jpg");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSl6WhULK8DOGZaTEC2fJukkWAFG-01FGa8SLohyCZq8Oxuv-IE");
        links.add("http://proxy11.media.online.ua/uol/r2-6cf106323a/56b692d8d25bd.jpg");
        links.add("https://toppictures.ru/content/medium/aab75e58c07251a8c0b4defbbcd75b9d.jpeg");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFcE91a0G0w7dDrp9ms78TG5Nv7sUDUMQzb7-jILGVmVB5yqxSiA");
        links.add("https://angloved.ru/wp-content/uploads/2015/01/rusalochka.jpg");
        links.add("https://novomoskovsk-ua.info/wp-content/uploads/2015/12/sovetskie-multfilmy.jpg");
        links.add("http://womanadvice.ru/sites/default/files/mainimage200x200/multiki_disneya_pro_princess.jpg.crop_display.jpg");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0Pao8lrZX4x0w92HA0JgrfbD2IdGq_oYcyc_wUXvgHhp0U06z");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvhVyo4R0x2MrFGfYfVSX0Y7MBUGa0IR7cxEZlN0UpPLEOu9Ze");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRN5ZJY0C1zxPbJsNkJdteKvYCgGsQIZgu_rn205E2sd10OwqfV7w");
        links.add("http://www.ugorod.kr.ua/userfiles/novosti/images/clipart-107.jpg");
        links.add("http://miranimashek.com/_ph/47/2/696850697.gif");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYvRN5oHmVjIfmlaN8xaIMOB10Eyh1XeSmWQhbhOXEZjOtDceWsw");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrfXzuhJigzPRG8JNqoa6R9Te5n_FwqASiX3cFMKnZCvTHeNgwWA");
        links.add("http://karapyziki.net/wp-content/uploads/2013/08/myltik.jpg");
        links.add("https://i.ytimg.com/vi/K69MTvVIL38/maxresdefault.jpg");
        links.add("https://i.ytimg.com/vi/2gh7JjbWbBM/hqdefault.jpg");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJ1o_vrEUeFguuFMNB9VMZsSmbgeuMVDe7VZrK4QjoERyG3zd7");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGGdyoXL7gL-W005q5iIjmwE3uaZiwNuSqWUmh_ww0kTBmgpp71Q");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHGOP5H1SEoCcTPpX-VzBuAwTIbSEbw3UBbgW9RYH1vNP9-7aB0g");
        links.add("https://i.ytimg.com/vi/fuDfeJ1uyvU/maxresdefault.jpg");
        links.add("https://pic.rutube.ru/user/6f/5c/6f5cc5f7cbf555245a62cd2a2f818a43.jpeg");
        links.add("http://www.puzmo.com/resimler/640/16933840514.jpg");
        links.add("https://i.ytimg.com/vi/MrMeCQ0m6k0/maxresdefault.jpg");
        links.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPJKYktglxW38_Qc9AXQd9TjY5ZwZm1OxObxFYqnBU8d557Hcw");
        links.add(" https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0_jkjhz-pwUzT1uibFWjMORWxHDxdrrt1LFZajmbxPDs7szvh");
        links.add(" https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSL7j50svMLszQBjJWxDI-q7woaPq3Xr3b05G2uBxnp-HzWenjF");
        links.add(" https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReGNuXgM2pm8sNmi2WHVVSVf42Oxn3Fm9B-fRXLcthECaLbqQA");
        links.add(" https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZa2jME9OC0TcCCyqlyZuV6_9nKZ1l_Anq0RiguRrtweaFwVOn");
        links.add(" https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6lzhPmzA_UmqhYsFPtRD9BMLSn7xtHqcdLBqDCFYiw6ZM-Y7A");
        links.add(" https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR85AELkWpsWipxZszCBjQGyQT6Ydn_FN-py7oYQ2011xsDNc1qyQ");

      final Button buttom = new Button("Обновить");
        buttom.setTranslateX(10);
        buttom.setTranslateY(10);

        root.getChildren().addAll(buttom);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);


        buttom.setOnMouseClicked((MouseEvent event) -> {
            GridPane grid = new GridPane();
            int size = 5;
            try {
                for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                   // getRandomElements(25, links);

                    //List<String> url = new URL(links);
                    //String activity = links.getBody();

                    for (int i1 = 0; i1 < links.size(); i1++) {

                        final String item = links.get(r.nextInt(25));

                        ImageView image = new ImageView(item);
                        image.setFitHeight(100);
                        image.setFitWidth(100);
                        image.setPreserveRatio(true);
                        grid.add(image, i, j);
                    }
                }
            }

        } catch (final IllegalArgumentException e) {}
            root.getChildren().addAll(grid);


        });
    }

    /*public URL getRandomElements (final int amount, final List<String> list) throws  MalformedURLException {
        ArrayList<String> returnList1 = new ArrayList<String>(list);

        Collections.shuffle(returnList1); // тут делаем рандом
        if (returnList1.size() > amount) { // отрезаем не нужную часть
            // тут отрезаем не нужную часть
            list.subList(returnList1.size() - amount, returnList1.size()).clear();
        }
        ArrayList<URL> returnList = new ArrayList<>(returnList1.size());
        for (int i = 0; i < returnList1.size(); i++){
            returnList.add(new URL(returnList1.get(i)));
        }
        return returnList.get(r.nextInt());
    }*/
}
