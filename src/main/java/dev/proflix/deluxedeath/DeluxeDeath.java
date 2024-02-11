package dev.proflix.deluxedeath;

import de.cubbossa.tinytranslations.BukkitTinyTranslations;
import de.cubbossa.tinytranslations.MessageTranslator;
import de.cubbossa.tinytranslations.TinyTranslations;
import de.cubbossa.tinytranslations.storage.yml.YamlMessageStorage;
import de.cubbossa.tinytranslations.storage.yml.YamlStyleStorage;
import dev.proflix.deluxedeath.util.Messages;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Locale;

public final class DeluxeDeath extends JavaPlugin {

    private MessageTranslator translator = null;

    @Override
    public void onLoad() {
        translator = BukkitTinyTranslations.application(this);

        translator.setStyleStorage(new YamlStyleStorage(new File(getDataFolder(), "/lang/styles.yml")));
        translator.setMessageStorage(new YamlMessageStorage(new File(getDataFolder(), "/lang/")));

        translator.addMessages(TinyTranslations.messageFieldsFromClass(Messages.class));
        reloadLocales();
    }

    private void reloadLocales() {
        boolean useClientLocale = true; // read from config or ignore step
        Locale fallbackLocale = Locale.ENGLISH; // read from config or ignore step

        translator.setUseClientLocale(useClientLocale);
        translator.setDefaultLocale(fallbackLocale);

        translator.saveLocale(Locale.ENGLISH);
        translator.loadLocales();
        translator.loadStyles();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
