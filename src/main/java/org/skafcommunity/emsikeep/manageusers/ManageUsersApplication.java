package org.skafcommunity.emsikeep.manageusers;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.skafcommunity.emsikeep.manageusers.firestore.dao.FirebaseAdminSDK;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ManageUsersApplication {

  public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(ManageUsersApplication.class, args);
    try {
      FirebaseAdminSDK.initSDK();
      System.out.println("************************************************************************");
      for (QueryDocumentSnapshot queryDocumentSnapshot : FirebaseAdminSDK.getFirestore().collection("Users").get().get().getDocuments()) {
        System.out.println(queryDocumentSnapshot.getData());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

