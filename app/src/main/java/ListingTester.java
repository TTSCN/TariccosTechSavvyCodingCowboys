import android.util.Log;
import com.example.zeynepalptekin.tariccostechsavvycodingnightmares.Account;
import com.example.zeynepalptekin.tariccostechsavvycodingnightmares.Listing;
/**
 * Created by Abby on 3/28/2018.
 * a class to test the Listing class
 * also tests the account and location class, which are used within the listing class
 */
public class ListingTester
{
    public void main()
    {
        Account user = new Account("John Smith", "email@gmail.com", "Worcester", "MA");
        Listing listing = new Listing(user, "garden help", 8);
        String str = listing.getTitle();
        Log.d("listing", str);
    }
}
