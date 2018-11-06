import com.arrayMaxValue.library.UserArrayLibrary;


public class Main {
    public static void main(String[] args) {

        UserArrayLibrary userArray = new UserArrayLibrary();

        userArray.getUserArraySize();
        userArray.fillArray();
        userArray.findMaxArrValue(userArray.getArray());
    }
}
