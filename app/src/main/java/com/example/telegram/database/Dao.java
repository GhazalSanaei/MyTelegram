package com.example.telegram.database;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@androidx.room.Dao
public interface Dao {

    // telegram list

    @Insert(onConflict = REPLACE)
    void insertTelegramListInfo(TelegramList telegramList);

    @Query("SELECT * FROM TelegramList ")
    List<TelegramList> getTelegramListInfo();

    @Query("SELECT * FROM TelegramList WHERE  contactId = :id")
    TelegramList getTelegramListInfoById(int id);

    @Insert(onConflict = REPLACE)
    void insertTelegramChatInfo(TelegramChat telegramChat);

    @Query("SELECT * FROM TelegramChat WHERE  idContact = :id")
    TelegramChat getTelegramChatnfoById(int id);

    @Query("SELECT * FROM TelegramChat ")
    List<TelegramChat> getTelegramChatnfo();

  /*  @Query("SELECT * FROM TelegramList JOIN TelegramChat ON TelegramList.idList = TelegramChat.idContact")
    List<TelegramList> getTelegramListInfoJOIN();*/




    @Query("SELECT * FROM TelegramMessage WHERE  idContact = :id")
    List<TelegramMessage> getTelegramMessagenfo(int id);

    @Insert(onConflict = REPLACE)
    void insertTelegramMessages(List<TelegramMessage> messages);

    /*@Query("SELECT * FROM user INNER JOIN user_repo_join ON
            user.id=user_repo_join.userId WHERE
            user_repo_join.repoId=:repoId")
            List<User> getUsersForRepository(final int repoId);*/

   /* select order_date, order_amount
    from customers
    join orders
    on customers.customer_id = orders.customer_id
    where customer_id = three*/
}
