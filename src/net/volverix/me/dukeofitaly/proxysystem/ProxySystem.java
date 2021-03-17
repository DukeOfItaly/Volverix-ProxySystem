package net.volverix.me.dukeofitaly.proxysystem;

import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;
import net.volverix.me.oxince.me.dukeofitaly.core.sql.DriverManager;

public class ProxySystem extends Plugin {

    @Getter
    private static ProxySystem proxySystem;

    @Getter
    private DriverManager driverManager;

    @Override
    public void onEnable() {
        proxySystem = this;
        connect();

    }

    @Override
    public void onDisable() {

    }

    private void connect() {
        driverManager = new DriverManager("localhost", "root", "hardcoreffa", "");
        if (!driverManager.isConnected()) {
            try {
                System.out.println("[ProxySystem] Trying to connect to MySQL database via VolverixCore...");
                driverManager = new DriverManager("localhost", "root", "hardcoreffa", "");
                driverManager.startConnection();
                driverManager.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS PlayerData (UUID VARCHAR(128) PRIMARY KEY, COINS INT(16), CLAN VARCHAR(16), CLAN_RANK VARCHAR(16), ELO INT(16))").executeUpdate();
                driverManager.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS PlayerSettings (UUID VARCHAR(128) PRIMARY KEY, PARTY_REQUESTS INT(16), FRIEND_REQUESTS INT(16))").executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
