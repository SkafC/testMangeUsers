package org.skafcommunity.emsikeep.manageusers.firestore.dao;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FirebaseAdminSDK {

  public static FirebaseApp firebaseApp;

  public static void initSDK() throws IOException {
    System.out.println("Working Directory = " + System.getProperty("user.dir"));
    File serviceAccountFile = new ClassPathResource("static/emsikeep-firebase.json").getFile();
//        FileInputStream serviceAccount = new FileInputStream("target\\classes\\static\\emsikeep-firebase.json");
    System.out.println(serviceAccountFile.getAbsolutePath());
    FileInputStream serviceAccount = new FileInputStream(serviceAccountFile.getAbsolutePath());

    FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://emsikeep.firebaseio.com")
            .build();

    FirebaseApp.initializeApp(options);
  }

  public static Firestore getFirestore() {
    return FirestoreClient.getFirestore();
  }
}
