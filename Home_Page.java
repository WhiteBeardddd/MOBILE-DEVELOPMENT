package ph.edu.usc.boquecosa_project;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Home_Page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spin_weapons;
    ListView listView;

    private Integer[] imgid = {
            R.drawable.bronze_sword, R.drawable.silver_sword, R.drawable.iron_sword,
            R.drawable.mistwalker, R.drawable.black_metal_sword, R.drawable.crude_bow,
            R.drawable.finewood_bow, R.drawable.draugr_fang, R.drawable.splitnir,
            R.drawable.ancient_bark_spear, R.drawable.carapace_spear, R.drawable.flint_spear
    };

    private String[] weapon_name = {
            "Bronze Sword", "Silver Sword", "Iron Sword", "Mistwalker", "Black Metal Sword",
            "Crude Bow", "Finewood Bow", "Draugr Fang", "Splitnir", "Ancient Bark Spear",
            "Carapace Spear", "Flint Spear"
    };

    private String[] weapon_desc = {
            "Damage: 85, Stamina Usage: 12, Durability: 250",
            "Damage: 70, Stamina Usage: 10, Durability: 200",
            "Damage: 90, Stamina Usage: 15, Durability: 300",
            "Damage: 78, Stamina Usage: 9, Durability: 150",
            "Damage: 95, Stamina Usage: 20, Durability: 350",
            "Damage: 60, Stamina Usage: 8, Durability: 100",
            "Damage: 75, Stamina Usage: 14, Durability: 200",
            "Damage: 88, Stamina Usage: 18, Durability: 300",
            "Damage: 92, Stamina Usage: 22, Durability: 400",
            "Damage: 65, Stamina Usage: 7, Durability: 150",
            "Damage: 99, Stamina Usage: 25, Durability: 400",
            "Damage: 80, Stamina Usage: 11, Durability: 250"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weaponlist_spinner);  // ✅ Fix: Ensure the correct layout file is set

        spin_weapons = findViewById(R.id.weapon_spinner);
        listView = findViewById(R.id.weapon_list);
        spin_weapons.setOnItemSelectedListener(this);

        // ✅ Fix: Removed unnecessary ArrayAdapter for ListView
        ArrayAdapter<String> weaponAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, weapon_name
        );
        spin_weapons.setAdapter(weaponAdapter);

        // ✅ Fix: Corrected Adapter Constructor
        WeaponlistAdaptor adapter = new WeaponlistAdaptor(this, weapon_name, weapon_desc, imgid);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), weapon_name[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }
}
