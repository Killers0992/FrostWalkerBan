package com.killers0992.frostwalkerban;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class FrostwalkerBan extends JavaPlugin {
    public static FileConfiguration config;

    @Override
    public void onEnable() {
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }
}
