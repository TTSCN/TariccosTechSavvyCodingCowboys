import android.util.Log;

import com.example.zeynepalptekin.tariccostechsavvycodingnightmares.Account;
import com.example.zeynepalptekin.tariccostechsavvycodingnightmares.Listing;

import java.util.logging.LogRecord;

/**
 * Created by Abby on 3/28/2018.
 */

public class ListingTester {
    Account user = new Account("John Smith","email@gmail.com","Worcester","MA");
    Listing listing = new Listing(user, "garden help",8 );
    String str = listing.getTitle();
    Log.d("listing", str);
}
