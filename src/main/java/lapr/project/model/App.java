package lapr.project.model;

public class App {

    private Company company;
    //private AuthFacade authFacade;

    private App() {
        this.company = new Company();
        //this.authFacade = company.getAuthFacade();
        //bootstrap();
    }

    public Company getCompany() {
        return company;
    }
    /*
    public UserSession getCurrentUserSession() {
        return authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String password) {
        return authFacade.doLogin(email, password).isLoggedIn();
    }

    public void doLogout() {
        authFacade.doLogout();
    }

    private void bootstrap() {

    }*/

    private static App singleton = null;

    public static App getInstance() {
        if (singleton == null) {
            synchronized (App.class) {
                singleton = new App();
            }
        }
        return singleton;
    }
}