package com.example.telegram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.telegram.adapter.TelegramAdapter;
import com.example.telegram.database.AppDatabase;
import com.example.telegram.database.TelegramMessage;
import com.example.telegram.database.TelegramChat;
import com.example.telegram.database.TelegramList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView imageViewOpenDrawer;

    List<TelegramList> telegramList;
    List<TelegramMessage> messagesList1;
    List<TelegramMessage> messagesList2;
    List<TelegramMessage> messagesList3;
    List<TelegramMessage> messagesList4;
    List<TelegramMessage> messagesList5;
    List<TelegramMessage> messagesList6;
    List<TelegramMessage> messagesList7;
    List<TelegramMessage> messagesList8;
    List<TelegramMessage> messagesList9;
    List<TelegramMessage> messagesList10;
    List<TelegramMessage> messagesList11;
    List<TelegramMessage> messagesList12;
    List<String> messagesListList;

    AppDatabase db;

    TelegramAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = AppDatabase.getInMemoryDatabase(MainActivity.this);
        Thread thread = new Thread() {
            @Override
            public void run() {
                db.clearAllTables();
            }
        };
        thread.start();

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        imageViewOpenDrawer=findViewById(R.id.imageViewOpenDrawer);

        View header = navigationView.getHeaderView(0);
        CircleImageView profileImageView=header.findViewById(R.id.image_profile);
        //  profileImageView.setImageDrawable(getResources().getDrawable(R.drawable.profile_picture));
        //  profileImageView.setBackgroundResource(R.drawable.profile_picture);
        profileImageView.setImageResource(R.drawable.profile_picture);
        // profileImageView.setBackground(getResources().getDrawable(R.drawable.profile_picture));

        CircleImageView profileImage=header.findViewById(R.id.imageProfileLittle);
        //  profileImageView.setImageDrawable(getResources().getDrawable(R.drawable.profile_picture));
        //  profileImageView.setBackgroundResource(R.drawable.profile_picture);
        profileImage.setImageResource(R.drawable.profile_picture);


        imageViewOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT, true);


            }
        });

        recyclerView = findViewById(R.id.recyclerView);



        telegramList = new ArrayList<>();
        messagesList1 = new ArrayList<>();
        messagesList2 = new ArrayList<>();
        messagesList3 = new ArrayList<>();
        messagesList4 = new ArrayList<>();
        messagesList5 = new ArrayList<>();
        messagesList6 = new ArrayList<>();
        messagesList7 = new ArrayList<>();
        messagesList8 = new ArrayList<>();
        messagesList9 = new ArrayList<>();
        messagesList10 = new ArrayList<>();
        messagesList11= new ArrayList<>();
        messagesList12 = new ArrayList<>();
        messagesListList = new ArrayList<>();

        fillList();

        fillChat();

        linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<TelegramList> telegramList=db.dao().getTelegramListInfo();

        adapter = new TelegramAdapter(MainActivity.this,telegramList);
        recyclerView.setAdapter(adapter);

    }

    private void fillChat() {


        TelegramMessage message1_1 = addNewMessageToChat("We should get together for lunch sometime. ","left","PM","10:22", false,false,false,false);
        TelegramMessage message1_2 = addNewMessageToChat("Yeah, that would be great.","right","PM","10:20", true,false,false,true);
        TelegramMessage message1_3 = addNewMessageToChat("I'll call you sometime. ","left","PM","10:23", false,false,false,false);
        TelegramMessage message1_4 = addNewMessageToChat("Ok. I'll see you later.","right","PM","10:24", true,false,false,true);
        TelegramMessage message1_5 = addNewMessageToChat("Alright. See ya.","left","PM","10:24", false,false,false,false);


        addNewMessagesToChat(messagesList1,1, "1 hour ago",message1_1,message1_2,message1_3,message1_4,message1_5,null,null,null,null,null,null,null,null,null,null);

        TelegramMessage message2_1 = addNewMessageToChat("Hi Mary.","left","PM","9:22", false,false,false,false);
        TelegramMessage message2_2 = addNewMessageToChat("Oh, hi. ","right","PM","9:20", true,false,false,true);
        TelegramMessage message2_3 = addNewMessageToChat("How are you doing?","left","PM","9:23", false,false,false,false);
        TelegramMessage message2_4 = addNewMessageToChat("I'm doing alright. How about you?","right","PM","9:24", true,false,false,true);
        TelegramMessage message2_5 = addNewMessageToChat("So where are you going now?","left","PM","9:24", false,false,false,false);
        TelegramMessage message2_6 = addNewMessageToChat("I'm going to meet a friend of mine at the department store.","right","PM","9:24", true,false,false,true);
        TelegramMessage message2_7 = addNewMessageToChat("Going to do a little shopping?","left","PM","9:25", false,false,false,false);
        TelegramMessage message2_8 = addNewMessageToChat("Yeah, I have to buy some presents for my parents.","right","PM","9:25", true,false,false,true);
        TelegramMessage message2_9 = addNewMessageToChat("What's the occasion?","left","PM","9:25", false,false,false,false);
        TelegramMessage message2_10 = addNewMessageToChat("It's their anniversary.","right","PM","9:26", true,false,false,true);
        TelegramMessage message2_11 = addNewMessageToChat("That's great. Well, you better get going. You don't want to be late.","left","PM","9:26", false,false,false,false);
        TelegramMessage message2_12 = addNewMessageToChat("I'll see you next time.","right","PM","9:27", true,false,false,true);
        TelegramMessage message2_13 = addNewMessageToChat("Sure. Bye.","left","PM","9:27", false,false,false,false);


        addNewMessagesToChat(messagesList2,2, "2 hours ago",message2_1,message2_2,message2_3,message2_4,message2_5,message2_6,message2_7, message2_8, message2_9,message2_10,message2_11,message2_12,message2_13,null,null);

        TelegramMessage message3_1 = addNewMessageToChat("I don’t think of all the misery but of the beauty that still remains. \n – Anne Frank","left","AM","10:03", false,false,false,false);
        TelegramMessage message3_2 = addNewMessageToChat("Everything has beauty, but not everyone sees it. Confucius ","left","AM","10:19", false,false,false,false);
        TelegramMessage message3_3 = addNewMessageToChat("The future belongs to those who believe in the beauty of their dreams. \n – Eleanor Roosevelt","left","AM","10:36", false,false,false,false);
        TelegramMessage message3_4 = addNewMessageToChat(" You are confined only by the walls you build yourself.","left","AM","10:48", false,false,false,false);
        TelegramMessage message3_5 = addNewMessageToChat("You learn more from failure than from success. Don’t let it stop you. Failure builds character. ","left","PM","12:13", false,false,false,false);
        TelegramMessage message3_6 = addNewMessageToChat("“If you are working on something that you really care about, you don’t have to be pushed. The vision pulls you.” \n – Steve Jobs ","left","PM","12:35", false,false,false,false);
        TelegramMessage message3_7 = addNewMessageToChat("You are braver than you believe, stronger than you seem and smarter than you think. ","left","PM","12:35", false,false,false,false);
        TelegramMessage message3_8 = addNewMessageToChat("The way get started is to quit talking and begin doing. – \n Walt Disney","left","PM","3:21", false,false,false,false);
        TelegramMessage message3_9 = addNewMessageToChat("There will haters and doubters. And then there will be you – proving them wrong! ","left","PM","4:47", false,false,false,false);
        TelegramMessage message3_10 = addNewMessageToChat("The first step to living the life you want is leaving the life you don’t want. Taking that first step forward is always the hardest. But then each step forward gets easier and easier. And each step forward gets you closer and closer. Until eventually what had once been invisible starts to be visible. And what had once felt impossible, starts to feel possible. \n – Karen Salmansohn ","left","PM","5:16", false,false,false,false);
        TelegramMessage message3_11 = addNewMessageToChat("Do more things that light you up. Become lit from within. – \n Karen Salmansohn ","left","PM","6:26", false,false,false,false);
        TelegramMessage message3_12 = addNewMessageToChat("The more light you allow within your the brighter the world you live in will be. – \n Shakti Gawain","left","PM","8:43", false,false,false,false);
        TelegramMessage message3_13 = addNewMessageToChat("Trees which endure the stormiest times grow the strongest and most beautiful. Ditto how your stormy times can encourage you to thrive and bloom into your mightiest self. – \n Karen Salmansohn ","left","PM","8:46", false,false,false,false);
        TelegramMessage message3_14 = addNewMessageToChat("Look up from what you're doing and look around for a minute. See what a beautiful world you're in. \n Ralph Marston" ,"left","PM","8:58", false,false,false,false);
        TelegramMessage message3_15 = addNewMessageToChat("Love is like a beautiful flower which I may not touch, but whose fragrance makes the garden a place of delight just the same. \n Helen Keller" ,"left","PM","9:00", false,false,false,false);

        addNewMessagesToChat(messagesList3,3, "last seen recently",message3_1,message3_2,message3_3,message3_4,message3_5,message3_6,message3_7,message3_8,message3_9,message3_10,message3_11,message3_12,message3_13,message3_14,message3_15);

        TelegramMessage message4_1 = addNewMessageToChat("I was wondering if you have any plans for tomorrow night.","left","PM","8:53", false,false,false,false);
        TelegramMessage message4_2 = addNewMessageToChat("Umm... I don't think I have anything special for tomorrow. Why?","right","PM","8:53", true,false,false,true);
        TelegramMessage message4_3 = addNewMessageToChat("Do you want to see the new movie with me?","left","PM","8:54", false,false,false,false);
        TelegramMessage message4_4 = addNewMessageToChat("I wanted to see that. Yeah. Let's go.","right","PM","8:54", true,false,false,true);
        TelegramMessage message4_5 = addNewMessageToChat("What time is good for you? ","left","PM","8:55", false,false,false,false);
        TelegramMessage message4_6 = addNewMessageToChat("How about seven thirty. ","right","PM","8:55", true,false,false,true);
        TelegramMessage message4_7 = addNewMessageToChat("What time is good for you? ","left","PM","8:56", false,false,false,false);
        TelegramMessage message4_8 = addNewMessageToChat("Sure. I'll meet you at the theater at seven.","right","PM","8:56", true,false,true,false);

        addNewMessagesToChat(messagesList4,4, "1 hour ago",message4_1,message4_2,message4_3,message4_4,message4_5,message4_6,message4_7,message4_8,null,null,null,null,null,null,null);


        TelegramMessage message5_1 = addNewMessageToChat("Uncanny Valley, by Anna Wiener \n\n Anna Wiener left her book-publishing job to pursue a career in tech back when start-ups were revered for their possibilities, all IPAs and cold brew on tap and open-plan offices filled with precocious future billionaires still dressed as children.","left","PM","4:34", false,false,false,false);
        TelegramMessage message5_2 = addNewMessageToChat("If the literary world was all about paying one’s dues and respecting a rigid hierarchy, then Silicon Valley was 24-year-old bosses with major holes in their knowledge and experience who nonetheless controlled the fates of many.  ","left","PM","4:34", false,false,false,false);
        TelegramMessage message5_3 = addNewMessageToChat("In this cutting, gossipy memoir, Wiener details how the absurdities of the culture of tech companies helped to mask larger, looming problems: the lack of regulation that allowed tech companies to amass monstrous amounts of wealth while eroding the privacy of ordinary citizens.","left","PM","4:35", false,false,false,false);
        TelegramMessage message5_4 = addNewMessageToChat("Amnesty, by Aravind Adiga \n\n The latest from Aravinda Adiga, whose 2008 The White Tiger won the Man Booker, Amnesty tells the story of an undocumented immigrant, Danny, living a relatively quiet life in Australia after being denied refugee status as he fled his native Sri Lanka. ","left","PM","7:36", false,false,false,false);
        TelegramMessage message5_5 = addNewMessageToChat("Things take a turn after he finds himself in the middle of a murder case and speaking up could mean deportation.","left","PM","7:36", false,false,false,false);
        TelegramMessage message5_6 = addNewMessageToChat("Amnesty is a story that will, with plenty of Adiga’s trademark wit, force you to reckon with your own ethical code. —Madison Malone Kircher","left","PM","7:36", false,false,false,false);
        TelegramMessage message5_7 = addNewMessageToChat("In this cutting, gossipy memoir, Wiener details how the absurdities of the culture of tech companies helped to mask larger, looming problems: the lack of regulation that allowed tech companies to amass monstrous amounts of wealth while eroding the privacy of ordinary citizens.","left","PM","4:34", false,false,false,false);
        TelegramMessage message5_8 = addNewMessageToChat("Amnesty, by Aravind Adiga \n\n The latest from Aravinda Adiga, whose 2008 The White Tiger won the Man Booker, Amnesty tells the story of an undocumented immigrant, Danny, living a relatively quiet life in Australia after being denied refugee status as he fled his native Sri Lanka.","left","PM","4:34", false,false,false,false);
        TelegramMessage message5_9 = addNewMessageToChat("Things take a turn after he finds himself in the middle of a murder case and speaking up could mean deportation.","left","PM","4:35", false,false,false,false);

        addNewMessagesToChat(messagesList5,5, "",message5_1,message5_2,message5_3,message5_4,message5_5,message5_6,message5_7,message5_8,message5_9,null,null,null,null,null,null);



        TelegramMessage message6_1 = addNewMessageToChat("I'm so bored. I have nothing to do.","left","PM","6:21", false,false,false,false);
        TelegramMessage message6_2 = addNewMessageToChat("Maybe you should start thinking about some hobbies.","right","PM","6:22", true,false,false,true);
        TelegramMessage message6_3 = addNewMessageToChat("Umm maybe you're right","left","PM","6:22", false,false,false,false);
        TelegramMessage message6_4 = addNewMessageToChat("What do you do in your spare time?","left","PM","6:23", false,false,false,false);
        TelegramMessage message6_5 = addNewMessageToChat("I do a lot of writing, so I write every chance I get. ","right","PM","6:23", true,false,false,true);

        addNewMessagesToChat(messagesList6,6, "1 hour ago",message6_1,message6_2,message6_3,message6_4,message6_5,null,null,null,null,null,null,null,null,null,null);



        TelegramMessage message7_1 = addNewMessageToChat("What type of movies do you like?","left","PM","5:42", false,false,false,false);
        TelegramMessage message7_2 = addNewMessageToChat("I like all sorts of movies, primarily drama and science fiction. ","right","PM","5:42", true,false,false,true);
        TelegramMessage message7_3 = addNewMessageToChat("That's an interesting combination. How about western movies?","left","PM","5:42", false,false,false,false);
        TelegramMessage message7_4 = addNewMessageToChat("Western and horror are the two types of movies I don't care for. ","right","PM","5:45", true,false,false,true);
        TelegramMessage message7_5 = addNewMessageToChat("Some are entertaining, but I find most of them stupid and childish. For example, I don't understand why a person always goes into the house alone when something is suspicious.","left","PM","5:46", false,false,false,false);
        TelegramMessage message7_6 = addNewMessageToChat("Ha ha. I know what you mean. But it's just a movie. They need for the characters to do that.","right","PM","5:46", true,false,false,true);
        TelegramMessage message7_7 = addNewMessageToChat("Why don't you like horror? They're entertaining.","left","PM","5:47", false,false,false,false);
        TelegramMessage message7_8 = addNewMessageToChat("Some are entertaining, but I find most of them stupid and childish. For example, I don't understand why a person always goes into the house alone when something is suspicious.","right","PM","5:47", true,false,false,true);
        TelegramMessage message7_9 = addNewMessageToChat("Ha ha. I know what you mean. But it's just a movie. They need for the characters to do that.","left","PM","5:47", false,false,false,false);

        addNewMessagesToChat(messagesList7,7, "last seen recently",message7_1,message7_2,message7_3,message7_4,message7_5,message7_6,message7_7,message7_8,message7_9,null,null,null,null,null,null);

        TelegramMessage message8_1 = addNewMessageToChat("How have you been?","left","PM","3:11", false,false,false,false);
        TelegramMessage message8_2 = addNewMessageToChat("Not too bad. I'm still in school and having a little fun.","right","PM","3:11", true,false,false,true);
        TelegramMessage message8_3 = addNewMessageToChat("How are you enjoying Mr. Lee's history class?","left","PM","3:12", true,false,false,true);
        TelegramMessage message8_4 = addNewMessageToChat("It's so boring. ","right","PM","3:12", true,false,false,true);
        TelegramMessage message8_5 = addNewMessageToChat(" If it wasn't a requirement, I wouldn't have taken it.","right","PM","3:13", true,false,false,true);
        TelegramMessage message8_6 = addNewMessageToChat(" Tell me about it.","left","PM","3:13", false,false,false,false);
        TelegramMessage message8_7 = addNewMessageToChat(" How about you? What have you been up to?","right","PM","3:14", true,false,false,true);
        TelegramMessage message8_8 = addNewMessageToChat(" I finished school last spring. I'm searching for a job now, but I'm slacking off.","left","PM","3:14", false,false,false,false);
        TelegramMessage message8_9 = addNewMessageToChat(" Well, good luck to you.","right","PM","3:15", true,false,false,true);
        TelegramMessage message8_10 = addNewMessageToChat(" Thanks. It was good seeing you again.","left","PM","3:15", false,false,false,false);
        TelegramMessage message8_11 = addNewMessageToChat(" Have a good night.","right","PM","3:15", true,true,false,false);

        addNewMessagesToChat(messagesList8,8, "last seen recently",message8_1,message8_2,message8_3,message8_4,message8_5,message8_6,message8_7,message8_8,message8_9,message8_10,message8_11,null,null,null,null);

        TelegramMessage message9_1 = addNewMessageToChat("I was wondering if you have any plans for tomorrow night.","left","AM","10:34", false,false,false,false);
        TelegramMessage message9_2 = addNewMessageToChat("Umm... I don't think I have anything special for tomorrow. Why? ","right","AM","10:37", true,false,false,true);
        TelegramMessage message9_3 = addNewMessageToChat("Do you want to see the new movie with me?","left","AM","10:45", false,false,false,false);
        TelegramMessage message9_4 = addNewMessageToChat("I wanted to see that. Yeah. Let's go.\" ","right","AM","10:52", true,false,false,true);
        TelegramMessage message9_5 = addNewMessageToChat("What time is good for you? ","left","AM","10:53", false,false,false,false);
        TelegramMessage message9_6= addNewMessageToChat("How about seven thirty.","right","AM","10:56", true,false,false,true);
        TelegramMessage message9_7 = addNewMessageToChat("What time is good for you? ","left","AM","11:00", false,false,false,false);
        TelegramMessage message9_8 = addNewMessageToChat("Sure. I'll meet you at the theater at seven.","right","AM","11:15", true,false,true,false);

        addNewMessagesToChat(messagesList9,9, "1 hour ago",message9_1,message9_2,message9_3,message9_4,message9_5,message9_6,message9_7,message8_8,message9_8,null,null,null,null,null,null);

        TelegramMessage message10_1 = addNewMessageToChat("We should get together for lunch sometime.  ","left","AM","10:22", false,false,false,false);
        TelegramMessage message10_2 = addNewMessageToChat("Yeah, that would be great.","right","AM","10:20", true,false,false,true);
        TelegramMessage message10_3 = addNewMessageToChat("I'll call you sometime. ","left","AM","10:23", false,false,false,false);
        TelegramMessage message10_4 = addNewMessageToChat("Ok. I'll see you later.","right","AM","10:24", true,false,false,true);
        TelegramMessage message10_5 = addNewMessageToChat("Alright. See ya.","left","AM","10:24", false,false,false,false);

        addNewMessagesToChat(messagesList10,10, "2 hours ago",message10_1,message10_2,message10_3,message10_4,message10_5,null,null,null,null,null,null,null,null,null,null);


        TelegramMessage message11_1 = addNewMessageToChat("I don’t think of all the misery but of the beauty that still remains. \n\nAnne Frank","left","AM","8:31", false,false,false,false);
        TelegramMessage message11_2 = addNewMessageToChat("Everything has beauty, but not everyone sees it. Confucius ","left","AM","8:42", false,false,false,false);
        TelegramMessage message11_3 = addNewMessageToChat("The future belongs to those who believe in the beauty of their dreams. \n\nEleanor Roosevelt","left","AM","9:27", false,false,false,false);
        TelegramMessage message11_4 = addNewMessageToChat(" You are confined only by the walls you build yourself.","left","AM","9:39", false,false,false,false);
        TelegramMessage message11_5 = addNewMessageToChat("You learn more from failure than from success. Don’t let it stop you. Failure builds character. ","left","AM","10:24", false,false,false,false);
        TelegramMessage message11_6 = addNewMessageToChat("“If you are working on something that you really care about, you don’t have to be pushed. The vision pulls you.” \n\nSteve Jobs ","left","PM","12:35", false,false,false,false);
        TelegramMessage message11_7 = addNewMessageToChat("You are braver than you believe, stronger than you seem and smarter than you think. ","left","PM","4:28", false,false,false,false);
        TelegramMessage message11_8 = addNewMessageToChat("The way get started is to quit talking and begin doing. \n\nWalt Disney","left","PM","6:53", false,false,false,false);
        TelegramMessage message11_9 = addNewMessageToChat("There will haters and doubters. And then there will be you – proving them wrong! ","left","PM","7:24", false,false,false,false);
        TelegramMessage message11_10 = addNewMessageToChat("The first step to living the life you want is leaving the life you don’t want. Taking that first step forward is always the hardest. But then each step forward gets easier and easier. And each step forward gets you closer and closer. Until eventually what had once been invisible starts to be visible. And what had once felt impossible, starts to feel possible. \n\nKaren Salmansohn ","left","PM","8:35", false,false,false,false);
        TelegramMessage message11_11 = addNewMessageToChat("Do more things that light you up. Become lit from within. \n\nKaren Salmansohn ","left","AM","9:15", false,false,false,false);
        TelegramMessage message11_12 = addNewMessageToChat("The more light you allow within your the brighter the world you live in will be.  \n\nShakti Gawain","left","AM","9:24", false,false,false,false);
        TelegramMessage message11_13 = addNewMessageToChat("Trees which endure the stormiest times grow the strongest and most beautiful. Ditto how your stormy times can encourage you to thrive and bloom into your mightiest self. \n\nKaren Salmansohn ","left","AM","10:13", false,false,false,false);
        TelegramMessage message11_14 = addNewMessageToChat("Look up from what you're doing and look around for a minute. See what a beautiful world you're in. \n \nRalph Marston" ,"left","AM","10:20", false,false,false,false);
        TelegramMessage message11_15 = addNewMessageToChat("Love is like a beautiful flower which I may not touch, but whose fragrance makes the garden a place of delight just the same. \n \nHelen Keller" ,"left","AM","10:21", false,false,false,false);

        addNewMessagesToChat(messagesList11,11, "",message11_1,message11_2,message11_3,message11_4,message11_5,message11_6,message11_7,message11_8,message11_9,message11_10,message11_11,message11_12,message11_13,message11_14,message11_15);


        TelegramMessage message12_1 = addNewMessageToChat("What type of movies do you like?","left","AM","9:07", false,false,false,false);
        TelegramMessage message12_2 = addNewMessageToChat("I like all sorts of movies, primarily drama and science fiction. ","right","AM","9:20", true,false,false,true);
        TelegramMessage message12_3 = addNewMessageToChat("That's an interesting combination. How about western movies?","left","AM","9:24", false,false,false,false);
        TelegramMessage message12_4 = addNewMessageToChat("Western and horror are the two types of movies I don't care for. ","right","AM","9:25", true,false,false,true);
        TelegramMessage message12_5 = addNewMessageToChat("Some are entertaining, but I find most of them stupid and childish. For example, I don't understand why a person always goes into the house alone when something is suspicious.","left","AM","9:27", false,false,false,false);
        TelegramMessage message12_6 = addNewMessageToChat("Ha ha. I know what you mean. But it's just a movie. They need for the characters to do that.","right","AM","9:28", true,false,false,true);
        TelegramMessage message12_7 = addNewMessageToChat("Why don't you like horror? They're entertaining.","left","AM","9:28", false,false,false,false);
        TelegramMessage message12_8 = addNewMessageToChat("Some are entertaining, but I find most of them stupid and childish. For example, I don't understand why a person always goes into the house alone when something is suspicious.","right","AM","9:36", true,false,false,true);
        TelegramMessage message12_9 = addNewMessageToChat("Ha ha. I know what you mean. But it's just a movie. They need for the characters to do that.","left","AM","9:37", false,false,false,false);

        addNewMessagesToChat(messagesList12,12, "1 hour ago",message12_1,message12_2,message12_3,message12_4,message12_5,message12_6,message12_7,message12_8,message12_9,null,null,null,null,null,null);
    }

    private void fillList() {


        newTelegramListItem("sara",1,false,false,true,false,0,"10:24","PM","Alright. See ya.",R.drawable.one);
        newTelegramListItem("Irene",2,true,false,false,true,0,"9:27","PM","Sure. Bye.",R.drawable.two);
        newTelegramListItem("John",3,false,true,false,false,7,"9:00","PM","Love is like a beautiful flower which I may not touch, but whose fragrance makes the garden a place of delight just the same. \n Helen Keller",R.drawable.three);
        newTelegramListItem("Mandy",4,false,false,false,false,0,"8:56","PM","Sure. I'll meet you at the theater at seven.",R.drawable.four);
        newTelegramListItem("Books",5,false,false,false,true,10,"7:36","PM","Amnesty is a story that will, with plenty of Adiga’s trademark wit, force you to reckon with your own ethical code. —Madison Malone Kircher",R.drawable.five);
        newTelegramListItem("Taylor",6,true,false,false,true,0,"6:23","PM","I do a lot of writing, so I write every chance I get.  ",R.drawable.six);
        newTelegramListItem("Genny",7,false,false,false,false,0,"5:47","PM","Ha ha. I know what you mean. But it's just a movie. They need for the characters to do that.",R.drawable.seven);
        newTelegramListItem("Alex",8,false,false,true,false,0,"3:15","PM","Have a good night.",R.drawable.eight);
        newTelegramListItem("Lisa",9,false,true,false,false,0,"11:15","AM","Sure. I'll meet you at the theater at seven.",R.drawable.nine);
        newTelegramListItem("Mark",10,false,true,false,false,0,"10:24","AM","Alright. See ya.",R.drawable.ten);
        newTelegramListItem("Words",11,false,true,false,true,0,"10:21","AM","Love is like a beautiful flower which I may not touch, but whose fragrance makes the garden a place of delight just the same. \n Helen Keller",R.drawable.eleven);
        newTelegramListItem("Jennifer",12,true,false,false,false,0,"9:37","AM","Why don't you like horror? They're entertaining.",R.drawable.twelve);

    }


    public void onClick(View view) {

        // drawer
        View header = navigationView.getHeaderView(0);
        LinearLayout linearLayoutHeader = header.findViewById(R.id.addHeader);
        ImageView imageViewArrowDown=header.findViewById(R.id.imgArrowDown);
        ImageView imageViewArrowUp=header.findViewById(R.id.imgArrowUp);
        if(imageViewArrowDown.getVisibility() == View.VISIBLE){

            linearLayoutHeader.setVisibility(View.VISIBLE);
            imageViewArrowDown.setVisibility(View.GONE);
            imageViewArrowUp.setVisibility(View.VISIBLE);
        }else {
            linearLayoutHeader.setVisibility(View.GONE);
            imageViewArrowDown.setVisibility(View.VISIBLE);
            imageViewArrowUp.setVisibility(View.GONE);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.clearAllTables();
    }


    public TelegramMessage addNewMessageToChat(String text , String position , String am_pm , String time ,Boolean isMyText ,
                                               Boolean sent , Boolean received , Boolean seen){
        TelegramMessage message= new TelegramMessage();
        message.setText(text);
        message.setPosition(position);
        message.setAmPm(am_pm);
        message.setTime(time);
        message.setMyText(isMyText);
        message.setSent(sent);
        message.setReceived(received);
        message.setSeen(seen);
        return message;

    }


    public void newChat(List<TelegramMessage> messagesList , Integer idContact, String lastSeen){

        TelegramChat telegramChat = new TelegramChat();
        telegramChat.setLastSeen(lastSeen);

        String stringMessageList = DataConverter.ListToString(messagesList);
        messagesListList.add(stringMessageList);
        String stringMessagesListList = DataConverterTwo.ListToString(messagesListList);
        telegramChat.setMessages(stringMessagesListList);
        telegramChat.setIdContact(idContact);

        db.dao().insertTelegramChatInfo(telegramChat);

            }




    public  void  newTelegramListItem(String name, int contactId , Boolean sent , Boolean received , Boolean seen , Boolean mute ,
                          Integer messageNumber , String time , String am_pm , String text , int profileImage){


        TelegramList telegramListItem = new TelegramList();
        telegramListItem.setName(name);
        telegramListItem.setContactId(contactId);
        telegramListItem.setSent(sent);
        telegramListItem.setReceived(received);
        telegramListItem.setSeen(seen);
        telegramListItem.setImage_mute(mute);
        telegramListItem.setMessage_number(messageNumber);
        telegramListItem.setTime(time);
        telegramListItem.setAm_pm(am_pm);
        telegramListItem.setText(text);
        telegramListItem.setImage_profile(profileImage);

        telegramList.add(telegramListItem);
        db.dao().insertTelegramListInfo(telegramListItem);



    }

    public  void  addNewMessagesToChat( List<TelegramMessage> messagesList , Integer idContact , String lastSeen ,TelegramMessage message1, TelegramMessage message2 , TelegramMessage message3   , TelegramMessage message4  ,
                                        TelegramMessage message5 , TelegramMessage message6  , TelegramMessage message7  , TelegramMessage message8 ,
                                        TelegramMessage message9  , TelegramMessage message10  , TelegramMessage message11,
                                        TelegramMessage message12, TelegramMessage message13 , TelegramMessage message14 , TelegramMessage message15  ){
        messagesList.add(message1);
        messagesList.add(message2);
        messagesList.add(message3);
        messagesList.add(message4);
        messagesList.add(message5);
        messagesList.add(message6);
        messagesList.add(message7);
        messagesList.add(message8);
        messagesList.add(message9);
        messagesList.add(message10);
        messagesList.add(message11);
        messagesList.add(message12);
        messagesList.add(message13);
        messagesList.add(message14);
        messagesList.add(message15);

        newChat(messagesList ,idContact ,lastSeen);



    }
}
