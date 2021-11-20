/*
 * Copyright Xanium Development (c) 2013-2018. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Xanium Development. Distribution, reproduction, taking snippets or claiming
 * any contents as your own will break the terms of the license, and void any agreements with you, the third party.
 * Thank you.
 */

package me.xanium.gemseconomy.logging;

import me.xanium.gemseconomy.GemsEconomy;
import me.xanium.gemseconomy.utils.UtilTime;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public abstract class AbstractLogger {

    private final GemsEconomy plugin;
    private final Path folder;
    private final Path latest;

    public AbstractLogger(GemsEconomy plugin) {
        this.plugin = plugin;
        this.folder = Paths.get(plugin.getDataFolder() + File.separator + "logs");
        this.latest = Paths.get(folder.toString(), LocalDate.now() + ".log");

        initDir();
    }

    public void log(String message) {

        final String log = getDateAndTime().concat(message).concat(System.lineSeparator());

        try {
            Files.writeString(latest, log,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getDateAndTime() {
        return "[".concat(UtilTime.now()).concat("]").concat(" ");
    }

    private void initDir() {
        try {
            Files.createDirectories(folder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
