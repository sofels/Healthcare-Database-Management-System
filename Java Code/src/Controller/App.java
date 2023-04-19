package Controller;

import View.AdminView;
import View.LoginView;
import View.MainView;

public class App {

    MainView frame;
//    LoginView loginView;
//    AdminView adminView;

    public void run(){
        buildMainView();
    }

//    private void buildAdmin() {
//        adminView = new AdminView();
//        frame.setCard(1);
//    }

    private void buildMainView(){
        frame = new MainView();
        frame.setCard(0);
    }
//    public void buildLogin(){
//        loginView = new LoginView();
//
//    }
    public static void main(String[] args) {
        new App();
    }
    public App(){
        run();
    }

}
