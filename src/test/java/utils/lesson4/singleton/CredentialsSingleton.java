package utils.lesson4.singleton;

public final class CredentialsSingleton {
    private static CredentialsSingleton credentials;
    public static String login = "UAtestAPI@ukr.net";
    public static String password = "qwerty1234567!@#$%^";


    private CredentialsSingleton(String login, String password){
        this.login = login;
        this.password = password;
    }

    public static  CredentialsSingleton getCredentials(){
        if(credentials == null){
            credentials = new CredentialsSingleton(login, password);
        }
        return credentials;
    }
}
