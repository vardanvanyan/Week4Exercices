package com.example.vardan.week3exercices1;

import com.example.vardan.week3exercices1.Models.MessageModel;
import com.example.vardan.week3exercices1.Models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class MyProvider {
    private static List<UserModel> list = new ArrayList<>();

    public static List<UserModel> getUsersList() {
        if (!list.isEmpty()) {
            list.clear();
        }
        list.add(new UserModel("Phil Hellmuth", "Age:  53", "Trophy:  World Series of Poker", "http://www.wsop.com/images/all_player_images/Phil_Hellmuth_2017_WSOP.jpg", "065465552", "normal", "Phill@mail.ru", new ArrayList<MessageModel>()));
        list.add(new UserModel("Phil Ivey", "Age:  42", "Trophy:  World Poker Tour", "http://www.pokerplayersbase.com/w/players/13/501668854ec86.jpg", "065445467", "normal", "Ivey@mail.ru", new ArrayList<MessageModel>()));
        list.add(new UserModel("Liv Boeree", "Age:  33", "Trophy:  European Poker Tour", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxeMI2oiVAa8yvP3e11ncmRQ-h2X9EzoG1B4OG7jreE9h4584j3Q", "065879887", "normal", "Boeree@mail.ru", new ArrayList<MessageModel>()));
        list.add(new UserModel("Daniel Negreanu", "Age:  43", "Trophy:  World Series of Poker", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Daniel_Negreanu_2007.jpg/220px-Daniel_Negreanu_2007.jpg", "065124561", "normal", "negreanu@mail.ru", new ArrayList<MessageModel>()));
        list.add(new UserModel("Jason Mercier", "Age:  31", "Trophy:  European Poker Tour", "https://pnimg.net/lrep/1922/19/bbf10b8d86b.jpg", "06546555", "normal", "Mercier@mail.ru", new ArrayList<MessageModel>()));
        list.add(new UserModel("Igor Kurganov", "Age:  30", "Trophy:  World Series of Poker", "https://pokerfuse.com/site_media/media/uploads/news/igor-kurganov-pokerstars-reg_orig_f5.jpg", "065465555", "normal", "Kurganov@mail.ru", new ArrayList<MessageModel>()));
        list.add(new UserModel("Tiffany Michelle", "Age:  4", "Trophy:  European Poker Tour", "http://unrealitymag.com/wp-content/uploads/2009/07/tiffany-michelle.jpg", "065465550", "normal", "Michelle@mail.ru", new ArrayList<MessageModel>()));
        list.add(new UserModel("Vanessa Rousso", "Age:  35", "Trophy:  World Series of Poker", "https://pnimg.net/lrep/1859/97/me240412021.jpg", "065465567", "normal", "Rousso@mail.ru", new ArrayList<MessageModel>()));
        list.add(new UserModel("John Duthie", "Age:  57", "Trophy:  World Series of Poker", "http://www.bankrollmob.com/pokernews_images/People/poker_players/John%20Duthie.JPG", "065465231", "normal", "Duthie@mail.ru", new ArrayList<MessageModel>()));

        return list;
    }

    public static UserModel getUserByPosition(int position) {
        return list.get(position);
    }
}

