package com.killers0992.frostwalkerban;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {

    @EventHandler
    public void OnJoin(PlayerJoinEvent ev){
        ItemStack item = ev.getPlayer().getInventory().getBoots();

        if (item == null){
            return;
        }

        if (item.containsEnchantment(Enchantment.FROST_WALKER))
        {
            item.removeEnchantment(Enchantment.FROST_WALKER);
            ev.getPlayer().getInventory().setBoots(item);
            ev.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', FrostwalkerBan.config.getString("frostwalkerban-message")));
        }
    }

    @EventHandler
    public void OnArmorEquip(PlayerArmorChangeEvent ev){
        if (ev.getSlotType() != PlayerArmorChangeEvent.SlotType.FEET){
            return;
        }

        ItemStack item = ev.getNewItem();
        if (item.containsEnchantment(Enchantment.FROST_WALKER)){
            item.removeEnchantment(Enchantment.FROST_WALKER);
            ev.getPlayer().getInventory().setBoots(item);
            ev.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', FrostwalkerBan.config.getString("frostwalkerban-message")));
        }
    }
}

