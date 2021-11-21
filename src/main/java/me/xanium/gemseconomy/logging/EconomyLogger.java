package me.xanium.gemseconomy.logging;

import me.xanium.gemseconomy.GemsEconomy;
import org.bukkit.Bukkit;

public class EconomyLogger extends AbstractLogger {

    private final GemsEconomy plugin;

    public EconomyLogger(GemsEconomy plugin) {
        super(plugin);
        this.plugin = plugin;
    }


}
