package me.alien.meksifi.mek;

import me.alien.meksifi.mek.items.Test;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class Items {

    public static final RegistryObject<Item> TEST = Registration.ITEMS.register("test", () -> new Test());

    public static void register() {
    }
}
